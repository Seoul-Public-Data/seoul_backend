package seouldata.seoul_backend.domain.firestation.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "an_fire_station")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class FireStation {

    @Id
    private Long id;
    @Column(name = "center_name")
    private String name;
    private double lon;
    private double lat;


    @Builder
    public FireStation(Long id, String name, double lon, double lat) {
        this.id = id;
        this.name = name;
        this.lon = lon;
        this.lat = lat;
    }

}
