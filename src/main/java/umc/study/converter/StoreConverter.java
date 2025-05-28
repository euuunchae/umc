package umc.study.converter;

import umc.study.domain.Region;
import umc.study.web.dto.StoreRequestDTO;
import umc.study.web.dto.StoreResponseDTO;
import umc.study.domain.Store;

import java.time.LocalDateTime;

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

}
