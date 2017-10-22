package com.wpc.foosball.foosball.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(path="/foosball/api")
@RestController
public class FoosballController {

	@GetMapping
	public String ping() {
		return "api services are up and running";
	}
}
