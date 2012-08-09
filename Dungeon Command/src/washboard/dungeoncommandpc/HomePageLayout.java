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

import board.grid.RangeGrid;

public class HomePageLayout extends JFrame {
	
	HomePageData menu;
	JPanel options;
	Object that;
	
	public HomePageLayout(HomePageData m) {
		that = this;
		System.out.println("layout created");
		
		menu = m;
		
		options = new JPanel(new GridLayout(3,2));
		//options.setPreferredSize(new Dimension(150,300));
		options.setBorder(new EtchedBorder());
		getContentPane().add(options, BorderLayout.CENTER);
		
		setUpMenuOptions();
		
		setPreferredSize(new Dimension(500,150));
		setTitle("Don't close this window!!!");
		setVisible(true);
		pack();
	}
	
	private void setUpMenuOptions() {
		
		class MenuListener extends MouseAdapter {
			public void mouseClicked(MouseEvent event){
				if(event.getComponent().getName() == "quit") {
					/*int result = JOptionPane.showConfirmDialog(event.getComponent(), "Leave for sure?", "Test title", JOptionPane.YES_NO_OPTION);
					if(result==0)*/
						closeWindow();	
				}
				else if(event.getComponent().getName() == "settings") {
					JOptionPane.showMessageDialog(event.getComponent(), "Test");
					JFrame a = new Board();
				}
				else {
					String result = JOptionPane.showInputDialog(event.getComponent(), "Input something!", "Title of input");
					if(result != null){
						JFrame a = new CreatureFrame();
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
		options.add(newGame);
		
		JButton settings = new JButton("Settings");
		settings.setName("settings");
		settings.addMouseListener(listener);
		options.add(settings);
		
		JButton quit = new JButton("Quit");
		quit.setName("quit");
		quit.addMouseListener(listener);
		options.add(quit);
	}
	
	private void closeWindow() {
		this.dispose();
	}
	
	private void goInvisible() {
		this.setVisible(false);
	}
	
	public void mainGoVisible() {
		setVisible(true);
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
