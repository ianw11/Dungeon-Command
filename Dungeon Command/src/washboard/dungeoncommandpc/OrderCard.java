package washboard.dungeoncommandpc;

public class OrderCard {
	
	private String name;
	private int level;
	private String ability;
	private int actionType; //0 is standard, 1 is Minor, 2 is immediate
	private String cardEffect;
	
	
	public OrderCard(String nam, int lev, String abil, int speed, String effect) {
		name = nam;
		level = lev;
		ability = abil;
		actionType = speed;
		cardEffect = effect;
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
	
	public String getCardEffect() {
		return new String(cardEffect);
	}
	

}
