package washboard.dungeoncommandpc;

public class Commander {
	
	private String name;
	private String leaderPower;
	
	private int creatureHandSize;
	private int initialOrderHandSize;
	
	private int morale;
	private int leadership;
	
	private String flavorText;
	
	
	public int incrementLeadership() {
		return ++leadership;
	}
	
	
	
	public Commander(String nam, String pow, int crtHndSze, int odrHndSze, int mor, int ldr, String flavor) {
		name = nam;
		leaderPower = pow;
		creatureHandSize = crtHndSze;
		initialOrderHandSize = odrHndSze;
		morale = mor;
		leadership = ldr;
		flavorText = flavor;
	}
	
	public String getName(){
		return name;
	}
	
	public String getLeaderPower() {
		return new String(leaderPower);
	}
	
	public int getMaxCreatures() {
		return creatureHandSize;
	}
	
	public int getInitialOrder() {
		return initialOrderHandSize;
	}
	
	public int getCurrentMorale() {
		return morale;
	}
	
	public int getCurrentLeadership() {
		return leadership;
	}
	
	public String getFlavor() {
		return new String(flavorText);
	}

}
