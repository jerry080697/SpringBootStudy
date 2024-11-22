package umc.study.domain;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import umc.study.domain.enums.Gender;
import umc.study.domain.enums.UserStatus;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Integer userId;

    @Column(nullable = false,length=10)
    private String name;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(columnDefinition = "VARCHAR(15) DEFAULT 'ACTIVE'")
    private UserStatus userStatus;


    @Column(nullable = false,length=30)
    private String address;

    @Column(nullable = false,length=30)
    private String preferFoodCategory;

    @CreatedDate
    @Column(nullable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(nullable = false)
    private LocalDateTime updatedAt;


    @OneToMany(mappedBy = "user",cascade=CascadeType.ALL)
    private List<Review> reviewList=new ArrayList<>();

    @OneToMany(mappedBy = "user",cascade=CascadeType.ALL)
    private List<Mission> missionList=new ArrayList<>();
}