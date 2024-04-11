package seouldata.seoul_backend.domain.heatshelter.appplication.dto.response;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class HeatShelterResponse {

    @Getter
    @NoArgsConstructor
    public static class HeatShelterNearResponse {
        private String name;
        private String address;
        private double longitude;
        private double latitude;
        private String type;

        @Builder
        public HeatShelterNearResponse(String name, String address, double longitude, double latitude, String type) {
            this.name = name;
            this.address = address;
            this.longitude = longitude;
            this.latitude = latitude;
            this.type = type;
        }
    }
}
