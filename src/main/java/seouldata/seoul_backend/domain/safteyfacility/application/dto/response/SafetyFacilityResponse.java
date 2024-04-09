package seouldata.seoul_backend.domain.safteyfacility.application.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class SafetyFacilityResponse {

    @Getter
    @NoArgsConstructor
    public static class SafetyFacilityNearResponse{
        private String city;
        private String dong;
        private String road;
        private Long number;
        private String lon;
        private double lat;
        private String name;

        @Builder
        public SafetyFacilityNearResponse(String city, String dong, String road, Long number,
                                          String lon, double lat, String name) {
            this.city = city;
            this.dong = dong;
            this.road = road;
            this.number = number;
            this.lon = lon;
            this.lat = lat;
            this.name = name;
        }
    }
}
