package du.search.classBE.service;

import du.search.classBE.Entity.Building;
import du.search.classBE.Entity.Classroom;
import du.search.classBE.Entity.Hall;
import du.search.classBE.Entity.HallLocationData;
import du.search.classBE.Repository.BuildingRepository;
import du.search.classBE.Repository.ClassroomRepository;
import du.search.classBE.Repository.HallLocationDataRepository;
import du.search.classBE.Repository.HallRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InitClassroomService {

    private final BuildingRepository buildingRepository;
    private final ClassroomRepository classroomRepository;
    private final HallRepository hallRepository;

    private final HallLocationDataRepository hallLocationDataRepository;

    private static final String HALL_NOT_EXIST = "0";


    @Transactional
    public void insertClassroomsAndHallByHyphen(List<String> classrooms) {

        for (String code : classrooms) {
            String[] parts = code.split("-");
            String buildingName = parts[0].substring(0, parts[0].length() - 1);
            String hallNumber = getClassroomNumber(parts[0], parts[0].length() - 1);
            String floorAndRoom = parts[1];

            Building DbBuildingName = createBuildingName(buildingName);
            Hall hall = createHall(buildingName, hallNumber, DbBuildingName);
            createClassroom(floorAndRoom, hall);
        }

    }
    @Transactional
    public void insertHallNotExistClassroomsByHyphen(List<String> classroomCodesWithoutHall) {

        for (String code : classroomCodesWithoutHall) {
            String[] parts = code.split("-");
            String buildingName = parts[0].substring(0, parts[0].length());
            String floorAndRoom = parts[1];

            Building DbBuildingName = createBuildingName(buildingName);
            Hall hall = createHall(buildingName, HALL_NOT_EXIST, DbBuildingName);
            createClassroom(floorAndRoom, hall);
        }

    }

    @Transactional
    public void insertHallLocation(List<HallLocationData> hallLocationDataList) {
        for (HallLocationData hallLocationData : hallLocationDataList) {
            hallLocationDataRepository.save(hallLocationData);
        }
    }

    private Building createBuildingName(String buildingName) {
        Building DbBuildingName = buildingRepository.findByName(buildingName);
        if (DbBuildingName == null) {
            DbBuildingName = Building.builder()
                    .name(buildingName)
                    .build();

            buildingRepository.save(DbBuildingName);
        }
        return DbBuildingName;
    }

    private Hall createHall(String buildingName, String hallNumber, Building DbBuildingName) {
        Hall hall = hallRepository.findByHallNumberAndBuildingName(hallNumber, buildingName);
        if (hall == null) {
            hall = Hall.builder()
                    .hallNumber(hallNumber)
                    .building(DbBuildingName)
                    .build();
            hallRepository.save(hall);
        }
        return hall;
    }

    private void createClassroom(String floorAndRoom, Hall hall) {
        Classroom classroom = Classroom.builder()
                .floor(getFloor(floorAndRoom))
                .classroomNumber(getClassroomNumber(floorAndRoom, 1))
                .hall(hall)
                .build();
        classroomRepository.save(classroom);
    }

    private static String getClassroomNumber(String floorAndRoom, int beginIndex) {
        return floorAndRoom.substring(beginIndex);
    }

    private static int getFloor(String floorAndRoom) {
        return Integer.parseInt(floorAndRoom.substring(0, 1));
    }


}
