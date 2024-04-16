package seouldata.seoul_backend.domain.cctv.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import seouldata.seoul_backend.common.utils.DistanceUtils;
import seouldata.seoul_backend.domain.cctv.application.dto.response.CctvResponse;
import seouldata.seoul_backend.domain.cctv.domain.entity.AnCctv;
import seouldata.seoul_backend.domain.cctv.domain.service.AnCctvQueryService;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class AnCctvGetService {

    private final AnCctvQueryService anCctvQueryService;

    public List<CctvResponse.CctvNearResponse> getCctvNear(double userLon, double userLat) {

        String type = "cctv";

        // 모든 cctv 위치 가져오기
        List<AnCctv> allCctvs = anCctvQueryService.findAll();


        // 500m이내에 있는 cctv 정보 가져오기
        List<CctvResponse.CctvNearResponse> nearCctvs = new ArrayList<>();

        for (AnCctv cctv : allCctvs) {
            double lon = cctv.getLon();
            double lat = cctv.getLat();

            double distance = DistanceUtils.calculateDistance(userLon, userLat, lon, lat);

            if(distance <= 500) {
                CctvResponse.CctvNearResponse nearCctv = CctvResponse.CctvNearResponse.builder()
                        .address(cctv.getAddress())
                        .autonomousRegion(cctv.getAutonomousRegion())
                        .lat(cctv.getLat())
                        .lon(cctv.getLon())
                        .number(cctv.getNumber())
                        .type(type)
                        .build();
                nearCctvs.add(nearCctv);
            }
        }

        return nearCctvs;

    }
}
