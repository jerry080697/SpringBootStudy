package umc.study.domain;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer storeId;

    @Column(nullable = false,length = 20)
    private String storeName;

    @Column(nullable = false,length = 10)
    private String category;

    @Column(nullable = false)
    private Integer earnablePoint;

    @Column(nullable = false,length = 254)
    private String description;

    @Column(nullable = false,length = 10)
    private String status;

    @Column(nullable = false)
    private Double starRate;

    @Column(nullable = false,length = 254)
    private String address;
    @CreatedDate
    @Column(nullable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(nullable = false)
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL)
    private List<Review> reviewList = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mission_id")
    private Mission mission;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="region_id")
    private Region region;
    @Override
    public String toString() {
        return "Store{" +
                "id=" + storeId +
                ", name='" + storeName + '\'' +
                ", address='" + address + '\'' +
                ", score=" + starRate +
                ", region=" + (region != null ? region.getName() : "N/A") + // region의 이름 출력
                '}';
    }
}
