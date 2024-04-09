package seouldata.seoul_backend.domain.safteyfacility.application.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class SafetyFacilityRequest {

    @Getter
    @NoArgsConstructor
    public static class SafetyFacilityNearRequest {
        private double userLon;
        private double userLat;

        @Builder
        public SafetyFacilityNearRequest(double userLon, double userLat) {
            this.userLat = userLat;
            this.userLon = userLon;
        }

    }
}
