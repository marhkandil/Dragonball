package dragonball.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class chooseFighter2 extends JLabel{
	ArrayList<JButton> original;
	ArrayList<ImageIcon>pressed,origin;
	DragonBallView listener;
	JTextArea txt;
	JButton play;
	boolean chosen;
	int chosenFighter;
	public int getChosenFighter() {
		return chosenFighter;
	}
	public void setChosenFighter(int chosenFighter) {
		this.chosenFighter = chosenFighter;
	}
	public chooseFighter2(JFrame jf){
		setSize(jf.getWidth(),jf.getHeight());
		ImageIcon freizBut= new ImageIcon(Toolkit.getDefaultToolkit().getImage("frieza.png").getScaledInstance((int)(jf.getWidth()*0.2), (int)(jf.getHeight()*0.37), java.awt.Image.SCALE_SMOOTH));
		
		JButton frieza=new JButton(freizBut);
		original=new ArrayList<JButton>();
		pressed=new ArrayList<ImageIcon>();
		origin=new ArrayList<ImageIcon>();
		add(frieza);
		//frieza.setBounds(250, 20, 275,270);
		frieza.setBounds((int)(jf.getWidth()*0.182), (int)(jf.getHeight()*0.0276), (int)(jf.getWidth()*0.2), (int)(jf.getHeight()*0.37));
		
		frieza.setContentAreaFilled(false);
		frieza.setBorderPainted(false);
		ImageIcon earthBut= new ImageIcon(Toolkit.getDefaultToolkit().getImage("earthling.png").getScaledInstance((int)(jf.getWidth()*0.2), (int)(jf.getHeight()*0.37), java.awt.Image.SCALE_SMOOTH));
		
		JButton earthling=new JButton(earthBut);
		add(earthling);
		//earthling.setBounds(420, 400, 275,270);
		earthling.setBounds((int)(jf.getWidth()*0.307), (int)(jf.getHeight()*0.551), (int)(jf.getWidth()*0.2), (int)(jf.getHeight()*0.37));
		
		earthling.setContentAreaFilled(false);
		earthling.setBorderPainted(false);

		ImageIcon saiBut= new ImageIcon(Toolkit.getDefaultToolkit().getImage("supersaiyan.png").getScaledInstance((int)(jf.getWidth()*0.2), (int)(jf.getHeight()*0.37), java.awt.Image.SCALE_SMOOTH));
		
		JButton saiyan=new JButton(saiBut);
		add(saiyan);
		//saiyan.setBounds(50, 150, 275,270);
		saiyan.setBounds((int)(jf.getWidth()*0.036), (int)(jf.getHeight()*0.207), (int)(jf.getWidth()*0.2), (int)(jf.getHeight()*0.37));
		saiyan.setContentAreaFilled(false);
		saiyan.setBorderPainted(false);

		
		ImageIcon majinBut= new ImageIcon(Toolkit.getDefaultToolkit().getImage("majin.png").getScaledInstance((int)(jf.getWidth()*0.2), (int)(jf.getHeight()*0.37), java.awt.Image.SCALE_SMOOTH));
		
		JButton majin=new JButton(majinBut);
		add(majin);
		//majin.setBounds(450, 150, 275,270);
		majin.setBounds((int)(jf.getWidth()*0.33), (int)(jf.getHeight()*0.206), (int)(jf.getWidth()*0.2), (int)(jf.getHeight()*0.37));
		
		majin.setContentAreaFilled(false);
		majin.setBorderPainted(false);

		ImageIcon nameBut= new ImageIcon(Toolkit.getDefaultToolkit().getImage("namekian.png").getScaledInstance((int)(jf.getWidth()*0.2), (int)(jf.getHeight()*0.37), java.awt.Image.SCALE_SMOOTH));
		
		JButton namekian=new JButton(nameBut);
		add(namekian);
		//namekian.setBounds(100, 400, 275,270);
		namekian.setBounds((int)(jf.getWidth()*0.073), (int)(jf.getHeight()*0.551), (int)(jf.getWidth()*0.2), (int)(jf.getHeight()*0.37));
		
		namekian.setContentAreaFilled(false);
		namekian.setBorderPainted(false);
		
		//name.setContentAreaFilled(false);
		//name.setBorderPainted(false);
		ImageIcon pickF= new ImageIcon(Toolkit.getDefaultToolkit().getImage("pick2.png").getScaledInstance((int)(jf.getWidth()*0.600), (int)(jf.getHeight()*0.3449), java.awt.Image.SCALE_SMOOTH));
		
		JLabel pick=new JLabel(pickF);
		add(pick);
//		pick.setBounds(490, 50, 950,250);
		pick.setBounds((int)(jf.getWidth()*0.410), (int)(jf.getHeight()*0.0689), (int)(jf.getWidth()*0.600), (int)(jf.getHeight()*0.3449));
		
		//pick.setContentAreaFilled(false);
	//	pick.setBorderPainted(false);
		ImageIcon backIm= new ImageIcon(Toolkit.getDefaultToolkit().getImage("Namek.jpg").getScaledInstance((int)(jf.getWidth()), (int)(jf.getHeight()), java.awt.Image.SCALE_SMOOTH));
		
		JLabel background=new JLabel(backIm);
		
		original.add(earthling);
		original.add(majin);
		original.add(frieza);
		original.add(saiyan);
		original.add(namekian);
	
		ImageIcon pressedmajin= new ImageIcon(Toolkit.getDefaultToolkit().getImage("pressedMajin.png").getScaledInstance((int)(jf.getWidth()*0.2), (int)(jf.getHeight()*0.37), java.awt.Image.SCALE_SMOOTH));
		ImageIcon pressedEarthling= new ImageIcon(Toolkit.getDefaultToolkit().getImage("pressedEarthling.png").getScaledInstance((int)(jf.getWidth()*0.2), (int)(jf.getHeight()*0.37), java.awt.Image.SCALE_SMOOTH));
		ImageIcon pressedFrieza= new ImageIcon(Toolkit.getDefaultToolkit().getImage("pressedFrieza.png").getScaledInstance((int)(jf.getWidth()*0.2), (int)(jf.getHeight()*0.37), java.awt.Image.SCALE_SMOOTH));
		ImageIcon pressedsuper= new ImageIcon(Toolkit.getDefaultToolkit().getImage("pressedsai.png").getScaledInstance((int)(jf.getWidth()*0.2), (int)(jf.getHeight()*0.37), java.awt.Image.SCALE_SMOOTH));
		ImageIcon pressedNameK= new ImageIcon(Toolkit.getDefaultToolkit().getImage("pressedNameK.png").getScaledInstance((int)(jf.getWidth()*0.2), (int)(jf.getHeight()*0.37), java.awt.Image.SCALE_SMOOTH));
		
		pressed.add(pressedEarthling);
		pressed.add(pressedmajin);
		pressed.add(pressedFrieza);
		pressed.add(pressedsuper);
		pressed.add(pressedNameK);
		
		origin.add(earthBut);
		origin.add(majinBut);
		origin.add(freizBut);
		origin.add(saiBut);
		origin.add(nameBut);
		ImageIcon playP= new ImageIcon(Toolkit.getDefaultToolkit().getImage("play.png").getScaledInstance((int)(jf.getWidth()*0.10), (int)(jf.getHeight()*0.20), java.awt.Image.SCALE_SMOOTH));
		
		play=new JButton(playP);
		add(play);
		play.setVisible(true);
		//play.setBounds(750, 450,500,300);
		play.setBounds((int)(jf.getWidth()*0.67), (int)(jf.getHeight()*0.65), (int)(jf.getWidth()*0.1), (int)(jf.getHeight()*0.20));
		
		play.setContentAreaFilled(false);
		play.setBorderPainted(false);
		
		add(background);
		background.setBounds(0, 0,getWidth(),getHeight());
		
	}
	public ArrayList<JButton> getOriginal() {
		return original;
	}
	public void setOriginal(ArrayList<JButton> original) {
		this.original = original;
	}
	public ArrayList<ImageIcon> getPressed() {
		return pressed;
	}
	public void setPressed(ArrayList<ImageIcon> pressed) {
		this.pressed = pressed;
	}
	public ArrayList<ImageIcon> getOrigin() {
		return origin;
	}
	public void setOrigin(ArrayList<ImageIcon> origin) {
		this.origin = origin;
	}
	public DragonBallView getListener() {
		return listener;
	}
	public void setListener(DragonBallView listener) {
		this.listener = listener;
	}
	public JTextArea getTxt() {
		return txt;
	}
	public void setTxt(JTextArea txt) {
		this.txt = txt;
	}
	public JButton getPlay() {
		return play;
	}
	public void setPlay(JButton play) {
		this.play = play;
	}
	public boolean isChosen() {
		return chosen;
	}
	public void setChosen(boolean chosen) {
		this.chosen = chosen;
	}
	public static void main(String[] args) {
		JFrame jf=new JFrame();
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.add(new chooseFighter(jf));
	}

}

