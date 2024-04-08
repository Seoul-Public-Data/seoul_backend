package seouldata.seoul_backend.domain.safetycenter.application.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class SafetyCenterRequest {

    @Getter
    @NoArgsConstructor
    public static class SafetyCenterNearRequest {
        private double userLon;
        private double userLat;

        @Builder
        public SafetyCenterNearRequest(double userLon, double userLat) {
            this.userLat = userLat;
            this.userLon = userLon;
        }
    }

}
