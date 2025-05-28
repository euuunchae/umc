package umc.study.domain;

import jakarta.persistence.*;
import lombok.*;
import umc.study.domain.common.BaseEntity;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Store extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private Float rating;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "region_id")
    private Region region;

    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL)
    private List<Review> reviewList = new ArrayList<>();

    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL)
    private List<FoodCategory> foodCategoryList = new ArrayList<>();

    @Override
    public String toString() {
        return "Store{" +
                "id= " + id +
                ", name = '" +  name + '\'' +
                ", rating = " + rating +
                ", region = " + (region != null ? region.getName() : "N/A") +
                '}';

    }

    //생성자 메서드
    public void setRegion(Region region) {
        this.region = region;
    }
}
