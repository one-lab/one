package com.sinosoft.one.mvc.web.validation;

import java.beans.PropertyDescriptor;
import java.lang.annotation.ElementType;
import java.lang.reflect.*;
import java.util.*;

import javax.annotation.PostConstruct;
import javax.validation.*;
import javax.validation.constraints.AssertFalse;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Future;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.validation.metadata.ConstraintDescriptor;


import com.sinosoft.one.mvc.web.Invocation;
import com.sinosoft.one.mvc.web.ParamValidator;
import com.sinosoft.one.mvc.web.paramresolver.ParamMetaData;
import com.sinosoft.one.mvc.web.validation.enumation.ErrorMessageType;
import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.validator.HibernateValidator;
import org.hibernate.validator.HibernateValidatorConfiguration;
import org.hibernate.validator.cfg.ConstraintDef;
import org.hibernate.validator.cfg.ConstraintMapping;
import org.hibernate.validator.cfg.context.PropertyConstraintMappingContext;
import org.hibernate.validator.cfg.context.TypeConstraintMappingContext;
import org.hibernate.validator.cfg.defs.AssertFalseDef;
import org.hibernate.validator.cfg.defs.AssertTrueDef;
import org.hibernate.validator.cfg.defs.DecimalMaxDef;
import org.hibernate.validator.cfg.defs.DecimalMinDef;
import org.hibernate.validator.cfg.defs.DigitsDef;
import org.hibernate.validator.cfg.defs.FutureDef;
import org.hibernate.validator.cfg.defs.MaxDef;
import org.hibernate.validator.cfg.defs.MinDef;
import org.hibernate.validator.cfg.defs.NotBlankDef;
import org.hibernate.validator.cfg.defs.NotEmptyDef;
import org.hibernate.validator.cfg.defs.NotNullDef;
import org.hibernate.validator.cfg.defs.NullDef;
import org.hibernate.validator.cfg.defs.PastDef;
import org.hibernate.validator.cfg.defs.PatternDef;
import org.hibernate.validator.cfg.defs.SizeDef;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.internal.engine.PathImpl;
import org.hibernate.validator.method.MethodConstraintViolation;
import org.hibernate.validator.method.MethodValidator;
import org.hibernate.validator.method.metadata.MethodDescriptor;
import org.hibernate.validator.method.metadata.ParameterDescriptor;
import org.hibernate.validator.method.metadata.TypeDescriptor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ClassUtils;
import org.springframework.validation.Errors;

import com.sinosoft.one.mvc.web.instruction.reply.Replys;
import com.sinosoft.one.mvc.web.instruction.reply.transport.Json;
import com.sinosoft.one.mvc.web.validation.annotation.AssertFalseEx;
import com.sinosoft.one.mvc.web.validation.annotation.AssertTrueEx;
import com.sinosoft.one.mvc.web.validation.annotation.DecimalMaxEx;
import com.sinosoft.one.mvc.web.validation.annotation.DecimalMinEx;
import com.sinosoft.one.mvc.web.validation.annotation.DigitsEx;
import com.sinosoft.one.mvc.web.validation.annotation.FutureEx;
import com.sinosoft.one.mvc.web.validation.annotation.MaxEx;
import com.sinosoft.one.mvc.web.validation.annotation.MinEx;
import com.sinosoft.one.mvc.web.validation.annotation.NotBlankEx;
import com.sinosoft.one.mvc.web.validation.annotation.NotEmptyEx;
import com.sinosoft.one.mvc.web.validation.annotation.NotNullEx;
import com.sinosoft.one.mvc.web.validation.annotation.NullEx;
import com.sinosoft.one.mvc.web.validation.annotation.PastEx;
import com.sinosoft.one.mvc.web.validation.annotation.PatternEx;
import com.sinosoft.one.mvc.web.validation.annotation.SizeEx;
import com.sinosoft.one.mvc.web.validation.annotation.Validation;

/**
 * 提供针对Method参数的Annotation方式配置validation实现
 * 使用Hibernate Validation Program式风格实现
 *
 * @author Morgan
 *
 */
public class AnnotationConfigValidator implements ParamValidator{

    private static Log logger = LogFactory.getLog(AnnotationConfigValidator.class);

    @Autowired
    private ValidatorFactory validationFactory;


    private Validator defaultValidator;

    @PostConstruct
    public void init(){
        defaultValidator = validationFactory.getValidator();
    }

    private static final String PROPERTY_PATH = "propertyPath";
    private static final String MSSAGE = "message";
    private static final String INVALID_VALUE = "invalidValue";


