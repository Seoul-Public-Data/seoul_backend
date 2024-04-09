package seouldata.seoul_backend.domain.firestation.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import seouldata.seoul_backend.domain.firestation.domain.entity.FireStation;

public interface FireStationRepository extends JpaRepository<FireStation, Long> {
}
