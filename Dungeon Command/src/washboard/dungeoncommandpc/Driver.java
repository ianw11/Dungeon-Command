package washboard.dungeoncommandpc;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public final class Driver {
	
<<<<<<< HEAD
	private static JPanel home;
	private static JFrame application;
	private static JPanel gameGrid;
	private static final Dimension GAMEDIMENSION = new Dimension(1200, 650);
	
	// Entire application begins at this point
	public static void main(String[] args){
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new Driver();
			}
		});
	}
	
	public Driver() {
		application = new JFrame("Dungeon Commander");
		
		//gameGrid = new JPanel();
		//gameGrid.setVisible(false);
		
		home = new HomePageLayout();
		home.setPreferredSize(new Dimension(400,500));
		
		application.add(home);
		//application.add(gameGrid);
		
		application.pack();
		application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		application.setVisible(true);
	}
	
	public static void endApp() {
		System.exit(0);
	}
	
	public static void switchPanel(String targetClass, JPanel target) {
		if(targetClass == "board")
		{
			//application.removeAll(); YEAH FUCK THAT METHOD
			application.getContentPane().removeAll();
			
			gameGrid = target;
			gameGrid.setPreferredSize(GAMEDIMENSION);
			application.add(gameGrid);
			
			application.validate();
			application.repaint();
			application.pack();
		}
	}
	
	public static void backToHome(JPanel current){
		System.out.println(current.getClass().getName());
		application.getContentPane().removeAll();
		application.add(home);
		
		application.validate();
		application.repaint();
		application.pack();
=======
	private static JPanel home = new HomePageLayout();
	private static JFrame application;
	
	// Entire application begins at this point
	public static void main(String[] args){
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new Driver();
			}
		});
	}
	
	public Driver() {
		application = new JFrame("Dungeon Commander");
		home.setPreferredSize(new Dimension(400,500));
		application.add(home);
		
		application.pack();
		application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		application.setVisible(true);
	}
	
	public static void endApp() {
		System.exit(0);
	}
	
	public static void switchPanel(JPanel target) {
		home.setVisible(false);
		application.add(target);
		application.pack();
	}
	
	public static void backToHome(JPanel current){
		application.getContentPane().remove(current);
		home.setVisible(true);
		application.validate();
		
>>>>>>> branch 'master' of git@github.com:ianw11/Dungeon-Command.git
	}
	
	public void setAppFrameTitle(String newTitle) {
		application.setTitle(newTitle);
	}
	
}
