package com.sinosoft.one.mvc.web.validation.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Target;
import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.ElementType.PARAMETER;
import javax.validation.Constraint;

/**
 * The annotated element must be a number whose value must be higher or
 * equal to the specificed minimum.
 * <p/>
 * Supported types are:
 * <ul>
 * <li><code>BigDecimal</code></li>
 * <li><code>BigInteger</code></li>
 * <li><code>String</code></li>
 * <li><code>byte</code>, <code>short</code>, <code>int</code>, <code>long</code>,
 * and their respective wrappers</li>
 * </ul>
 * Note that <code>double</code> and <code>float</code> are not supported due to rounding errors
 * (some providers might provide some approximative support)
 * <p/>
 * <code>null</code> elements are considered valid
 *
 * @author Morgan
 */
@Target({ANNOTATION_TYPE})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = {})
public @interface DecimalMinEx {
	String message() default "{javax.validation.constraints.DecimalMin.message}";

	
	/**
	 * The <code>String</code> representation of the min value according to the
	 * <code>BigDecimal</code> string representation
	 * @return value the element must be higher or equal to
	 */
	String value();

	String[] props() ;
}
