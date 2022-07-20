package cat.solar.api.controller;

import java.util.Date;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/solar_data")
@AllArgsConstructor
public class SolarDataController {
	
	@GetMapping
	public String dayPeriod(@RequestParam Date start,
							@RequestParam Date end) {
		return "day period";
	}

	@GetMapping("/current")
	public String current() {
		// get current from inverter
		return "current";
	}

}