package umc.study.validation.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import umc.study.validation.validator.PageValidator;
import umc.study.validation.validator.StoreExistValidator;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PageValidator.class)
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidPage {

    String message() default "유효하지 않은 페이지 번호입니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
