package du.search.classBE.Entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;

//건물 호관
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Hall {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hallId")
    private Long id;

    private String hallNumber;

    private double latitude;
    private double longitude;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "buildingId")
    private Building building;

    @Builder
    public Hall(Long id, String hallNumber, double latitude, double longitude, Building building) {
        this.id = id;
        this.hallNumber = hallNumber;
        this.latitude = latitude;
        this.longitude = longitude;
        this.building = building;
    }
}
