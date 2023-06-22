package du.search.classBE.Entity;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.persistence.*;

//건물 안 강의실
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Classroom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //
    @Column(name = "classroomId")
    private Long id;

    private Integer floor;
    private String classroomNumber;

    //cascade를 통해 부모엔티티 저장 시 연관된 자식 엔티티도 함께 저장
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hallId")
    private Hall hall;

}
