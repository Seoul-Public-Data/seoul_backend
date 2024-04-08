package seouldata.seoul_backend.domain.cctv.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import seouldata.seoul_backend.domain.cctv.domain.entity.AnCctv;

public interface AnCctvRepository extends JpaRepository<AnCctv, String> {

}
