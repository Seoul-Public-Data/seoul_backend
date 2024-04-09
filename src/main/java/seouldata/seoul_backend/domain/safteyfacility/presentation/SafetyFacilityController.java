package seouldata.seoul_backend.domain.safteyfacility.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import seouldata.seoul_backend.domain.safteyfacility.application.dto.request.SafetyFacilityRequest;
import seouldata.seoul_backend.domain.safteyfacility.application.dto.response.SafetyFacilityResponse;
import seouldata.seoul_backend.domain.safteyfacility.application.service.SafetyFacilityGetService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class SafetyFacilityController {

    private final SafetyFacilityGetService safetyFacilityGetService;

    @GetMapping("/api/safetyfacilities")
    public ResponseEntity getSafetyFacilityNear(@RequestBody SafetyFacilityRequest.SafetyFacilityNearRequest safetyFacilityNearRequest) {
        List<SafetyFacilityResponse.SafetyFacilityNearResponse> safetyFacilityNear = safetyFacilityGetService.getSafetyFacilityNear(safetyFacilityNearRequest);
        return ResponseEntity.ok(safetyFacilityNear);
    }

}
