package umc.study.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

public class StoreRequestDTO {

    @Getter
    public static class AddStoreDTO{

        @NotBlank(message = "가게 이름은 필수입니다.")
        String name;

        @NotNull(message = "별점은 필수입니다.")
        Float rating;

        @NotNull
        int regionId;

    }
}
