package seouldata.seoul_backend.domain.emergencyreport.domain.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class EmergencyReport {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emergency_report_id")
    private Long id;

    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm", timezone="Asia/Seoul")
    private LocalDateTime time;

    private double longitude;
    private double latitude;

    @Builder
    public EmergencyReport(LocalDateTime time, double longitude, double latitude) {
        this.time = time;
        this.longitude = longitude;
        this.latitude = latitude;
    }
}
