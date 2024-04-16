package seouldata.seoul_backend.domain.heatshelter.appplication.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import seouldata.seoul_backend.common.utils.DistanceUtils;
import seouldata.seoul_backend.domain.heatshelter.appplication.dto.response.HeatShelterResponse;
import seouldata.seoul_backend.domain.heatshelter.domain.entity.HeatShelter;
import seouldata.seoul_backend.domain.heatshelter.domain.service.HeatShelterQueryService;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class HeatShelterGetService {

    private final HeatShelterQueryService heatShelterQueryService;

    public List<HeatShelterResponse.HeatShelterNearResponse> getHeatShelterNear(double userLon, double userLat) {

        List<HeatShelter> heatShelters = heatShelterQueryService.findAll();

        String type = "heatshelter";

        List<HeatShelterResponse.HeatShelterNearResponse> heatShelterNearList = new ArrayList<>();
        for (HeatShelter heatShelter : heatShelters) {
            double longitude = heatShelter.getLongitude();
            double latitude = heatShelter.getLatitude();
            double distance = DistanceUtils.calculateDistance(userLon, userLat, longitude, latitude);
            if (distance < 500) {
                HeatShelterResponse.HeatShelterNearResponse heatShelterNearResponse = HeatShelterResponse.HeatShelterNearResponse.builder()
                        .name(heatShelter.getName())
                        .address(heatShelter.getAddress())
                        .lon(heatShelter.getLongitude())
                        .lat(heatShelter.getLatitude())
                        .type(type)
                        .build();
                heatShelterNearList.add(heatShelterNearResponse);
            }
        }
        return heatShelterNearList;
    }
}
