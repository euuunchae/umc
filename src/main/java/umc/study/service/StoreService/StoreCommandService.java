package umc.study.service.StoreService;

import umc.study.apiPayload.code.StoreRequestDTO;
import umc.study.apiPayload.code.StoreResponseDTO;

public interface StoreCommandService {
    StoreResponseDTO registerStore(StoreRequestDTO.CreateStoreDTO dto);
}
