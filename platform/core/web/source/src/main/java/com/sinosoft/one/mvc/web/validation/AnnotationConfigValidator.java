package com.sinosoft.one.mvc.web.validation;

import java.lang.annotation.ElementType;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.validation.Configuration;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
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
import com.sinosoft.one.mvc.web.validation.OneTraversableResolver;
import com.sinosoft.one.mvc.web.paramresolver.ParamMetaData;
import com.sinosoft.one.mvc.web.validation.enumation.ErrorMessageType;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.validator.HibernateValidator;
import org.hibernate.validator.HibernateValidatorConfiguration;
import org.hibernate.validator.cfg.ConstraintDef;
import org.hibernate.validator.cfg.ConstraintMapping;
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
import org.hibernate.validator.internal.engine.resolver.DefaultTraversableResolver;
import org.hibernate.validator.method.MethodConstraintViolation;
import org.hibernate.validator.method.MethodValidator;
import org.hibernate.validator.method.metadata.MethodDescriptor;
import org.hibernate.validator.method.metadata.ParameterDescriptor;
import org.hibernate.validator.method.metadata.TypeDescriptor;
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
 * 提供Annotation方式配置的validation实现。
 * 2012-7-5
 * 
 * @author Morgan
 *
 */
public class AnnotationConfigValidator implements ParamValidator{

	enum Constraint{
		NotNull,NotEmpty,NotBlank,Min,
		Max,Null,Past,Pattern,
		Size,Future,Digits,DecimalMax,
		DecimalMin,AssertFalse,AssertTrue;
	}

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
            OneTraversableResolver traversableResolver = new OneTraversableResolver();
            Configuration<?> config =
					javax.validation.Validation.byProvider(HibernateValidator.class).configure();
            config.traversableResolver(traversableResolver);
            if(config instanceof  HibernateValidatorConfiguration) {
                ((HibernateValidatorConfiguration)config).addMapping(getMapping(configValidation,metaData));
            }

