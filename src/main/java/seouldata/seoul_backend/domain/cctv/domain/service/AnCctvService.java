package seouldata.seoul_backend.domain.cctv.domain.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import seouldata.seoul_backend.domain.cctv.application.dto.request.CctvRequest;
import seouldata.seoul_backend.domain.cctv.application.dto.response.CctvResponse;
import seouldata.seoul_backend.domain.cctv.domain.entity.AnCctv;
import seouldata.seoul_backend.domain.cctv.domain.repository.AnCctvRepository;
import seouldata.seoul_backend.common.DistanceUtils;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class AnCctvService {

    private final AnCctvRepository anCctvRepository;

    public List<CctvResponse.CctvNearResponse> getCctvNear(CctvRequest.CctvNearRequest cctvNearRequest) {

        // 사용자의 위치
        double userLon = cctvNearRequest.getUserLon();
        double userLat = cctvNearRequest.getUserLat();

        // 모든 cctv 위치 가져오기
        List<AnCctv> allCctvs = anCctvRepository.findAll();
//        List<AnCctv> allCctvs = all.stream().distinct()
//                .collect(Collectors.toList());


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
                        .build();
                nearCctvs.add(nearCctv);
            }
        }

        return nearCctvs;

    }
}
