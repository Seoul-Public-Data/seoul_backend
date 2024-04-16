package seouldata.seoul_backend.domain.safteyfacility.application.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import seouldata.seoul_backend.common.utils.DistanceUtils;
import seouldata.seoul_backend.domain.safteyfacility.application.dto.response.SafetyFacilityResponse;
import seouldata.seoul_backend.domain.safteyfacility.domain.entity.SafetyFacility;
import seouldata.seoul_backend.domain.safteyfacility.domain.service.SafetyFacilityQueryService;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class SafetyFacilityGetService {

    private final SafetyFacilityQueryService safetyFacilityQueryService;

    public List<SafetyFacilityResponse.SafetyFacilityNearResponse> getSafetyFacilityNear(double userLon, double userLat) {
        String type = "safetyfacility";

        List<SafetyFacility> allSafetyFacility = safetyFacilityQueryService.findAll();

        List<SafetyFacilityResponse.SafetyFacilityNearResponse> nearSafetyFacilities = new ArrayList<>();

        for (SafetyFacility safetyFacility : allSafetyFacility) {
            double lat = safetyFacility.getId().getLat();
            String lonStr = safetyFacility.getId().getLon().replaceAll("[^0-9\\.]", "");
            Double lon = Double.valueOf(lonStr);

            double distance = DistanceUtils.calculateDistance(userLon, userLat, lon, lat);
            if(distance <= 500) {
                SafetyFacilityResponse.SafetyFacilityNearResponse nearSafetyFacility = SafetyFacilityResponse.SafetyFacilityNearResponse.builder()
                        .city(safetyFacility.getCity())
                        .dong(safetyFacility.getDong())
                        .number(safetyFacility.getNumber())
                        .road(safetyFacility.getRoad())
                        .name(safetyFacility.getId().getName())
                        .lat(safetyFacility.getId().getLat())
                        .lon(safetyFacility.getId().getLon())
                        .type(type)
                        .build();

                nearSafetyFacilities.add(nearSafetyFacility);
            }

        }

        return nearSafetyFacilities;

    }

}
