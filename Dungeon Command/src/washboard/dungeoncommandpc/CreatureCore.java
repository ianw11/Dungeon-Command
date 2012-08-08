package washboard.dungeoncommandpc;

import java.util.ArrayList;

public abstract class CreatureCore {
	
	private String name;
	private int hitPoints;
	private int level;
	private int movementSpeed;
	private boolean isTapped;
	
	private boolean hasRangedAttack;
	private int meleeDamage;
	private int rangedDamage;
	private int rangedDistance;
	
	private ArrayList<String> creatureTypes;
	private ArrayList<String> creatureAbilityScores;
	
	private ArrayList<String> uniqueFeatures;
	
	private int creatureSize;
	
	public CreatureCore(String nam, int hp, int lev, int size, int spd, boolean tap, boolean ran, int mDmg, int rDmg, int rDist,
			ArrayList<String> types, ArrayList<String> abilities, ArrayList<String> features) {
		name = nam;
		hitPoints = hp;
		level = lev;
		movementSpeed = spd;
		isTapped = tap;
		hasRangedAttack = ran;
		meleeDamage = mDmg;
		rangedDamage = rDmg;
		rangedDistance = rDist;
		creatureTypes = new ArrayList<String>(types);
		creatureAbilityScores = new ArrayList<String>(abilities);
		uniqueFeatures = new ArrayList<String>(features);
		creatureSize = size;
	}
	
	public String getName() {
		return name;
	}
	
	public int getCurrentHP() {
		return hitPoints;
	}
	
	public int getLevel() {
		return level;
	}
	
	public int getMovementSpeed() {
		return movementSpeed;
	}
	
	public boolean isCreatureTapped() {
		return isTapped;
	}
	
	public int getMeleeDamage() {
		return meleeDamage;
	}
	

}
