package dragonball.view;

import java.awt.Font;
import java.awt.Toolkit;
import java.net.URL;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import dragonball.controller.GameGUI;
import dragonball.model.attack.Attack;
import dragonball.model.attack.PhysicalAttack;
import dragonball.model.battle.Battle;
import dragonball.model.character.fighter.Earthling;
import dragonball.model.character.fighter.Fighter;
import dragonball.model.character.fighter.Frieza;
import dragonball.model.character.fighter.Majin;
import dragonball.model.character.fighter.Namekian;
import dragonball.model.character.fighter.Saiyan;
import dragonball.model.exceptions.MissingFieldException;
import dragonball.model.exceptions.NotEnoughKiException;
import dragonball.model.exceptions.UnknownAttackTypeException;
import javafx.scene.paint.Color;

public class BattleView extends JLabel{
	private Fighter active,foe,me;
	private JLabel meFighter, foeFighter;
	private ArrayList<Fighter> foes;
	private Icon foefightMode;
	private Icon foepeaceMode;
	private Icon mefightMode;
	private Icon mepeaceMode,meBlockMode,foeBlockMode;
	private ImageIcon turn,turn1;
	private int posYM,posXM, pos2YM,pos2XM,posYF,posYF2,posXF,posXF2;
	private JLabel play1,myHBG,foeHBG,mySt,foeSt,myKi,foeKi,options,myTurn,foeTurn,myHealth,foeHealth,myStamina,foeStamina;
	private Battle battle;
	private boolean myturn;
	private JLabel action;
	public Fighter getActive() {
		return active;
	}
	public void setActive(Fighter active) {
		this.active = active;
	}
	public Fighter getFoe() {
		return foe;
	}
	public void setFoe(Fighter foe) {
		this.foe = foe;
	}
	public Fighter getMe() {
		return me;
	}
	public void setMe(Fighter me) {
		this.me = me;
	}
	public JLabel getMeFighter() {
		return meFighter;
	}
	public void setMeFighter(JLabel meFighter) {
		this.meFighter = meFighter;
	}
	public JLabel getFoeFighter() {
		return foeFighter;
	}
	public void setFoeFighter(JLabel foeFighter) {
		this.foeFighter = foeFighter;
	}
	public ArrayList<Fighter> getFoes() {
		return foes;
	}
	public void setFoes(ArrayList<Fighter> foes) {
		this.foes = foes;
	}
	public Icon getFoefightMode() {
		return foefightMode;
	}
	public void setFoefightMode(Icon foefightMode) {
		this.foefightMode = foefightMode;
	}
	public Icon getFoepeaceMode() {
		return foepeaceMode;
	}
	public void setFoepeaceMode(Icon foepeaceMode) {
		this.foepeaceMode = foepeaceMode;
	}
	public Icon getMefightMode() {
		return mefightMode;
	}
	public void setMefightMode(Icon mefightMode) {
		this.mefightMode = mefightMode;
	}
	public Icon getMepeaceMode() {
		return mepeaceMode;
	}
	public void setMepeaceMode(Icon mepeaceMode) {
		this.mepeaceMode = mepeaceMode;
	}
	public JLabel getMyHBG() {
		return myHBG;
	}
	public void setMyHBG(JLabel myHBG) {
		this.myHBG = myHBG;
	}
	public JLabel getFoeHBG() {
		return foeHBG;
	}
	public void setFoeHBG(JLabel foeHBG) {
		this.foeHBG = foeHBG;
	}
	public JLabel getMySt() {
		return mySt;
	}
	public void setMySt(JLabel mySt) {
		this.mySt = mySt;
	}
	public JLabel getFoeSt() {
		return foeSt;
	}
	public void setFoeSt(JLabel foeSt) {
		this.foeSt = foeSt;
	}
	public JLabel getMyKi() {
		return myKi;
	}
	public void setMyKi(JLabel myKi) {
		this.myKi = myKi;
	}
	public JLabel getFoeKi() {
		return foeKi;
	}
	public void setFoeKi(JLabel foeKi) {
		this.foeKi = foeKi;
	}
	public JLabel getOptions() {
		return options;
	}
	public void setOptions(JLabel options) {
		this.options = options;
	}
	public JLabel getMyTurn() {
		return myTurn;
	}
	public void setMyTurn(JLabel myTurn) {
		this.myTurn = myTurn;
	}
	public JLabel getFoeTurn() {
		return foeTurn;
	}
	public void setFoeTurn(JLabel foeTurn) {
		this.foeTurn = foeTurn;
	}
	public int getF() {
		return f;
	}
	public void setF(int f) {
		this.f = f;
	}
	public int getM() {
		return m;
	}
	public void setM(int m) {
		this.m = m;
	}
	public JFrame getJf() {
		return jf;
	}
	public void setJf(JFrame jf) {
		this.jf = jf;
	}
	public int getW() {
		return w;
	}
	public void setW(int w) {
		this.w = w;
	}
	public int getH() {
		return h;
	}
	public void setH(int h) {
		this.h = h;
	}
	public JButton getAttackBut() {
		return attackBut;
	}
	public void setAttackBut(JButton attackBut) {
		this.attackBut = attackBut;
	}
	public JButton getUseBut() {
		return useBut;
	}
	public void setUseBut(JButton useBut) {
		this.useBut = useBut;
	}
	public JButton getBlockBut() {
		return blockBut;
	}
	public void setBlockBut(JButton blockBut) {
		this.blockBut = blockBut;
	}
	public GameGUI getListener() {
		return listener;
	}
	public void setListener(GameGUI listener) {
		this.listener = listener;
	}
	public JLabel getMeFight() {
		return meFight;
	}
	public void setMeFight(JLabel meFight) {
		this.meFight = meFight;
	}
	public JLabel getFoeFight() {
		return foeFight;
	}
	
