package washboard.dungeoncommandpc;

import java.awt.Dimension;

import javax.swing.JFrame;

public class HomePageData {

	private int data;
	
	public static void main(String[] args){
		HomePageData menu = new HomePageData();
		//JFrame appFrame = new HomePageLayout(menu);
		JFrame application = new JFrame("Card");
		application.setPreferredSize(new Dimension(350,350));
		
		application.add(new HomePageLayout(menu));
		
		//application.add(new CreatureFrame());
		
		application.pack();
		application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		application.setVisible(true);
		
		new HomePageData();
		
		System.out.println("Correct build");
	}
	
	
	public HomePageData() {
		data = 5;
	}
	
	public int getData(){
		return data;
	}
	
}
