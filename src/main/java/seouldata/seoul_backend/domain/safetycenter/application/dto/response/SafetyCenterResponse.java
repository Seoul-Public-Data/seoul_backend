package seouldata.seoul_backend.domain.safetycenter.application.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class SafetyCenterResponse {

    @Getter
    @NoArgsConstructor
    public static class SafetyCenterNearResponse {
        private Long id;
        private String name;
        private String type;
        private double lon;
        private double lat;

        @Builder
        public SafetyCenterNearResponse(Long id, String name, String type,
                                        double lon, double lat) {
            this.id = id;
            this.name = name;
            this.type = type;
            this.lon = lon;
            this.lat = lat;
        }

    }
}
