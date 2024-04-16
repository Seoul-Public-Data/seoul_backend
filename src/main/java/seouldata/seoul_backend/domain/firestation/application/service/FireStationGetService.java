package seouldata.seoul_backend.domain.firestation.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import seouldata.seoul_backend.common.utils.DistanceUtils;
import seouldata.seoul_backend.domain.firestation.application.dto.response.FireStationResponse;
import seouldata.seoul_backend.domain.firestation.domain.entity.FireStation;
import seouldata.seoul_backend.domain.firestation.domain.service.FireStationQueryService;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class FireStationGetService {

    private final FireStationQueryService fireStationQueryService;

    public List<FireStationResponse.FireStationNearResponse> getFireStationNear(double userLon, double userLat) {
        String type = "firestation";

        List<FireStation> allFireStation = fireStationQueryService.findAll();

        List<FireStationResponse.FireStationNearResponse> nearFireStations = new ArrayList<>();

        for (FireStation fireStation : allFireStation) {
            double lat = fireStation.getLat();
            double lon = fireStation.getLon();

            double distance = DistanceUtils.calculateDistance(userLon, userLat, lon, lat);
            if(distance <= 500) {
                FireStationResponse.FireStationNearResponse nearFireStation = FireStationResponse.FireStationNearResponse.builder()
                        .id(fireStation.getId())
                        .name(fireStation.getName())
                        .lon(fireStation.getLon())
                        .lat(fireStation.getLat())
                        .type(type)
                        .build();

                nearFireStations.add(nearFireStation);
            }
        }

        return nearFireStations;
    }

}
