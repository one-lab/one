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
import javax.validation.constraints.Size;

/**
 * Asserts that the annotated string, collection, map or array is not {@code null} or empty.
 * Accepts any type.
 * @author Morgan
 *
 */
@Target({ANNOTATION_TYPE})
@Retention(RUNTIME)
@Documented
@ReportAsSingleViolation
@NotNull
@Size(min = 1)
public @interface NotEmptyEx {
	String message() default "{org.hibernate.validator.constraints.NotEmpty.message}";
	String[] props() ;
}
