package du.search.classBE.Entity;

import lombok.AccessLevel;
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "buildingId")
    private Building building;

}
