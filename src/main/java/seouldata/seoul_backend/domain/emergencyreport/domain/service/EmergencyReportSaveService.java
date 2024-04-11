package seouldata.seoul_backend.domain.emergencyreport.domain.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import seouldata.seoul_backend.domain.emergencyreport.domain.entity.EmergencyReport;
import seouldata.seoul_backend.domain.emergencyreport.domain.repository.EmergencyReportRepository;

@Service
@RequiredArgsConstructor
@Transactional
public class EmergencyReportSaveService {

    private final EmergencyReportRepository emergencyReportRepository;

    public void save(EmergencyReport emergencyReport) {
        emergencyReportRepository.save(emergencyReport);
    }
}
