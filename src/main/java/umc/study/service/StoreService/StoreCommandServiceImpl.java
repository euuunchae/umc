package umc.study.service.StoreService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.domain.Region;
import umc.study.repository.RegionRepository.RegionRepository;
import umc.study.web.dto.StoreResponseDTO;
import umc.study.repository.StoreRepository.StoreRepository;

@Service
@RequiredArgsConstructor
public class StoreCommandServiceImpl {
    private final StoreRepository storeRepository;
    private final RegionRepository regionRepository;
/*
    @Override
    @Transactional
    public StoreResponseDTO registerStore(StoreRequestDTO.StoreRegisterDTO dto) {
        Region region = regionRepository.findById(dto.getRegionId())
                .orElseThrow(() -> new RegionHandler(ErrorStatus.REGION_NOT_FOUND));

        Store store = StoreConverter.toStore(dto, region);

        return StoreConverter.toStoreResponseDTO(storeRepository.save(store));
    }

*
 */
}