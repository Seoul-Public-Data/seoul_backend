package seouldata.seoul_backend.domain.firestation.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import seouldata.seoul_backend.domain.firestation.application.dto.request.FireStationRequest;
import seouldata.seoul_backend.domain.firestation.application.dto.response.FireStationResponse;
import seouldata.seoul_backend.domain.firestation.application.service.FireStationGetService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class FireStationController {

    private final FireStationGetService fireStationGetService;

    @GetMapping("/api/firestation")
    public ResponseEntity getFireStationNear(@RequestBody FireStationRequest.FireStationNearRequest fireStationNearRequest) {
        List<FireStationResponse.FireStationNearResponse> fireStationNear = fireStationGetService.getFireStationNear(fireStationNearRequest);
        return ResponseEntity.ok(fireStationNear);
    }

}
