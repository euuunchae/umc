package umc.study.apiPayload.exception.handler;

import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.apiPayload.exception.GeneralException;

public class MemberHandler extends GeneralException {
    public MemberHandler(ErrorStatus errorStatus) {
        super(ErrorStatus.MEMBER_NOT_FOUND);
    }
}
