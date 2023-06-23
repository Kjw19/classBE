package du.search.classBE.Repository;

import du.search.classBE.Entity.Building;
import du.search.classBE.Entity.Hall;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HallRepository extends JpaRepository<Hall, Long> {
    Hall findByHallNumberAndBuildingName(String hallNumber, String building);
}
