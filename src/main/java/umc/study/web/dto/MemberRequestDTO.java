package umc.study.web.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import umc.study.domain.enums.Gender;
import umc.study.domain.enums.Role;
import umc.study.validation.annotation.ExistCategories;

import java.util.List;

public class MemberRequestDTO {

    @Getter
    @Setter //thymeleaf에서 사용하기 위해 추가
    public static class JoinDTO{
        @NotBlank
        String name;
        @NotNull
        @Email
        String email;
        @NotBlank
        String password;
        @NotNull
        String phone;
        @NotNull
        Integer birthYear;
        @NotNull
        Integer birthMonth;
        @NotNull
        Integer birthDay;
        @NotNull
        Gender gender;
        @ExistCategories
        List<Long> memberFood;
        @NotNull
        Role role;

    }
}
