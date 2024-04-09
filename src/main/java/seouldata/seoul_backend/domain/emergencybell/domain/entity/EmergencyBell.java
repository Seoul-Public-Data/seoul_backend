package seouldata.seoul_backend.domain.emergencybell.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "an_safety_emergency_bell")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class EmergencyBell {

    @Id @Column(name = "installation_location")
    private String location;
    private String address;
    @Column(name = "lon")
    private Double longitude;
    @Column(name = "lat")
    private Double latitude;

    @Builder
    public EmergencyBell(String location, String address, Double longitude, Double latitude) {
        this.location = location;
        this.address = address;
        this.longitude = longitude;
        this.latitude = latitude;
    }
}
