package umc.study.converter;

import umc.study.web.dto.StoreRequestDTO;
import umc.study.web.dto.StoreResponseDTO;
import umc.study.domain.Region;
import umc.study.domain.Store;

public class StoreConverter {

    public static Store toStore(StoreRequestDTO.CreateStoreDTO dto, Region region) {
        return Store.builder()
                .name(dto.getName())
                .rating(dto.getRating())
                .region(region)
                .build();
    }

    public static StoreResponseDTO.CreateStoreResultDTO toCreateResultDTO(Store store) {
        return StoreResponseDTO.CreateStoreResultDTO.builder()
                .storeId(store.getId())
                .regionName(store.getRegion().getName())
                .createdAt(store.getCreatedAt())
                .build();
    }
}
