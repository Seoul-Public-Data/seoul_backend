package seouldata.seoul_backend.domain.heatshelter.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import seouldata.seoul_backend.domain.heatshelter.domain.entity.HeatShelter;

public interface HeatShelterRepository extends JpaRepository<HeatShelter, String> {
}
