package seouldata.seoul_backend.domain.emergencyreport.application.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class EmergencyReportResponse {

    @Getter
    @NoArgsConstructor
    public static class EmergencyReportInHourResponse {
        private String time;
        private double latitude;
        private double longitude;

        @Builder
        public EmergencyReportInHourResponse(String time, double latitude, double longitude) {
            this.time = time;
            this.latitude = latitude;
            this.longitude = longitude;
        }
    }
}
