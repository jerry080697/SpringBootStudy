package umc.study.service.UserService;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import umc.study.domain.Review;
@Service

public interface UserQueryService {
    Page<Review> getUserReviewList(Integer userId, Integer page);
}
