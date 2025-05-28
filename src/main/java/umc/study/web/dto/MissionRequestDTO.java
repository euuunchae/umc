package umc.study.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.time.LocalDate;

public class MissionRequestDTO {

    @Getter
    public static class AddMissionDTO{

        @NotBlank(message = "미션 내용은 필수입니다.")
        String content;

        @NotNull(message = "리워드는 필수입니다.")
        Integer reward;

        @NotNull
        LocalDate deadline;

    }
}
