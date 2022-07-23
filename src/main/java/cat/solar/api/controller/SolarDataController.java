package cat.solar.api.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cat.solar.api.dto.SolarDataDTO;
import cat.solar.api.service.SolarDataService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/solar_data")
@AllArgsConstructor
public class SolarDataController {
	
	private final SolarDataService service;
	
	@GetMapping
	public List<SolarDataDTO> period(@RequestParam(required = false, defaultValue = "#{new java.util.Date()}")@DateTimeFormat(iso = ISO.DATE_TIME) Date start,
			@RequestParam(required = false) @DateTimeFormat(iso = ISO.DATE_TIME) Optional<Date> end) {
		
		return service.findSolarDataPeriod(start, end);
	}
	
	@GetMapping("/current")
	public String current() {
		// get current from inverter
		return "current";
	}
	
	@GetMapping("/{groupBy}")
	public List<SolarDataDTO> dayPeriod(@PathVariable String groupBy,
			 @RequestParam(required = false, defaultValue = "#{new java.util.Date()}") @DateTimeFormat(iso = ISO.DATE_TIME) Date start,
			 @RequestParam(required = false) @DateTimeFormat(iso = ISO.DATE_TIME) Optional<Date> end) {
		return service.findSolarDataGroupBy(groupBy, start, end);
	}

}