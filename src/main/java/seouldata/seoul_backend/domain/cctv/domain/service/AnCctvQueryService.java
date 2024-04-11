package seouldata.seoul_backend.domain.cctv.domain.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import seouldata.seoul_backend.domain.cctv.domain.entity.AnCctv;
import seouldata.seoul_backend.domain.cctv.domain.repository.AnCctvRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class AnCctvQueryService {
    private final AnCctvRepository anCctvRepository;

    public List<AnCctv> findAll() {
        return anCctvRepository.findAll();
    }
}
