package seouldata.seoul_backend.domain.heatshelter.domain.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import seouldata.seoul_backend.domain.heatshelter.domain.entity.HeatShelter;
import seouldata.seoul_backend.domain.heatshelter.domain.repository.HeatShelterRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class HeatShelterQueryService {

    private final HeatShelterRepository heatShelterRepository;

    public List<HeatShelter> findAll() {
        return heatShelterRepository.findAll();
    }
}
