package seouldata.seoul_backend.domain.safteyfacility.domain.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import seouldata.seoul_backend.domain.safteyfacility.domain.entity.SafetyFacility;
import seouldata.seoul_backend.domain.safteyfacility.domain.repository.SafetyFacilityRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class SafetyFacilityQueryService {

    private final SafetyFacilityRepository safetyFacilityRepository;

    public List<SafetyFacility> findAll() {
        return safetyFacilityRepository.findAll();
    }

}
