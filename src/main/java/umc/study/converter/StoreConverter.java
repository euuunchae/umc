package umc.study.converter;

import org.springframework.data.domain.Page;
import umc.study.domain.Region;
import umc.study.domain.Review;
import umc.study.web.dto.ReviewResponseDTO;
import umc.study.web.dto.StoreRequestDTO;
import umc.study.web.dto.StoreResponseDTO;
import umc.study.domain.Store;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class StoreConverter {

    public static StoreResponseDTO.AddStoreResultDTO toAddStoreResultDTO(Store store) {
        return StoreResponseDTO.AddStoreResultDTO.builder()
                .storeId(store.getId())
                .storeName(store.getName())
                .rating(store.getRating())
                .regionName(store.getRegion().getName())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Store toStore(StoreRequestDTO.AddStoreDTO request, Region region) {
        return Store.builder()
                .name(request.getName())
                .rating(request.getRating())
                .region(region)
                .build();
    }

    //리뷰 조회하기
    public static ReviewResponseDTO.ReviewPreViewDTO reviewPreViewDTO(Review review){
        return ReviewResponseDTO.ReviewPreViewDTO.builder()
                .ownerNickname(review.getMember().getName())
                .rating(review.getRating())
                .createdAt(review.getCreatedAt().toLocalDate())
                .content(review.getContent())
                .build();
    }
    public static ReviewResponseDTO.ReviewPreViewListDTO reviewPreViewListDTO(Page<Review> reviewList){

        List<ReviewResponseDTO.ReviewPreViewDTO> reviewPreViewDTOList = reviewList.getContent().stream()
                .map(StoreConverter::reviewPreViewDTO).collect(Collectors.toList());

        return ReviewResponseDTO.ReviewPreViewListDTO.builder()
                .isLast(reviewList.isLast())
                .isFirst(reviewList.isFirst())
                .totalPage(reviewList.getTotalPages())
                .totalElements(reviewList.getTotalElements())
                .listSize(reviewPreViewDTOList.size())
                .reviewList(reviewPreViewDTOList)
                .build();
    }
}
