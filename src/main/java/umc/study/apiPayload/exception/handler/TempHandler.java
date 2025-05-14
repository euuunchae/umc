package umc.study.apiPayload.exception.handler;

import org.springframework.http.HttpStatus;
import umc.study.apiPayload.code.BaseErrorCode;
import umc.study.apiPayload.exception.GeneralException;

public class TempHandler extends GeneralException {

    public TempHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
