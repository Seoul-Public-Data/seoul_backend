package seouldata.seoul_backend.domain.heatshelter.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import seouldata.seoul_backend.domain.heatshelter.appplication.dto.response.HeatShelterResponse;
import seouldata.seoul_backend.domain.heatshelter.appplication.service.HeatShelterGetService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class HeatShelterController {

    private final HeatShelterGetService heatShelterGetService;

    @GetMapping("/api/heatshelter")
    public List<HeatShelterResponse.HeatShelterNearResponse> getHeatShelterNear(@RequestParam double userLon, @RequestParam double userLat) {
        return heatShelterGetService.getHeatShelterNear(userLon, userLat);
    }

}