    private Validator getValidator(ParamMetaData metaData, Validation configValidation ) {

        if( ! ClassUtils.isPrimitiveOrWrapper(metaData.getParamType())) {
            HibernateValidatorConfiguration config =javax.validation.Validation.byProvider(HibernateValidator.class).configure();
            config.addMapping(
                    createConstraintMapping(configValidation, metaData, config.createConstraintMapping())
            );
            return config.buildValidatorFactory().getValidator();
        }
        return defaultValidator;
    }


    private ConstraintMapping createConstraintMapping(Validation configValidation ,ParamMetaData metaData,ConstraintMapping constraintMapping) {

        Collection<ValidationWrapper> validationWrappers = this.createConstraintMap(configValidation);

        Collection<ValidationTypeContext> validationTypeContextCollection = this.createValidationTypeContextMap(metaData,validationWrappers);

        dealHibernateValidation(validationTypeContextCollection, constraintMapping);
        return constraintMapping;
    }


    /**
     * 将约束Map转换为需要校验环境
     * @param metaData
     * @param validationWrappers
     * @return   Map<String,ValidationTypeContext>
     */
    private Collection<ValidationTypeContext> createValidationTypeContextMap(ParamMetaData metaData,Collection<ValidationWrapper> validationWrappers){
        //创建TypeValidationMap保存当前的TypeValidation
        Map<String,ValidationTypeContext> validationTypeContextMap = new LinkedHashMap<String, ValidationTypeContext>();
        //创建此参数的根校验对象
        ValidationTypeContext rootContext = new ValidationTypeContext(metaData.getParamName(),metaData.getParamType());
        //将当前根参数放置到环境中
        validationTypeContextMap.put(metaData.getParamName(),rootContext);

        //遍历所有的约束，构建 validationTypeContextMap
        for (ValidationWrapper validationWrapper : validationWrappers){

            //获取当前约束中的所有配置的属性
            for(String propertyPath :validationWrapper.getProperties()){

                //每次将临时typeContext重设为RootContext
                ValidationTypeContext temp = rootContext;
                //构建属性Path
                Path path = PathImpl.createPathFromString(propertyPath);
                //记录当前的class
                for(Iterator<Path.Node> iterator = path.iterator();iterator.hasNext();){
                    Path.Node node =  iterator.next();
                    //该节点也是property的一种，需要加入进去
                    ValidationPropertyContext validationPropertyContext = temp.getValidationProperty(node.getName());
                    if(validationPropertyContext == null){
                        validationPropertyContext = new ValidationPropertyContext(node.getName());
                        temp.putValidationProperty(node.getName(),validationPropertyContext);
                    }
                    //如果有下级，代表是class
                    if(iterator.hasNext()){
                        //如果没有TypeValidationContext，新创建一个
                        if(validationTypeContextMap.get(node.getName())==null){
                            validationTypeContextMap.put(node.getName(),
                                    new ValidationTypeContext(node.getName(),getPropertyRealClass(temp.getCurrentClass(),node.getName())));
                        }
                        //将临时变量设置为当前的typeContext
                        temp = validationTypeContextMap.get(node.getName());
                    }
                    //已经是末级节点,将获取的约束增加到属性中
                    else{
                        validationPropertyContext.addConstraint(validationWrapper.getConstraintDef());
                    }
                }
            }
        }
        return validationTypeContextMap.values();
    }


    /**
     * 获取@param currentClass中@param propertyName的类型，如果类型为Collection类型，可以获取到定义的泛型信息
     * @param currentClass
     * @param propertyName
     * @return
     */
    private Class<?> getPropertyRealClass(Class<?> currentClass,String propertyName){
        //获取到当前级别的class,为适应泛型的情况，需要通过read method方法获取返回类型，然后再获取里面的参数
        PropertyDescriptor propertyDescriptor =  BeanUtils.getPropertyDescriptor(currentClass, propertyName);
        Class<?>[] returnClass = this.getActualClass(propertyDescriptor.getReadMethod().getGenericReturnType());
        if(returnClass.length==0){
            currentClass = propertyDescriptor.getPropertyType();
        }else{
            currentClass = returnClass[0];
        }
        return currentClass;
    }

    /**
     * 根据建立好的validationTypeContextCollections，去处理hibernateValidation
     * @param validationTypeContextCollections
     * @param constraintMapping
     */
    private void dealHibernateValidation(Collection<ValidationTypeContext> validationTypeContextCollections,ConstraintMapping constraintMapping){
        PropertyConstraintMappingContext propertyConstraintMappingContext = null;
        //创建ConstraintMapping
        for(ValidationTypeContext validationTypeContext:validationTypeContextCollections){
            if(propertyConstraintMappingContext == null){
                propertyConstraintMappingContext = validationTypeContext.validate(constraintMapping);
            }
            else{
                propertyConstraintMappingContext =  validationTypeContext.validate(propertyConstraintMappingContext);
            }
        }
    }



