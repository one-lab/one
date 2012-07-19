package com.sinosoft.web.validation;

import java.lang.annotation.ElementType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.PostConstruct;
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

import net.paoding.rose.web.Invocation;
import net.paoding.rose.web.ParamValidator;
import net.paoding.rose.web.paramresolver.ParamMetaData;

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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ClassUtils;
import org.springframework.validation.Errors;

import com.sinosoft.web.instruction.reply.Replys;
import com.sinosoft.web.instruction.reply.transport.Json;
import com.sinosoft.web.validation.annotation.AssertFalseEx;
import com.sinosoft.web.validation.annotation.AssertTrueEx;
import com.sinosoft.web.validation.annotation.DecimalMaxEx;
import com.sinosoft.web.validation.annotation.DecimalMinEx;
import com.sinosoft.web.validation.annotation.DigitsEx;
import com.sinosoft.web.validation.annotation.FutureEx;
import com.sinosoft.web.validation.annotation.MaxEx;
import com.sinosoft.web.validation.annotation.MinEx;
import com.sinosoft.web.validation.annotation.NotBlankEx;
import com.sinosoft.web.validation.annotation.NotEmptyEx;
import com.sinosoft.web.validation.annotation.NotNullEx;
import com.sinosoft.web.validation.annotation.NullEx;
import com.sinosoft.web.validation.annotation.PastEx;
import com.sinosoft.web.validation.annotation.PatternEx;
import com.sinosoft.web.validation.annotation.SizeEx;
import com.sinosoft.web.validation.annotation.Validation;

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
		
		if(isContainsRules(configValidation) || 
				ClassUtils.isPrimitiveOrWrapper(metaData.getParamType())) {
			HibernateValidatorConfiguration config = 
					javax.validation.Validation.byProvider( HibernateValidator.class ).configure();
			config.addMapping( getMapping(configValidation,metaData));
			return  config.buildValidatorFactory().getValidator();
		}
		
		return defaultValidator;
		
	}
	
	
	private ConstraintMapping getMapping(Validation configValidation ,ParamMetaData metaData) {
		@SuppressWarnings("deprecation")
		ConstraintMapping mapping = new ConstraintMapping();
		//针对非基本类型和包装类
		if( ! ClassUtils.isPrimitiveOrWrapper(metaData.getParamType()) ) {
			addConstraction(configValidation,mapping.type(metaData.getParamType()));
		} else {
			addConstraction(metaData, mapping);
		}
		
		return mapping;
	}
	
	private void addConstraction(ParamMetaData metaData,
			ConstraintMapping mapping) {
		Map<Constraint,ValidationWrapper> constrantMap =this.createConstrantMap(metaData);
		
		TypeConstraintMappingContext<?> constraintType = mapping.type(metaData.getParamType());
		for (Constraint con : constrantMap.keySet()) {
			this.innerConstractionMappingForValue(constraintType, constrantMap.get(con));
		}
	}


	private void addConstraction(Validation configValidation,TypeConstraintMappingContext<?> mappingContext) {
		Map<Constraint,ValidationWrapper> constrantMap =this.createConstrantMap(configValidation);
		for (Constraint con : constrantMap.keySet()) {
			this.innerConstractionMapping(mappingContext,constrantMap.get(con));
		}
	}
	
	private void innerConstractionMappingForValue( TypeConstraintMappingContext<?> mappingContext,
			ValidationWrapper validationWrapper) {
		mappingContext.property(validationWrapper.getParamName(), ElementType.LOCAL_VARIABLE)
			.constraint(validationWrapper.getConstraintDef())
			.valid();
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
	 * 构建单个参数验证用的mapping数据
	 * @param metaData
	 * @return
	 */
	private Map<Constraint, ValidationWrapper> createConstrantMap(
			ParamMetaData metaData) {
		Map<Constraint,ValidationWrapper> constrantMap= new HashMap<AnnotationConfigValidator.Constraint, 
				ValidationWrapper>();
		final String paramName = metaData.getParamName();
		if( metaData.getAnnotation(NotNull.class) != null ) {
			constrantMap.put(Constraint.NotNull, 
					ValidationWrapper.createNotNullDef(metaData.getAnnotation(NotNull.class),paramName));
		}
		if( metaData.getAnnotation(NotBlank.class) != null ) {
			constrantMap.put(Constraint.NotBlank, ValidationWrapper.createNotBlankDef(metaData.getAnnotation(NotBlank.class),paramName));
		}
		if(  metaData.getAnnotation(NotEmpty.class) != null ) {
			constrantMap.put(Constraint.NotEmpty, ValidationWrapper.createNotEmptyDef( metaData.getAnnotation(NotEmpty.class),paramName));
		}
		if( metaData.getAnnotation(Max.class) != null ) {
			constrantMap.put(Constraint.Max, ValidationWrapper.createMaxDef(metaData.getAnnotation(Max.class),paramName));
		}
		if( metaData.getAnnotation(Min.class) != null ) {
			constrantMap.put(Constraint.Min, ValidationWrapper.createMinDef(metaData.getAnnotation(Min.class),paramName));
		}
		if( metaData.getAnnotation(Pattern.class) != null ) {
			constrantMap.put(Constraint.Pattern, ValidationWrapper.createPatternDef(metaData.getAnnotation(Pattern.class),paramName));
		}
		if( metaData.getAnnotation(Size.class) != null ) {
			constrantMap.put(Constraint.Size, ValidationWrapper.createSizeDef(metaData.getAnnotation(Size.class),paramName));
		}
		if( metaData.getAnnotation(AssertFalse.class) != null ) {
			constrantMap.put(Constraint.AssertFalse, ValidationWrapper.createAssertFalseDef(metaData.getAnnotation(AssertFalse.class),paramName));
		}
		if( metaData.getAnnotation(AssertTrue.class) != null ) {
			constrantMap.put(Constraint.AssertTrue, ValidationWrapper.createAssertTrueDef(metaData.getAnnotation(AssertTrue.class),paramName));
		}
		if( metaData.getAnnotation(DecimalMax.class) != null ) {
			constrantMap.put(Constraint.DecimalMax, ValidationWrapper.createDecimalMaxDef(metaData.getAnnotation(DecimalMax.class),paramName));
		}
		if( metaData.getAnnotation(DecimalMin.class) != null ) {
			constrantMap.put(Constraint.DecimalMin, ValidationWrapper.createDecimalMinDef(metaData.getAnnotation(DecimalMin.class),paramName));
		}
		if( metaData.getAnnotation(Digits.class) != null ) {
			constrantMap.put(Constraint.Digits, ValidationWrapper.createDigistDef(metaData.getAnnotation(Digits.class),paramName));
		}
		if( metaData.getAnnotation(Future.class) != null ) {
			constrantMap.put(Constraint.Future, ValidationWrapper.createFutureDef(metaData.getAnnotation(Future.class),paramName));
		}
		if( metaData.getAnnotation(Past.class) != null ) {
			constrantMap.put(Constraint.Past, ValidationWrapper.createPastDef(metaData.getAnnotation(Past.class),paramName));
		}
		if( metaData.getAnnotation(Null.class) != null ) {
			constrantMap.put(Constraint.Null, ValidationWrapper.createNullDef(metaData.getAnnotation(Null.class),paramName));
		}
		return constrantMap;
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
			if(!result.isEmpty())
				return this.isAjaxRequest(inv) ? errorAjaxResponse(result) : errorCommonResponse(inv,result,errorPath);
		} else if(ClassUtils.isPrimitiveOrWrapper(metaData.getParamType())){
//			Set<?> result2 = getValidator(metaData,configValidation).
//					validateValue(metaData.getParamType(), metaData.getParamName(),target);
//			
//			if(!result2.isEmpty()){
//				
//			}
				//return this.isAjaxRequest(inv) ? errorAjaxResponse(result2) : errorCommonResponse(inv,result2,errorPath);
		}
		
		
	
		
		return null;
	}
	
	
	private String errorCommonResponse(Invocation inv,Set<ConstraintViolation<Object>> result,String errorPath){
		for(Iterator<ConstraintViolation<Object>> it = result.iterator(); it.hasNext();) {
			ConstraintViolation<Object> cv = it.next();
			inv.addModel(cv.getPropertyPath()+"ErrorMsg",cv);
		}
		return errorPath;
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
	 * @param validation
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
		public static ValidationWrapper createSizeDef(Size ex,String paramName) {
			SizeDef def =new SizeDef();
			def.max(ex.max());
			def.min(ex.min());
			def.message(ex.message());
			return new ValidationWrapper(paramName,def);
		}
		public static ValidationWrapper createNotNullDef(NotNull ex,String paramName) {
			NotNullDef def = new NotNullDef();
			def.message(ex.message());
			return new ValidationWrapper(paramName,def);
		}
		public static ValidationWrapper createAssertFalseDef(AssertFalse ex,String paramName) {
			AssertFalseDef def = new AssertFalseDef();
			def.message(ex.message());
			return new ValidationWrapper(paramName,def);
		}
		public static ValidationWrapper createAssertTrueDef(AssertTrue ex,String paramName) {
			AssertTrueDef def = new AssertTrueDef();
			def.message(ex.message());
			return new ValidationWrapper(paramName,def);
		}
		public static ValidationWrapper createDecimalMaxDef(DecimalMax ex,String paramName) {
			DecimalMaxDef def = new DecimalMaxDef();
			def.value(ex.value());
			def.message(ex.message());
			return new ValidationWrapper(paramName,def);
		}
		public static ValidationWrapper createDecimalMinDef(DecimalMin ex,String paramName) {
			DecimalMinDef def = new DecimalMinDef();
			def.value(ex.value());
			def.message(ex.message());
			return new ValidationWrapper(paramName,def);
		}
		public static ValidationWrapper createDigistDef(Digits ex,String paramName) {
			DigitsDef def = new DigitsDef();
			def.fraction(ex.fraction());
			def.integer(ex.integer());
			def.message(ex.message());
			return new ValidationWrapper(paramName,def);
		}
		public static ValidationWrapper createFutureDef(Future ex,String paramName) {
			FutureDef def = new FutureDef();
			def.message(ex.message());
			return new ValidationWrapper(paramName,def);
		}
		public static ValidationWrapper createMaxDef(Max ex,String paramName) {
			MaxDef def = new MaxDef();
			def.value(ex.value());
			def.message(ex.message());
			return new ValidationWrapper(paramName,def);
		}
		public static ValidationWrapper createMinDef(Min ex,String paramName) {
			MinDef def = new MinDef();
			def.value(ex.value());
			def.message(ex.message());
			return new ValidationWrapper(paramName,def);
		}
		public static ValidationWrapper createNotBlankDef(NotBlank ex,String paramName) {
			NotBlankDef def = new NotBlankDef();
			def.message(ex.message());
			return new ValidationWrapper(paramName,def);
		}
		public static ValidationWrapper createNotEmptyDef(NotEmpty ex,String paramName) {
			NotEmptyDef def = new NotEmptyDef();
			def.message(ex.message());
			return new ValidationWrapper(paramName,def);
		}
		public static ValidationWrapper createNullDef(Null ex,String paramName) {
			NullDef def = new NullDef();
			def.message(ex.message());
			return new ValidationWrapper(paramName,def);
		}
		public static ValidationWrapper createPastDef(Past ex,String paramName) {
			PastDef def = new PastDef();
			def.message(ex.message());
			return new ValidationWrapper(paramName,def);
		}
		public static ValidationWrapper createPatternDef(Pattern ex,String paramName) {
			PatternDef def = new PatternDef();
			def.regexp(ex.regexp());
			def.message(ex.message());
			return new ValidationWrapper(paramName,def);
		}
		
	}
	
}
