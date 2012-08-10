package washboard.dungeoncommandpc;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public final class Driver {
	
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
		
	}
	
	public void setAppFrameTitle(String newTitle) {
		application.setTitle(newTitle);
	}
	
}
