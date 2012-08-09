package washboard.dungeoncommandpc;

public class CreatureFeatures {
	
	private String friendlyName;
	private String friendlyDescription;
	
	public CreatureFeatures(String name, String description) {
		friendlyName = name;
		friendlyName = description;
	}
	
	public String getName() {
		return new String(friendlyName);
	}
	
	public String getDescription() {
		return new String(friendlyDescription);
	}

}
