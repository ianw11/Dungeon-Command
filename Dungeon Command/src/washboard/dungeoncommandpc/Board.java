package washboard.dungeoncommandpc;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import board.GridPane;
import board.grid.RangeGrid;
import board.grid.Space;

public class Board extends JPanel{
	
	public Board() {
		
		RangeGrid<Creature> pieces = new RangeGrid<Creature>(16,16);
		
		pieces.put(Space.get(0, 0), new Creature("Kelp-o", 20, 2, 1, 5, 10, null, null, null, new Point(0,0), "res/DungeonCommand.jpg"));
		
		GridPane grid = new GridPane(pieces);
		
		add(grid);
		
		JButton back = new JButton("Back");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Driver.backToHome(Board.this);
			}
		});
		add(back);
		
		setVisible(true);
	}
	
	
}
