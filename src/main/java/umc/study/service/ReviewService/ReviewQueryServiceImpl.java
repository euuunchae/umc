package umc.study.service.ReviewService;


import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.converter.ReviewConverter;
import umc.study.domain.Member;
import umc.study.domain.Review;
import umc.study.domain.Store;
import umc.study.repository.ReviewRepository.ReviewRepository;
import umc.study.repository.StoreRepository.StoreRepository;
import umc.study.web.dto.ReviewResponseDTO;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ReviewQueryServiceImpl implements ReviewQueryService {



    @Override
    public ReviewResponseDTO.ReviewPreViewListDTO getMyReviews(Member member, Integer page) {
        Pageable pageable = PageRequest.of(page, 10);
        Page<Review> reviews = reviewRepository.findAllByMember(member, pageable);
        return ReviewConverter.reviewPreViewListDTO(reviews);
    }

}
