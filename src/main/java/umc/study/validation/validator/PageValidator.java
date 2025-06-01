package umc.study.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import umc.study.validation.annotation.ValidPage;

public class PageValidator implements ConstraintValidator<ValidPage, Integer> {

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        return value != null && value > 0; // 1페이지 이상만 허용
    }
}
