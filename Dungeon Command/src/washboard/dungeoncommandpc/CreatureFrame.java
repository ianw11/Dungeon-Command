package washboard.dungeoncommandpc;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class CreatureFrame extends JFrame {
	
	public CreatureFrame() {
		
		JPanel panel = new JPanel(new BorderLayout());
		JPanel title = new JPanel(new BorderLayout());
		JPanel stats = new JPanel(new BorderLayout());
		JPanel statsImage = new JPanel(new BorderLayout());
		JPanel details = new JPanel(new BorderLayout());
		System.out.println("Creature Frame created");
		
		Creature testDude = CreatureDatabase.creatures.get((int)(Math.floor(Math.random()*CreatureDatabase.creatures.size())));  //Random card for now
		
		/////////////////////////////////////////////////////
		JTextArea name = new JTextArea(testDude.getName());
		name.setEditable(false);
		title.add(name, BorderLayout.CENTER);
		
		JTextArea level = new JTextArea(Integer.toString(testDude.getLevel()));
		level.setEditable(false);
		title.add(level, BorderLayout.LINE_START);
		
		JTextArea hp = new JTextArea(Integer.toString(testDude.getMaxHP()));
		hp.setEditable(false);
		title.add(hp, BorderLayout.LINE_END);
		
		/////////////////////////////////////////////////////
		
		JTextArea ability = new JTextArea(testDude.getAbilityTypes().toString());
		ability.setEditable(false);
		stats.add(ability, BorderLayout.PAGE_START);
		
		if(testDude.hasRangedAttack()) {
			JTextArea ranged = new JTextArea(testDude.getRangedDamage() + "(" + testDude.getRangedDistance() + ")");
			ranged.setEditable(false);
			stats.add(ability, BorderLayout.LINE_START);
		}
		
		JTextArea melee = new JTextArea(testDude.getMeleeDamage()+"");
		melee.setEditable(false);
		stats.add(melee, BorderLayout.PAGE_END);
		
		/////////////////////////////////////////////////////
		
		BufferedImage image;
		try{
		image = ImageIO.read(new File("res/DungeonCommand.jpg"));
		} catch (IOException ex){
			image = null;
			System.out.println("Image failed to load");
		}
		ImageIcon icon = new ImageIcon(image);
		JLabel borderedImage = new JLabel(icon);
		borderedImage.setPreferredSize(new Dimension(100,100));
		//statsImage.add(borderedImage);
		
		statsImage.add(stats, BorderLayout.CENTER);
		
		/////////////////////////////////////////////////////
		
		JButton close = new JButton("Back");
		MouseListener listener = new CreatureFrameListener();
		close.addMouseListener(listener);
		
		panel.add(title, BorderLayout.PAGE_START);
		panel.add(statsImage, BorderLayout.CENTER);
		panel.add(close, BorderLayout.PAGE_END);
		
		getContentPane().add(panel);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setVisible(true);
		pack();
	}
	
	
	private class CreatureFrameListener extends MouseAdapter{
		public void mouseClicked(MouseEvent event){
			dispose();
		}
		
		public void mouseExited(MouseEvent event){}
		public void mouseEntered(MouseEvent event){}
		public void mouseReleased(MouseEvent event){}
		public void mousePressed(MouseEvent event){}
	} //End of MenuListener
}