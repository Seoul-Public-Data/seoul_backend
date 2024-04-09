package seouldata.seoul_backend.domain.emergencybell.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import seouldata.seoul_backend.domain.emergencybell.domain.entity.EmergencyBell;

public interface EmergencyBellRepository extends JpaRepository<EmergencyBell, String> {
}
