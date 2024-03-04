package icu.fdss.validation;

import icu.fdss.annotation.State;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class StateValidation implements ConstraintValidator<State, String> {
    /**
     * 提供校验逻辑
     *
     * @param s                          待校验的值
     * @param constraintValidatorContext 约束校验上下文
     * @return boolean 是否校验通过
     */
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (s == null) {
            return false;
        }
        return "已发布".equals(s) || "草稿".equals(s);
    }
}
