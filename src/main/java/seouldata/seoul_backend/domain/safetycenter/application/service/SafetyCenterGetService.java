package seouldata.seoul_backend.domain.safetycenter.application.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import seouldata.seoul_backend.common.DistanceUtils;
import seouldata.seoul_backend.domain.safetycenter.application.dto.request.SafetyCenterRequest;

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

    public List<SafetyCenterResponse.SafetyCenterNearResponse> getSafetyCenterNear(SafetyCenterRequest.SafetyCenterNearRequest safetyCenterNearRequest) {
        // 사용자의 위치
        double userLon = safetyCenterNearRequest.getUserLon();
        double userLat = safetyCenterNearRequest.getUserLat();

        List<SafetyCenter> allSafetyCenter = safetyCenterQueryService.findAll();

        List<SafetyCenterResponse.SafetyCenterNearResponse> nearSafetyCenters = new ArrayList<>();

        for (SafetyCenter safetyCenter : allSafetyCenter) {
            Double lat = Double.valueOf(safetyCenter.getLat());
            Double lon = Double.valueOf(safetyCenter.getLon());

            double distance = DistanceUtils.calculateDistance(userLon, userLat, lon, lat);

            if(distance <= 500) {
                SafetyCenterResponse.SafetyCenterNearResponse nearSafetyCenter = SafetyCenterResponse.SafetyCenterNearResponse.builder()
                        .id(safetyCenter.getId())
                        .name(safetyCenter.getName())
                        .type(safetyCenter.getType())
                        .lon(lon)
                        .lat(lat)
                        .build();
                nearSafetyCenters.add(nearSafetyCenter);
            }
        }

        return nearSafetyCenters;

    }


}
