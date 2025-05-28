package umc.study.apiPayload.exception.handler;

import lombok.Getter;
import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.apiPayload.exception.GeneralException;

@Getter
public class FoodCategoryHandler extends GeneralException {
    public FoodCategoryHandler(ErrorStatus errorStatus) {
        super(errorStatus);
    }
}
