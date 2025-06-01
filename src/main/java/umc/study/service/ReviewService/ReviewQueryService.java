package umc.study.service.ReviewService;

import org.springframework.data.domain.Page;
import umc.study.domain.Review;
import umc.study.service.StoreService.StoreQueryService;
import umc.study.validation.annotation.ExistStore;

public interface ReviewQueryService {
    Page<Review> getReviewList(Long MemberId, Integer page);

}
