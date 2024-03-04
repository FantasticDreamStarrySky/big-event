package icu.fdss.annotation;

import icu.fdss.validation.StateValidation;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * 自定义校验注解
 *
 * @author 🌃梦幻◎星空🌃
 */
@Documented // 说明该注解将被包含在javadoc中
@Target({FIELD})    // 说明该注解可以被应用于字段
@Retention(RUNTIME) // 说明该注解将被保留到什么级别
@Constraint(validatedBy = {StateValidation.class})  // 说明该注解将被哪个校验器进行校验
public @interface State {

    /**
     * 提供校验不通过时的提示信息
     */
    String message() default "state参数的值只能是已发布或者草稿";

    /**
     * 用于指定校验分组
     */
    Class<?>[] groups() default {};

    /**
     * 用于指定负载   获取到State注解的附加信息
     */
    Class<? extends Payload>[] payload() default {};

}
