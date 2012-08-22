package com.sinosoft.one.mvc.web.validation.annotation;

import java.lang.annotation.Target;
import java.lang.annotation.Retention;
import java.lang.annotation.Documented;
import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import javax.validation.Constraint;

/**
 * The annotated element size must be between the specified boundaries (included).
 *
 * Supported types are:
 * <ul>
 * <li><code>String</code> (string length is evaludated)</li>
 * <li><code>Collection</code> (collection size is evaluated)</li>
 * <li><code>Map</code> (map size is evaluated)</li>
 * <li>Array (array length is evaluated)</li>
 *
 * <code>null</code> elements are considered valid.
 *
 * @author Morgan
 */
@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = {})
public @interface SizeEx {
	String message() default "{javax.validation.constraints.Size.message}";
	
	/**
	 * @return size the element must be higher or equal to
	 */
	int min() default 0;

	/**
	 * @return size the element must be lower or equal to
	 */
	int max() default Integer.MAX_VALUE;

	String[] props() ;
}
