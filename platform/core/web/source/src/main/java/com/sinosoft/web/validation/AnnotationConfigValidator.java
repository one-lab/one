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
		Size,Future,Digist,DecimalMax,
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


	public Validator getValidator(Validation configValidation ,Class<?> targetClass) {
		if(isContainsRules(configValidation)) {
			HibernateValidatorConfiguration config = javax.validation.Validation.byProvider( HibernateValidator.class ).configure();
			config.addMapping( getMapping(configValidation,targetClass));
			return  config.buildValidatorFactory().getValidator();
		} 
		return defaultValidator;
		
	}
	
	private ConstraintMapping getMapping(Validation configValidation ,Class<?> targetClass) {
		@SuppressWarnings("deprecation")
		ConstraintMapping mapping = new ConstraintMapping();
		this.addConstraction(configValidation,mapping.type(targetClass));
		return mapping;
	}
	
	

	private void addConstraction(Validation configValidation,TypeConstraintMappingContext<?> mappingContext) {
		Map<Constraint,ValidationWrapper> constrantMap =this.createConstrantMap(configValidation);
		for (Constraint con : constrantMap.keySet()) {
			this.innerConstractionMapping(mappingContext,constrantMap.get(con));
		}
	}
	

	private void innerConstractionMapping(
			TypeConstraintMappingContext<?> mappingContext, ValidationWrapper validationWrapper) {
		for(String propertyPath:validationWrapper.getProperties()) {
		 	mappingContext.property( propertyPath, ElementType.FIELD )
			 	.constraint(validationWrapper.getConstraintDef())
			 	.valid();
		}
	}
	

	private Map<Constraint, ValidationWrapper> createConstrantMap(
			Validation configValidation) {
		Map<Constraint,ValidationWrapper> constrantMap= new HashMap<AnnotationConfigValidator.Constraint, 
				ValidationWrapper>();
		if(configValidation.notNull().props().length > 0) {
			constrantMap.put(Constraint.NotNull, ValidationWrapper.createNotNullDef(configValidation.notNull()));
		}
		if(configValidation.notBlank().props().length>0) {
			constrantMap.put(Constraint.Size, ValidationWrapper.createNotBlankDef(configValidation.notBlank()));
		}
		if(configValidation.notEmpty().props().length>0) {
			constrantMap.put(Constraint.Size, ValidationWrapper.createNotEmptyDef(configValidation.notEmpty()));
		}
		if(configValidation.max().props().length>0) {
			constrantMap.put(Constraint.Size, ValidationWrapper.createMaxDef(configValidation.max()));
		}
		if(configValidation.min().props().length>0) {
			constrantMap.put(Constraint.Size, ValidationWrapper.createMinDef(configValidation.min()));
		}
		if(configValidation.pattern().props().length>0) {
			constrantMap.put(Constraint.Size, ValidationWrapper.createPatternDef(configValidation.pattern()));
		}
		if(configValidation.size().props().length>0) {
			constrantMap.put(Constraint.Size, ValidationWrapper.createSizeDef(configValidation.size()));
		}
		if(configValidation.assertFalse().props().length>0) {
			constrantMap.put(Constraint.Size, ValidationWrapper.createAssertFalseDef(configValidation.assertFalse()));
		}
		if(configValidation.assertTrue().props().length>0) {
			constrantMap.put(Constraint.Size, ValidationWrapper.createAssertTrueDef(configValidation.assertTrue()));
		}
		if(configValidation.decimalMax().props().length>0) {
			constrantMap.put(Constraint.Size, ValidationWrapper.createDecimalMaxDef(configValidation.decimalMax()));
		}
		if(configValidation.decimalMin().props().length>0) {
			constrantMap.put(Constraint.Size, ValidationWrapper.createDecimalMinDef(configValidation.decimalMin()));
		}
		if(configValidation.digits().props().length>0) {
			constrantMap.put(Constraint.Size, ValidationWrapper.createDigistDef(configValidation.digits()));
		}
		if(configValidation.future().props().length>0) {
			constrantMap.put(Constraint.Size, ValidationWrapper.createFutureDef(configValidation.future()));
		}
		if(configValidation.past().props().length>0) {
			constrantMap.put(Constraint.Size, ValidationWrapper.createPastDef(configValidation.past()));
		}
		if(configValidation.nulls().props().length>0) {
			constrantMap.put(Constraint.Size, ValidationWrapper.createNullDef(configValidation.nulls()));
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
		if( !ClassUtils.isPrimitiveOrWrapper(target.getClass()) ) {
			Validation configValidation = metaData.getAnnotation(Validation.class);
			String errorPath = configValidation.errorPath();
			
			Set<ConstraintViolation<Object>> result = getValidator(configValidation,target.getClass())
					.validate(target);
			
			if(!result.isEmpty())
				return this.isAjaxRequest(inv) ? errorAjaxResponse(result) : errorCommonResponse(inv,result,errorPath);
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

		@SuppressWarnings("rawtypes")
		private final ConstraintDef constraintDef;
		
		@SuppressWarnings("rawtypes")
		private ValidationWrapper(final String[] properties,final ConstraintDef constraintDef){
			this.properties = properties;
			this.constraintDef = constraintDef;
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
