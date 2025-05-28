package umc.study.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

public class ReviewRequestDTO {

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class AddReviewDTO{ //가게에 리뷰 추가하기

        @NotBlank(message = "내용 입력은 필수입니다.")
        String content;

        @NotNull
        Float rating;

        @NotNull
        int storeId;

    }

}
