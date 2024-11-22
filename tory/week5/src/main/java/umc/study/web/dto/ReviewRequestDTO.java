package umc.study.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

public class ReviewRequestDTO {

    @Getter
    public static class JoinReviewDto{
        @NotBlank
        String userName;
        @NotNull
        Integer storeId;

        @NotNull
        String content;

        @NotNull
        Double starRate;

    }
}