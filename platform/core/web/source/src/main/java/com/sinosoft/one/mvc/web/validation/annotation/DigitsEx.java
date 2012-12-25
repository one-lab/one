package com.sinosoft.one.mvc.web.validation.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Target;
import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.ElementType.PARAMETER;
import javax.validation.Constraint;

/**
 * The annotated element must be a number within accepted range
 * Supported types are:
 * <ul>
 * <li><code>BigDecimal</code></li>
 * <li><code>BigInteger</code></li>
 * <li><code>String</code></li>
 * <li><code>byte</code>, <code>short</code>, <code>int</code>, <code>long</code>,
 * and their respective wrapper types</li>
 * </ul>
 * <p/>
 * <code>null</code> elements are considered valid
 *
 * @author Morgan
 */
@Target({ANNOTATION_TYPE})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = {})
public @interface DigitsEx {
	String message() default "{javax.validation.constraints.Digits.message}";


	/**
	 * @return maximum number of integral digits accepted for this number.
	 */
	int integer();

	/**
	 * @return maximum number of fractional digits accepted for this number.
	 */
	int fraction();
	
	String[] props() ;

}
