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
        private String centerType;
        private double lon;
        private double lat;

        @Builder
        public SafetyCenterNearResponse(Long id, String name, String type, String centerType,
                                        double lon, double lat) {
            this.id = id;
            this.name = name;
            this.type = type;
            this.centerType = centerType;
            this.lon = lon;
            this.lat = lat;
        }

    }
}
