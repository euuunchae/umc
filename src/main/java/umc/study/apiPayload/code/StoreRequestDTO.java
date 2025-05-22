package umc.study.apiPayload.code;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

public class StoreRequestDTO {

    @Getter
    public static class CreateStoreDTO{
        @NotBlank
        private String name;

        @NotNull
        private Float rating;

        @NotNull
        private Long regionId;
    }
}
