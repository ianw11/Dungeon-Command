package washboard.dungeoncommandpc;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.border.EtchedBorder;

public class HomePageLayout extends JPanel {
	
	public HomePageLayout() {
		setAutoscrolls(true);
		setPreferredSize(new Dimension(400, 500));
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
					Driver.switchPanel("board", new Board());
				}
				else if(event.getComponent().getName() == "popUp"){
						//JDialog popup = new JDialog();
						JDialog popup = new CreatureCardLayout();
						popup.setTitle("Creature Card");
						popup.setSize(new Dimension(400,550));
						popup.setResizable(false);
						
						Component[] t = popup.getComponents();
						System.err.println(t.length);
						for(Component c: t){
							System.out.println(c.getName());
						}
						
						
						//popup.pack();
						popup.setVisible(true);
				}
				else if(event.getComponent().getName() == "order") {
					JDialog popup = new OrderCardLayout();
					popup.setTitle("Order Card Preview");
					popup.setSize(new Dimension(400,550));
					popup.setResizable(false);
				}
				else {
					System.err.println("NOT IMPLEMENTED YET");
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
		//Temporarily removing this from the listener above
		newGame.addMouseListener(listener);
		//newGame.addActionListener(listener);
		SpringLayout springLayout = new SpringLayout();
		springLayout.putConstraint(SpringLayout.NORTH, newGame, 10, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, newGame, 2, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, newGame, 120, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.EAST, newGame, -2, SpringLayout.EAST, this);
		setLayout(springLayout);
		add(newGame);
		
		JButton settings = new JButton("Settings");
		springLayout.putConstraint(SpringLayout.NORTH, settings, 21, SpringLayout.SOUTH, newGame);
		springLayout.putConstraint(SpringLayout.WEST, settings, 0, SpringLayout.WEST, newGame);
		springLayout.putConstraint(SpringLayout.EAST, settings, -2, SpringLayout.EAST, this);
		settings.setName("settings");
		settings.addMouseListener(listener);
		//settings.addActionListener(listener);
		add(settings);
		
		JButton quit = new JButton("Quit");
		springLayout.putConstraint(SpringLayout.SOUTH, settings, -33, SpringLayout.NORTH, quit);
		springLayout.putConstraint(SpringLayout.NORTH, quit, 235, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, quit, 0, SpringLayout.WEST, newGame);
		springLayout.putConstraint(SpringLayout.SOUTH, quit, -200, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.EAST, quit, -18, SpringLayout.EAST, this);
		quit.setName("quit");
		quit.addMouseListener(listener);
		//quit.addActionListener(listener);
		add(quit);
		
		JButton card = new JButton("Card");
		springLayout.putConstraint(SpringLayout.NORTH, card, 6, SpringLayout.SOUTH, settings);
		springLayout.putConstraint(SpringLayout.WEST, card, 0, SpringLayout.WEST, newGame);
		card.setName("popUp");
		card.addMouseListener(listener);
		//card.addActionListener(listener);
		add(card);
		
		JButton order = new JButton("Order");
		springLayout.putConstraint(SpringLayout.NORTH, order, 6, SpringLayout.SOUTH, quit);
		springLayout.putConstraint(SpringLayout.WEST, order, 0, SpringLayout.WEST, newGame);
		order.setName("order");
		order.addMouseListener(listener);
		add(order);
	}
}
