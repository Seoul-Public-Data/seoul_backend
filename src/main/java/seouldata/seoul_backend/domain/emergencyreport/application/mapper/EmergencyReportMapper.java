package seouldata.seoul_backend.domain.emergencyreport.application.mapper;

import seouldata.seoul_backend.domain.emergencyreport.application.dto.request.EmergencyReportRequest;
import seouldata.seoul_backend.domain.emergencyreport.application.dto.response.EmergencyReportResponse;
import seouldata.seoul_backend.domain.emergencyreport.domain.entity.EmergencyReport;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class EmergencyReportMapper {

    public static EmergencyReport mapToEntity(EmergencyReportRequest.EmergencyReportCreateRequest emergencyReportCreateRequest) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return EmergencyReport.builder()
                .time(LocalDateTime.parse(emergencyReportCreateRequest.getTime(), formatter))
                .latitude(emergencyReportCreateRequest.getLatitude())
                .longitude(emergencyReportCreateRequest.getLongitude())
                .contents(emergencyReportCreateRequest.getContents())
                .build();
    }
    public static EmergencyReportResponse.EmergencyReportInHourResponse mapToEmergencyReportInHourResponse(EmergencyReport emergencyReport) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return EmergencyReportResponse.EmergencyReportInHourResponse.builder()
                .time(emergencyReport.getTime().format(formatter))
                .latitude(emergencyReport.getLatitude())
                .longitude(emergencyReport.getLongitude())
                .contents(emergencyReport.getContents())
                .build();
    }
}
