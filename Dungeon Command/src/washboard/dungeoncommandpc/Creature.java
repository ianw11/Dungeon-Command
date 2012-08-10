package washboard.dungeoncommandpc;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;

import board.grid.Grid;
import board.grid.Space;
import board.pieces.Piece;

public class Creature implements Piece{
	
	//Piece variables for the interface
	private Color color = new Color(0,0,0);
	private Space space;
	private Grid<Piece> grid;
	
	private String name;
	private int maxHitPoints;
	private int currHitPoints;
	private int level;
	private int movementSpeed;
	private boolean isTapped;
	private ArrayList<CreatureFeatures> uniqueFeatures;
	private int creatureSize; //1 will represent medium size, 2 will represent large
	
	private boolean hasRangedAttack;
	private int meleeDamage;
	private int rangedDamage;
	private int rangedDistance;
	
	private String[] keyWords;
	private String[] creatureAbilityTypes;
	
	private Point position;
	
	//Methods for the interface
	public Color getColor() {
		return new Color(color.getRGB());
	}
	public Space getCurrentSpace() {
		return space;
	}
	public Grid<? super Piece> getGrid() {
		return grid;
	}
	public void moveTo(Space s){
		//TO BE IMPLEMENTED
	}
	public void putSetfOnGrid(Grid<? super Piece> g, Space s) {
		//TO BE IMPLEMENTED
	}
	public void removeSelfFromGrid() {
		//TO BE IMPLEMENTED
	}
	public void setColor(Color c) {
		color = new Color(c.getRGB());
	}
	
	
	
	
	/*
	 * @return The position of the appended feature
	 */
	public int appendAttachText(CreatureFeatures attach) {
		uniqueFeatures.add(attach);
		return uniqueFeatures.size();
	}
	
	public void removeAttachText(String name) {
		for(CreatureFeatures c: uniqueFeatures){
			if (c.getName() == name)
				uniqueFeatures.remove(c);
		}
	}
	
	public void removeAttachText(int pos){
		uniqueFeatures.remove(pos);
	}
	
	
	
	/**
	 * @param nam The name of the card
	 * @param hp
	 * @param lev
	 * @param size
	 * @param spd
	 * @param tap
	 * @param range
	 * @param mDmg
	 * @param types
	 * @param abilities
	 * @param features
	 * @param startingPosition
	 */
	public Creature(String nam, int hp, int lev, int size, int spd, int mDmg,
			String[] types, String[] abilities,
			ArrayList<CreatureFeatures> features, Point startingPosition) {
		int i;
		name = nam;
		maxHitPoints = hp;
		currHitPoints = hp;
		level = lev;
		movementSpeed = spd;
		meleeDamage = mDmg;
		
		if(types != null){
			keyWords = new String[types.length];
			for(i=0; i<types.length; i++){
				keyWords[i] = new String(types[i]);
			}
		}
		if(abilities != null){
			creatureAbilityTypes = new String[abilities.length];
			for(i=0; i<abilities.length; i++){
				creatureAbilityTypes[i] = new String(abilities[i]);
			}
		}
		if(uniqueFeatures != null) {
			uniqueFeatures = new ArrayList<CreatureFeatures>(features);
		}
		creatureSize = size;
		position = startingPosition;
		
		hasRangedAttack = false;
		isTapped = false;
	}
	/**
	 * @param nam The name of the card
	 * @param hp
	 * @param lev
	 * @param size
	 * @param spd
	 * @param range
	 * @param mDmg
	 * @param rDmg
	 * @param rDist
	 * @param types
	 * @param abilities
	 * @param features
	 * @param startingPosition
	 */
	public Creature(String nam, int hp, int lev, int size, int spd, int mDmg,
			int rDmg, int rDist, String[] types, String[] abilities,
			ArrayList<CreatureFeatures> features, Point startingPosition) {
		int i;
		
		name = nam;
		if (hp%10 != 0) {
			hp = hp*10;
		}
		if(mDmg%10 != 0)
			mDmg = 10*mDmg;
		if(rDmg%10 != 0)
			rDmg = rDmg*10;

		maxHitPoints = hp;
		currHitPoints = hp;
		level = lev;
		movementSpeed = spd;
		hasRangedAttack = true;
		meleeDamage = mDmg;
		rangedDamage = rDmg;
		rangedDistance = rDist;
		
		if(types != null){
			keyWords = new String[types.length];
			for(i=0; i<types.length; i++){
				keyWords[i] = new String(types[i]);
			}
		}
		if(abilities != null){
			creatureAbilityTypes = new String[abilities.length];
			for(i=0; i<abilities.length; i++){
				creatureAbilityTypes[i] = new String(abilities[i]);
			}
		}
		if(uniqueFeatures != null) {
			uniqueFeatures = new ArrayList<CreatureFeatures>(features);
		}
		creatureSize = size;
		position = startingPosition;
		
		isTapped = false;
	}
	
	public String getName() {
		return name;
	}
	
	public int getMaxHP() {
		return maxHitPoints;
	}
	
	public int getCurrentHP() {
		return currHitPoints;
	}
	
	public void takeDamage(int damage) {
		currHitPoints -= damage;
	}
	
	public void healDamage(int healed){
		currHitPoints += healed;
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
	
	public boolean hasRangedAttack() {
		return hasRangedAttack;
	}
	
	public int getRangedDamage() {
		if(hasRangedAttack)
			return rangedDamage;
		else return 0;
	}
	
	public int getRangedDistance() {
		if (hasRangedAttack)
			return rangedDistance;
		else return 0;
	}
	
	public void changePosition(int deltaX, int deltaY) {
		position.move(deltaX, deltaY);
	}
	
	public int getCreatureSize() {
		return creatureSize;
	}
	
	public String[] getAbilityTypes() {
		return creatureAbilityTypes.clone();
	}
	
	public String[] getCreatureTypes() {
		return keyWords.clone();
	}
	
	public ArrayList<CreatureFeatures> getFeatures() {
		return new ArrayList<CreatureFeatures>(uniqueFeatures);
	}
	

}
