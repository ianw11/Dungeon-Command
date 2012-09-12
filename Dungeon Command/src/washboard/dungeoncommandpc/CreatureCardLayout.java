package washboard.dungeoncommandpc;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
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


// This file is going to be ugly as it was created in Window Builder, and programs like that don't tidy code up
//setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
//FOR TESTING. PICKS A RANDOM UNIT
public class CreatureCardLayout extends JDialog {
	
	// This file is going to be ugly as it was created in Window Builder, and programs like that don't tidy code up
	
	public CreatureCardLayout() {
		//setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		setBackground(Color.DARK_GRAY);
		
		setPreferredSize(new Dimension(400, 500));
		
		JPanel title = new JPanel();
		title.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		title.setLayout(new GridLayout(0, 3, 0, 0));
		
		JPanel details = new JPanel(new BorderLayout());
		details.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		//FOR TESTING. PICKS A RANDOM UNIT
		Random generator = new Random();
		Creature testDude = CreatureDatabase.creatures.get(generator.nextInt(CreatureDatabase.creatures.size()));
		int featRandom = generator.nextInt(CreatureDatabase.creatureFeatureList.size());
		
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
		
		JTextField ranged = new JTextField();
		ranged.setEditable(false);
		JTextField hp = new JTextField(testDude.getCurrentHP() + "/" + testDude.getMaxHP());
		hp.setFont(new Font("Tahoma", Font.PLAIN, 30));
		hp.setBorder(null);
		hp.setHorizontalAlignment(SwingConstants.CENTER);
		hp.setEditable(false);
		title.add(hp);
		String words = testDude.getAbilityTypes()[0];
		for(int i = 1; i<testDude.getAbilityTypes().length; i++)
			words = words.concat("; " + testDude.getAbilityTypes()[i]);
		if(testDude.hasRangedAttack()) {
			ranged.setText(testDude.getRangedDamage() + " DMG (" + testDude.getRangedDistance() + " DIST)");
		} else { ranged.setVisible(false); }
		
		BufferedImage image;
		try{
		image = ImageIO.read(new File(testDude.getImageString()));
		} catch (IOException ex){
			image = null;
			System.err.println("Image failed to load");
		}
		ImageIcon icon = new ImageIcon(image);
		
		/////////////////////////////////////////////////////
		
		JTextPane features = new JTextPane();
		features.setFont(new Font("Tahoma", Font.PLAIN, 17));
		features.setBackground(SystemColor.menu);
		features.setEditable(false);
		details.add(features);
		features.setText(CreatureDatabase.creatureFeatureList.get(featRandom).getName() + ":\n" + CreatureDatabase.creatureFeatureList.get(featRandom).getDescription());
		
		JLabel speedLabel = new JLabel("SPEED: " + testDude.getMovementSpeed());
		speedLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		speedLabel.setHorizontalAlignment(SwingConstants.CENTER);
		speedLabel.setHorizontalTextPosition(SwingConstants.LEADING);
		details.add(speedLabel, BorderLayout.SOUTH);
		
		
		/////////////////////////////////////////////////////
		
		JButton close = new JButton("Back");
		close.setAutoscrolls(true);
		close.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		/////////////////////////////////////////////////////
		
		
		SpringLayout sl_panel = new SpringLayout();
		sl_panel.putConstraint(SpringLayout.SOUTH, details, -6, SpringLayout.NORTH, close);
		sl_panel.putConstraint(SpringLayout.WEST, title, 10, SpringLayout.WEST, this);
		sl_panel.putConstraint(SpringLayout.EAST, title, -10, SpringLayout.EAST, this);
		sl_panel.putConstraint(SpringLayout.WEST, ranged, 10, SpringLayout.WEST, this);
		sl_panel.putConstraint(SpringLayout.NORTH, details, 292, SpringLayout.NORTH, this);
		sl_panel.putConstraint(SpringLayout.NORTH, close, 455, SpringLayout.NORTH, this);
		sl_panel.putConstraint(SpringLayout.WEST, close, 10, SpringLayout.WEST, this);
		sl_panel.putConstraint(SpringLayout.SOUTH, close, -3, SpringLayout.SOUTH, this);
		sl_panel.putConstraint(SpringLayout.EAST, close, -10, SpringLayout.EAST, this);
		sl_panel.putConstraint(SpringLayout.WEST, details, 0, SpringLayout.WEST, close);
		sl_panel.putConstraint(SpringLayout.EAST, details, -10, SpringLayout.EAST, this);
		sl_panel.putConstraint(SpringLayout.NORTH, title, 16, SpringLayout.NORTH, this);
		sl_panel.putConstraint(SpringLayout.SOUTH, title, 80, SpringLayout.NORTH, this);
		sl_panel.putConstraint(SpringLayout.WEST, features, 0, SpringLayout.WEST, title);
		sl_panel.putConstraint(SpringLayout.SOUTH, features, -6, SpringLayout.NORTH, close);
		sl_panel.putConstraint(SpringLayout.EAST, features, 0, SpringLayout.EAST, title);
		getContentPane().setLayout(sl_panel);
		
		getContentPane().add(title);
		getContentPane().add(details);
		getContentPane().add(close);
		JLabel borderedImage = new JLabel(icon);
		sl_panel.putConstraint(SpringLayout.NORTH, borderedImage, 2, SpringLayout.SOUTH, title);
		sl_panel.putConstraint(SpringLayout.SOUTH, borderedImage, -10, SpringLayout.NORTH, details);
		sl_panel.putConstraint(SpringLayout.EAST, ranged, -6, SpringLayout.WEST, borderedImage);
		sl_panel.putConstraint(SpringLayout.WEST, borderedImage, 190, SpringLayout.WEST, this);
		sl_panel.putConstraint(SpringLayout.EAST, borderedImage, -10, SpringLayout.EAST, this);
		borderedImage.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		
		getContentPane().add(borderedImage);
		borderedImage.setAlignmentX(Component.CENTER_ALIGNMENT);
		borderedImage.setPreferredSize(new Dimension(100,100));
		
		/////////////////////////////////////////////////////
		
		JTextField ability = new JTextField();
		sl_panel.putConstraint(SpringLayout.NORTH, ability, 2, SpringLayout.SOUTH, title);
		sl_panel.putConstraint(SpringLayout.WEST, ability, 10, SpringLayout.WEST, this);
		sl_panel.putConstraint(SpringLayout.EAST, ability, -6, SpringLayout.WEST, borderedImage);
		ability.setFont(new Font("Tahoma", Font.PLAIN, 20));
		getContentPane().add(ability);
		ability.setHorizontalAlignment(SwingConstants.CENTER);
		ability.setText(words);
		ability.setEditable(false);
		
		JTextField melee = new JTextField(testDude.getMeleeDamage()+" DMG");
		sl_panel.putConstraint(SpringLayout.NORTH, melee, 4, SpringLayout.SOUTH, ability);
		sl_panel.putConstraint(SpringLayout.WEST, melee, 10, SpringLayout.WEST, this);
		sl_panel.putConstraint(SpringLayout.EAST, melee, -6, SpringLayout.WEST, borderedImage);
		sl_panel.putConstraint(SpringLayout.NORTH, ranged, 4, SpringLayout.SOUTH, melee);
		melee.setFont(new Font("Tahoma", Font.PLAIN, 20));
		getContentPane().add(melee);
		melee.setHorizontalAlignment(SwingConstants.CENTER);
		melee.setEditable(false);
		
		
		
		ranged.setFont(new Font("Tahoma", Font.PLAIN, 20));
		getContentPane().add(ranged);
		ranged.setHorizontalAlignment(SwingConstants.CENTER);
		
		
		
		setVisible(true);
	}//End Constructor
}//End Class

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
