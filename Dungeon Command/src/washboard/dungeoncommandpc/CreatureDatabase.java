package washboard.dungeoncommandpc;

import java.awt.Point;
import java.util.ArrayList;

public class CreatureDatabase {
	
	public static ArrayList<Creature> creatures = new ArrayList<Creature>(){
		{
			add(new Creature("Umber Hulk", 100, 5, 2, 6, 30, new String[] {"Aberration"}, new String[] {"STR", "DEX"}, null, new Point(0,0), "res/redDot.jpg"));
			add(new Creature("War Wizard", 60, 4, 1, 6, 10, 30, 10, new String[]{"Humanoid", "Human", "Adventurer"}, new String[] {"INT"}, null, new Point(0,0), "res/yellowDot.jpg"));
			add(new Creature("Dragon Fighter", 120, 10, 1, 10, 40, new String[] {"Humanoid", "Fighter"}, new String[] {"STR", "DEX", "INT"}, null, new Point(0,0), "res/DungeonCommand.jpg"));
			
		}
	};
	
	public static ArrayList<CreatureFeatures> creatureFeatureList = new ArrayList<CreatureFeatures>() {
		{
			add(new CreatureFeatures("Empty Space Holder",""));
			add(new CreatureFeatures("Burrow", "Move through walls and slow spaces."));
			add(new CreatureFeatures("Scuttle", "Unaffected by enemy units (don't have to stop next to one)."));
			add(new CreatureFeatures("Confusion Gaze", "{tap}: As a standard action, choose 1 enemy creature within 5 squares and slide that creature 3 squares," +
					" then make a melee attack that deals {melee} Damage"));
			add(new CreatureFeatures("Arcane Portal", "When deploying this creature, you can place it in any unoccupied Magic Circle square."));
		}
	};
	
	
	//public CreatureDatabase() {
	//	creatures.add(new Creature("Umber Hulk", 100, 5, 2, 6, false, 30, new String[] {"Aberration"}, new String[] {"STR", "DEX"}, null, new Point(0,0)));
	//	creatures.add(new Creature("War Wizard", 60, 4, 1, 6, true, 10, 30, 10, new String[]{"Humanoid", "Human", "Adventurer"}, new String[] {"INT"}, null, new Point(0,0)));
	//}
	
} 