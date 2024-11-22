package umc.study.service.ReviewService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.converter.ReviewConverter;
import umc.study.domain.Review;
import umc.study.repository.ReviewRepository.ReviewRepository;
import umc.study.web.dto.ReviewRequestDTO;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ReviewCommandServiceImpl implements ReviewCommandService {

    private final ReviewRepository reviewRepository;
    @Override
    @Transactional
    public Review joinReview(ReviewRequestDTO.JoinReviewDto request) {

        Review newReview = ReviewConverter.toReview(request);
        newReview.setCreatedAt(LocalDateTime.now());
        newReview.setUpdatedAt(LocalDateTime.now());

        return reviewRepository.save(newReview);
    }
}
