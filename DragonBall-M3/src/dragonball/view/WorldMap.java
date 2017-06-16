package dragonball.view;

import java.awt.Font;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import dragonball.controller.GameGUI;
import dragonball.model.character.fighter.Earthling;
import dragonball.model.character.fighter.Frieza;
import dragonball.model.character.fighter.Majin;
import dragonball.model.character.fighter.PlayableFighter;
import dragonball.model.character.fighter.Saiyan;
import dragonball.model.player.Player;

public class WorldMap extends JLabel{
	JButton buttons [][]= new JButton [10][10];
	DragonBallView jf;
	Player player;
	ArrayList<JButton> fighters;
	JButton update;
	JButton customize;
	JLabel actFight;
	JButton ch;
	JButton save;
	int width;
	int height;
	GameGUI listener;
	public JButton getCh() {
		return ch;
	}
	public void setCh(JButton ch) {
		this.ch = ch;
	}
	public JButton getSave() {
		return save;
	}
	public void setSave(JButton save) {
		this.save = save;
	}
	public WorldMap(DragonBallView jf,Player player,GameGUI listener){
		this.jf=jf;
		this.listener=listener;
		width= jf.getWidth();
		height= jf.getHeight();
		this.player=player;
		fighters= new ArrayList<JButton>(); 
		createMap();
		ImageIcon sav= new ImageIcon(Toolkit.getDefaultToolkit().getImage("saveButton.png").getScaledInstance((int)(width*0.08), (int)(height*0.05), java.awt.Image.SCALE_SMOOTH));
		save= new JButton(sav);
		add(save);
		save.setBounds((int)(width*0.9), (int)(height*0.02), (int)(width*0.08), (int)(height*0.05));
		save.addActionListener(listener);
		addPlayerInfo();
		addFirstTimeChar();
		addActiveFighter(false);
		int r= listener.getGame().getWorld().getPlayerRow();
		int c= listener.getGame().getWorld().getPlayerColumn();
		addCharacter(9,9,r,c);
		ImageIcon back= new ImageIcon(Toolkit.getDefaultToolkit().getImage("sea.jpg").getScaledInstance(jf.getWidth(),jf.getHeight(), java.awt.Image.SCALE_SMOOTH));
		JLabel background= new JLabel(back);
		add(background);
		background.setBounds(0,0,getWidth(),getHeight());
		
	}
	public void addActiveFighter(boolean check){
		//System.out.println("hey");
		PlayableFighter pf= player.getActiveFighter();
//		if(actFight!=null)
//			actFight.setVisible(false);
		if(actFight!=null)
			remove(actFight);
		revalidate();
		repaint();
		jf.getContentPane().revalidate();
		jf.getContentPane().repaint();
		actFight= new JLabel();
		actFight.setBounds(0, 0, width, height);
		actFight.setOpaque(false);
		ImageIcon character;
		if(pf instanceof Saiyan)
			character= new ImageIcon(Toolkit.getDefaultToolkit().getImage("pressedsai.png").getScaledInstance((int)(jf.getWidth()*0.15), (int)(jf.getHeight()*0.2), java.awt.Image.SCALE_SMOOTH));
		else if(pf instanceof Earthling)
			character= new ImageIcon(Toolkit.getDefaultToolkit().getImage("pressedEarthling.png").getScaledInstance((int)(jf.getWidth()*0.15), (int)(jf.getHeight()*0.2), java.awt.Image.SCALE_SMOOTH));
		else if(pf instanceof Frieza)
			character= new ImageIcon(Toolkit.getDefaultToolkit().getImage("pressedFrieza.png").getScaledInstance((int)(jf.getWidth()*0.15), (int)(jf.getHeight()*0.2), java.awt.Image.SCALE_SMOOTH));
		else if(pf instanceof Majin)
			character= new ImageIcon(Toolkit.getDefaultToolkit().getImage("pressedMajin.png").getScaledInstance((int)(jf.getWidth()*0.15), (int)(jf.getHeight()*0.2), java.awt.Image.SCALE_SMOOTH));
		else
			character= new ImageIcon(Toolkit.getDefaultToolkit().getImage("pressedNamek.png").getScaledInstance((int)(jf.getWidth()*0.15), (int)(jf.getHeight()*0.2), java.awt.Image.SCALE_SMOOTH));
		JLabel ch= new JLabel(character);
		
		actFight.add(ch);
		ch.setBounds((int)(width*0.73), (int)(height*0.38), (int)(width*0.2), (int)(height*0.2));
		
		JLabel player_name= new JLabel("Name: "+pf.getName());
		player_name.setFont(new Font(Font.MONOSPACED, Font.CENTER_BASELINE, 20));
		player_name.setBounds((int)(width*0.7), (int)(jf.getHeight()*0.55),(int)(jf.getWidth()*0.5), (int)(jf.getHeight()*0.1));
		actFight.add(player_name);
		
		
		JLabel player_level= new JLabel("Level: "+pf.getLevel());
		player_level.setFont(new Font(Font.MONOSPACED, Font.CENTER_BASELINE, 20));
		player_level.setBounds((int)(width*0.7), (int)(jf.getHeight()*0.575),(int)(jf.getWidth()*0.5), (int)(jf.getHeight()*0.1));
		actFight.add(player_level);
		
		JLabel player_xp= new JLabel("XP: "+pf.getXp());
		player_xp.setFont(new Font(Font.MONOSPACED, Font.CENTER_BASELINE, 20));
		player_xp.setBounds((int)(width*0.7), (int)(jf.getHeight()*0.6),(int)(jf.getWidth()*0.5), (int)(jf.getHeight()*0.1));
		actFight.add(player_xp);
		
		JLabel player_targetXp= new JLabel("Target XP: "+pf.getTargetXp());
		player_targetXp.setFont(new Font(Font.MONOSPACED, Font.CENTER_BASELINE, 20));
		player_targetXp.setBounds((int)(width*0.7), (int)(jf.getHeight()*0.625),(int)(jf.getWidth()*0.5), (int)(jf.getHeight()*0.1));
		actFight.add(player_targetXp);
		
		JLabel player_KI= new JLabel("KI: "+pf.getKi());
		player_KI.setFont(new Font(Font.MONOSPACED, Font.CENTER_BASELINE, 20));
		player_KI.setBounds((int)(width*0.7), (int)(jf.getHeight()*0.65),(int)(jf.getWidth()*0.5), (int)(jf.getHeight()*0.1));
		actFight.add(player_KI);
		
		JLabel player_MaxKI= new JLabel("Maximum KI: "+pf.getMaxKi());
		player_MaxKI.setFont(new Font(Font.MONOSPACED, Font.CENTER_BASELINE, 20));
		player_MaxKI.setBounds((int)(width*0.7), (int)(jf.getHeight()*0.675),(int)(jf.getWidth()*0.5), (int)(jf.getHeight()*0.1));
		actFight.add(player_MaxKI);
		
		JLabel player_Stamina= new JLabel("Stamina: "+pf.getStamina());
		player_Stamina.setFont(new Font(Font.MONOSPACED, Font.CENTER_BASELINE, 20));
		player_Stamina.setBounds((int)(width*0.7), (int)(jf.getHeight()*0.7),(int)(jf.getWidth()*0.5), (int)(jf.getHeight()*0.1));
		actFight.add(player_Stamina);
		
		JLabel player_MaxStamina= new JLabel("Maximum Stamina: "+pf.getMaxStamina());
		player_MaxStamina.setFont(new Font(Font.MONOSPACED, Font.CENTER_BASELINE, 20));
		player_MaxStamina.setBounds((int)(width*0.7), (int)(jf.getHeight()*0.725),(int)(jf.getWidth()*0.5), (int)(jf.getHeight()*0.1));
		actFight.add(player_MaxStamina);
		
		JLabel player_PD= new JLabel("Physical Damage: "+pf.getPhysicalDamage());
		player_PD.setFont(new Font(Font.MONOSPACED, Font.CENTER_BASELINE, 20));
		player_PD.setBounds((int)(width*0.7), (int)(jf.getHeight()*0.75),(int)(jf.getWidth()*0.5), (int)(jf.getHeight()*0.1));
		actFight.add(player_PD);
		
		JLabel player_BD= new JLabel("Blast Damage: "+pf.getBlastDamage());
		player_BD.setFont(new Font(Font.MONOSPACED, Font.CENTER_BASELINE, 20));
		player_BD.setBounds((int)(width*0.7), (int)(jf.getHeight()*0.775),(int)(jf.getWidth()*0.5), (int)(jf.getHeight()*0.1));
		actFight.add(player_BD);
		
		JLabel player_abilityPoint= new JLabel("Ability Points: "+pf.getAbilityPoints());
		player_abilityPoint.setFont(new Font(Font.MONOSPACED, Font.CENTER_BASELINE, 20));
		player_abilityPoint.setBounds((int)(width*0.8), (int)(jf.getHeight()*0.65),(int)(jf.getWidth()*0.5), (int)(jf.getHeight()*0.1));
		actFight.add(player_abilityPoint);
		
		ImageIcon up= new ImageIcon(Toolkit.getDefaultToolkit().getImage("upgradeButton.png").getScaledInstance((int)(width*0.15), (int)(height*0.08), java.awt.Image.SCALE_SMOOTH));
		update=new JButton(up);
		update.setBounds((int)(width*0.76),(int)(height*0.85),(int)(width*0.15),(int)(height*0.08));
		update.addActionListener(listener);
		actFight.add(update);
		
		//updateUI();
		
		add(actFight);
//		revalidate();
//		repaint();
//		jf.revalidate();
//		jf.repaint();
//		//int r= listener.getGame().getWorld().getPlayerRow();
//		//int c= listener.getGame().getWorld().getPlayerColumn();
//		//addCharacter(r,c,r,c);
//		revalidate();
//		repaint();
//		if(check)
//		jf.viewWorld();
//		
//		jf.setVisible(true);
//		setVisible(true);
		//jf.pack();
		//jf.setSize(jf.getMaximumSize()); ---------------------------------------> check this weird thing
		//actFight.setVisible(true);
		//update(null);
		//jf.update(null);
		//updateUI();
		
		
	}
	public void addFirstTimeChar(){
		PlayableFighter pf= player.getActiveFighter();
		ImageIcon character;
		if(pf instanceof Saiyan)
			character= new ImageIcon(Toolkit.getDefaultToolkit().getImage("supersaiyanIcon.jpg").getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH));
		else if(pf instanceof Earthling)
			character= new ImageIcon(Toolkit.getDefaultToolkit().getImage("earthlingIcon.jpg").getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH));
		else if(pf instanceof Frieza)
			character= new ImageIcon(Toolkit.getDefaultToolkit().getImage("friezaIcon.jpg").getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH));
		else if(pf instanceof Majin)
			character= new ImageIcon(Toolkit.getDefaultToolkit().getImage("majinIcon.jpg").getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH));
		else
			character= new ImageIcon(Toolkit.getDefaultToolkit().getImage("namekianIcon.png").getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH));
		
		ch= new JButton(character);
		Rectangle r= buttons[9][9].getBounds();
