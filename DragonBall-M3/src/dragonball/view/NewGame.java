package dragonball.view;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Window;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class NewGame extends JLabel{
	 private DragonBallView jf;
	 boolean saved;
	 private JButton newgame,loadgame;
	public JButton getNewgame() {
		return newgame;
	}

	public void setNewgame(JButton newgame) {
		this.newgame = newgame;
	}

	public JButton getLoadgame() {
		return loadgame;
	}

	public void setLoadgame(JButton loadgame) {
		this.loadgame = loadgame;
	}

	public NewGame(JFrame jf,boolean saved){
		//this.jf=(DragonBallView) jf;
		//super(new ImageIcon("background.jpg"));
	//	System.out.println(jf.getWidth()+" "+jf.getHeight());
		this.saved=saved;
		setSize(jf.getWidth(),jf.getHeight());
		Image n= Toolkit.getDefaultToolkit().getImage("testback.jpg").getScaledInstance(getWidth(), getHeight(), java.awt.Image.SCALE_SMOOTH);
		ImageIcon t= new ImageIcon(n); 
		ImageIcon newgameim= new ImageIcon(Toolkit.getDefaultToolkit().getImage("Picture1.png").getScaledInstance((int)(jf.getWidth()*0.31), (int)(jf.getHeight()*0.12), java.awt.Image.SCALE_SMOOTH));
		ImageIcon loadgameim= new ImageIcon(Toolkit.getDefaultToolkit().getImage("load.png").getScaledInstance((int)(jf.getWidth()*0.31), (int)(jf.getHeight()*0.12), java.awt.Image.SCALE_SMOOTH));
		
		newgame=new JButton(newgameim);
		loadgame=new JButton(loadgameim);
		add(newgame);
		add(loadgame);
		newgame.setBounds((int)(jf.getWidth()*0.15), (int)(jf.getHeight()*0.4), (int)(jf.getWidth()*0.3), (int)(jf.getHeight()*0.09));
		//newgame.setBounds(180, 300, 490, 85);
		
		loadgame.setBounds((int)(jf.getWidth()*0.15), (int)(jf.getHeight()*0.51), (int)(jf.getWidth()*0.3), (int)(jf.getHeight()*0.09));
		JLabel background= new JLabel(t);
		add(background);
		//System.out.println(this.getWidth());
		background.setBounds(0,0,getWidth(),getHeight());
		
	}
	
	public DragonBallView getJf() {
		return jf;
	}

	public void setJf(DragonBallView jf) {
		this.jf = jf;
	}

	public boolean isSaved() {
		return saved;
	}

	public void setSaved(boolean saved) {
		this.saved = saved;
	}

	public static void main(String[] args) {
		JFrame jf=new JFrame();
		jf.setSize(1370, 725);
		//setDefaultCloseOperation(EXIT_ON_CLOSE);
		//setLayout(null); for some reason!!! not working
		//jf.setTitle("DragonBall");
		 Image icon = Toolkit.getDefaultToolkit().getImage("images.png");
		jf.setIconImage(icon);
		//jf.setVisible(true);
	NewGame ng=new NewGame(jf,true);
		//System.out.println(jf.getMaximumSize());
		jf.setVisible(true);
	jf.add(ng);
	}
	
}