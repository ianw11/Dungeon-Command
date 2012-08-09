package washboard.dungeoncommandpc;

import javax.swing.JFrame;

import board.GridPane;
import board.grid.RangeGrid;

public class Board extends JFrame{
	
	public Board() {
		
		RangeGrid<Creature> range = new RangeGrid<Creature>(5,5);
		GridPane grid = new GridPane(range);
		
		add(grid);
		
		setVisible(true);
		pack();
	}
	
	
}
