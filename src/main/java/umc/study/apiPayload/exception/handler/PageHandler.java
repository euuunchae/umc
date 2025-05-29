package umc.study.apiPayload.exception.handler;

import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.apiPayload.exception.GeneralException;

public class PageHandler extends GeneralException {
    public PageHandler() {

        super(ErrorStatus.PAGE_OUT_OF_RANGE);
    }
}