    /**
     * 根据 @Validation 获取所有配置的Constraint以及对应Validation，并转成对应的Map<Constraint, ValidationWrapper>返回
     * @param configValidation
     * @return
     */
    private Collection<ValidationWrapper> createConstraintMap(Validation configValidation) {
        Collection<ValidationWrapper> validationConstraints = new ArrayList<ValidationWrapper>(10);
        if(configValidation.notNull().props().length > 0) {
            validationConstraints.add(ValidationWrapper.createNotNullDef(configValidation.notNull()));
        }
        if(configValidation.notBlank().props().length>0) {
            validationConstraints.add(ValidationWrapper.createNotBlankDef(configValidation.notBlank()));
        }
        if(configValidation.notEmpty().props().length>0) {
            validationConstraints.add(ValidationWrapper.createNotEmptyDef(configValidation.notEmpty()));
        }
        if(configValidation.max().props().length>0) {
            validationConstraints.add(ValidationWrapper.createMaxDef(configValidation.max()));
        }
        if(configValidation.min().props().length>0) {
            validationConstraints.add(ValidationWrapper.createMinDef(configValidation.min()));
        }
        if(configValidation.pattern().props().length>0) {
            validationConstraints.add(ValidationWrapper.createPatternDef(configValidation.pattern()));
        }
        if(configValidation.size().props().length>0) {
            validationConstraints.add(ValidationWrapper.createSizeDef(configValidation.size()));
        }
        if(configValidation.assertFalse().props().length>0) {
            validationConstraints.add(ValidationWrapper.createAssertFalseDef(configValidation.assertFalse()));
        }
        if(configValidation.assertTrue().props().length>0) {
            validationConstraints.add(ValidationWrapper.createAssertTrueDef(configValidation.assertTrue()));
        }
        if(configValidation.decimalMax().props().length>0) {
            validationConstraints.add(ValidationWrapper.createDecimalMaxDef(configValidation.decimalMax()));
        }
        if(configValidation.decimalMin().props().length>0) {
            validationConstraints.add(ValidationWrapper.createDecimalMinDef(configValidation.decimalMin()));
        }
        if(configValidation.digits().props().length>0) {
            validationConstraints.add(ValidationWrapper.createDigistDef(configValidation.digits()));
        }
        if(configValidation.future().props().length>0) {
            validationConstraints.add(ValidationWrapper.createFutureDef(configValidation.future()));
        }
        if(configValidation.past().props().length>0) {
            validationConstraints.add(ValidationWrapper.createPastDef(configValidation.past()));
        }
        if(configValidation.nulls().props().length>0) {
            validationConstraints.add(ValidationWrapper.createNullDef(configValidation.nulls()));
        }
        return validationConstraints;
    }

    public boolean supports(ParamMetaData metaData) {
        return metaData.getAnnotation(Validation.class) != null;
    }

    public Object validate(ParamMetaData metaData, Invocation inv,
                           Object target, Errors errors) {

        if(logger.isDebugEnabled()){
            logger.debug("[annotation config validate] "+"use validator: to validate "+target);
        }

        Validation configValidation = metaData.getAnnotation(Validation.class);


        String errorPath = configValidation.errorPath();

        String[] params = StringUtils.substringsBetween(errorPath, "{", "}");
        if(params != null && params.length > 0) {
            for(String param : params) {
                String paramValue = StringUtils.substringBefore(param,":").trim();
                paramValue = StringUtils.stripToEmpty(inv.getParameter(
                        StringUtils.substringBefore(param,":").trim()));
                errorPath = errorPath.replace("{" + param + "}", paramValue);
            }
        }

		if(ClassUtils.isPrimitiveOrWrapper(metaData.getParamType())){

            MethodValidator methodValidator = javax.validation.Validation.byProvider(HibernateValidator.class).configure()
                    .buildValidatorFactory().getValidator().unwrap(MethodValidator.class);

            Set<MethodConstraintViolation<Object>> result =
                    methodValidator.validateAllParameters(inv.getController(), inv.getMethod(), inv.getMethodParameters());

            if(!result.isEmpty()){
                return this.isAjaxRequest(inv) ? methodErrorAjaxResponse(result, inv.getMethodParameterNames()) :
                        methodErrorCommonResponse(inv, result, errorPath, inv.getMethodParameterNames());
            }

        }
        else {
			Set<ConstraintViolation<Object>> result = getValidator(metaData,configValidation).validate(target);
			if(!result.isEmpty()) {
				return this.isAjaxRequest(inv) ? errorAjaxResponse(result) : errorCommonResponse(inv,result,errorPath);
			}
		}

        return null;
    }


