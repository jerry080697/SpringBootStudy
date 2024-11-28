package umc.study.service.StoreService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import umc.study.domain.Review;
import umc.study.domain.Store;
import umc.study.domain.User;
import umc.study.repository.ReviewRepository.ReviewRepository;
import umc.study.repository.StoreRepository.StoreRepository;
import umc.study.repository.UserRepository.UserRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor

public class StoreQueryServiceImpl implements StoreQueryService {

    private final StoreRepository storeRepository;
    private final ReviewRepository reviewRepository;
    private final UserRepository userRepository;

    @Override
    public Optional<Store> findStore(Long id) {
        return storeRepository.findById(id);
    }


    @Override
    public Page<Review> getReviewList(Long storeId, Integer page) {


        Store store = storeRepository.findById(Long.valueOf(storeId)).get();

        Page<Review> StorePage = reviewRepository.findAllByStore(store, PageRequest.of(page, 10));
        return StorePage;
    }

    @Override
    public Page<Review> getUserReviewList(Integer UserId, Integer page) {


        User user = userRepository.findById(UserId).get();


        Page<Review> StorePage = reviewRepository.findAllByUser(user, PageRequest.of(page, 10));
        return StorePage;
    }
}