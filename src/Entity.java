import java.util.ArrayList;
import java.util.HashMap;

public class Entity {

	private String name;
	private String faction;
	private String description;
	private HashMap<String, Entity> entities;
	//location in array
	private int xCordinate;
	private int yCordinate;
	
	public Entity() {
		this("no name", -1, -1, "faction less", "Description has not been made yet");
	}
	public Entity(String name, int xCordinate, int yCordinate, 
			String faction, String description) {
		this.name = name;
		this.xCordinate = xCordinate;
		this.yCordinate = yCordinate;
		this.faction = faction;
		this.description = description;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFaction() {
		return faction;
	}

	public void setFaction(String faction) {
		this.faction = faction;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getCordinates() {
		
		return String.format("%2d%2d", xCordinate, yCordinate);
	}

	public void setCordinates(int xCordinate, int yCordinate) {
		this.xCordinate = xCordinate;
		this.yCordinate = yCordinate;
	}
	
	public int getxCordinate() {
		return xCordinate;
	}

	public void setxCordinate(int xCordinate) {
		this.xCordinate = xCordinate;
	}

	public int getyCordinate() {
		return yCordinate;
	}

	public void setyCordinate(int yCordinate) {
		this.yCordinate = yCordinate;
	}

	@Override
	public String toString(){
		return String.format("%s: %s", name, description);
	}
	public void addEntity(HashMap<String, Entity> entity) {
		 
	}
	
	public HashMap<String, Entity> getEntities() {
		return entities;
	}
	public void setEntities(HashMap<String, Entity> entities) {
		this.entities = entities;
	}
}
