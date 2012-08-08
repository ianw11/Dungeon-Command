package washboard.dungeoncommandpc;

import javax.swing.JFrame;

public class LaunchPage {
	
	public static void main(String[] args){
		System.out.println("Launch Page Activated");
		
		HomePageData menu = new HomePageData();
		JFrame appFrame = new HomePageLayout(menu);
		appFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		appFrame.setVisible(true);
		
		
	}

}
