package com.sinosoft.one.mvc.web.validation.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.sinosoft.one.mvc.web.validation.enumation.ConfigType;

/**
 * 加上此注解采用默认的验证器验证相关对象
 * @author Morgan
 *
 */
@Target( { ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Validation {
    String value() default "";
    /**
     * 配置类型<br>
     * default <code>ConfigType.BEAN</code><br>
     * <code>ConfigType.BEAN</code> 代表采用Bean中的注解验证属性<br>
     * 
     * <code>ConfigType.ANNOTATION</code> 代表采用Validation中的注解验证属性
     * @return
     * 
     * @author Morgan
     */
    
    String errorPath();
    
    NotBlankEx notBlank() default @NotBlankEx(props = {});
    
    NotNullEx notNull() default @NotNullEx(props = {});
    
    NotEmptyEx notEmpty() default @NotEmptyEx(props = {});
    
    SizeEx size() default @SizeEx(props = {});
    
    AssertFalseEx assertFalse() default @AssertFalseEx(props = {});
    
    AssertTrueEx assertTrue() default @AssertTrueEx(props = {});
    
    DecimalMaxEx decimalMax() default @DecimalMaxEx(props = {}, value = "");
    
    DecimalMinEx decimalMin() default @DecimalMinEx(props = {}, value = "");
    
    DigitsEx digits() default @DigitsEx(fraction = 0, integer = 0, props = {});
    
    FutureEx future() default @FutureEx(props = {});
    
    MaxEx max() default @MaxEx(props = {}, value = 0);
    
    MinEx min() default @MinEx(props = {}, value = 0);
    
    PastEx past() default @PastEx(props = {});
    
    PatternEx pattern() default @PatternEx(props = {}, regexp = "");
    
    NullEx nulls() default @NullEx(props = {});
}

