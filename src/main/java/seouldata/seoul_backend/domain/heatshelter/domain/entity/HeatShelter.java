package seouldata.seoul_backend.domain.heatshelter.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "an_heat_shelter")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class HeatShelter {

    @Id  @Column(name = "shelter_name")
    private String name;

    private String address;

    @Column(name = "lon")
    private double longitude;

    @Column(name = "lat")
    private double latitude;

    @Builder
    public HeatShelter(String name, String address, double longitude, double latitude) {
        this.name = name;
        this.address = address;
        this.longitude = longitude;
        this.latitude = latitude;
    }
}
