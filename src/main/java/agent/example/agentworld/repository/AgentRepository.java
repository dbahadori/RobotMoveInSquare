package agent.example.agentworld.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import agent.example.agentworld.models.Agent;
import agent.example.agentworld.models.Location;

@Repository
public interface AgentRepository extends MongoRepository<Agent, String>  {
		
	@Query("{ 'name' : ?0 }")
	Optional<Agent> findAgentByName(String name);	
	
	@Query(value = "{location : ?0}", exists = true)
	Boolean isAnyAgentInThisLocation(Location location); 


 }
