package seouldata.seoul_backend.domain.safetycenter.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import seouldata.seoul_backend.domain.safetycenter.application.dto.response.SafetyCenterResponse;
import seouldata.seoul_backend.domain.safetycenter.application.service.SafetyCenterGetService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class SafetyCenterController {

    private final SafetyCenterGetService safetyCenterGetService;

    @GetMapping("/api/safetycenter")
    public ResponseEntity getSafetyCenterNear(@RequestParam double userLon, @RequestParam double userLat) {
        List<SafetyCenterResponse.SafetyCenterNearResponse> safetyCenterNear = safetyCenterGetService.getSafetyCenterNear(userLon, userLat);
        return ResponseEntity.ok(safetyCenterNear);
    }

}
