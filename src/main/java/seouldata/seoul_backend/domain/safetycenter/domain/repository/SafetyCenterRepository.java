package seouldata.seoul_backend.domain.safetycenter.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import seouldata.seoul_backend.domain.safetycenter.domain.entity.SafetyCenter;

public interface SafetyCenterRepository extends JpaRepository<SafetyCenter, Long> {
}
