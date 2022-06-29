package agent.example.agentworld.controller;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import agent.example.agentworld.exception.BadActionException;
import agent.example.agentworld.models.Agent;
import agent.example.agentworld.models.CommandRequest;
import agent.example.agentworld.models.Location;
import agent.example.agentworld.repository.AgentRepository;
import agent.example.agentworld.service.AgentService;

@RestController
public class agentWorldController {

	@Autowired
	private AgentService service;
	
	@GetMapping("agents/{name}")
	public Location actorLocation(@PathVariable String name) {
		
		// alternative method is returning an agent object and filter its name property using @JsonIgnoreProperties annotation  
		return service.getAgentLocation(name);
	}
	
	@PostMapping("/commands")
	public void upAction(@RequestBody CommandRequest command) {
		
		try {
			service.moveCommand(command);
		} catch (Exception e) {
			throw new BadActionException("Unexpected command. Valid command is one of these: UP, DOWN, FORWARD, BACK");
		}
	}
	
}
