package agent.example.agentworld.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import agent.example.agentworld.BLL.AgentLogic;
import agent.example.agentworld.exception.AgentNotFoundException;
import agent.example.agentworld.models.Action;
import agent.example.agentworld.models.Agent;
import agent.example.agentworld.models.CommandRequest;
import agent.example.agentworld.models.Location;
import agent.example.agentworld.repository.AgentRepository;

@Service
public class AgentServiceImp implements AgentService{
	@Autowired
	private AgentRepository agentRepository;

	@Autowired
	private AgentLogic agentLogic;

	
	public Agent moveCommand(CommandRequest command) {
		return agentLogic.Move(command.getAgentName(), command.getAction()	);
	}

	public Location getAgentLocation(String name) {
		Agent agent = agentRepository.findAgentByName(name).
				orElseThrow(()->  new AgentNotFoundException("There is no agent with this name:" + name));
        return agent.getLocation();	}
}
