package umc.study.service.StoreService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import umc.study.converter.StoreConverter;
import umc.study.domain.Store;
import umc.study.repository.StoreRepository.StoreRepository;
import umc.study.web.dto.StoreRequestDTO;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Validated  // 클래스 수준에서 유효성 검사를 활성화
public class StoreCommandServiceImpl implements StoreCommandService {

    private final StoreRepository storeRepository;

    @Override
    @Transactional
    public Store joinStore(@Valid StoreRequestDTO.JoinStoreDto request) {
        Store newStore = StoreConverter.toStore(request);
        newStore.setCreatedAt(LocalDateTime.now());
        newStore.setUpdatedAt(LocalDateTime.now());
        newStore.setStarRate(4.5);

        return storeRepository.save(newStore);
    }
}
