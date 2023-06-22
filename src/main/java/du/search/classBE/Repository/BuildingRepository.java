package du.search.classBE.Repository;


import du.search.classBE.Entity.Building;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BuildingRepository extends JpaRepository<Building, Long> {

    Building findByName(String name);
}
