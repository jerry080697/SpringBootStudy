package umc.study.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import umc.study.repository.StoreRepository.StoreRepository;
import umc.study.validation.annotation.StoreExist;

@RequiredArgsConstructor
public class StoreExistValidator implements ConstraintValidator<StoreExist, Integer> {

    private final StoreRepository storeRepository;

    @Override
    public boolean isValid(Integer storeId, ConstraintValidatorContext context) {
        // storeId로 가게가 존재하는지 확인하는 로직
        return storeRepository.existsById(Long.valueOf(storeId));  // storeId는 Long으로 변환해서 사용
    }
}
