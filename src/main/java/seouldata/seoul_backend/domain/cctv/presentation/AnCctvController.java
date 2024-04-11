package seouldata.seoul_backend.domain.cctv.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import seouldata.seoul_backend.domain.cctv.application.dto.request.CctvRequest;
import seouldata.seoul_backend.domain.cctv.application.dto.response.CctvResponse;
import seouldata.seoul_backend.domain.cctv.application.service.AnCctvGetService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AnCctvController {
    private final AnCctvGetService anCctvGetService;

    @GetMapping("/api/cctv")
    public ResponseEntity getCctvNear(@RequestBody CctvRequest.CctvNearRequest cctvNearRequest) {
        List<CctvResponse.CctvNearResponse> cctvNear = anCctvGetService.getCctvNear(cctvNearRequest);
        return ResponseEntity.ok(cctvNear);
    }

}
