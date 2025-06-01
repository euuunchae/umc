package umc.study.converter;

import org.springframework.data.domain.Page;
import umc.study.domain.Review;
import umc.study.domain.Store;
import umc.study.web.dto.ReviewRequestDTO;
import umc.study.web.dto.ReviewResponseDTO;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class ReviewConverter {

    public static ReviewResponseDTO.AddReviewResultDTO toAddReviewResultDTO(Review review) {
        return ReviewResponseDTO.AddReviewResultDTO.builder()
                .reviewId(review.getId())
                .content(review.getContent())
                .rating(review.getRating())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Review toReview(ReviewRequestDTO.AddReviewDTO request, Store store) {
        return Review.builder()
                .content(request.getContent())
                .rating(request.getRating())
                .store(store)
                .build();
    }


}

