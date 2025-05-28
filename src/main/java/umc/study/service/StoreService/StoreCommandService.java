package umc.study.service.StoreService;

import jakarta.validation.Valid;
import umc.study.web.dto.StoreRequestDTO;
import umc.study.web.dto.StoreResponseDTO;

public interface StoreCommandService {
    StoreResponseDTO registerStore(StoreRequestDTO.CreateStoreDTO dto);

    StoreResponseDTO.CreateStoreResultDTO createStore(StoreRequestDTO.@Valid CreateStoreDTO request);
}
