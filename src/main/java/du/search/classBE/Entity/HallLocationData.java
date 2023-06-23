package du.search.classBE.Entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class HallLocationData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String buildingName;
    private String hallNumber;
    private double latitude;
    private double longitude;

    @Builder
    public HallLocationData(String buildingName, String hallNumber, double latitude, double longitude) {
        this.buildingName = buildingName;
        this.hallNumber = hallNumber;
        this.latitude = latitude;
        this.longitude = longitude;
    }
}
