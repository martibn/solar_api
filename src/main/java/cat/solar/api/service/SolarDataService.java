package cat.solar.api.service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import cat.solar.api.dto.SolarDataDTO;
import cat.solar.api.mapper.SolarDataMapper;
import cat.solar.api.repository.SolarDataRepository;
import cat.solar.api.utils.DateUtils;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
@AllArgsConstructor
public class SolarDataService {
	
	private final SolarDataRepository repo;
	
	private final SolarDataMapper mapper;
	
	public List<SolarDataDTO> findSolarDataGroupBy(String groupBy, Date start, Optional<Date> end) {
		Date startDate = adjustStartDate(groupBy, start);
		Date endDate = end.orElse(adjustEndDate(groupBy, startDate));
		
		return repo.findSolarDataGroupBy(groupBy, startDate, endDate);
	}

	public List<SolarDataDTO> findSolarDataPeriod(Date start, Optional<Date> end) {
		
		start = DateUtils.zeroTime(start);
		Date endDate = end.orElse(DateUtils.addOneDay(start));
		
		return repo.findAllByTimestampBetween(start, endDate).stream().map(mapper::toDto).toList();
	}

	private Date adjustStartDate(String groupBy, Date start) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(start);
		
		return switch(groupBy) {
		
			case "day" -> DateUtils.zeroTime(cal.getTime());
			case "month" -> DateUtils.setDay(start, 1, cal.get(Calendar.MONTH), cal.get(Calendar.YEAR));
			case "year" -> DateUtils.setDay(start, 1, 0, cal.get(Calendar.YEAR));
		
			default -> new Date();
		};
	}

	private Date adjustEndDate(String groupBy, Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(DateUtils.setTime(date, 23, 59, 59, 99));
		
		return switch(groupBy) {
		
			case "day" -> cal.getTime();
			case "month" -> DateUtils.setDay(cal.getTime(), 0, cal.get(Calendar.MONTH) + 1 , cal.get(Calendar.YEAR));
			case "year" -> DateUtils.setDay(cal.getTime(), 0, 0, cal.get(Calendar.YEAR) + 1);
		
			default -> new Date();
		};
	}

}