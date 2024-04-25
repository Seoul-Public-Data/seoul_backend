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
        private String contents;

        @Builder
        public EmergencyReportCreateRequest(String time, double latitude, double longitude, String contents) {
            this.time = time;
            this.latitude = latitude;
            this.longitude = longitude;
            this.contents = contents;
        }
    }
}
