package washboard.dungeoncommandpc;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.border.EtchedBorder;
import java.awt.Dimension;
import java.awt.Color;

public class HomePageLayout extends JPanel {
	
	public HomePageLayout() {
		setAutoscrolls(true);
		setPreferredSize(new Dimension(400, 600));
		setBorder(new EtchedBorder());
		
		setUpMenuOptions();
	}
	
	// Use JOptionPane for popup menus!!!!
	
	private void setUpMenuOptions() {
		
		class MenuListener extends MouseAdapter {
			
			public void mouseClicked(MouseEvent event) {
				if(event.getComponent().getName() == "quit") {
					
					Driver.endApp();
				}
				else if(event.getComponent().getName() == "settings") {
					new Board();
				}
				else {
					Driver.switchPanel(new CreatureCardLayout());
				}
			}
			
			public void mouseExited(MouseEvent event){}
			public void mouseEntered(MouseEvent event){}
			public void mouseReleased(MouseEvent event){}
			public void mousePressed(MouseEvent event){}
		} //End of MenuListener
		
		MouseListener listener = new MenuListener();
		
		JButton newGame = new JButton("New Game");
		newGame.setBackground(Color.GREEN);
		newGame.setName("newgame");
		newGame.addMouseListener(listener);
		SpringLayout springLayout = new SpringLayout();
		springLayout.putConstraint(SpringLayout.NORTH, newGame, 65, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, newGame, 2, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, newGame, 175, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.EAST, newGame, -2, SpringLayout.EAST, this);
		setLayout(springLayout);
		add(newGame);
		
		JButton settings = new JButton("Settings");
		springLayout.putConstraint(SpringLayout.NORTH, settings, 110, SpringLayout.SOUTH, newGame);
		springLayout.putConstraint(SpringLayout.EAST, settings, 0, SpringLayout.EAST, newGame);
		springLayout.putConstraint(SpringLayout.WEST, settings, 2, SpringLayout.WEST, this);
		settings.setName("settings");
		settings.addMouseListener(listener);
		add(settings);
		
		JButton quit = new JButton("Quit");
		springLayout.putConstraint(SpringLayout.SOUTH, settings, -145, SpringLayout.NORTH, quit);
		springLayout.putConstraint(SpringLayout.WEST, quit, 8, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, quit, -12, SpringLayout.EAST, this);
		springLayout.putConstraint(SpringLayout.NORTH, quit, 525, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.SOUTH, quit, -10, SpringLayout.SOUTH, this);
		quit.setPreferredSize(new Dimension(55, 23));
		quit.setName("quit");
		quit.addMouseListener(listener);
		add(quit);
	}

}
