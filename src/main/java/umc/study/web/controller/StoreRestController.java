package umc.study.web.controller;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.study.apiPayload.code.StoreRequestDTO;
import umc.study.apiPayload.code.StoreResponseDTO;
import umc.study.service.MemberService.MemberCommandService;
import umc.study.service.StoreService.StoreCommandService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/stores")
public class StoreRestController {

    private final StoreCommandService storeCommandService;

    @PostMapping
    public ResponseEntity<StoreResponseDTO.CreateStoreResultDTO> createStore(@RequestBody @Valid StoreRequestDTO.CreateStoreDTO request) {
        StoreResponseDTO.CreateStoreResultDTO result = storeCommandService.createStore(request);
        return ResponseEntity.ok(result);
    }
}
