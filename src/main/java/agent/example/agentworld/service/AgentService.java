package agent.example.agentworld.service;

import org.springframework.beans.factory.annotation.Autowired;

import agent.example.agentworld.BLL.AgentLogic;
import agent.example.agentworld.models.Agent;
import agent.example.agentworld.models.CommandRequest;
import agent.example.agentworld.models.Location;

public interface AgentService {

	public Agent moveCommand(CommandRequest command);
	public Location getAgentLocation(String name);
}
