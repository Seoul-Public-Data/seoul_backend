package seouldata.seoul_backend.domain.emergencybell.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import seouldata.seoul_backend.domain.emergencybell.application.dto.request.EmergencyBellRequest;
import seouldata.seoul_backend.domain.emergencybell.application.dto.response.EmergencyBellResponse;
import seouldata.seoul_backend.domain.emergencybell.application.service.EmergencyBellGetService;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class EmergencyBellController {

    private final EmergencyBellGetService emergencyBellGetService;

    @GetMapping("/api/emergencybell")
    public List<EmergencyBellResponse.EmergencyBellNearResponse> getEmergencyBellNear(@RequestBody EmergencyBellRequest.EmergencyBellNearRequest emergencyBellNearRequest) {
        return emergencyBellGetService.getEmergencyBellNear(emergencyBellNearRequest);
    }
}
