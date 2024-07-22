package objects;

public class Persona {
	private String name;
	private String arcana;
	private String type;
	private Integer level;
	private Integer rank;
	
	public Persona(String name, String arcana, String type, Integer level, Integer rank) {
		this.name = name;
		this.arcana = arcana;
		this.type = type;
		this.level = level;
		this.rank = rank;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getArcana() {
		return this.arcana;
	}
	
	public String getType() {
		return this.type;
	}
	
	public Integer getLevel() {
		return this.level;
	}
	
	public Integer getRank() {
		return this.rank;
	}
	
	public String toString() {
		return String.format("Name: %s | Arcana: %s | Type: %s | Base Level: %d",
				this.name, this.arcana, this.type, this.level);
	}
}
