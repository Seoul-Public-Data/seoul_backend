package seouldata.seoul_backend.domain.firestation.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import seouldata.seoul_backend.domain.firestation.application.dto.response.FireStationResponse;
import seouldata.seoul_backend.domain.firestation.application.service.FireStationGetService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class FireStationController {

    private final FireStationGetService fireStationGetService;

    @GetMapping("/api/firestation")
    public ResponseEntity getFireStationNear(@RequestParam double userLon, @RequestParam double userLat) {
        List<FireStationResponse.FireStationNearResponse> fireStationNear = fireStationGetService.getFireStationNear(userLon, userLat);
        return ResponseEntity.ok(fireStationNear);
    }

}
