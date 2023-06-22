package du.search.classBE.service;

import du.search.classBE.Entity.Building;
import du.search.classBE.Repository.BuildingRepository;
import du.search.classBE.Repository.ClassroomRepository;
import du.search.classBE.Repository.HallRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InitClassroomService {

    private BuildingRepository buildingRepository;
    private ClassroomRepository classroomRepository;
    private HallRepository hallRepository;

    @Transactional
    public void insertClassroomsAndHallByHyphen(List<String> classrooms) {

        for (String code : classrooms) {
            String[] parts = code.split("-");
            String buildingName = parts[0].substring(0, parts[0].length() - 1);
            String hallNumber = parts[0].substring(parts[0].length() - 1);
            String floorAndRoom = parts[1];

            Building DbBuildingName = buildingRepository.findByName(buildingName);
        }

    }


}