//		System.out.println(r.getX()+ " "+r.getY()+" rect");
//		jf.revalidate();
//		jf.repaint();
		ch.setBounds((int)(r.getX()), (int)(r.getY()), (int)(height*0.1), (int)(height*0.084));
		add(ch);
		buttons[9][9]=ch;
		ch.addActionListener(listener);
	//	System.out.println(ch.getBounds().getX()+ " "+ch.getBounds().getY()+" initial po");
		
	}
	public void addCharacter(int pr, int pc,int row, int col){
		//jf.getContentPane().removeAll();//or remove(JComponent)
//		jf.getContentPane().revalidate();
//		jf.getContentPane().repaint();
		
		PlayableFighter pf= player.getActiveFighter();
		ImageIcon character;
		if(pf instanceof Saiyan)
			character= new ImageIcon(Toolkit.getDefaultToolkit().getImage("supersaiyanIcon.jpg").getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH));
		else if(pf instanceof Earthling)
			character= new ImageIcon(Toolkit.getDefaultToolkit().getImage("earthlingIcon.jpg").getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH));
		else if(pf instanceof Frieza)
			character= new ImageIcon(Toolkit.getDefaultToolkit().getImage("friezaIcon.jpg").getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH));
		else if(pf instanceof Majin)
			character= new ImageIcon(Toolkit.getDefaultToolkit().getImage("majinIcon.jpg").getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH));
		else
			character= new ImageIcon(Toolkit.getDefaultToolkit().getImage("namekianIcon.png").getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH));
		
		//this.remove(buttons[pr][pc]);
		
		int size= (int)(jf.getHeight()*0.084);
		int rwidth= (int)(jf.getHeight()*0.1);
		ImageIcon rock= new ImageIcon(Toolkit.getDefaultToolkit().getImage("rock.png").getScaledInstance(rwidth, size, java.awt.Image.SCALE_SMOOTH));
		JButton b= buttons[row][col];
		Rectangle r= buttons[row][col].getBounds();
		Rectangle x= ch.getBounds();
		//b.addActionListener(listener);
		//b.setBounds((int)(x.getX()),(int)(x.getY()), rwidth,size);
		//b.setContentAreaFilled(false);
		//System.out.println("rock"+ b.getBounds().getX());
		//System.out.println(ch.getBounds().getX()+ " "+ch.getBounds().getY()+" initial po");
		//add(b);
		//buttons[pr][pc]=b;
	
		//buttons[row][col]=null;
		
