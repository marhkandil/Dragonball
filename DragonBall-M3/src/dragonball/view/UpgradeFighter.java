package dragonball.view;

import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import dragonball.controller.GameGUI;
import dragonball.model.character.fighter.Fighter;
import dragonball.model.character.fighter.PlayableFighter;

public class UpgradeFighter extends JLabel {
	private JButton healthBar, maxKi,physical,blast,stamina;
	private Fighter f;
	private GameGUI listener;
	
public JButton getHealthBar() {
		return healthBar;
	}
	public void setHealthBar(JButton healthBar) {
		this.healthBar = healthBar;
	}
	public JButton getMaxKi() {
		return maxKi;
	}
	public void setMaxKi(JButton maxKi) {
		this.maxKi = maxKi;
	}
	public JButton getPhysical() {
		return physical;
	}
	public void setPhysical(JButton physical) {
		this.physical = physical;
	}
	public JButton getBlast() {
		return blast;
	}
	public void setBlast(JButton blast) {
		this.blast = blast;
	}
	public JButton getStamina() {
		return stamina;
	}
	public void setStamina(JButton stamina) {
		this.stamina = stamina;
	}
	public Fighter getF() {
		return f;
	}
	public void setF(Fighter f) {
		this.f = f;
	}
public UpgradeFighter(JFrame jf,Fighter f, GameGUI listener){
	this.f=f;
	this.listener=listener;
	setSize(jf.getWidth(),jf.getHeight());
	ImageIcon hb= new ImageIcon(Toolkit.getDefaultToolkit().getImage("healthBar.png").getScaledInstance((int)(jf.getWidth()*0.4), (int)(jf.getHeight()*0.1), java.awt.Image.SCALE_SMOOTH));
	 healthBar=new JButton(hb);
	add(healthBar);
	healthBar.setContentAreaFilled(false);
	//frieza.setBounds(250, 20, 275,270);
	healthBar.setBounds((int)(jf.getWidth()*0.007), (int)(jf.getHeight()*0.075), (int)(jf.getWidth()*0.4), (int)(jf.getHeight()*0.1));
	healthBar.addActionListener(listener);
	JLabel health= new JLabel("Your current max health points: "+f.getMaxHealthPoints()+"");
	add(health);
	health.setBounds((int)(jf.getWidth()*0.007), (int)(jf.getHeight()*0.02), (int)(jf.getWidth()*0.4), (int)(jf.getHeight()*0.1));
	
	
	JLabel ab= new JLabel("Your current ability points: "+((PlayableFighter)(f)).getAbilityPoints()+"");
	add(ab);
	ab.setBounds((int)(jf.getWidth()*0.5), (int)(jf.getHeight()*0.005), (int)(jf.getWidth()*0.4), (int)(jf.getHeight()*0.1));
	
	ImageIcon sb= new ImageIcon(Toolkit.getDefaultToolkit().getImage("staminaBar.png").getScaledInstance((int)(jf.getWidth()*0.4), (int)(jf.getHeight()*0.06), java.awt.Image.SCALE_SMOOTH));
	 stamina=new JButton(sb);
	add(stamina);
	stamina.setContentAreaFilled(false);
	//frieza.setBounds(250, 20, 275,270);
	stamina.setBounds((int)(jf.getWidth()*0.45), (int)(jf.getHeight()*0.8), (int)(jf.getWidth()*0.4), (int)(jf.getHeight()*0.06));
	stamina.addActionListener(listener);
	
	JLabel st= new JLabel("Your current max stamina: "+((PlayableFighter)(f)).getMaxStamina()+"");
	add(st);
	st.setBounds((int)(jf.getWidth()*0.35), (int)(jf.getHeight()*0.85), (int)(jf.getWidth()*0.4), (int)(jf.getHeight()*0.1));
	
	
	ImageIcon ki= new ImageIcon(Toolkit.getDefaultToolkit().getImage("kiUpgra.png").getScaledInstance((int)(jf.getWidth()*0.3), (int)(jf.getHeight()*0.2), java.awt.Image.SCALE_SMOOTH));
	 maxKi=new JButton(ki);
	add(maxKi);
	maxKi.setContentAreaFilled(false);
	//frieza.setBounds(250, 20, 275,270);
	maxKi.setBounds((int)(jf.getWidth()*0.05), (int)(jf.getHeight()*0.2), (int)(jf.getWidth()*0.3), (int)(jf.getHeight()*0.2));
	maxKi.addActionListener(listener);

	JLabel mx= new JLabel("Your current max Ki: "+((PlayableFighter)(f)).getMaxKi()+"");
	add(mx);
	mx.setBounds((int)(jf.getWidth()*0.4), (int)(jf.getHeight()*0.3), (int)(jf.getWidth()*0.4), (int)(jf.getHeight()*0.1));
	
	ImageIcon pa= new ImageIcon(Toolkit.getDefaultToolkit().getImage("physicalUp.jpg").getScaledInstance((int)(jf.getWidth()*0.2), (int)(jf.getHeight()*0.25), java.awt.Image.SCALE_SMOOTH));
	 physical=new JButton(pa);
	add(physical);
	physical.setContentAreaFilled(false);
	//frieza.setBounds(250, 20, 275,270);
	physical.setBounds((int)(jf.getWidth()*0.085), (int)(jf.getHeight()*0.67), (int)(jf.getWidth()*0.2), (int)(jf.getHeight()*0.25));
	physical.addActionListener(listener);
	
	JLabel pd= new JLabel("Your current physical damage: "+((PlayableFighter)(f)).getPhysicalDamage()+"");
	add(pd);
	pd.setBounds((int)(jf.getWidth()*0.4), (int)(jf.getHeight()*0.7), (int)(jf.getWidth()*0.4), (int)(jf.getHeight()*0.1));
	
	
	ImageIcon bd= new ImageIcon(Toolkit.getDefaultToolkit().getImage("blastDamage.jpg").getScaledInstance((int)(jf.getWidth()*0.2), (int)(jf.getHeight()*0.25), java.awt.Image.SCALE_SMOOTH));
	 blast=new JButton(bd);
	add(blast);
	blast.setContentAreaFilled(false);
	//frieza.setBounds(250, 20, 275,270);
	blast.setBounds((int)(jf.getWidth()*0.085), (int)(jf.getHeight()*0.41), (int)(jf.getWidth()*0.2), (int)(jf.getHeight()*0.25));
	blast.addActionListener(listener);
	
	JLabel bdam= new JLabel("Your current blast damage: "+((PlayableFighter)(f)).getBlastDamage()+"");
	add(bdam);
	bdam.setBounds((int)(jf.getWidth()*0.4), (int)(jf.getHeight()*0.5), (int)(jf.getWidth()*0.4), (int)(jf.getHeight()*0.1));
	
	ImageIcon backIm= new ImageIcon(Toolkit.getDefaultToolkit().getImage("upgrade.png").getScaledInstance((int)(jf.getWidth()), (int)(jf.getHeight()), java.awt.Image.SCALE_SMOOTH));
	JLabel background1=new JLabel(backIm);
	add(background1);
	background1.setBounds(0, 0,getWidth(),getHeight());
	jf.setVisible(true);
}


}
