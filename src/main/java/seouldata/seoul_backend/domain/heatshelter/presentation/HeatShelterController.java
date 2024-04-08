package seouldata.seoul_backend.domain.heatshelter.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import seouldata.seoul_backend.domain.heatshelter.appplication.dto.request.HeatShelterRequest;
import seouldata.seoul_backend.domain.heatshelter.appplication.dto.response.HeatShelterResponse;
import seouldata.seoul_backend.domain.heatshelter.appplication.service.HeatShelterGetService;


import java.util.List;

@RestController
@RequiredArgsConstructor
public class HeatShelterController {

    private final HeatShelterGetService heatShelterGetService;

    @GetMapping("/api/heatshelter")
    public List<HeatShelterResponse.HeatShelterNearResponse> getHeatShelterNear(@RequestBody HeatShelterRequest.HeatShelterNearRequest heatShelterNearRequest) {
        return heatShelterGetService.getHeatShelterNear(heatShelterNearRequest);
    }

}
