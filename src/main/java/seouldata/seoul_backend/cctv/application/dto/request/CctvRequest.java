package seouldata.seoul_backend.cctv.application.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class CctvRequest {

    @Getter
    @NoArgsConstructor
    public static class CctvNearRequest {
        private double userLon;
        private double userLat;

        @Builder
        public CctvNearRequest(double userLon, double userLat) {
            this.userLon = userLon;
            this.userLat = userLat;
        }

    }

}
