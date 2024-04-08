package seouldata.seoul_backend.domain.safetycenter.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "an_safety_center")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SafetyCenter {

    @Id
    private Long id;
    @Column(name = "center_name")
    private String name;
    private String type;
    private String lon;
    private String lat;

    @Builder
    public SafetyCenter(Long id, String name, String type, String lon, String lat) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.lon = lon;
        this.lat = lat;
    }

}
