package com.sinosoft.one.mvc.web.validation.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Target;
import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.ElementType.PARAMETER;
import javax.validation.Constraint;

/**
 * The annotated element must be a date in the past.
 * Now is defined as the current time according to the virtual machine
 * The calendar used if the compared type is of type <code>Calendar</code>
 * is the calendar based on the current timezone and the current locale.
 * <p/>
 * Supported types are:
 * <ul>
 * <li><code>java.util.Date</code></li>
 * <li><code>java.util.Calendar</code></li>
 * </ul>
 * <p/>
 * <code>null</code> elements are considered valid.
 *
 * @author Morgan
 */
@Target({ANNOTATION_TYPE})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = {})
public @interface PastEx {
	String message() default "{javax.validation.constraints.Past.message}";
	String[] props() ;
	
}
