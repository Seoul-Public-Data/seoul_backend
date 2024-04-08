package seouldata.seoul_backend.domain.firestation.application.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class FireStationRequest {

    @Getter
    @NoArgsConstructor
    public static class FireStationNearRequest {
        private double userLon;
        private double userLat;

        @Builder
        public FireStationNearRequest(double userLon, double userLat) {
            this.userLat = userLat;
            this.userLon = userLon;
        }
    }
}
