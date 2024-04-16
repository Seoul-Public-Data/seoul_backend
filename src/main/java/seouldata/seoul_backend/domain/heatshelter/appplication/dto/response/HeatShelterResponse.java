package seouldata.seoul_backend.domain.heatshelter.appplication.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class HeatShelterResponse {

    @Getter
    @NoArgsConstructor
    public static class HeatShelterNearResponse {
        private String name;
        private String address;
        private double lon;
        private double lat;
        private String type;

        @Builder
        public HeatShelterNearResponse(String name, String address, double lon, double lat, String type) {
            this.name = name;
            this.address = address;
            this.lon = lon;
            this.lat = lat;
            this.type = type;
        }
    }
}
