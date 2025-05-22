package umc.study.apiPayload.code;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import umc.study.domain.Review;
import umc.study.domain.enums.Gender;
import umc.study.domain.mapping.MemberAgree;
import umc.study.domain.mapping.MemberFood;
import umc.study.domain.mapping.MemberMission;
import umc.study.validation.annotation.ExistCategories;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MemberRequestDTO {

    @Getter
    public static class JoinDTO{
        @NotBlank
        String name;
        @NotNull
        String email;
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

    }
}
