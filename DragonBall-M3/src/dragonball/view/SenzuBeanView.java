package dragonball.view;

import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import dragonball.controller.GameGUI;

public class SenzuBeanView extends JLabel{
	
	GameGUI listener;
	DragonBallView jf;
	public SenzuBeanView (GameGUI listener,DragonBallView jf){
		this.listener= listener;
		this.jf=jf;
		setSize(jf.getSize());
		ImageIcon senzu= new ImageIcon(Toolkit.getDefaultToolkit().getImage("SenzuBean.jpg.png").getScaledInstance((int)(getWidth()), (int)(jf.getHeight()), java.awt.Image.SCALE_SMOOTH));
		ImageIcon cont= new ImageIcon(Toolkit.getDefaultToolkit().getImage("back2.png").getScaledInstance((int)(jf.getWidth()*0.2), (int)(jf.getHeight()*0.15), java.awt.Image.SCALE_SMOOTH));
		JButton button= new JButton(cont);
		button.setBounds((int)(getWidth()*0.12), ((int)(getHeight()*0.6)), (int)(jf.getWidth()*0.2), (int)(jf.getHeight()*0.15));
		add(button);
		button.setContentAreaFilled(false);
		button.setBorderPainted(false);
		button.addActionListener(listener);
		JLabel background1= new JLabel(senzu);
		add(background1);
		background1.setBounds(0,0,getWidth(),getHeight());
		ImageIcon calm= new ImageIcon(Toolkit.getDefaultToolkit().getImage("SenzuBean.jpg.png").getScaledInstance(getWidth(), getHeight(), java.awt.Image.SCALE_SMOOTH));
		JLabel background2= new JLabel(calm);
		add(background2);
		background2.setBounds(0,0,getWidth(),getHeight());
	}

}
