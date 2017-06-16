package dragonball.view;

import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import dragonball.controller.GameGUI;
import dragonball.model.dragon.Dragon;

public class sevenDragon extends JLabel {
	JButton continueTo;
	GameGUI listener;
	Dragon dragon;
	public sevenDragon(JFrame jf, GameGUI listener,Dragon dragon){
		
		this.dragon=dragon;
		setSize(jf.getWidth(),jf.getHeight());
		this.listener=listener;
		ImageIcon playP= new ImageIcon(Toolkit.getDefaultToolkit().getImage("continueAr.png").getScaledInstance((int)(jf.getWidth()*0.10), (int)(jf.getHeight()*0.20), java.awt.Image.SCALE_SMOOTH));
		
		continueTo=new JButton(playP);
		add(continueTo);
		continueTo.setVisible(true);
		//play.setBounds(750, 450,500,300);
		continueTo.setBounds((int)(jf.getWidth()*0.67), (int)(jf.getHeight()*0.65), (int)(jf.getWidth()*0.1), (int)(jf.getHeight()*0.20));
		
		continueTo.setContentAreaFilled(false);
		continueTo.setBorderPainted(false);
		continueTo.addActionListener(listener);
		
		
		
		ImageIcon backIm= new ImageIcon(Toolkit.getDefaultToolkit().getImage("collected.png").getScaledInstance((int)(jf.getWidth()), (int)(jf.getHeight()), java.awt.Image.SCALE_SMOOTH));
		
		JLabel background=new JLabel(backIm);
		
		add(background);
		background.setBounds(0, 0,getWidth(),getHeight());
	}
	public JButton getContinueTo() {
		return continueTo;
	}
	public void setContinueTo(JButton continueTo) {
		this.continueTo = continueTo;
	}
	public GameGUI getListener() {
		return listener;
	}
	public void setListener(GameGUI listener) {
		this.listener = listener;
	}
	public Dragon getDragon() {
		return dragon;
	}
	public void setDragon(Dragon dragon) {
		this.dragon = dragon;
	}
	
}
