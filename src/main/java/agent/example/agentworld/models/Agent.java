package agent.example.agentworld.models;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;

import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
@Document("agent")
public class Agent {	
	@Id
	private String id;
	@Indexed(unique = true) 
	private String name;
	private Location location;

}
