package dragonball.view;

import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import dragonball.controller.GameGUI;

public class LostView extends JLabel{
	DragonBallView jf;
	GameGUI listener;
	JButton continueTo;
	public LostView(DragonBallView jf, GameGUI listener){
		this.jf=jf;
		this.listener=listener;
		setSize(jf.getSize());
		ImageIcon playP= new ImageIcon(Toolkit.getDefaultToolkit().getImage("continueAr.png").getScaledInstance((int)(jf.getWidth()*0.12), (int)(jf.getHeight()*0.20), java.awt.Image.SCALE_SMOOTH));
		
		continueTo=new JButton(playP);
		add(continueTo);
		continueTo.setVisible(true);
		//play.setBounds(750, 450,500,300);
		continueTo.setBounds((int)(jf.getWidth()*0.8), (int)(jf.getHeight()*0.5), (int)(jf.getWidth()*0.12), (int)(jf.getHeight()*0.20));
		
		continueTo.setContentAreaFilled(false);
		continueTo.setBorderPainted(false);
		continueTo.addActionListener(listener);
		
		
		
		ImageIcon backIm= new ImageIcon(Toolkit.getDefaultToolkit().getImage("defeat.png").getScaledInstance((int)(jf.getWidth()), (int)(jf.getHeight()), java.awt.Image.SCALE_SMOOTH));
		
		JLabel background=new JLabel(backIm);
		
		add(background);
		background.setBounds(0, 0,getWidth(),getHeight());
		
	}

}
