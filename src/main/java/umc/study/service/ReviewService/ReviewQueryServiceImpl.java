package umc.study.service.ReviewService;


import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.domain.Member;
import umc.study.domain.Review;
import umc.study.repository.MemberRepository.MemberRepositoryCustom;
import umc.study.repository.ReviewRepository.ReviewRepository;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ReviewQueryServiceImpl implements ReviewQueryService {
    private final ReviewRepository reviewRepository;
    private final MemberRepositoryCustom memberRepositoryCustom;

    @Override
    @Transactional
    public Page<Review> getReviewList(Long MemberId, Integer page) {
        Member member = memberRepositoryCustom.findMemberInfoById(MemberId);

        Page<Review> reviewPage = reviewRepository.findAllByMember(member, PageRequest.of(page -1, 10));
        return reviewPage;
    }


}
