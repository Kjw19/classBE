package du.search.classBE.Entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

//건물 이름
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Building {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "buildingId")
    private Long id;

    @Column
    private String name;

    @Builder
    public Building(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
