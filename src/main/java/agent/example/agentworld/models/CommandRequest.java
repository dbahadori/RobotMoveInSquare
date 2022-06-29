package agent.example.agentworld.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CommandRequest {
	public String agentName;
	public Action action;
}
