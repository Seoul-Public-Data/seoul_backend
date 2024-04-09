package seouldata.seoul_backend.domain.firestation.domain.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import seouldata.seoul_backend.domain.firestation.domain.entity.FireStation;
import seouldata.seoul_backend.domain.firestation.domain.repository.FireStationRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class FireStationQueryService {
    private final FireStationRepository fireStationRepository;
    public List<FireStation> findAll() {
        return fireStationRepository.findAll();
    }
}
