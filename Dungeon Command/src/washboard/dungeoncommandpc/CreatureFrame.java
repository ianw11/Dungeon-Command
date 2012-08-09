package washboard.dungeoncommandpc;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.text.AbstractDocument;
import javax.swing.text.BoxView;
import javax.swing.text.ComponentView;
import javax.swing.text.Element;
import javax.swing.text.IconView;
import javax.swing.text.LabelView;
import javax.swing.text.ParagraphView;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import javax.swing.text.StyledEditorKit;
import javax.swing.text.View;
import javax.swing.text.ViewFactory;
import javax.swing.border.BevelBorder;

public class CreatureFrame extends JFrame {
	
	public CreatureFrame() {
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(400, 600));
		
		JPanel title = new JPanel();
		title.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		title.setLayout(new GridLayout(0, 3, 0, 0));
		
		JPanel stats = new JPanel();
		stats.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel details = new JPanel(new BorderLayout());
		details.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		System.out.println("Creature Frame created");
		
		//FOR TESTING. PICKS A RANDOM UNIT
		Random generator = new Random();
		Creature testDude = CreatureDatabase.creatures.get(generator.nextInt(CreatureDatabase.creatures.size()));
		
		/////////////////////////////////////////////////////
		JTextField level = new JTextField();
		level.setBorder(null);
		level.setHorizontalAlignment(SwingConstants.CENTER);
		level.setFont(new Font("Tahoma", Font.PLAIN, 28));
		level.setSize(new Dimension(100, 0));
		level.setText("LEVEL " + testDude.getLevel());
		level.setPreferredSize(new Dimension(40, 40));
		level.setEditable(false);
		title.add(level);
		
		JTextPane name = new JTextPane();
		name.setBackground(SystemColor.menu);
		name.setEditable(false);
		name.setFont(new Font("Tahoma", Font.PLAIN, 20));
		name.setBorder(null);
		//Hard-coding the title to be centered
		try{
			name.setEditorKit(new MyEditorKit());
			StyledDocument doc = (StyledDocument)name.getDocument();
			SimpleAttributeSet center = new SimpleAttributeSet();
			StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
			doc.insertString(0, testDude.getName(), center);
			doc.setParagraphAttributes(0, doc.getLength()-1, center, false);
		} catch (Exception ex) { ex.printStackTrace(); }
		title.add(name);
		
		JTextField hp = new JTextField(testDude.getCurrentHP() + "/" + testDude.getMaxHP());
		hp.setFont(new Font("Tahoma", Font.PLAIN, 30));
		hp.setBorder(null);
		hp.setHorizontalAlignment(SwingConstants.CENTER);
		hp.setEditable(false);
		title.add(hp);
		
		/////////////////////////////////////////////////////
		
		JTextField ability = new JTextField(testDude.getAbilityTypes().toString());
		ability.setEditable(false);
		stats.add(ability);
		
		JTextField melee = new JTextField(testDude.getMeleeDamage()+"");
		melee.setEditable(false);
		stats.add(melee);
		
		BufferedImage image;
		try{
		image = ImageIO.read(new File("res/DungeonCommand.jpg"));
		} catch (IOException ex){
			image = null;
			System.err.println("Image failed to load");
		}
		ImageIcon icon = new ImageIcon(image);
		JLabel borderedImage = new JLabel(icon);
		borderedImage.setPreferredSize(new Dimension(100,100));
		stats.add(borderedImage);
		
		/////////////////////////////////////////////////////
		
		JTextPane features = new JTextPane();
		features.setFont(new Font("Tahoma", Font.PLAIN, 17));
		features.setBackground(SystemColor.menu);
		features.setEditable(false);
		details.add(features);
		features.setText(CreatureDatabase.creatureFeatureList.get(0).getName() + ":\n" + CreatureDatabase.creatureFeatureList.get(0).getDescription());
		
		/////////////////////////////////////////////////////
		
		JButton close = new JButton("Back");
		MouseListener listener = new CreatureFrameListener();
		close.addMouseListener(listener);
		
		/////////////////////////////////////////////////////
		
		
		SpringLayout sl_panel = new SpringLayout();
		sl_panel.putConstraint(SpringLayout.NORTH, details, 57, SpringLayout.SOUTH, stats);
		sl_panel.putConstraint(SpringLayout.WEST, details, 0, SpringLayout.WEST, title);
		sl_panel.putConstraint(SpringLayout.SOUTH, details, -6, SpringLayout.NORTH, close);
		sl_panel.putConstraint(SpringLayout.EAST, details, 0, SpringLayout.EAST, title);
		sl_panel.putConstraint(SpringLayout.NORTH, close, 530, SpringLayout.NORTH, panel);
		
		sl_panel.putConstraint(SpringLayout.NORTH, stats, 71, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, stats, 329, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, title, 64, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, close, 0, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, close, 600, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, close, 400, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.NORTH, title, 0, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, title, 0, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, title, 400, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.WEST, stats, 0, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, stats, 400, SpringLayout.WEST, panel);
		
		sl_panel.putConstraint(SpringLayout.NORTH, features, 6, SpringLayout.SOUTH, stats);
		sl_panel.putConstraint(SpringLayout.WEST, features, 0, SpringLayout.WEST, title);
		sl_panel.putConstraint(SpringLayout.SOUTH, features, -6, SpringLayout.NORTH, close);
		sl_panel.putConstraint(SpringLayout.EAST, features, 0, SpringLayout.EAST, title);
		panel.setLayout(sl_panel);
		
		panel.add(title);
		panel.add(stats);
		panel.add(details);
		panel.add(close);
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

// Code below borrowed from http://java-sl.com/tip_center_vertically.html
// Used to center the card name
class MyEditorKit extends StyledEditorKit {
    public ViewFactory getViewFactory() {
        return new StyledViewFactory();
    }
    static class StyledViewFactory implements ViewFactory {
        public View create(Element elem) {
            String kind = elem.getName();
            if (kind != null) {
                if (kind.equals(AbstractDocument.ContentElementName)) {
                    return new LabelView(elem);
                } else if (kind.equals(AbstractDocument.ParagraphElementName)) {
                    return new ParagraphView(elem);
                } else if (kind.equals(AbstractDocument.SectionElementName)) {
                    return new CenteredBoxView(elem, View.Y_AXIS);
                } else if (kind.equals(StyleConstants.ComponentElementName)) {
                    return new ComponentView(elem);
                } else if (kind.equals(StyleConstants.IconElementName)) {
                    return new IconView(elem);
                }
            }
            return new LabelView(elem);
        }
    }
}
 
class CenteredBoxView extends BoxView {
    public CenteredBoxView(Element elem, int axis) {
        super(elem,axis);
    }
    protected void layoutMajorAxis(int targetSpan, int axis, int[] offsets, int[] spans) {
        super.layoutMajorAxis(targetSpan,axis,offsets,spans);
        int textBlockHeight = 0;
        int offset = 0;
 
        for (int i = 0; i < spans.length; i++) {

            textBlockHeight = spans[i];
        }
        offset = (targetSpan - textBlockHeight) / 2;
        for (int i = 0; i < offsets.length; i++) {
            offsets[i] += offset;
        }
    }
}  