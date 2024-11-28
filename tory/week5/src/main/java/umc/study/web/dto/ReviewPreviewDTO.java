package umc.study.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ReviewPreviewDTO {
   // UserInfoDTO userinfo;
    Float score;
    String body;
    LocalDate createdAt;

}
