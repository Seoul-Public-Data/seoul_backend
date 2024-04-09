package seouldata.seoul_backend.domain.emergencybell.application.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import seouldata.seoul_backend.common.DistanceUtils;
import seouldata.seoul_backend.domain.emergencybell.application.dto.request.EmergencyBellRequest;
import seouldata.seoul_backend.domain.emergencybell.application.dto.response.EmergencyBellResponse;
import seouldata.seoul_backend.domain.emergencybell.domain.entity.EmergencyBell;
import seouldata.seoul_backend.domain.emergencybell.domain.service.EmergencyBellQueryService;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class EmergencyBellGetService {

    private final EmergencyBellQueryService emergencyBellQueryService;

    public List<EmergencyBellResponse.EmergencyBellNearResponse> getEmergencyBellNear(EmergencyBellRequest.EmergencyBellNearRequest emergencyBellNearRequest) {
        List<EmergencyBell> emergencyBellList = emergencyBellQueryService.findAll();
        double userLatitude = emergencyBellNearRequest.getUserLatitude();
        double userLongitude = emergencyBellNearRequest.getUserLongitude();

        List<EmergencyBellResponse.EmergencyBellNearResponse> emergencyBellNearList = new ArrayList<>();
        for (EmergencyBell emergencyBell : emergencyBellList) {
            double longitude = emergencyBell.getLongitude();
            double latitude = emergencyBell.getLatitude();
            double distance = DistanceUtils.calculateDistance(userLongitude, userLatitude, longitude, latitude);
            if (distance < 500) {
                EmergencyBellResponse.EmergencyBellNearResponse emergencyBellNearResponse = EmergencyBellResponse.EmergencyBellNearResponse.builder()
                        .location(emergencyBell.getLocation())
                        .address(emergencyBell.getAddress())
                        .function(emergencyBell.getFunction())
                        .longitude(emergencyBell.getLongitude())
                        .latitude(emergencyBell.getLatitude())
                        .build();
                emergencyBellNearList.add(emergencyBellNearResponse);
            }
        }
        return emergencyBellNearList;
    }
}
