package seouldata.seoul_backend.domain.emergencyreport.application.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import seouldata.seoul_backend.domain.emergencyreport.application.dto.response.EmergencyReportResponse;
import seouldata.seoul_backend.domain.emergencyreport.application.mapper.EmergencyReportMapper;
import seouldata.seoul_backend.domain.emergencyreport.domain.entity.EmergencyReport;
import seouldata.seoul_backend.domain.emergencyreport.domain.service.EmergencyQueryService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class EmergencyReportGetService {

    private final EmergencyQueryService emergencyQueryService;

    public List<EmergencyReportResponse.EmergencyReportInHourResponse> getReportInHour() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime beforeHour = now.minusHours(1);
        List<EmergencyReport> emergencyReports = emergencyQueryService.findByTimeBetween(beforeHour, now);
        return emergencyReports.stream().map(EmergencyReportMapper::mapToEmergencyReportInHourResponse).collect(Collectors.toList());
    }
}