		    return  config.buildValidatorFactory().getValidator();
		}
		return defaultValidator;
	}
	
	
	private ConstraintMapping getMapping(Validation configValidation ,ParamMetaData metaData) {
		@SuppressWarnings("deprecation")
		ConstraintMapping mapping = new ConstraintMapping();
		//针对非基本类型和包装类
		addConstraction(configValidation,mapping.type(metaData.getParamType()));

		return mapping;
	}
	

	private void addConstraction(Validation configValidation,TypeConstraintMappingContext<?> mappingContext) {
		Map<Constraint,ValidationWrapper> constrantMap =this.createConstrantMap(configValidation);
		for (Constraint con : constrantMap.keySet()) {
			this.innerConstractionMapping(mappingContext,constrantMap.get(con));
		}
	}
	
	private void innerConstractionMapping( TypeConstraintMappingContext<?> mappingContext,
			ValidationWrapper validationWrapper) {
		for(String propertyPath:validationWrapper.getProperties()) {
		 	mappingContext.property( propertyPath, ElementType.FIELD )
			 	.constraint(validationWrapper.getConstraintDef())
			 	.valid();
		}
	}

	/**
	 * 构建Bean验证用的mapping数据
	 * @param configValidation
	 * @return
	 */
	private Map<Constraint, ValidationWrapper> createConstrantMap(
			Validation configValidation) {
		Map<Constraint,ValidationWrapper> constrantMap= new HashMap<AnnotationConfigValidator.Constraint, 
				ValidationWrapper>();
		if(configValidation.notNull().props().length > 0) {
			constrantMap.put(Constraint.NotNull, ValidationWrapper.createNotNullDef(configValidation.notNull()));
		}
		if(configValidation.notBlank().props().length>0) {
			constrantMap.put(Constraint.NotBlank, ValidationWrapper.createNotBlankDef(configValidation.notBlank()));
		}
		if(configValidation.notEmpty().props().length>0) {
			constrantMap.put(Constraint.NotEmpty, ValidationWrapper.createNotEmptyDef(configValidation.notEmpty()));
		}
		if(configValidation.max().props().length>0) {
			constrantMap.put(Constraint.Max, ValidationWrapper.createMaxDef(configValidation.max()));
		}
		if(configValidation.min().props().length>0) {
			constrantMap.put(Constraint.Min, ValidationWrapper.createMinDef(configValidation.min()));
		}
		if(configValidation.pattern().props().length>0) {
			constrantMap.put(Constraint.Pattern, ValidationWrapper.createPatternDef(configValidation.pattern()));
		}
		if(configValidation.size().props().length>0) {
			constrantMap.put(Constraint.Size, ValidationWrapper.createSizeDef(configValidation.size()));
		}
		if(configValidation.assertFalse().props().length>0) {
			constrantMap.put(Constraint.AssertFalse, ValidationWrapper.createAssertFalseDef(configValidation.assertFalse()));
		}
		if(configValidation.assertTrue().props().length>0) {
			constrantMap.put(Constraint.AssertTrue, ValidationWrapper.createAssertTrueDef(configValidation.assertTrue()));
		}
		if(configValidation.decimalMax().props().length>0) {
			constrantMap.put(Constraint.DecimalMax, ValidationWrapper.createDecimalMaxDef(configValidation.decimalMax()));
		}
		if(configValidation.decimalMin().props().length>0) {
			constrantMap.put(Constraint.DecimalMin, ValidationWrapper.createDecimalMinDef(configValidation.decimalMin()));
		}
		if(configValidation.digits().props().length>0) {
			constrantMap.put(Constraint.Digits, ValidationWrapper.createDigistDef(configValidation.digits()));
		}
		if(configValidation.future().props().length>0) {
			constrantMap.put(Constraint.Future, ValidationWrapper.createFutureDef(configValidation.future()));
		}
		if(configValidation.past().props().length>0) {
			constrantMap.put(Constraint.Past, ValidationWrapper.createPastDef(configValidation.past()));
		}
		if(configValidation.nulls().props().length>0) {
			constrantMap.put(Constraint.Null, ValidationWrapper.createNullDef(configValidation.nulls()));
		}
		
		//--
		return constrantMap;
	}

	@Override
	public boolean supports(ParamMetaData metaData) {
		return metaData.getAnnotation(Validation.class) != null;
	}

	@Override
	public Object validate(ParamMetaData metaData, Invocation inv,
			Object target, Errors errors) {

		if(logger.isDebugEnabled()){
			logger.debug("[annotation config validate] "+"use validator: "
					+" to validate "+target);
		}

		Validation configValidation = metaData.getAnnotation(Validation.class);
		String errorPath = configValidation.errorPath();
		if(isContainsRules(configValidation)){
			Set<ConstraintViolation<Object>> result = getValidator(metaData,configValidation).validate(target);
			if(!result.isEmpty()) {
                return this.isAjaxRequest(inv) ? errorAjaxResponse(result) : errorCommonResponse(inv,result,errorPath);
            }

		} else if(ClassUtils.isPrimitiveOrWrapper(metaData.getParamType())){

            MethodValidator methodValidator = javax.validation.Validation.byProvider(HibernateValidator.class).configure()
                    .buildValidatorFactory().getValidator().unwrap(MethodValidator.class);

            Set<MethodConstraintViolation<Object>> result =
                    methodValidator.validateAllParameters(inv.getController(), inv.getMethod(), inv.getMethodParameters());

            if(!result.isEmpty()){
                return this.isAjaxRequest(inv) ? methodErrorAjaxResponse(result, inv.getMethodParameterNames()) :
                        methodErrorCommonResponse(inv, result, errorPath, inv.getMethodParameterNames());
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
	 * 判断Validation是否包含验证规则的定义。
	 * @param configValidation
	 * @return
	 */
	private boolean isContainsRules(Validation configValidation) {
		if(configValidation.notNull().props().length > 0) {return true;}
		if(configValidation.notBlank().props().length > 0) {return true;}
		if(configValidation.notEmpty().props().length > 0) {return true;}
		if(configValidation.max().props().length > 0) {return true;}
		if(configValidation.min().props().length > 0) {return true;}
		if(configValidation.pattern().props().length > 0) {return true;}
		if(configValidation.size().props().length > 0) {return true;}
		if(configValidation.assertFalse().props().length > 0) {return true;}
		if(configValidation.assertTrue().props().length > 0) {return true;}
		if(configValidation.decimalMax().props().length > 0) {return true;}
		if(configValidation.decimalMin().props().length > 0) {return true;}
		if(configValidation.digits().props().length > 0) {return true;}
		if(configValidation.future().props().length > 0) {return true;}
		if(configValidation.past().props().length > 0) {return true;}
		if(configValidation.nulls().props().length > 0) {return true;}
		return false;
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
	
}
