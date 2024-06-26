package seouldata.seoul_backend.domain.firestation.application.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class FireStationResponse {

    @Getter
    @NoArgsConstructor
    public static class FireStationNearResponse {
        private Long id;
        private String name;
        private double lon;
        private double lat;
        private String type;

        @Builder
        public FireStationNearResponse(Long id, String name, double lon, double lat, String type) {
            this.id = id;
            this.name = name;
            this.lon = lon;
            this.lat = lat;
            this.type = type;
        }

    }
}
