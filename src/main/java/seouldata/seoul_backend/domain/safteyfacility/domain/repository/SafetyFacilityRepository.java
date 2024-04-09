package seouldata.seoul_backend.domain.safteyfacility.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import seouldata.seoul_backend.domain.safteyfacility.domain.entity.SafetyFacility;
import seouldata.seoul_backend.domain.safteyfacility.domain.entity.SafetyFacilityId;

public interface SafetyFacilityRepository extends JpaRepository<SafetyFacility, SafetyFacilityId> {
}
