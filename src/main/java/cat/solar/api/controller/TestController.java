package cat.solar.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cat.solar.api.repository.SolarDataRepository;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/test")
@AllArgsConstructor
public class TestController {
	
	private final SolarDataRepository repo;

	@GetMapping
	public String test() {
		
		return repo.findAll().toString();
	}

}