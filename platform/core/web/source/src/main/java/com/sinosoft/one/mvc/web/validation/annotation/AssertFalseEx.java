package com.sinosoft.one.mvc.web.validation.annotation;

import java.lang.annotation.Documented;
import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.PARAMETER;
import java.lang.annotation.Retention;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Target;
import javax.validation.Constraint;

/**
 * The annotated element must be false.
 * Supported types are <code>boolean</code> and <code>Boolean</code>
 * <p/>
 * <code>null</code> elements are considered valid.
 *
 * @author Morgan
 */
@Target({ANNOTATION_TYPE})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = {})
public @interface AssertFalseEx {
	String message() default "{javax.validation.constraints.AssertFalse.message}";
	
	String[] props() ;


}
