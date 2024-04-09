package seouldata.seoul_backend.domain.emergencybell.application.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class EmergencyBellRequest {

    @Getter
    @NoArgsConstructor
    public static class EmergencyBellNearRequest {
        private double userLongitude;
        private double userLatitude;

        @Builder
        public EmergencyBellNearRequest(double userLongitude, double userLatitude) {
            this.userLongitude = userLongitude;
            this.userLatitude = userLatitude;
        }
    }
}
