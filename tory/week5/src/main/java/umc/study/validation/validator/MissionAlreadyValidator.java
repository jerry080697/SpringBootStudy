package umc.study.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import umc.study.repository.StoreRepository.StoreRepository;
import umc.study.validation.annotation.MissionAlready;

@RequiredArgsConstructor
public class MissionAlreadyValidator implements ConstraintValidator<MissionAlready, Long> {

    private final StoreRepository storeRepository;  // MissionRepository -> StoreRepository로 변경

    @Override
    public boolean isValid(Long storeId, ConstraintValidatorContext context) {
        // storeId가 존재하고 해당 storeId에 가게가 존재하는지 확인하는 로직
        return storeRepository.existsById(storeId);
    }
}
