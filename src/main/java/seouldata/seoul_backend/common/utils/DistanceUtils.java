package seouldata.seoul_backend.common.utils;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DistanceUtils {

    /**
     * 하버사인 공식을 이용하여 두 지점간의 거리를 계산
     */
    public static double calculateDistance(double userLon, double userLat, double lon, double lat) {

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
