package seouldata.seoul_backend.domain.emergencyreport.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import seouldata.seoul_backend.domain.emergencyreport.domain.entity.EmergencyReport;

import java.time.LocalDateTime;
import java.util.List;

public interface EmergencyReportRepository extends JpaRepository<EmergencyReport, Long> {

    List<EmergencyReport> findByTimeBetween(LocalDateTime beforeHour, LocalDateTime now);
}
