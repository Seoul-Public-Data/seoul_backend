package seouldata.seoul_backend.domain.cctv.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "an_cctv")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class AnCctv {

    private Long number;
    private String autonomousRegion;
    @Id
    private String address;
    private Double lon;
    private Double lat;

    @Builder
    public AnCctv(Long number, String autonomousRegion, String address,
                  Double lon, Double lat) {
        this.number = number;
        this.autonomousRegion = autonomousRegion;
        this.address = address;
        this.lon = lon;
        this.lat = lat;
    }

}
