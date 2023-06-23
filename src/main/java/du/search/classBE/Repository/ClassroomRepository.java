package du.search.classBE.Repository;

import du.search.classBE.Entity.Classroom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassroomRepository extends JpaRepository<Classroom, Long> {

    Classroom findByHall_BuildingNameAndHall_HallNumber(String buildingName, String hallNumber);
}
