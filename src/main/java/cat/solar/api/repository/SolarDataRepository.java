package cat.solar.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cat.solar.api.model.SolarData;

@Repository 
public interface SolarDataRepository extends CrudRepository<SolarData, Long>{

}
