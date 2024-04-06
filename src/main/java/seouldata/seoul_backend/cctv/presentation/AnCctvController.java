package seouldata.seoul_backend.cctv.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import seouldata.seoul_backend.cctv.domain.service.AnCctvService;

@RestController
@RequiredArgsConstructor
public class AnCctvController {
    private final AnCctvService anCctvService;



}
