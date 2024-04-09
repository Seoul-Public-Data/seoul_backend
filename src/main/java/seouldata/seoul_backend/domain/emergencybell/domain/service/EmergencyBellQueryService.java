package seouldata.seoul_backend.domain.emergencybell.domain.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import seouldata.seoul_backend.domain.emergencybell.domain.entity.EmergencyBell;
import seouldata.seoul_backend.domain.emergencybell.domain.repository.EmergencyBellRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class EmergencyBellQueryService {

    private final EmergencyBellRepository emergencyBellRepository;

    public List<EmergencyBell> findAll() {
        return emergencyBellRepository.findAll();
    }
}
