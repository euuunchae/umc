package umc.study.service.MemberService;

import umc.study.domain.Member;
import umc.study.web.dto.ReviewResponseDTO;

public interface MemberQueryService {
    ReviewResponseDTO.ReviewPreViewListDTO getMyReviews(Member member, Integer page);
}
