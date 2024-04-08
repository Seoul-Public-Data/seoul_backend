package seouldata.seoul_backend.domain.safetycenter.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import seouldata.seoul_backend.domain.safetycenter.application.dto.request.SafetyCenterRequest;
import seouldata.seoul_backend.domain.safetycenter.application.dto.response.SafetyCenterResponse;
import seouldata.seoul_backend.domain.safetycenter.application.service.SafetyCenterGetService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class SafetyCenterController {

    private final SafetyCenterGetService safetyCenterGetService;

    @GetMapping("/api/safetycenter")
    public ResponseEntity getSafetyCenterNear(@RequestBody SafetyCenterRequest.SafetyCenterNearRequest safetyCenterNearRequest) {
        List<SafetyCenterResponse.SafetyCenterNearResponse> safetyCenterNear = safetyCenterGetService.getSafetyCenterNear(safetyCenterNearRequest);
        return ResponseEntity.ok(safetyCenterNear);
    }

}
