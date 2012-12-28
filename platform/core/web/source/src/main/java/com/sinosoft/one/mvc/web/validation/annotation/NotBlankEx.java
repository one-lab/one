package com.sinosoft.one.mvc.web.validation.annotation;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.ReportAsSingleViolation;
import javax.validation.constraints.NotNull;

/**
 * The annotated element must not be <code>null</code> or <code>""</code>.
 * Accepts any type.
 * @author Morgan
 *
 */
@Target({ANNOTATION_TYPE})
@Retention(RUNTIME)
@Documented
@ReportAsSingleViolation
@NotNull
public @interface NotBlankEx {
	String message() default "{org.hibernate.validator.constraints.NotBlank.message}";
	String[] props() ;
}
