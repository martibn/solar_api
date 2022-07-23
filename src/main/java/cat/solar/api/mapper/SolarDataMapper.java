package cat.solar.api.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import cat.solar.api.dto.SolarDataDTO;
import cat.solar.api.model.SolarData;

@Component
public class SolarDataMapper {

	public SolarDataDTO toDto(SolarData data) {
		SolarDataDTO dto = new SolarDataDTO();
		dto.setGrid_consumption(data.getGrid_consumption());
		dto.setGrid_injection(data.getGrid_injection());
		dto.setPower_consumption(data.getPower_consumption());
		dto.setPower_generated(data.getPower_generated());
		dto.setTime(data.getTimestamp());
		
		return dto;
	}
	
}
