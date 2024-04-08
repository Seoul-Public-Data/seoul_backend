package seouldata.seoul_backend.cctv.application.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class CctvResponse {

    @Getter
    @NoArgsConstructor
    public static class CctvNearResponse {
        private Long number;
        private String autonomousRegion;
        private String address;
        private Double lon;
        private Double lat;

        @Builder
        public CctvNearResponse(Long number, String autonomousRegion, String address,
                                Double lon, Double lat) {
            this.number = number;
            this.autonomousRegion = autonomousRegion;
            this.address = address;
            this.lon = lon;
            this.lat = lat;
        }
    }
}
