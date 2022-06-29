package agent.example.agentworld.BLL;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import agent.example.agentworld.exception.AgentConflictException;
import agent.example.agentworld.exception.AgentNotFoundException;
import agent.example.agentworld.exception.BadActionException;
import agent.example.agentworld.exception.OutOfSquareException;
import agent.example.agentworld.models.Action;
import agent.example.agentworld.models.Agent;
import agent.example.agentworld.models.Location;
import agent.example.agentworld.repository.AgentRepository;

@Component
public class AgentLogic {

	@Autowired
	private AgentRepository agentRepository;
	
	@Value("${environment.height}")
	private int maxHeight;
	
	@Value("${environment.width}")
	private int maxWidth;
	
	public Agent Move( String agentName, Action action) {
		
		
		// getting actors positions at business logic side as the first method for showing java 8
		
		/*
		 * List<Agent> agents= agentRepository.findAll(); List<Location> locations=
		 * agents.stream().map(agent->agent.getLocation()).collect(Collectors.toList());
		 * 
		 * Optional<Agent> selectedAgent= agents.stream()
		 * .filter(agent->agentName.equals(agent.getName())) .findAny();
		 * 
		 * if(!selectedAgent.isEmpty()) {
		 * 
		 * switch (action) { case UP : selectedAgent.get().getLocation().incrementY();
		 * break; case DOWN : selectedAgent.get().getLocation().decrementY(); break;
		 * case FORWARD : selectedAgent.get().getLocation().incrementX(); break; case
		 * BACK : selectedAgent.get().getLocation().decrementX(); break; default : throw
		 * new BadActionException("Unexpected action: " + action); };
		 * 
		 * if(!Stream.of(selectedAgent.get().getLocation()) .anyMatch(a ->
		 * locations.contains(selectedAgent.get().getLocation()))) { //throw new
		 * AgentConflictException("You do not have permission to perform this action, there is another agent at this position!"
		 * ); } }
		 */

		
		// getting actors positions at repository side as the second method		  
		Agent agent = agentRepository.findAgentByName(agentName).orElseThrow(()->  new AgentNotFoundException("There is no agent with this name:" + agentName));
		if(agent!=null) {
			  
			  switch (action) { 
			  case UP : agent.getLocation().incrementY();
			  	break; 
			  case DOWN : agent.getLocation().decrementY(); 
			  	break;
			  case FORWARD : agent.getLocation().incrementX(); 
			  	break; 
			  case BACK : agent.getLocation().decrementX(); 
			  	break; 
			  	
			  default : throw new BadActionException("Unexpected command: " + action+ ". Valid command is one of these: UP, DOWN, FORWARD, BACK"); };
		}
		
		if(agentRepository.isAnyAgentInThisLocation(agent.getLocation())) {
			throw new  AgentConflictException("You do not have permission to perform this action, there is another agent at this position!"); 
		}
		if(!isThisPositionInSquare(agent)) {
			throw new  OutOfSquareException("You do not have permission to perform this action, this action takes you out of square!"); 
		}
				
		return agentRepository.save(agent);
	}
	
	private Boolean isThisPositionInSquare(Agent agent) {
		
		int positionX= agent.getLocation().getX();
		int positionY= agent.getLocation().getY();
		
		if(positionX>=1 && positionX<=maxWidth && positionY>=1 && positionY<=maxHeight)
			return true;
		else 
			return false;
	}
}
