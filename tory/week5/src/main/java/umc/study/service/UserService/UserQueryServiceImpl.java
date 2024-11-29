package umc.study.service.UserService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import umc.study.domain.Review;
import umc.study.domain.User;
import umc.study.repository.ReviewRepository.ReviewRepository;
import umc.study.repository.UserRepository.UserRepository;

@Service
public class UserQueryServiceImpl implements UserQueryService {
    private final UserRepository userRepository;
    private final ReviewRepository reviewRepository;

    public UserQueryServiceImpl(UserRepository userRepository, ReviewRepository reviewRepository) {
        this.userRepository = userRepository;
        this.reviewRepository = reviewRepository;
    }

    @Override
    public Page<Review> getUserReviewList(Integer userId, Integer page) {
        User user = userRepository.findById(userId).get();

        Page<Review> userPage = reviewRepository.findAllByUser(user, PageRequest.of(page, 10));


        return userPage;
    }
}
