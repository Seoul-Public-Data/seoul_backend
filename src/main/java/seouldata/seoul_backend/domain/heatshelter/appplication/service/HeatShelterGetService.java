package seouldata.seoul_backend.domain.heatshelter.appplication.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import seouldata.seoul_backend.common.DistanceUtils;
import seouldata.seoul_backend.domain.heatshelter.domain.entity.HeatShelter;
import seouldata.seoul_backend.domain.heatshelter.domain.service.HeatShelterQueryService;
import seouldata.seoul_backend.domain.heatshelter.appplication.dto.request.HeatShelterRequest;
import seouldata.seoul_backend.domain.heatshelter.appplication.dto.response.HeatShelterResponse;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class HeatShelterGetService {

    private final HeatShelterQueryService heatShelterQueryService;

    public List<HeatShelterResponse.HeatShelterNearResponse> getHeatShelterNear(HeatShelterRequest.HeatShelterNearRequest heatShelterNearRequest) {

        List<HeatShelter> heatShelters = heatShelterQueryService.findAll();
        double userLatitude = heatShelterNearRequest.getUserLatitude();
        double userLongitude = heatShelterNearRequest.getUserLongitude();
        System.out.println("userLatitude: " + userLatitude);

        List<HeatShelterResponse.HeatShelterNearResponse> heatShelterNearList = new ArrayList<>();
        for (HeatShelter heatShelter : heatShelters) {
            double longitude = heatShelter.getLongitude();
            double latitude = heatShelter.getLatitude();
            double distance = DistanceUtils.calculateDistance(userLongitude, userLatitude, longitude, latitude);
            if (distance < 500) {
                HeatShelterResponse.HeatShelterNearResponse heatShelterNearResponse = HeatShelterResponse.HeatShelterNearResponse.builder()
                        .name(heatShelter.getName())
                        .address(heatShelter.getAddress())
                        .longitude(heatShelter.getLongitude())
                        .latitude(heatShelter.getLatitude())
                        .build();
                heatShelterNearList.add(heatShelterNearResponse);
            }
        }
        return heatShelterNearList;
    }
}
