package washboard.dungeoncommandpc;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

public class HomePageLayout extends JFrame {
	
	HomePageData menu;
	JPanel options;
	
	public HomePageLayout(HomePageData m) {
		System.out.println("layout created");
		
		menu = m;
		
		options = new JPanel(new GridLayout(3,1));
		options.setPreferredSize(new Dimension(150,300));
		options.setBorder(new EtchedBorder());
		getContentPane().add(options, BorderLayout.CENTER);
		
		setUpMenuOptions(this);
		
		setVisible(true);
		pack();
	}
	
	private void setUpMenuOptions(JFrame context) {
		
		class MenuListener extends MouseAdapter {
			public void mouseClicked(MouseEvent event){
				if(event.getComponent().getName() == "quit"){
					closeWindow();
				}
				else {
					System.out.println("Not quit");
					System.out.println(menu.getData());
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
		options.add(newGame);
		
		JButton quit = new JButton("Quit");
		quit.setName("quit");
		quit.addMouseListener(listener);
		options.add(quit);
	}
	
	private void closeWindow() {
		this.dispose();
	}

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
