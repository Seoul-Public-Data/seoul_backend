package seouldata.seoul_backend.domain.safteyfacility.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Getter
@Embeddable
@NoArgsConstructor
@EqualsAndHashCode
public class SafetyFacilityId implements Serializable {

    @Column(name = "lon")
    private String lon;
    @Column(name = "lat")
    private double lat;
    @Column(name = "facility_name")
    private String name;

}
