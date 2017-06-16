package dragonball.view;

import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import dragonball.controller.GameGUI;

public class DragonBallFound extends JLabel{
	
	GameGUI listener;
	DragonBallView jf;
	
	public DragonBallFound(GameGUI listener, DragonBallView jf){
		this.listener=listener;
		this.jf= jf;
		setSize(jf.getSize());
		ImageIcon balls= new ImageIcon(Toolkit.getDefaultToolkit().getImage("dragonballF.png").getScaledInstance((int)(getWidth()), (int)(getHeight()), java.awt.Image.SCALE_SMOOTH));
		JLabel dragonball= new JLabel (balls);
		//dragonball.setContentAreaFilled(false);
		//dragonball.setBorderPainted(false);
		//dragonball.setBounds((int)(jf.getWidth()), (int)(jf.getHeight()*0.16),(int)(getWidth()), (int)(getHeight()));
		
		ImageIcon cont= new ImageIcon(Toolkit.getDefaultToolkit().getImage("back.png").getScaledInstance((int)(jf.getWidth()*0.2), (int)(jf.getHeight()*0.2), java.awt.Image.SCALE_SMOOTH));
		JButton button= new JButton(cont);
		button.setBounds((int)(getWidth()*0.12), ((int)(getHeight()*0.6)), (int)(jf.getWidth()*0.2), (int)(jf.getHeight()*0.2));
		add(button);
		button.setContentAreaFilled(false);
		button.setBorderPainted(false);
		button.addActionListener(listener);
		
		
		
		
		add(dragonball);
		dragonball.setBounds(0,0,getWidth(),getHeight());
		jf.setVisible(true);
	}

}
