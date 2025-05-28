package umc.study.apiPayload.exception.handler;

import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.apiPayload.exception.GeneralException;

public class RegionHandler extends GeneralException {
    public RegionHandler(ErrorStatus errorStatus) {
        super(ErrorStatus.REGION_NOT_FOUND);
    }
}
