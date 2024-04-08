package seouldata.seoul_backend.domain.safetycenter.domain.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import seouldata.seoul_backend.domain.safetycenter.domain.entity.SafetyCenter;
import seouldata.seoul_backend.domain.safetycenter.domain.repository.SafetyCenterRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class SafetyCenterQueryService {
    private final SafetyCenterRepository safetyCenterRepository;

    public List<SafetyCenter> findAll() {
        return safetyCenterRepository.findAll();
    }
}
