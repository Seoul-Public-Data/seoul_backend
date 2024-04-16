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
        private Double lon;
        private Double lat;
        private String type;

        @Builder
        public EmergencyBellNearResponse(String location, String address, String function, Double lon, Double lat, String type) {
            this.location = location;
            this.address = address;
            this.function = function;
            this.lon = lon;
            this.lat = lat;
            this.type = type;
        }
    }
}
