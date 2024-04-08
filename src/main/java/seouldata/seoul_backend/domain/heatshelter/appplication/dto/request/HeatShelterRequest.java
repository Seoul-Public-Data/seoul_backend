package seouldata.seoul_backend.domain.heatshelter.appplication.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class HeatShelterRequest {

    @Getter
    @NoArgsConstructor
    public static class HeatShelterNearRequest {
        private double userLongitude;
        private double userLatitude;

        @Builder
        public HeatShelterNearRequest(double userLongitude, double userLatitude) {
            this.userLongitude = userLongitude;
            this.userLatitude = userLatitude;
        }
    }
}
