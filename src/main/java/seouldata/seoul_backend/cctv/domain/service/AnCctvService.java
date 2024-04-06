package seouldata.seoul_backend.cctv.domain.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import seouldata.seoul_backend.cctv.application.dto.request.CctvRequest;
import seouldata.seoul_backend.cctv.application.dto.response.CctvResponse;
import seouldata.seoul_backend.cctv.domain.entity.AnCctv;
import seouldata.seoul_backend.cctv.domain.repository.AnCctvRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

            double distance = calculationDistance(userLon, userLat, lon, lat);

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

    // 하버 사인 적용하여 두 점 사이 거리 구하기
    public double calculationDistance(double userLon, double userLat, double lon, double lat) {
        double earthRadius = 6371000; // 지구 반지름(미터)

        double dLat = Math.toRadians(lat - userLat);
        double dLon = Math.toRadians(lon - userLon);

        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2)
                + Math.cos(Math.toRadians(userLat)) * Math.cos(Math.toRadians(lat))
                * Math.sin(dLon / 2) * Math.sin(dLon / 2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return earthRadius * c;
    }


}
