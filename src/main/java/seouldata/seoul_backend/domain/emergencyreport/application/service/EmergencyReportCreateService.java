package seouldata.seoul_backend.domain.emergencyreport.application.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import seouldata.seoul_backend.domain.emergencyreport.application.dto.request.EmergencyReportRequest;
import seouldata.seoul_backend.domain.emergencyreport.application.mapper.EmergencyReportMapper;
import seouldata.seoul_backend.domain.emergencyreport.domain.entity.EmergencyReport;
import seouldata.seoul_backend.domain.emergencyreport.domain.service.EmergencyReportSaveService;

@Service
@RequiredArgsConstructor
@Transactional
public class EmergencyReportCreateService {

    private final EmergencyReportSaveService emergencyReportSaveService;

    public void createReport(EmergencyReportRequest.EmergencyReportCreateRequest emergencyReportCreateRequest) {
        EmergencyReport emergencyReport = EmergencyReportMapper.mapToEntity(emergencyReportCreateRequest);
        emergencyReportSaveService.save(emergencyReport);
    }
}
