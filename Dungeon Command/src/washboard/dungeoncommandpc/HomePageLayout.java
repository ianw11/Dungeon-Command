package washboard.dungeoncommandpc;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

public class HomePageLayout extends JPanel {
	
	HomePageData menu;
	//JPanel homePageMenu;
	Object that;
	
	public HomePageLayout(HomePageData m) {
		that = this;
		menu = m;
		
		setLayout(new GridLayout(3,2));
		setBorder(new EtchedBorder());
		
		//add(homePageMenu, BorderLayout.CENTER);
		
		setUpMenuOptions();
		
		//setPreferredSize(new Dimension(500,350));
		setVisible(true);
		//((JFrame)getParent()).pack();
	}
	
	private void setUpMenuOptions() {
		
		class MenuListener extends MouseAdapter {
			public void mouseClicked(MouseEvent event){
				if(event.getComponent().getName() == "quit") {
					/*int result = JOptionPane.showConfirmDialog(event.getComponent(), "Leave for sure?", "Test title", JOptionPane.YES_NO_OPTION);
					if(result==0)*/
						System.err.println("No quit yet");	
				}
				else if(event.getComponent().getName() == "settings") {
					JOptionPane.showMessageDialog(event.getComponent(), "Test");
					new Board();
				}
				else {
					String result = JOptionPane.showInputDialog(event.getComponent(), "Input something!", "Title of input");
					if(result != null){
						new CreatureFrame();
						//options.add(new CreatureFrame());
						//((JFrame)that).getContentPane().add(new CreatureFrame(), BorderLayout.EAST);
						//((JFrame)that).pack();
						//goInvisible();
					}
				}
			}
			
			public void mouseExited(MouseEvent event){}
			public void mouseEntered(MouseEvent event){}
			public void mouseReleased(MouseEvent event){}
			public void mousePressed(MouseEvent event){}
		} //End of MenuListener
		
		MouseListener listener = new MenuListener();
		
		JButton newGame = new JButton("New Game");
		newGame.setName("newgame");
		newGame.addMouseListener(listener);
		add(newGame);
		
		JButton settings = new JButton("Settings");
		settings.setName("settings");
		settings.addMouseListener(listener);
		add(settings);
		
		JButton quit = new JButton("Quit");
		quit.setName("quit");
		quit.addMouseListener(listener);
		add(quit);
	}
	
	//private void goInvisible() {
	//	this.setVisible(false);
	//}
	
	//public void mainGoVisible() {
	//	setVisible(true);
	//}

}

/*
   public class FooWindow extends JFrame {
        public FooWindow() {
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setBounds(5, 5, 400, 300);  // yeah yeah, this is an example ;P
            setVisible(true);
        }
        public void pullThePlug() {
                WindowEvent wev = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
                Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(wev);
        }
    }

// Here's how that would be employed from elsewhere -

    // someplace the window gets created ..
    FooWindow fooey = new FooWindow();
    ...
    // and someplace else, you can close it thusly
    fooey.pullThePlug();
    ]
    */
