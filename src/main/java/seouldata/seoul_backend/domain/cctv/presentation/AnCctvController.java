package seouldata.seoul_backend.domain.cctv.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import seouldata.seoul_backend.domain.cctv.application.dto.response.CctvResponse;
import seouldata.seoul_backend.domain.cctv.application.service.AnCctvGetService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AnCctvController {
    private final AnCctvGetService anCctvGetService;

    @GetMapping("/api/cctv")
    public ResponseEntity getCctvNear(@RequestParam double userLon, @RequestParam double userLat) {
        List<CctvResponse.CctvNearResponse> cctvNear = anCctvGetService.getCctvNear(userLon, userLat);
        return ResponseEntity.ok(cctvNear);
    }

}
