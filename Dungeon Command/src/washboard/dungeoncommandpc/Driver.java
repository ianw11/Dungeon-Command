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
		home.setPreferredSize(new Dimension(400,600));
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
	
	public static void backToHome(JPanel orig){
		application.getContentPane().remove(orig);
		home.setVisible(true);
		
	}
	
	public void setAppFrameTitle(String newTitle) {
		application.setTitle(newTitle);
	}
	
}
