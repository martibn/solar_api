package cat.solar.api.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cat.solar.api.dto.SolarDataDTO;
import cat.solar.api.model.SolarData;

@Repository 
public interface SolarDataRepository extends CrudRepository<SolarData, Long>{

	@Query("select date_trunc(:groupBy, sd.timestamp) as \"time\", sum(power_generated)/12 \"power_generated\", sum(grid_injection)/12 as \"grid_injection\", sum(grid_consumption)/12 as \"grid_consumption\", sum(power_consumption)/12 as \"power_consumption\" "
			+ "from solar_data sd "
			+ "where timestamp between :start AND :end "
			+ "GROUP BY time order by time")
	List<SolarDataDTO> findSolarDataGroupBy(String groupBy, Date start, Date end);
	
	List<SolarData> findAllByTimestampBetween(Date start, Date end);
}
