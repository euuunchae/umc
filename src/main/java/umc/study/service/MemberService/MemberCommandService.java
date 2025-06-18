package umc.study.service.MemberService;

import umc.study.web.dto.MemberRequestDTO;
import umc.study.domain.Member;
import umc.study.web.dto.MemberResponseDTO;

public interface MemberCommandService {
    Member joinMember(MemberRequestDTO.JoinDTO request);
    MemberResponseDTO.LoginResultDTO loginMember(MemberRequestDTO.LoginRequestDTO request);
}
