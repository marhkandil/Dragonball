package dragonball.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import dragonball.controller.GameGUI;
import dragonball.model.attack.SuperAttack;
import dragonball.model.attack.UltimateAttack;
import dragonball.model.character.fighter.Earthling;
import dragonball.model.character.fighter.Frieza;
import dragonball.model.character.fighter.Majin;
import dragonball.model.character.fighter.Namekian;
import dragonball.model.character.fighter.PlayableFighter;
import dragonball.model.character.fighter.Saiyan;
import dragonball.model.player.Player;

public class CustomizeFighter extends JLabel{
	public String name;
	public ArrayList<UltimateAttack> picked;
	public ArrayList<SuperAttack> superAttacks;
	public SuperAttack[] assignedSuper;
	public UltimateAttack[] assignedUltimate;
	public JComboBox choice1,choice2,choice3,choice4,choice5,choice6;
	public ArrayList<JComboBox> choices;
	public JTextArea txt;
	public JButton play;
	public int fighter;
	public char race;
	public GameGUI listener;
	
	public CustomizeFighter(Player p, char race, JFrame jf, GameGUI listener){
		this.listener= listener;
		setSize(jf.getWidth(),jf.getHeight());
		ImageIcon playP= new ImageIcon(Toolkit.getDefaultToolkit().getImage("continue.png").getScaledInstance((int)(jf.getWidth()*0.3), (int)(jf.getHeight()*0.20), java.awt.Image.SCALE_SMOOTH));
		this.race=race;
		int index=0;
		fighter=-1;
		ArrayList<PlayableFighter> fighters=p.getFighters();
		for (int i = 0; i < fighters.size(); i++) {
			if((fighters.get(i) instanceof Majin && race=='M')||(fighters.get(i) instanceof Saiyan && race=='S')||(fighters.get(i) instanceof Frieza && race=='F')||(fighters.get(i) instanceof Namekian && race=='N')||(fighters.get(i) instanceof Earthling && race=='E')){
			fighter=i;
			index=i;
		//	System.out.println("found!");
			break;
			
			}
		}
		choices=new ArrayList<JComboBox>();
		play=new JButton(playP);
		play.addActionListener(listener);
		add(play);
		play.setVisible(true);
		play.setBounds((int)(jf.getWidth()*0.68), (int)(jf.getHeight()*0.65), (int)(jf.getWidth()*0.3), (int)(jf.getHeight()*0.20));
		play.setContentAreaFilled(false);
		play.setBorderPainted(false);
		ArrayList<SuperAttack> SA=new ArrayList<SuperAttack>();
				for(SuperAttack x :p.getSuperAttacks())
					SA.add(x);
		
		SA.add(0,new SuperAttack("No Attack", 0));
		ArrayList<UltimateAttack> UA=new ArrayList<UltimateAttack>();
				for(UltimateAttack x: p.getUltimateAttacks())
					UA.add(x);
		UA.add(0,new UltimateAttack("No Attack", 0));
		assignedSuper=new SuperAttack[SA.size()];
		for (int i = 0; i < assignedSuper.length; i++) {
			assignedSuper[i]=SA.get(i);
		}
		assignedUltimate=new UltimateAttack[UA.size()];
		for (int i = 0; i < assignedUltimate.length; i++) {
			assignedUltimate[i]=UA.get(i);
		}
		choice1=new JComboBox(assignedSuper);
		choice2=new JComboBox(assignedSuper);
		choice3=new JComboBox(assignedSuper);
		choice4=new JComboBox(assignedSuper);
		choice5=new JComboBox(assignedUltimate);
		choice6=new JComboBox(assignedUltimate);
		choices.add(choice1);
		choices.add(choice2);
		choices.add(choice3);
		choices.add(choice4);
		choices.add(choice5);
		choices.add(choice6);
		//	if(fighter instanceof )
		add(choice1);
		choice1.setFont(new Font(Font.MONOSPACED, Font.BOLD, 30));
		choice1.setOpaque(false);
		choice1.setBackground(Color.GRAY);
		choice1.setBounds((int)(jf.getWidth()*0.11), (int)(jf.getHeight()*0.272), (int)(jf.getWidth()*0.547), (int)(jf.getHeight()*0.07));
		add(choice2);
		choice2.setFont(new Font(Font.MONOSPACED, Font.BOLD, 30));
		choice2.setOpaque(false);
		choice2.setBackground(Color.WHITE);
		choice2.setBounds((int)(jf.getWidth()*0.11), (int)(jf.getHeight()*0.368), (int)(jf.getWidth()*0.547), (int)(jf.getHeight()*0.07));
		add(choice3);
		choice3.setFont(new Font(Font.MONOSPACED, Font.BOLD, 30));
		choice3.setOpaque(false);
		choice3.setBackground(Color.WHITE);
		choice3.setBounds((int)(jf.getWidth()*0.11), (int)(jf.getHeight()*0.464), (int)(jf.getWidth()*0.547), (int)(jf.getHeight()*0.07));
		add(choice4);
		choice4.setFont(new Font(Font.MONOSPACED, Font.BOLD, 30));
		choice4.setOpaque(false);
		choice4.setBackground(Color.WHITE);
		choice4.setBounds((int)(jf.getWidth()*0.11), (int)(jf.getHeight()*0.560), (int)(jf.getWidth()*0.547), (int)(jf.getHeight()*0.07));
		add(choice5);
		choice5.setFont(new Font(Font.MONOSPACED, Font.BOLD, 30));
		choice5.setOpaque(false);
		choice5.setBackground(Color.WHITE);
		choice5.setBounds((int)(jf.getWidth()*0.11), (int)(jf.getHeight()*0.656), (int)(jf.getWidth()*0.547), (int)(jf.getHeight()*0.07));
		add(choice6);
		choice6.setFont(new Font(Font.MONOSPACED, Font.BOLD, 30));
		choice6.setOpaque(false);
		choice6.setBackground(Color.WHITE);
		choice6.setBounds((int)(jf.getWidth()*0.11), (int)(jf.getHeight()*0.752), (int)(jf.getWidth()*0.547), (int)(jf.getHeight()*0.07));
		//jf.setVisible(true);
		txt=new JTextArea();
		add(txt);
		txt.setVisible(true);
		
		txt.setBounds((int)(jf.getWidth()*0.500), (int)(jf.getHeight()*0.08), (int)(jf.getWidth()*0.40), (int)(jf.getHeight()*0.06));
		
		txt.setFont(new Font(Font.MONOSPACED, Font.CENTER_BASELINE, 40));
		
		if(fighter!=-1){
		PlayableFighter cur=fighters.get(index);
		ArrayList<SuperAttack> sa=cur.getSuperAttacks();
		ArrayList<UltimateAttack> ua=cur.getUltimateAttacks();
		for (int i = 0; i < sa.size(); i++) {
			//System.out.println(sa.get(i));
			index=SA.indexOf(sa.get(i));
			choices.get(i).setSelectedIndex(index);
		}
		for (int i = 0; i <ua.size(); i++) {
			index=UA.indexOf(ua.get(i));
			choices.get(i+4).setSelectedIndex(index);
		}
		txt.setText(cur.getName());
		
		}
		ImageIcon backG;
		if(race=='M')
			backG= new ImageIcon(Toolkit.getDefaultToolkit().getImage("chooseMajin.png").getScaledInstance((int)(jf.getWidth()), (int)(jf.getHeight()), java.awt.Image.SCALE_SMOOTH));
		else if(race =='S')
			backG= new ImageIcon(Toolkit.getDefaultToolkit().getImage("chooseSaiyan.png").getScaledInstance((int)(jf.getWidth()), (int)(jf.getHeight()), java.awt.Image.SCALE_SMOOTH));
		else if(race =='E')
			backG= new ImageIcon(Toolkit.getDefaultToolkit().getImage("chooseEarthling.png").getScaledInstance((int)(jf.getWidth()), (int)(jf.getHeight()), java.awt.Image.SCALE_SMOOTH));
		else if(race=='N')
			backG= new ImageIcon(Toolkit.getDefaultToolkit().getImage("chooseNamekian.png").getScaledInstance((int)(jf.getWidth()), (int)(jf.getHeight()), java.awt.Image.SCALE_SMOOTH));
		else
			backG= new ImageIcon(Toolkit.getDefaultToolkit().getImage("chooseFrieza.png").getScaledInstance((int)(jf.getWidth()), (int)(jf.getHeight()), java.awt.Image.SCALE_SMOOTH));
	
		JLabel background=new JLabel(backG);
		add(background);
		background.setBounds(0, 0,jf.getWidth(),jf.getHeight());
	//	System.out.println(getWidth()+" "+getHeight());
		
		jf.setVisible(true);
	}
//	public static void main(String[] args) throws IOException {
//		Game g=new Game();
//		g.getPlayer().setName("Mariem");
//		Player mm=g.getPlayer();
//		mm.setSuperAttacks(g.getSuperAttacks());
//		mm.setUltimateAttacks(g.getUltimateAttacks());
//		//JFrame jf=new JFrame();
//		DragonBallView db=new DragonBallView();
//		db.add(new CustomizeFighter(mm, new Earthling("GB"), db));
//	//	jf.setVisible(true);
////		jf.setSize(jf.getMaximumSize());
////		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
////		jf.add(new customizeFighter(mm,new Earthling("Mariem"),jf));
////	
//	}
}
