import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Planet extends Entity {

	private SolorSystem system;
	private String atmosphere;
	private String temputure;
	private String biosphere;
	private String population;
	private String techLevel;
	private List<String> tags = new ArrayList<>();
	public Planet() {
		this("no name", -1, -1, "faction less", "Description has not been made yet",
				new SolorSystem(), "Class M Planet", "Mild", "Human-miscible", 
				"Few Billion", "5.0", 
				new ArrayList<>(Arrays.asList("Test", "Incomplete")));
		
	}
	public Planet(String name, int xCordinate, int yCordinate, String faction, 
			String description, SolorSystem system, String atmosphere, 
			String temputure, String biosphere, String population, 
			String techLevel, ArrayList<String> tags) {
		super(name, xCordinate, yCordinate, faction, description);
		
		this.setSystem(system);
		this.atmosphere = atmosphere;
		this.temputure = temputure;
		this.biosphere = biosphere;
		this.population = population;
		this.techLevel = techLevel;
		this.tags = tags;
		
		// TODO Auto-generated constructor stub
	}

	
	public SolorSystem getSystem() {
		return system;
	}

	public void setSystem(SolorSystem system) {
		this.system = system;
	}
	
	public String getAtmosphere() {
		return atmosphere;
	}

	public void setAtmosphere(String atmosphere) {
		this.atmosphere = atmosphere;
	}

	public String getTemputure() {
		return temputure;
	}

	public void setTemputure(String temputure) {
		this.temputure = temputure;
	}

	public String getBiosphere() {
		return biosphere;
	}

	public void setBiosphere(String biosphere) {
		this.biosphere = biosphere;
	}

	public String getPopulation() {
		return population;
	}

	public void setPopulation(String population) {
		this.population = population;
	}

	public String getTechLevel() {
		return techLevel;
	}

	public void setTechLevel(String techLevel) {
		this.techLevel = techLevel;
	}

	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}
	
	@Override
	public String toString(){
		return String.format("Planet: %s, Faction: %s, System: %s, Atm %s, Bio: %s, "
				+ "Pop: %s Tech LVL: %s, Tags: %s, Description %s", 
				super.getName(), super.getFaction(), system, atmosphere,
				biosphere, population, techLevel, tags.toString(), 
				super.getDescription());
	}

}
