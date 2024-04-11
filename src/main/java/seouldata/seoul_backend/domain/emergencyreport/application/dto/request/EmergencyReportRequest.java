package seouldata.seoul_backend.domain.emergencyreport.application.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class EmergencyReportRequest {

    @Getter
    @NoArgsConstructor
    public static class EmergencyReportCreateRequest {

        private String time;
        private double latitude;
        private double longitude;

        @Builder
        public EmergencyReportCreateRequest(String time, double latitude, double longitude) {
            this.time = time;
            this.latitude = latitude;
            this.longitude = longitude;
        }
    }
}
