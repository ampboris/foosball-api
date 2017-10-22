package com.wpc.foosball.foosball.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wpc.foosball.foosball.document.FoosballResult;
import com.wpc.foosball.foosball.repository.FoosbalResultRepository;

@RequestMapping(path="/foosball/api")
@RestController
public class FoosballController {

	@Autowired
	private FoosbalResultRepository repo;
	@GetMapping
	public String ping() {
		return "api services are up and running";
	}
	
	@GetMapping(path="/results")
	public List<FoosballResult> getResults() {
		return repo.findAll();
	}
}
