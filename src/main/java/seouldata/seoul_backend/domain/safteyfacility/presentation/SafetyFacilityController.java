package seouldata.seoul_backend.domain.safteyfacility.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import seouldata.seoul_backend.domain.safteyfacility.application.dto.response.SafetyFacilityResponse;
import seouldata.seoul_backend.domain.safteyfacility.application.service.SafetyFacilityGetService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class SafetyFacilityController {

    private final SafetyFacilityGetService safetyFacilityGetService;

    @GetMapping("/api/safetyfacilities")
    public ResponseEntity getSafetyFacilityNear(@RequestParam double userLon, @RequestParam double userLat) {
        List<SafetyFacilityResponse.SafetyFacilityNearResponse> safetyFacilityNear = safetyFacilityGetService.getSafetyFacilityNear(userLon, userLat);
        return ResponseEntity.ok(safetyFacilityNear);
    }

}
