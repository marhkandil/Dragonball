package dragonball.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class transition1 extends JLabel {
public transition1(JFrame jf){
	setSize(jf.getWidth(),jf.getHeight());
	URL url1 = this.getClass().getResource("trans2.gif");
	JLabel label=new JLabel("Be Ready for Battle!");
	label.setFont(new Font(Font.DIALOG,Font.BOLD,60));
	add(label);
	label.setBounds(100,100,700,100);
	ImageIcon backIm= new ImageIcon(url1);
	

	JLabel background=new JLabel(backIm);
	
	add(background);
	background.setBounds(0, 0,getWidth(),getHeight());
	ImageIcon backIm1= new ImageIcon(Toolkit.getDefaultToolkit().getImage("blackb.png").getScaledInstance((int)(jf.getWidth()), (int)(jf.getHeight()), java.awt.Image.SCALE_SMOOTH));

	JLabel background1=new JLabel(backIm1);
	
	add(background1);
	background1.setBounds(0, 0,getWidth(),getHeight());
	
}
public static void main(String[] args) {
	JFrame jf=new JFrame();
	jf.setSize(1370, 725);
	jf.add(new transition1(jf));
	jf.setVisible(true);
	jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
}
