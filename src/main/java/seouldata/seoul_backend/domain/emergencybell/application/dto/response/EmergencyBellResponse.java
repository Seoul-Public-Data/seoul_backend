package seouldata.seoul_backend.domain.emergencybell.application.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class EmergencyBellResponse {

    @Getter
    @NoArgsConstructor
    public static class EmergencyBellNearResponse {
        private String location;
        private String address;
        private String function;
        private Double longitude;
        private Double latitude;

        @Builder
        public EmergencyBellNearResponse(String location, String address, String function, Double longitude, Double latitude) {
            this.location = location;
            this.address = address;
            this.function = function;
            this.longitude = longitude;
            this.latitude = latitude;
        }
    }
}
