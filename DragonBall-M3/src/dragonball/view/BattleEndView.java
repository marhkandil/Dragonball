package dragonball.view;

import java.awt.Font;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import dragonball.controller.GameGUI;
import dragonball.model.attack.SuperAttack;
import dragonball.model.attack.UltimateAttack;
import dragonball.model.character.fighter.NonPlayableFighter;
import dragonball.model.game.Game;

public class BattleEndView extends JLabel{
	GameGUI listener;
	DragonBallView view;
	Game game;
	public BattleEndView(GameGUI listener,DragonBallView view, Game game, boolean boss, NonPlayableFighter foe,boolean levelup){
		this.setSize(view.getSize());
		this.listener=listener;
		this.view=view;
		this.game=game;
		JLabel win;
		if(boss)
			win= new JLabel("Congratulations on defeating the BOSS!");
		else
			win= new JLabel("Congratulations on defeating the foe");
		
		add(win);
		win.setBounds((int)(getWidth()*0.4), (int)(getHeight()*0.01), (int) (getWidth()*0.2), (int)(getHeight()*0.1));
		 win.setFont(new Font(Font.MONOSPACED,Font.BOLD,45));
			
		
		ImageIcon playP= new ImageIcon(Toolkit.getDefaultToolkit().getImage("continueAr.png").getScaledInstance((int)(getWidth()*0.12), (int)(getHeight()*0.20), java.awt.Image.SCALE_SMOOTH));
		JButton continueTo=new JButton(playP);
		add(continueTo);
		continueTo.setVisible(true);
		//play.setBounds(750, 450,500,300);
		continueTo.setBounds((int)(getWidth()*0.8), (int)(getHeight()*0.5), (int)(getWidth()*0.12), (int)(getHeight()*0.20));
		
		continueTo.setContentAreaFilled(false);
		continueTo.setBorderPainted(false);
		continueTo.addActionListener(listener);
		addInfo(foe,levelup);
	}
	
	public void addInfo(NonPlayableFighter foe,boolean levelup){
		
		JLabel xp= new JLabel("Your XP is now: "+ game.getPlayer().getActiveFighter().getXp());
		add(xp);
		xp.setBounds((int)(getWidth()*0.1), (int)(getHeight()*0.08), (int) (getWidth()*0.9), (int)(getHeight()*0.1));
		 xp.setFont(new Font(Font.MONOSPACED,Font.BOLD,45));
			
		ArrayList<SuperAttack> sa= foe.getSuperAttacks();
		ArrayList<UltimateAttack> ua= foe.getUltimateAttacks();
		JLabel supatt= new JLabel("Gained super attacks:");
		add(supatt);
		supatt.setBounds((int)(getWidth()*0.1), (int)(getHeight()*0.13), (int) (getWidth()*0.9), (int)(getHeight()*0.1));
		 supatt.setFont(new Font(Font.MONOSPACED,Font.BOLD,45));
			
		double lasth= 0.13;
		for(SuperAttack x:sa){
			JLabel y= new JLabel(x.toString());
			lasth+=0.05;
			add(y);
			y.setBounds((int)(getWidth()*0.1), (int)(getHeight()*lasth), (int) (getWidth()*0.9), (int)(getHeight()*0.1));
			 y.setFont(new Font(Font.MONOSPACED,Font.BOLD,45));
				}
		JLabel ultatt= new JLabel("Gained ultimate attacks:");
		add(ultatt);
		lasth+=0.05;
		ultatt.setBounds((int)(getWidth()*0.1), (int)(getHeight()*lasth), (int) (getWidth()*0.9), (int)(getHeight()*0.1));
		 ultatt.setFont(new Font(Font.MONOSPACED,Font.BOLD,45));
			
		for(UltimateAttack x:ua){
			JLabel y= new JLabel(x.toString());
			lasth+=0.05;
			add(y);
			y.setBounds((int)(getWidth()*0.1), (int)(getHeight()*lasth), (int) (getWidth()*0.9), (int)(getHeight()*0.1));
			 y.setFont(new Font(Font.MONOSPACED,Font.BOLD,45));
				
		}
		
		if(levelup){
		JLabel cong= new JLabel("You leveled up! :D ");
			 
		add(cong);
		cong.setFont(new Font(Font.MONOSPACED,Font.BOLD,45));
		lasth+=0.05;
		cong.setBounds((int)(getWidth()*0.1), (int)(getHeight()*lasth), (int) (getWidth()*0.9), (int)(getHeight()*0.1));
		JLabel level= new JLabel("Your Level is now: "+ game.getPlayer().getActiveFighter().getLevel());
		lasth+=0.05;
		level.setBounds((int)(getWidth()*0.1), (int)(getHeight()*lasth), (int) (getWidth()*0.9), (int)(getHeight()*0.1));
		 level.setFont(new Font(Font.MONOSPACED,Font.BOLD,45));
			
		JLabel targetxp= new JLabel("Your target XP is now: "+ game.getPlayer().getActiveFighter().getTargetXp());
		lasth+=0.05;
		targetxp.setBounds((int)(getWidth()*0.1), (int)(getHeight()*lasth), (int) (getWidth()*0.9), (int)(getHeight()*0.1));
		 targetxp.setFont(new Font(Font.MONOSPACED,Font.BOLD,45));
			
		
		JLabel abpoint= new JLabel("Your ability points is now: "+ game.getPlayer().getActiveFighter().getAbilityPoints());
		lasth+=0.05;
		abpoint.setBounds((int)(getWidth()*0.1), (int)(getHeight()*lasth), (int) (getWidth()*0.9), (int)(getHeight()*0.1));
		 abpoint.setFont(new Font(Font.MONOSPACED,Font.BOLD,45));
			 
		ImageIcon backG= new ImageIcon(Toolkit.getDefaultToolkit().getImage("winning.jpg").getScaledInstance((int)(view.getWidth()), (int)(view.getHeight()), java.awt.Image.SCALE_SMOOTH));
		 JLabel background=new JLabel(backG);
		 add(background);
		 background.setBounds(0, 0,getWidth(),getHeight());

		}
		
	}
	

}
