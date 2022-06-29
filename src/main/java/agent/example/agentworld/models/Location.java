package agent.example.agentworld.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Location {

	public Location() {
		super();
		// TODO Auto-generated constructor stub
	}
	private int x;
	private int y;

	
	public void incrementY() {this.y++;};
	public void incrementX() {this.x++;};
	public void decrementY() {this.y--;};
	public void decrementX() {this.x--;};



		
	
}
