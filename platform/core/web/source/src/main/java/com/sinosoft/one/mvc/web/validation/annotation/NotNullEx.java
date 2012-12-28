package com.sinosoft.one.mvc.web.validation.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Target;
import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.ElementType.PARAMETER;
import javax.validation.Constraint;

/**
 * The annotated element must not be <code>null</code>.
 * Accepts any type.
 *
 * @author Morgan
 */
@Target({ANNOTATION_TYPE})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = {})
public @interface NotNullEx {
	String message() default "{javax.validation.constraints.NotNull.message}";

	String[] props() ;
}