//		jf.getContentPane().revalidate();
//		jf.getContentPane().repaint();
//		
//		//this.remove(buttons[row][col]);
//		
//		jf.getContentPane().revalidate();
//		jf.getContentPane().repaint();
		ch.setIcon(rock);
		ch= buttons[row][col];
		b.setIcon(character);
		
		//ch.setBounds((int)(r.getX()), (int)(r.getY()), (int)(height*0.1), (int)(height*0.084));
		//System.out.println(ch.getBounds().getX()+" "+ ch.getBounds().getY()+" new positoin character");
		//buttons[row][col]=ch;
		
		
	}
	public void addPlayerInfo(){
		JLabel player_name= new JLabel(player.getName());
		
		player_name.setFont(new Font(Font.MONOSPACED, Font.CENTER_BASELINE, 40));
		player_name.setBounds((int)(width*0.75), (int)(jf.getHeight()*0.02),(int)(jf.getWidth()*0.5), (int)(jf.getHeight()*0.1));
		add(player_name);
		
		JLabel senzu_beans= new JLabel(player.getSenzuBeans()+"");
		senzu_beans.setFont(new Font(Font.MONOSPACED, Font.CENTER_BASELINE, 30));
		senzu_beans.setBounds((int)(width*0.75), (int)(jf.getHeight()*0.085),(int)(jf.getWidth()*0.1), (int)(jf.getHeight()*0.1));
		add(senzu_beans);
		
		ImageIcon senzu= new ImageIcon(Toolkit.getDefaultToolkit().getImage("Senzu_Bean.png").getScaledInstance((int)(width*0.03), (int)(jf.getHeight()*0.03), java.awt.Image.SCALE_SMOOTH));
		JButton use_senzu= new JButton (senzu);
		use_senzu.setContentAreaFilled(false);
		use_senzu.setBorderPainted(false);
		use_senzu.setBounds((int)(jf.getWidth()*0.7), (int)(jf.getHeight()*0.12),(int)(width*0.03), (int)(height*0.03));
		add(use_senzu);
		
		ImageIcon balls= new ImageIcon(Toolkit.getDefaultToolkit().getImage("dragonballIcon.png").getScaledInstance((int)(width*0.03), (int)(jf.getHeight()*0.048), java.awt.Image.SCALE_SMOOTH));
		JButton dragonball= new JButton (balls);
		dragonball.setContentAreaFilled(false);
		dragonball.setBorderPainted(false);
		dragonball.setBounds((int)(jf.getWidth()*0.7), (int)(jf.getHeight()*0.16),(int)(width*0.03), (int)(height*0.048));
		add(dragonball);
		
		JLabel db= new JLabel(player.getDragonBalls()+"");
		db.setFont(new Font(Font.MONOSPACED, Font.CENTER_BASELINE, 30));
		db.setBounds((int)(width*0.75), (int)(jf.getHeight()*0.12),(int)(jf.getWidth()*0.1), (int)(jf.getHeight()*0.1));
		add(db);
		
		ImageIcon up= new ImageIcon(Toolkit.getDefaultToolkit().getImage("addButton.png").getScaledInstance((int)(width*0.15), (int)(height*0.08), java.awt.Image.SCALE_SMOOTH));
		customize=new JButton(up);
		customize.setBounds((int)(width*0.8),(int)(height*0.12),(int)(width*0.15),(int)(height*0.08));
		customize.addActionListener(listener);
		add(customize);
		
		
		
		ArrayList<PlayableFighter> pf= player.getFighters();
		
		for(PlayableFighter x:pf)
			addFighter(x);
		
	}
	public void addFighter(PlayableFighter pf){
		ImageIcon character;
		if(pf instanceof Saiyan)
			character= new ImageIcon(Toolkit.getDefaultToolkit().getImage("supersaiyanIcon.jpg").getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH));
		else if(pf instanceof Earthling)
			character= new ImageIcon(Toolkit.getDefaultToolkit().getImage("earthlingIcon.jpg").getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH));
		else if(pf instanceof Frieza)
			character= new ImageIcon(Toolkit.getDefaultToolkit().getImage("friezaIcon.jpg").getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH));
		else if(pf instanceof Majin)
			character= new ImageIcon(Toolkit.getDefaultToolkit().getImage("majinIcon.jpg").getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH));
		else
			character= new ImageIcon(Toolkit.getDefaultToolkit().getImage("namekianIcon.png").getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH));
		int len= fighters.size();
		JButton b= new JButton(character);
		if(len==0)
			b.setBounds((int)(width*0.7), (int)(height*0.23), (int)(height*0.09), (int)(height*0.09));
		else{
			Rectangle bound= fighters.get(len-1).getBounds();
			b.setBounds((int)(bound.x+bound.getWidth()),(int)(bound.y), (int)(bound.getWidth()),(int)(bound.getHeight()));
		}
		b.addActionListener(listener);
		jf.getContentPane().revalidate();
		jf.getContentPane().repaint();
		add(b);
		fighters.add(b);
	}
	
	public void createMap(){
		setSize(jf.getWidth(),jf.getHeight());
		int size= (int)(jf.getHeight()*0.084);
		int rwidth= (int)(jf.getHeight()*0.1);
		ImageIcon rock= new ImageIcon(Toolkit.getDefaultToolkit().getImage("rock.png").getScaledInstance(rwidth, size, java.awt.Image.SCALE_SMOOTH));
		
		int last_height=(int)(jf.getHeight()*0.0018);
		int last_width= (int)(jf.getWidth()*0.01);
		int space= (int)(jf.getHeight()*0.01);
		int spacew= (int)(jf.getHeight()*0.013);
		
		for(int i=0; i<10 ;i++){
			for(int j=0; j<10; j++){
				JButton b= new JButton(rock);
				if(i==0 && j==0){
					ImageIcon boss= new ImageIcon(Toolkit.getDefaultToolkit().getImage("boss.jpg").getScaledInstance(rwidth, size, java.awt.Image.SCALE_SMOOTH));
					b.setIcon(boss);
				}
				b.setBounds(last_width,last_height, rwidth,size);
				b.setContentAreaFilled(false);
				buttons[i][j]= b;
				b.addActionListener(listener);
				last_width+= rwidth+spacew;
				if((i==9 && j==9))
					continue;
				add(b);
			}
			last_height+=size+space;
			last_width= (int)(jf.getWidth()*0.01);
		}
		
		
	}
	


	public JButton[][] getButtons() {
		return buttons;
	}
	public void setButtons(JButton[][] buttons) {
		this.buttons = buttons;
	}
	public DragonBallView getJf() {
		return jf;
	}
	public void setJf(DragonBallView jf) {
		this.jf = jf;
	}
	public Player getPlayer() {
		return player;
	}
	public void setPlayer(Player player) {
		this.player = player;
	}
	public ArrayList<JButton> getFighters() {
		return fighters;
	}
	public void setFighters(ArrayList<JButton> fighters) {
		this.fighters = fighters;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public JButton getUpdate() {
		return update;
	}
	public void setUpdate(JButton update) {
		this.update = update;
	}
	public JButton getCustomize() {
		return customize;
	}
	public void setCustomize(JButton customize) {
		this.customize = customize;
	}
	public JLabel getActFight() {
		return actFight;
	}
	public void setActFight(JLabel actFight) {
		this.actFight = actFight;
	}
	public GameGUI getListener() {
		return listener;
	}
	public void setListener(GameGUI listener) {
		this.listener = listener;
	}
}
