package washboard.dungeoncommandpc;

import java.awt.Point;
import java.util.ArrayList;

public class CreatureDatabase {
	
	public static ArrayList<Creature> creatures = new ArrayList<Creature>(){
		{
			add(new Creature("Umber Hulk", 100, 5, 2, 6, false, 30, new String[] {"Aberration"}, new String[] {"STR", "DEX"}, null, new Point(0,0)));
			add(new Creature("War Wizard", 60, 4, 1, 6, true, 10, 30, 10, new String[]{"Humanoid", "Human", "Adventurer"}, new String[] {"INT"}, null, new Point(0,0)));
			
		}
	};
	
	
	//public CreatureDatabase() {
	//	creatures.add(new Creature("Umber Hulk", 100, 5, 2, 6, false, 30, new String[] {"Aberration"}, new String[] {"STR", "DEX"}, null, new Point(0,0)));
	//	creatures.add(new Creature("War Wizard", 60, 4, 1, 6, true, 10, 30, 10, new String[]{"Humanoid", "Human", "Adventurer"}, new String[] {"INT"}, null, new Point(0,0)));
	//}
	
} 