    private String errorCommonResponse(Invocation inv,Set<ConstraintViolation<Object>> result,String errorPath){
        inv.addModel(ErrorMessageType.ERROR_MESSAGE_TYPE_BEAN.name(),"true");
        for(Iterator<ConstraintViolation<Object>> it = result.iterator(); it.hasNext();) {
            ConstraintViolation<Object> cv = it.next();
            inv.addModel(cv.getPropertyPath()+ ErrorMessageType.ERROR_MESSAGE_TYPE_SUFFIX.name(),cv);
        }
        return errorPath;
    }

    private String methodErrorCommonResponse(Invocation inv
            , Set<MethodConstraintViolation<Object>> result, String errorPath, String[] paramNames) {
        inv.addModel(ErrorMessageType.ERROR_MESSAGE_TYPE_METHOD.name(),"true");
        for(Iterator<MethodConstraintViolation<Object>> it = result.iterator(); it.hasNext();) {
            MethodConstraintViolation<Object> cv = it.next();
            inv.addModel(paramNames[cv.getParameterIndex()]+ErrorMessageType.ERROR_MESSAGE_TYPE_SUFFIX.name(),cv);
        }
        return errorPath;
    }

    private Object methodErrorAjaxResponse(Set<MethodConstraintViolation<Object>> result, String[] paramNames) {
        List<Map<String, String>> jsonList = new ArrayList<Map<String,String>>();

        for(Iterator<MethodConstraintViolation<Object>> it = result.iterator(); it.hasNext();) {
            MethodConstraintViolation<Object> cv = it.next();
            if(logger.isDebugEnabled()) {
                logger.debug("[annotation config validate] "+cv.getPropertyPath()+
                        cv.getMessage()+"  : "+cv.getInvalidValue());
            }
            Map<String, String> jsonMap = new HashMap<String, String>();
            jsonMap.put(PROPERTY_PATH, paramNames[cv.getParameterIndex()]);
            jsonMap.put(MSSAGE, cv.getMessage());
            jsonMap.put(INVALID_VALUE, cv.getInvalidValue() + "");
            jsonList.add(jsonMap);
        }
        return Replys.with(jsonList).as(Json.class);
    }

    private Object errorAjaxResponse(Set<ConstraintViolation<Object>> result){
        List<Map<String, String>> jsonList = new ArrayList<Map<String,String>>();

        for(Iterator<ConstraintViolation<Object>> it = result.iterator(); it.hasNext();) {
            ConstraintViolation<Object> cv = it.next();
            if(logger.isDebugEnabled()) {
                logger.debug("[annotation config validate] "+cv.getPropertyPath()+
                        cv.getMessage()+"  : "+cv.getInvalidValue());
            }
            Map<String, String> jsonMap = new HashMap<String, String>();
            jsonMap.put(PROPERTY_PATH, cv.getPropertyPath().toString());
            jsonMap.put(MSSAGE, cv.getMessage());
            jsonMap.put(INVALID_VALUE, cv.getInvalidValue() + "");
            jsonList.add(jsonMap);
        }
        return Replys.with(jsonList).as(Json.class);
    }

    /**
     * isAjaxRequest:判断请求是否为Ajax请求. <br/>
     */
    private boolean isAjaxRequest(Invocation inv){
        String header = inv.getRequest().getHeader("X-Requested-With");
        boolean isAjax = "XMLHttpRequest".equals(header) ? true:false;
        return isAjax;
    }
    /**
     * ValidationWrapper 包装需要验证的properties和与其对应的constraintDef。
     * @author Morgan
     *
     */
    private static class ValidationWrapper{

        private final String[] properties;

        private final String paramName;

        @SuppressWarnings("rawtypes")
        private final ConstraintDef constraintDef;

        private Class<?> currentClass;

        @SuppressWarnings("rawtypes")
        private ValidationWrapper(final String[] properties,final ConstraintDef constraintDef){
            this.properties = properties;
            this.constraintDef = constraintDef;
            this.paramName = null;
        }

        @SuppressWarnings("rawtypes")
        private ValidationWrapper(final String paramName,final ConstraintDef constraintDef) {
            this.paramName = paramName;
            this.constraintDef = constraintDef;
            this.properties = null;
        }


        public String getParamName() {
            return paramName;
        }

        public String[] getProperties() {
            return properties;
        }

