package seouldata.seoul_backend.domain.safetycenter.application.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import seouldata.seoul_backend.common.utils.DistanceUtils;
import seouldata.seoul_backend.domain.safetycenter.application.dto.response.SafetyCenterResponse;
import seouldata.seoul_backend.domain.safetycenter.domain.entity.SafetyCenter;
import seouldata.seoul_backend.domain.safetycenter.domain.service.SafetyCenterQueryService;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class SafetyCenterGetService {

    private final SafetyCenterQueryService safetyCenterQueryService;

    public List<SafetyCenterResponse.SafetyCenterNearResponse> getSafetyCenterNear(double userLon, double userLat) {

        List<SafetyCenter> allSafetyCenter = safetyCenterQueryService.findAll();

        List<SafetyCenterResponse.SafetyCenterNearResponse> nearSafetyCenters = new ArrayList<>();

        for (SafetyCenter safetyCenter : allSafetyCenter) {
            double lat = safetyCenter.getLat();
            double lon = safetyCenter.getLon();

            double distance = DistanceUtils.calculateDistance(userLon, userLat, lon, lat);

            if(distance <= 500) {
                SafetyCenterResponse.SafetyCenterNearResponse nearSafetyCenter = SafetyCenterResponse.SafetyCenterNearResponse.builder()
                        .id(safetyCenter.getId())
                        .name(safetyCenter.getName())
                        .type(safetyCenter.getType())
                        .lon(safetyCenter.getLon())
                        .lat(safetyCenter.getLat())
                        .build();
                nearSafetyCenters.add(nearSafetyCenter);
            }
        }

        return nearSafetyCenters;

    }


}
