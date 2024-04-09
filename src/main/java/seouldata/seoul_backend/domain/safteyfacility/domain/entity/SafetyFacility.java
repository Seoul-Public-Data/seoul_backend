package seouldata.seoul_backend.domain.safteyfacility.domain.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "an_safety_facilities")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SafetyFacility {

    @EmbeddedId
    private SafetyFacilityId id;

    private String city;
    private String dong;

    @Column(name = "road_name")
    private String road;
    private Long number;

//    private String lon;
//    private double lat;
//    @Column(name = "facility_name")
//    private String name;

    @Builder
    public SafetyFacility(String city, String dong, String road, Long number) {
        this.city = city;
        this.dong = dong;
        this.road = road;
        this.number = number;

    }

}