        @SuppressWarnings("rawtypes")
        public ConstraintDef getConstraintDef() {
            return constraintDef;
        }

        public static ValidationWrapper createSizeDef(SizeEx ex) {
            SizeDef def =new SizeDef();
            def.max(ex.max());
            def.min(ex.min());
            def.message(ex.message());
            return new ValidationWrapper(ex.props(),def);
        }
        public static ValidationWrapper createNotNullDef(NotNullEx ex) {
            NotNullDef def = new NotNullDef();
            def.message(ex.message());
            return new ValidationWrapper(ex.props(),def);
        }
        public static ValidationWrapper createAssertFalseDef(AssertFalseEx ex) {
            AssertFalseDef def = new AssertFalseDef();
            def.message(ex.message());
            return new ValidationWrapper(ex.props(),def);
        }
        public static ValidationWrapper createAssertTrueDef(AssertTrueEx ex) {
            AssertTrueDef def = new AssertTrueDef();
            def.message(ex.message());
            return new ValidationWrapper(ex.props(),def);
        }
        public static ValidationWrapper createDecimalMaxDef(DecimalMaxEx ex) {
            DecimalMaxDef def = new DecimalMaxDef();
            def.value(ex.value());
            def.message(ex.message());
            return new ValidationWrapper(ex.props(),def);
        }
        public static ValidationWrapper createDecimalMinDef(DecimalMinEx ex) {
            DecimalMinDef def = new DecimalMinDef();
            def.value(ex.value());
            def.message(ex.message());
            return new ValidationWrapper(ex.props(),def);
        }
        public static ValidationWrapper createDigistDef(DigitsEx ex) {
            DigitsDef def = new DigitsDef();
            def.fraction(ex.fraction());
            def.integer(ex.integer());
            def.message(ex.message());
            return new ValidationWrapper(ex.props(),def);
        }
        public static ValidationWrapper createFutureDef(FutureEx ex) {
            FutureDef def = new FutureDef();
            def.message(ex.message());
            return new ValidationWrapper(ex.props(),def);
        }
        public static ValidationWrapper createMaxDef(MaxEx ex) {
            MaxDef def = new MaxDef();
            def.value(ex.value());
            def.message(ex.message());
            return new ValidationWrapper(ex.props(),def);
        }
        public static ValidationWrapper createMinDef(MinEx ex) {
            MinDef def = new MinDef();
            def.value(ex.value());
            def.message(ex.message());
            return new ValidationWrapper(ex.props(),def);
        }
        public static ValidationWrapper createNotBlankDef(NotBlankEx ex) {
            NotBlankDef def = new NotBlankDef();
            def.message(ex.message());
            return new ValidationWrapper(ex.props(),def);
        }
        public static ValidationWrapper createNotEmptyDef(NotEmptyEx ex) {
            NotEmptyDef def = new NotEmptyDef();
            def.message(ex.message());
            return new ValidationWrapper(ex.props(),def);
        }
        public static ValidationWrapper createNullDef(NullEx ex) {
            NullDef def = new NullDef();
            def.message(ex.message());
            return new ValidationWrapper(ex.props(),def);
        }
        public static ValidationWrapper createPastDef(PastEx ex) {
            PastDef def = new PastDef();
            def.message(ex.message());
            return new ValidationWrapper(ex.props(),def);
        }
        public static ValidationWrapper createPatternDef(PatternEx ex) {
            PatternDef def = new PatternDef();
            def.regexp(ex.regexp());
            def.message(ex.message());
            return new ValidationWrapper(ex.props(),def);
        }

    }


    private static final Class<?>[] EMPTY_CLASSES = new Class<?>[0];

    /**
     * 从参数, 返回值, 基类的: Generic 类型信息获取传入的实际类信息。
     *
     * @param genericType - Generic 类型信息
     *
     * @return 实际类信息
     */
    private Class<?>[] getActualClass(Type genericType) {

        if (genericType instanceof ParameterizedType) {

            Type[] actualTypes = ((ParameterizedType) genericType).getActualTypeArguments();
            Class<?>[] actualClasses = new Class<?>[actualTypes.length];

            for (int i = 0; i < actualTypes.length; i++) {
                Type actualType = actualTypes[i];
                if (actualType instanceof Class<?>) {
                    actualClasses[i] = (Class<?>) actualType;
                } else if (actualType instanceof GenericArrayType) {
                    Type componentType = ((GenericArrayType) actualType).getGenericComponentType();
                    actualClasses[i] = Array.newInstance((Class<?>) componentType, 0).getClass();
                }
            }

            return actualClasses;
        }

        return EMPTY_CLASSES;
    }

}
