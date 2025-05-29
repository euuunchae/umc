package umc.study.service.MemberService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import umc.study.apiPayload.ApiResponse;
import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.apiPayload.exception.GeneralException;
import umc.study.domain.Member;
import umc.study.repository.MemberRepository.MemberRepository;
import umc.study.validation.annotation.ExistStore;
import umc.study.validation.annotation.ValidPage;
import umc.study.web.dto.ReviewResponseDTO;

@Service
@RequiredArgsConstructor
public class MemberQueryServiceImpl implements MemberQueryService {

    private final MemberQueryService memberQueryService;

    //내가 쓴 리뷰 조회하기
    @GetMapping("/my_review")
    @Operation(summary = "내가 쓴 리뷰 조회 API",description = "로그인 한 사용자의 리뷰 목록을 조회하는 API이며, 페이징을 포함합니다. query String 으로 page 번호를 주세요")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name="storeId", description = "가게의 아이디, path variable 입니다!")
            @Parameter(name="page", description = "조회할 페이지 번호를 입력해주세요!")
    })
    public ApiResponse<ReviewResponseDTO.ReviewPreViewListDTO> getMyReviewList(@ExistStore @PathVariable(name = "storeId") Long storeId, @RequestParam(name = "page") Integer page) {
        @CurrentMember Member member, // 직접 구현한 로그인 정보 주입 방식
        @ValidPage @RequestParam("page") Integer page) {

            ReviewResponseDTO.ReviewPreViewListDTO result = memberQueryService.getMyReviews(member, page);
            return ApiResponse.onSuccess(result);

        }

}