	public void setFoeFight(JLabel foeFight) {
		this.foeFight = foeFight;
	}
	public Battle getBattle() {
		return battle;
	}
	public void setBattle(Battle battle) {
		this.battle = battle;
	}
	private int f,m;
	private JFrame jf;
	private int w,h;
	private JButton attackBut,useBut,blockBut;
	private GameGUI listener;
	private JLabel meFight,foeFight,play;
	
	
	public BattleView(Fighter me,Fighter foe,Battle battle,JFrame jf,GameGUI listener){
		this.battle=battle;
	this.me=me;
	this.foe=foe;
	active=me;
	this.listener=listener;
	this.jf=jf;
	w=(int)(jf.getWidth()*0.338);h= (int)(jf.getHeight()*0.0685);
	if(me instanceof Earthling){
	URL url = this.getClass().getResource("yamchaS.gif");
	URL url1 = this.getClass().getResource("earthlingP.gif");
	URL url2 = this.getClass().getResource("yamchaB.gif");
	meBlockMode=new  ImageIcon(url2);

	mepeaceMode= new ImageIcon(url);
	meFighter = new JLabel(mepeaceMode);
	add(meFighter);
	meFighter.setBounds((int)(jf.getWidth()*0.007), (int)(jf.getHeight()*0.47), (int)(jf.getWidth()*0.23), (int)(jf.getHeight()*0.40));
	mefightMode=new ImageIcon(url1);
	meFight=new JLabel(mefightMode);
	meFighter.setBounds((int)(jf.getWidth()*0.007), (int)(jf.getHeight()*0.47), (int)(jf.getWidth()*0.23), (int)(jf.getHeight()*0.40));

	}if(me instanceof Namekian){
		URL url = this.getClass().getResource("piccoloS.gif");
		URL url1 = this.getClass().getResource("piccoloFFF.gif");
		URL url2 = this.getClass().getResource("piccB.gif");
		meBlockMode=new  ImageIcon(url2);

		mepeaceMode= new ImageIcon(url);
		meFighter = new JLabel(mepeaceMode);
		add(meFighter);
		mefightMode=new ImageIcon(url1);
		meFight=new JLabel(mefightMode);
		meFighter.setBounds((int)(jf.getWidth()*0.007), (int)(jf.getHeight()*0.47), (int)(jf.getWidth()*0.23), (int)(jf.getHeight()*0.40));
		}
	if(me instanceof Majin){
		URL url = this.getClass().getResource("majinSS.GIF");
		URL url1 = this.getClass().getResource("majinFF.gif");
		URL url2 = this.getClass().getResource("majinB.gif");
		meBlockMode=new ImageIcon(url2);
		mepeaceMode= new ImageIcon(url);
		meFighter = new JLabel(mepeaceMode);
		add(meFighter);
		mefightMode=new ImageIcon(url1);
		meFight=new JLabel(mefightMode);
		meFighter.setBounds((int)(jf.getWidth()*0.007), (int)(jf.getHeight()*0.47), (int)(jf.getWidth()*0.23), (int)(jf.getHeight()*0.40));
		}
	if(me instanceof Frieza){
		URL url = this.getClass().getResource("friezaSS.gif");
		URL url1 = this.getClass().getResource("friezaFF.gif");
		URL url2 = this.getClass().getResource("Frieza_Flippingg.gif");
		meBlockMode=new ImageIcon(url2);
		mepeaceMode= new ImageIcon(url);
		meFighter = new JLabel(mepeaceMode);
		add(meFighter);
		mefightMode=new ImageIcon(url1);
		meFight=new JLabel(mefightMode);
		meFighter.setBounds((int)(jf.getWidth()*0.007), (int)(jf.getHeight()*0.47), (int)(jf.getWidth()*0.23), (int)(jf.getHeight()*0.40));
		}
	if(me instanceof Saiyan){

		URL url = this.getClass().getResource("saiyanS.gif");
		URL url1 = this.getClass().getResource("saiyanF.gif");
		URL url2= this.getClass().getResource("saiyanBB.gif");
		meBlockMode=new ImageIcon(url2);
		mepeaceMode= new ImageIcon(url);
		mefightMode=new ImageIcon(url1);
		meFighter = new JLabel(mepeaceMode);
		add(meFighter);
		//meFight=new JLabel(mepeaceMode);
	//	add(meFight);
		meFighter.setBounds((int)(jf.getWidth()*0.007), (int)(jf.getHeight()*0.47), (int)(jf.getWidth()*0.23), (int)(jf.getHeight()*0.40));
				}
	myturn=true;
	 ImageIcon attack= new ImageIcon(Toolkit.getDefaultToolkit().getImage("attack2.png").getScaledInstance((int)(jf.getWidth()*0.13), (int)(jf.getHeight()*0.07), java.awt.Image.SCALE_SMOOTH));		
		ImageIcon use= new ImageIcon(Toolkit.getDefaultToolkit().getImage("use.png").getScaledInstance((int)(jf.getWidth()*0.13), (int)(jf.getHeight()*0.07), java.awt.Image.SCALE_SMOOTH));		
		ImageIcon block= new ImageIcon(Toolkit.getDefaultToolkit().getImage("block1.png").getScaledInstance((int)(jf.getWidth()*0.13), (int)(jf.getHeight()*0.07), java.awt.Image.SCALE_SMOOTH));		
		attackBut=new JButton(attack);
		add(attackBut);
		attackBut.setContentAreaFilled(false);
		attackBut.setBounds((int)(jf.getWidth()*0.5), (int)(jf.getHeight()*0.5),(int)(jf.getWidth()*0.13), (int)(jf.getHeight()*0.07));
		attackBut.addActionListener(listener);
		
		
		blockBut=new JButton(block);
		add(blockBut);
		blockBut.setContentAreaFilled(false);
		blockBut.setBounds((int)(jf.getWidth()*0.37), (int)(jf.getHeight()*0.5),(int)(jf.getWidth()*0.13), (int)(jf.getHeight()*0.07));
		blockBut.addActionListener(listener);
		
		useBut=new JButton(use);
		add(useBut);
		useBut.setContentAreaFilled(false);
		useBut.setBounds((int)(jf.getWidth()*0.43), (int)(jf.getHeight()*0.42),(int)(jf.getWidth()*0.13), (int)(jf.getHeight()*0.07));
		useBut.addActionListener(listener);
		ImageIcon blues= new ImageIcon(Toolkit.getDefaultToolkit().getImage("attacks.png").getScaledInstance((int)(jf.getWidth()*0.3), (int)(jf.getHeight()*0.2), java.awt.Image.SCALE_SMOOTH));		
		options=new JLabel(blues);
		add(options);
		options.setBounds((int)(jf.getWidth()*0.30), (int)(jf.getHeight()*0.39),(int)(jf.getWidth()*0.4), (int)(jf.getHeight()*0.2));
	
		 turn= new ImageIcon(Toolkit.getDefaultToolkit().getImage("yourTurn.png").getScaledInstance((int)(jf.getWidth()*0.4), (int)(jf.getHeight()*0.2), java.awt.Image.SCALE_SMOOTH));		
		myTurn=new JLabel(turn);
		add(myTurn);
		myTurn.setBounds((int)(jf.getWidth()*0.30), (int)(jf.getHeight()*0.270),(int)(jf.getWidth()*0.4), (int)(jf.getHeight()*0.2));
		 turn1= new ImageIcon(Toolkit.getDefaultToolkit().getImage("foeTurn.png").getScaledInstance((int)(jf.getWidth()*0.5), (int)(jf.getHeight()*0.23), java.awt.Image.SCALE_SMOOTH));		
		 
	//add(meFight);
	//meFight.setVisible(false);
	//add(meFighter);
	//startMethod();
	start(jf);
}
public void update(){
	int maxFoe=foe.getMaxHealthPoints();
	int curFoe=foe.getHealthPoints();
	int maxMe= me.getMaxHealthPoints();
	int curMe=me.getHealthPoints();
	double ratioFoe=((double)curFoe)/((double)maxFoe);
	double ratioMe=((double)curMe)/((double)maxMe);
	double ratioSMe=((double)me.getStamina())/((double)me.getMaxStamina());
	double ratioSFoe=((double)foe.getStamina())/((double)foe.getMaxStamina());
	myHealth.setText(""+me.getHealthPoints()+ "/"+me.getMaxHealthPoints());
	foeHealth.setText(""+foe.getHealthPoints()+ "/"+foe.getMaxHealthPoints());
	myStamina.setText(""+me.getStamina()+ "/"+me.getMaxStamina());
	foeStamina.setText(""+foe.getStamina()+ "/"+foe.getMaxStamina());
	
	//System.out.println("hello"+" "+ratioFoe+" "+myturn);
//	myHBG.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage("greenBar.png").getScaledInstance((int)(w*ratioMe), (int)(jf.getHeight()*0.0685), java.awt.Image.SCALE_SMOOTH)));
//	mySt.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage("stamina.png").getScaledInstance((int)(w*ratioSMe), (int)(jf.getHeight()*0.07), java.awt.Image.SCALE_SMOOTH)));
//	foeHBG.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage("greenBar.png").getScaledInstance((int)(w*ratioFoe), (int)(jf.getHeight()*0.0685), java.awt.Image.SCALE_SMOOTH)));
//	foeSt.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage("stamina.png").getScaledInstance((int)(w*ratioSFoe), (int)(jf.getHeight()*0.07), java.awt.Image.SCALE_SMOOTH)));
//	
	 myHBG.setBounds(posXM,posYM,(int)(w*ratioMe),h);
	 foeHBG.setBounds(posXF,posYF,(int)(w*ratioFoe),h);
	 mySt.setBounds(pos2XM,pos2YM,(int)(w*ratioSMe),h);
	 foeSt.setBounds(posXF2,posYF2,(int)(w*ratioSFoe),h);
	 	
	 	myKi.setText(""+me.getKi()+ "/"+me.getMaxKi()+"Ki");
		myKi.setFont(new Font(Font.MONOSPACED,Font.BOLD,40));
		foeKi.setText(""+foe.getKi()+"/"+foe.getMaxKi()+"Ki");
		foeKi.setFont(new Font(Font.MONOSPACED,Font.BOLD,40));
		//nameM.set;
	//	add(myKi);
		//add(foeKi);
		myKi.setBounds((int)(getWidth()*0.1),(int)(getHeight()*0.173),(int)(getWidth()*0.338),(int)(getHeight()*0.07));
		 foeKi.setBounds((int)(getWidth()*0.82),(int)(getHeight()*0.173),(int)(getWidth()*0.338),(int)(getHeight()*0.07));
//System.out.println("updating updating");	
jf.revalidate();
jf.repaint();
}

public void start(JFrame jf){
	//System.out.println("starting starting");
	//JLabel meFighter,foeFighter;//= new ImageIcon(Toolkit.getDefaultToolkit().getImage("Arena_Battle_Backgound.jpeg").getScaledInstance((int)(jf.getWidth()*0.2), (int)(jf.getHeight()), java.awt.Image.SCALE_SMOOTH));
		//jf.removeAll();
		jf.revalidate();
		jf.repaint();
	setSize(jf.getWidth(),jf.getHeight());
		 URL url1 = this.getClass().getResource("brolyS.gif");
		 URL url2 = this.getClass().getResource("brolyB.gif");
		       
		 Icon icon1 = new ImageIcon(url1);
	     foepeaceMode=icon1;
	     foefightMode=new ImageIcon(this.getClass().getResource("brolyF.gif"));
	      foeBlockMode= new ImageIcon(url2);
		 foeFighter = new JLabel(icon1);
	        foeFighter.setBounds((int)(jf.getWidth()*0.63), (int)(jf.getHeight()*0.37), (int)(jf.getWidth()*0.40), (int)(jf.getHeight()*0.40));
	        
	
	//add(meFighter);
	add(foeFighter);

	
	
	ImageIcon green= new ImageIcon(Toolkit.getDefaultToolkit().getImage("greenBar.png").getScaledInstance((int)(jf.getWidth()*0.338), (int)(jf.getHeight()*0.0685), java.awt.Image.SCALE_SMOOTH));
	ImageIcon blue= new ImageIcon(Toolkit.getDefaultToolkit().getImage("stamina.png").getScaledInstance((int)(jf.getWidth()*0.4), (int)(jf.getHeight()*0.07), java.awt.Image.SCALE_SMOOTH));
	myHealth=new JLabel(""+me.getHealthPoints()+"/"+me.getMaxHealthPoints());
	foeHealth=new JLabel(foe.getHealthPoints()+"/"+foe.getMaxHealthPoints());
	myStamina=new JLabel(""+me.getStamina()+"/"+me.getMaxStamina());
	foeStamina=new JLabel(foe.getStamina()+"/"+foe.getMaxStamina());
	
	myHBG=new JLabel(green);
	foeHBG=new JLabel(green);
	mySt=new JLabel(blue);
	foeSt=new JLabel(blue);
	add(myStamina);
	add(foeStamina);
	add(mySt);
	add(foeSt);
	add(myHealth);
	add(foeHealth);
	add(myHBG);
	add(foeHBG);
	posXM=(int)(getWidth()*0.023);
	posYM=(int)(getHeight()*0.013);
	 myHBG.setBounds(posXM,posYM,(int)(getWidth()*0.338),(int)(getHeight()*0.07));
	 
	 foeHBG.setBounds((int)(getWidth()*0.6356),(int)(getHeight()*0.01012),(int)(getWidth()*0.338),(int)(getHeight()*0.07));
	 posXF=(int)(getWidth()*0.6356);
	posYF=(int)(getHeight()*0.01012);
	 foeHealth.setBounds((int)(getWidth()*0.6356),(int)(getHeight()*0.01012),(int)(getWidth()*0.338),(int)(getHeight()*0.07));
	 myHealth.setBounds((int)(getWidth()*0.023),(int)(getHeight()*0.013),(int)(getWidth()*0.338),(int)(getHeight()*0.07));
	 
	 foeHealth.setFont(new Font(Font.MONOSPACED,Font.BOLD,40));
			
	 myHealth.setFont(new Font(Font.MONOSPACED,Font.BOLD,40));
		 
	 mySt.setBounds((int)(getWidth()*0.023),(int)(getHeight()*0.0847),(int)(getWidth()*0.338),(int)(getHeight()*0.07));
	 
	 pos2XM=(int)(getWidth()*0.023);
	 pos2YM=(int)(getHeight()*0.0847);
	 foeSt.setBounds((int)(getWidth()*0.6356),(int)(getHeight()*0.08182),(int)(getWidth()*0.338),(int)(getHeight()*0.07));
	 posXF2=(int)(getWidth()*0.6356);
	 posYF2=(int)(getHeight()*0.08182);
	 foeStamina.setBounds((int)(getWidth()*0.6356),(int)(getHeight()*0.08182),(int)(getWidth()*0.338),(int)(getHeight()*0.07));
	  myStamina.setBounds((int)(getWidth()*0.023),(int)(getHeight()*0.0847),(int)(getWidth()*0.338),(int)(getHeight()*0.07));

	 foeStamina.setFont(new Font(Font.MONOSPACED,Font.BOLD,40));
			
	 myStamina.setFont(new Font(Font.MONOSPACED,Font.BOLD,40));
		 	
//	 foeHBG.setBounds((int)(getWidth()*0.),(int)(getHeight()*0.04),(int)(getWidth()*0.35),(int)(getHeight()*0.04));
	//updateHB();
	
	JLabel levelM=new JLabel(""+me.getLevel());
	levelM.setFont(new Font(Font.MONOSPACED,Font.BOLD,40));
	JLabel levelF=new JLabel(""+foe.getLevel());
	levelF.setFont(new Font(Font.MONOSPACED,Font.BOLD,40));
	
	add(levelM);
	add(levelF);
	 levelM.setBounds((int)(getWidth()*0.3),(int)(getHeight()*0.177),(int)(getWidth()*0.338),(int)(getHeight()*0.07));
	 levelF.setBounds((int)(getWidth()*0.77),(int)(getHeight()*0.177),(int)(getWidth()*0.338),(int)(getHeight()*0.07));
	
	 
		JLabel nameM=new JLabel(""+me.getName());
		nameM.setFont(new Font(Font.MONOSPACED,Font.BOLD,40));
		JLabel nameF=new JLabel(""+foe.getName());
		nameF.setFont(new Font(Font.MONOSPACED,Font.BOLD,40));
		//nameM.set;
		add(nameM);
		add(nameF);
		 nameM.setBounds((int)(getWidth()*0.05),(int)(getHeight()*0.272),(int)(getWidth()*0.338),(int)(getHeight()*0.07));
		 nameF.setBounds((int)(getWidth()*0.815),(int)(getHeight()*0.272),(int)(getWidth()*0.338),(int)(getHeight()*0.07));
		

			myKi=new JLabel(""+me.getKi()+ "/"+me.getMaxKi()+"Ki");
			myKi.setFont(new Font(Font.MONOSPACED,Font.BOLD,40));
			foeKi=new JLabel(""+foe.getKi()+"/"+foe.getMaxKi()+"Ki");
			foeKi.setFont(new Font(Font.MONOSPACED,Font.BOLD,40));
			//nameM.set;
			add(myKi);
			add(foeKi);
			myKi.setBounds((int)(getWidth()*0.1),(int)(getHeight()*0.173),(int)(getWidth()*0.338),(int)(getHeight()*0.07));
			 foeKi.setBounds((int)(getWidth()*0.82),(int)(getHeight()*0.173),(int)(getWidth()*0.338),(int)(getHeight()*0.07));
	
			 if(myturn){
	myturn=false;
			 }
			 else{
				
				ImageIcon turn1= new ImageIcon(Toolkit.getDefaultToolkit().getImage("foeTurn.png").getScaledInstance((int)(jf.getWidth()*0.5), (int)(jf.getHeight()*0.23), java.awt.Image.SCALE_SMOOTH));		
				myTurn.setIcon(turn1);
				//foeTurn=new JLabel(turn1);
			//	add(foeTurn);
				myTurn.setBounds((int)(jf.getWidth()*0.25), (int)(jf.getHeight()*0.270),(int)(jf.getWidth()*0.5), (int)(jf.getHeight()*0.23));
				
				
				try {
					myturn=true;
					battle.play();
				} catch (NotEnoughKiException e) {
					myturn=false;
					start(jf);
					}
				
			 }
			 
			 
	 
			 ImageIcon playP= new ImageIcon(Toolkit.getDefaultToolkit().getImage("transform.png").getScaledInstance((int)(jf.getWidth()*0.2), (int)(jf.getHeight()*0.10), java.awt.Image.SCALE_SMOOTH));
			 play=new JLabel(playP);
			 add(play);
			 play.setBounds((int)(jf.getWidth()*0.77), (int)(jf.getHeight()*0.35), (int)(jf.getWidth()*0.2), (int)(jf.getHeight()*0.10));
			// play.setVisible(true);

			 play1=new JLabel(playP);
			 add(play1);
			 play1.setBounds((int)(jf.getWidth()*0.03), (int)(jf.getHeight()*0.35), (int)(jf.getWidth()*0.2), (int)(jf.getHeight()*0.10));
		 play1.setVisible(false);
			 
			 if(foe instanceof Saiyan&& ((Saiyan)foe).isTransformed())
					play.setVisible(true);
				else play.setVisible(false);

			 action=new JLabel("Let the Game BEGIN!",JLabel.CENTER);
			 action.setForeground(java.awt.Color.WHITE);
			 action.setFont(new Font(Font.MONOSPACED,Font.BOLD,45));
			 add(action);		
			 action.setBounds((int)(getWidth()*0.1),(int)(getHeight()*0.75),(int)(getWidth()*0.9),(int)(getHeight()*0.07));
			 
			 ImageIcon backG= new ImageIcon(Toolkit.getDefaultToolkit().getImage("battleBack2.png").getScaledInstance((int)(jf.getWidth()), (int)(jf.getHeight()), java.awt.Image.SCALE_SMOOTH));
	JLabel background=new JLabel(backG);
	add(background);
	background.setBounds(0, 0,getWidth(),getHeight());
	//update();
	jf.revalidate();
	jf.repaint();
}
public JLabel getAction() {
	return action;
}
public void setAction(JLabel action) {
	this.action = action;
}
public JLabel getPlay() {
	return play;
}
public void setPlay(JLabel play) {
	this.play = play;
}


public void changeTurn(Fighter curr){
	jf.revalidate();
	jf.repaint();
	
	
	if(me instanceof Saiyan&& ((Saiyan)me).isTransformed())
		play1.setVisible(true);
	else play1.setVisible(false);

	if(foe instanceof Saiyan&& ((Saiyan)foe).isTransformed())
		play.setVisible(true);
	else play.setVisible(false);

	if(myturn){
		 myTurn.setIcon(turn);myTurn.setBounds((int)(jf.getWidth()*0.25), (int)(jf.getHeight()*0.250),(int)(jf.getWidth()*0.5), (int)(jf.getHeight()*0.23));
			
		 attackBut.setVisible(true);
		 useBut.setVisible(true);
		 blockBut.setVisible(true);
		 options.setVisible(true);
		 myturn=false;
	 }
	 else{
		
		 myTurn.setIcon(turn1);
		myTurn.setBounds((int)(jf.getWidth()*0.25), (int)(jf.getHeight()*0.270),(int)(jf.getWidth()*0.5), (int)(jf.getHeight()*0.23));
		attackBut.setVisible(false);
		 useBut.setVisible(false);
		 blockBut.setVisible(false);
		 options.setVisible(false);
		 
		
		try {
			myturn=true;
			battle.play();
		} catch (NotEnoughKiException e) {
			myturn=false;
			changeTurn(curr);
		}
		
	 }

	
	
//	
//	
//	
//	
//	if(curr==me){
////		foeTurn.setVisible(false);
////		myTurn.setVisible(true);
////		
//		start(jf);	
//	attackBut.addActionListener(listener);
//
//	useBut.addActionListener(listener);
//
//	blockBut.addActionListener(listener);
//	}else{
//	//	foeTurn.setVisible(true);
//	//	myTurn.setVisible(false);
//		try {
//			battle.play();
//		} catch (NotEnoughKiException e) {
//			changeTurn(curr);
//			}
//		attackBut.setVisible(false);
//		useBut.setVisible(false);
//		blockBut.setVisible(false);
//		options.setVisible(false);
//		
//	}
	jf.revalidate();
	jf.repaint();
}
public Attack showAttacks(){
	int size=me.getUltimateAttacks().size()+me.getSuperAttacks().size()+1;
	Attack[] attacks=new Attack[size];
	attacks[0]= new PhysicalAttack();
	
	int j=0;
	for (int i = 1; i <=me.getSuperAttacks().size() ; i++) {
		attacks[i]=me.getSuperAttacks().get(j++);
		
	}
	j=0;
	for (int i =me.getSuperAttacks().size()+1; i <attacks.length; i++) {
		attacks[i]=me.getUltimateAttacks().get(j++);
	}
	Attack chosen=(Attack)JOptionPane.showInputDialog(null, "","Pick your Attack!", JOptionPane.INFORMATION_MESSAGE, null,attacks,attacks[0]); 
	return chosen;
}
public void startMethod() {
	if(active==me){
//System.out.println("hellere");
	    jf.revalidate();
	    jf.repaint();
		meFighter.setIcon(mefightMode);
		//meFight.setVisible(true);
	//	add(meFight);
	  //  jf.revalidate();
	   // jf.repaint();
		Timer timer = new Timer();
		    TimerTasker task = new TimerTasker(meFighter, mepeaceMode) {
		    	int secondsToWait = 5;
		        
		        public void run() {
		            secondsToWait--;
		            System.out.println(secondsToWait);
		      //      lblTimer.setText(secondsToWait + "");
		            if (secondsToWait == 0) {
		                timer.cancel();
		                timer.purge();
		                meFighter.setIcon(mepeaceMode);
		            }
		        }
		    };
		    timer.scheduleAtFixedRate(task, 1000, 1000);
  //  System.out.println("helloer");
    jf.revalidate();
    jf.repaint();


    jf.revalidate();
    jf.repaint();
	}

	if(foe==active){
	    jf.revalidate();
	    jf.repaint();
		meFighter.setIcon(mefightMode);
		Timer timer = new Timer();
		    TimerTasker task = new TimerTasker(foeFighter, foepeaceMode) {
		    	int secondsToWait = 5;
		        
		        public void run() {
		            secondsToWait--;
		     //       System.out.println(secondsToWait);
		      //      lblTimer.setText(secondsToWait + "");
		            if (secondsToWait == 0) {
		                timer.cancel();
		                timer.purge();
		                foeFighter.setIcon(foepeaceMode);
		            }
		        }
		    };
		    timer.scheduleAtFixedRate(task, 1000, 1000);
		    jf.revalidate();
		    jf.repaint();
	}

}
public static void main(String[] args) throws MissingFieldException, UnknownAttackTypeException {
	JFrame jf=new JFrame();
	
	GameGUI gg=new GameGUI();
	jf.pack();
	jf.setSize(jf.getMaximumSize());
	//setResizable(false);
	jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	//setLayout(null); for some reason!!! not working
	//setTitle("DragonBall");
	Earthling y=new Earthling("Jinkoumen");
	Saiyan x=new Saiyan("Mariem");
	Battle b=new Battle(x, y);
	x.setHealthPoints(x.getMaxHealthPoints()-100);
	//System.out.println(x.getHealthPoints()+" current health points");
	BattleView bv=new BattleView(x,y,b,jf,gg);
	jf.add(bv);
	bv.start(jf);
	//bv.changeTurn(y);
	//bv.startMethod();
	jf.setVisible(true);
	//System.out.println(bv.showAttacks());
	
}




public void inPeace(){
	if(!myturn){
		foeFighter.setIcon(foepeaceMode);
		if(battle.isMeBlocking())
			meFighter.setIcon(meBlockMode);
		else meFighter.setIcon(mepeaceMode);
	}
	else{
		meFighter.setIcon(mepeaceMode);
		if(battle.isFoeBlocking())
			foeFighter.setIcon(foeBlockMode);
		else foeFighter.setIcon(foepeaceMode);
	}
	
}
public void inAction(){
	if(!myturn){
		if(battle.isMeBlocking())
		meFighter.setIcon(meBlockMode);
		else
		meFighter.setIcon(mefightMode);
	}
	else{
		if(battle.isFoeBlocking())
			foeFighter.setIcon(foeBlockMode);
			else
			foeFighter.setIcon(foefightMode);
	}
	
}
}
class TimerTasker extends TimerTask{
	JLabel jl;
	Icon icon;
	public TimerTasker(JLabel jl, Icon icon){
		this.jl=jl;
		this.icon=icon;
	}
	public void run() {
		// TODO Auto-generated method stub
		
	}
	
}
