package umc.study.service.StoreService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import umc.study.domain.Review;
import umc.study.domain.Store;
import umc.study.repository.MissionRepository.MissionRepository;
import umc.study.repository.ReviewRepository.ReviewRepository;
import umc.study.repository.StoreRepository.StoreRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j

public class StoreQueryServiceImpl implements StoreQueryService {

    private final StoreRepository storeRepository;
    private final ReviewRepository reviewRepository;
    private final MissionRepository missionRepository;

    @Override
    public Optional<Store> findStore(Long id) {
        return storeRepository.findById(id);
    }



    @Override
    public Page<Review> getReviewList(Long storeId, Integer page) {
        Store store = storeRepository.findById(storeId).get(); // 먼저 storeId로 가게를 찾고

        Page<Review> storePage = reviewRepository.findAllByStore(store, PageRequest.of(page, 10)); // 해당 가게의 리뷰 10개 단위로 가져오기
        // Page<Review> : 데이터, 페이지 번호, 페이지 개수, 전체 데이터 개수, 페이지 크기, 페이지 여부, 정렬 정보 등

        return storePage;
    }


}