package seouldata.seoul_backend.cctv.domain.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import seouldata.seoul_backend.cctv.domain.entity.AnCctv;
import seouldata.seoul_backend.cctv.domain.repository.AnCctvRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class AnCctvService {

    private final AnCctvRepository anCctvRepository;


}
