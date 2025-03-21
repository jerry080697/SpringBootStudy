package umc.study.service.StoreService;


import org.springframework.data.domain.Page;
import umc.study.domain.Mission;
import umc.study.domain.Review;
import umc.study.domain.Store;

import java.util.Optional;

public interface StoreQueryService {

    Optional<Store> findStore(Long id); // null 반환 가능
    Page<Review> getReviewList(Long storeId, Integer page);
    Page<Mission> getMissionList(Long storeId, Integer page);
}