package washboard.dungeoncommandpc;

import java.awt.Point;

import javax.swing.JFrame;
import javax.swing.JPanel;

import board.GridPane;
import board.grid.RangeGrid;

public class Board extends JFrame{
	
	public Board() {
		
		RangeGrid<Creature> range = new RangeGrid<Creature>(16,16);
		GridPane grid = new GridPane(range);
		JPanel gridHolder = new JPanel();
		
		range.put(range.allValidSpaces().iterator().next(), new Creature("Hulk-o", 20, 2, 1, 5, false, 10, null, null, null, new Point(0,0)));
		System.out.println(range.allValidSpaces());
		
		gridHolder.add(grid);
		add(gridHolder);
		
		setVisible(true);
		pack();
	}
	
	
}
