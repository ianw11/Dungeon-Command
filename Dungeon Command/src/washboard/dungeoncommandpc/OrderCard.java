package washboard.dungeoncommandpc;

public class OrderCard {
	
	private String name;
	private int level;
	private String ability;
	private int actionType; //0 is standard, 1 is Minor, 2 is immediate
	
	
	public OrderCard(String nam, int lev, String abil, int speed) {
		name = nam;
		level = lev;
		ability = abil;
		actionType = speed;
	}
	
	public String getName() {
		return new String(name);
	}
	
	public int getLevel() {
		return level;
	}
	
	public String getAbilityReq() {
		return ability;
	}
	
	public int getCastingSpeed() {
		return actionType;
	}
	

}
