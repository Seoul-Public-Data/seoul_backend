package seouldata.seoul_backend.domain.emergencyreport.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import seouldata.seoul_backend.domain.emergencyreport.application.dto.request.EmergencyReportRequest;
import seouldata.seoul_backend.domain.emergencyreport.application.dto.response.EmergencyReportResponse;
import seouldata.seoul_backend.domain.emergencyreport.application.service.EmergencyReportCreateService;
import seouldata.seoul_backend.domain.emergencyreport.application.service.EmergencyReportGetService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class EmergencyReportController {

    private final EmergencyReportCreateService emergencyReportCreateService;
    private final EmergencyReportGetService emergencyReportGetService;

    @PostMapping("/api/report")
    public void createReport(@RequestBody EmergencyReportRequest.EmergencyReportCreateRequest reportCreateRequest) {
        emergencyReportCreateService.createReport(reportCreateRequest);
    }

    @GetMapping("/api/report")
    public List<EmergencyReportResponse.EmergencyReportInHourResponse> getReportInHour() {
        return emergencyReportGetService.getReportInHour();
    }
}
