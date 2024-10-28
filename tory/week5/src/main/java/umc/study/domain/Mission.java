package umc.study.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UpdateTimestamp;
import umc.study.domain.enums.MissionStatus;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Mission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Integer missionId;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(15) DEFAULT 'ACTIVE'")
    private MissionStatus status;

    @Column(nullable = false,length = 254)
    private String missionDescription;

    @UpdateTimestamp
    @Column(nullable = false)
    private LocalDateTime completeTime;

    @Column(nullable = false)
    private Integer earnablePoint;

    @Column(nullable = false,length = 20)
    private String missionTitle;

    @Column(nullable = false)
    private Integer missionDueDate;

    @Column(nullable = false,length = 10)
    private String restaurantCategory;

    //@Column(nullable = false)
    //private Integer userId;

    @Column(nullable = false)
    private Integer storeId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "mission", cascade = CascadeType.ALL)
    private List<Store> storeList = new ArrayList<>();
}