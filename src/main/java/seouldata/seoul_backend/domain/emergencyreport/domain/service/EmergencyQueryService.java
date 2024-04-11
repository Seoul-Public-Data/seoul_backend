package seouldata.seoul_backend.domain.emergencyreport.domain.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import seouldata.seoul_backend.domain.emergencyreport.domain.entity.EmergencyReport;
import seouldata.seoul_backend.domain.emergencyreport.domain.repository.EmergencyReportRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class EmergencyQueryService {

    private final EmergencyReportRepository emergencyReportRepository;

    public List<EmergencyReport> findByTimeBetween(LocalDateTime beforeHour, LocalDateTime now) {
        return emergencyReportRepository.findByTimeBetween(beforeHour, now);
    }
}
