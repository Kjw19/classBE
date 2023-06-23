package du.search.classBE.service;

import du.search.classBE.Entity.Building;
import du.search.classBE.Entity.Classroom;
import du.search.classBE.Entity.Hall;
import du.search.classBE.Repository.BuildingRepository;
import du.search.classBE.Repository.ClassroomRepository;
import du.search.classBE.Repository.HallRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class InitClassroomServiceTest {


    @Autowired
    BuildingRepository buildingRepository;

    @Autowired
    ClassroomRepository classroomRepository;

    @Autowired
    HallRepository hallRepository;

    @Autowired
    InitClassroomService initClassroomService;

    @Test
    public void basicTestAsHall() throws Exception{
        //given
        List<String> listAsHall = Arrays.asList(
                "법행대1-1112 ",
                "조예대1-1102B",
                "사과대1-1306 ",
                "사과대2-2408B",
                "사범대1-1119 ",
                "조예대5-1111 ",
                "과생대1-1211 ",
                "과생대2-1202A",
                "과생대3-1309A",
                "재과대1-1211 ",
                "인문대1-1322 ",
                "공과대1-1319 "
        );



        //when
        initClassroomService.insertClassroomsAndHallByHyphen(listAsHall);

        //then
        Building buildingName = buildingRepository.findByName("법행대");
        Classroom classroom = classroomRepository.findByHall_BuildingNameAndHall_HallNumber("법행대", "1");

        assertThat(buildingName.getName()).isEqualTo("법행대");
        assertThat(classroom.getFloor()).isEqualTo(1);


    }

    @Test
    public void basicTestNotExistHall() throws Exception{
        //given
        List<String> listNotExistHall = Arrays.asList(
                "교수학습-1321  ",
                "경영대-1101  ",
                "경영대-1419  ",
                "종합-301",
                "공과대본-0202 "
        );


        //when
        initClassroomService.insertHallNotExistClassroomsByHyphen(listNotExistHall);

        //then
        Building buildingName = buildingRepository.findByName("교수학습");
//        Classroom classroom = classroomRepository.findByHall_BuildingNameAndHall_HallNumber("교수학습", null);

        System.out.println("빌딩이름은 = " +  buildingName.getName());
//        assertThat(buildingName.getName()).isEqualTo("교수학습");
//        assertThat(classroom.getFloor()).isEqualTo(1);


    }

}
