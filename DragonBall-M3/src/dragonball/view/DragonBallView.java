package dragonball.view;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import dragonball.controller.GameGUI;
import dragonball.model.battle.Battle;
import dragonball.model.battle.BattleEvent;
import dragonball.model.character.fighter.Fighter;
import dragonball.model.character.fighter.NonPlayableFighter;
import dragonball.model.dragon.Dragon;
import dragonball.model.game.Game;
import dragonball.model.player.Player;
import sun.audio.AudioData;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import sun.audio.ContinuousAudioDataStream;

public class DragonBallView extends JFrame{
	JLabel jl;
	String name;
	GameGUI listener;
	WorldMap wm;

	
	
	 public static void music() 
	    {       
	        AudioPlayer MGP = AudioPlayer.player;
	        AudioStream BGM;
	        AudioData MD;
	        
	        ContinuousAudioDataStream loop = null;

	        try
	        {
	            InputStream test = new FileInputStream("music1.wav");
	            BGM = new AudioStream(test);
	            AudioPlayer.player.start(BGM);
	            //MD = BGM.getData();
	            //loop = new ContinuousAudioDataStream(MD);

	        }
	        catch(FileNotFoundException e){
	            System.out.print(e.toString());
	        }
	        catch(IOException error)
	        {
	            System.out.print(error.toString());
	        }
	        MGP.start(loop);
	    }


	 public void transit(){
			getContentPane().removeAll();//or remove(JComponent)
			getContentPane().revalidate();
			getContentPane().repaint();
			
			transition1 tr=new transition1(this);
			jl=tr;
			add(jl);
			
			
			setVisible(true);
		}
	
	public WorldMap getWm() {
		return wm;
	}
	public void setWm(WorldMap wm) {
		this.wm = wm;
	}
	public GameGUI getListener() {
		return listener;
	}
	public void setListener(GameGUI listener) {
		this.listener = listener;
	}
	public JLabel getJl() {
		return jl;
	}
	public void setJl(JLabel jl) {
		this.jl = jl;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public DragonBallView(GameGUI listener,boolean load){
		if(!load)
		music();
		this.listener=listener;
		pack();
		Dimension dim = getMaximumSize();
		if(dim.getHeight() > 900 || dim.getWidth() > 1500)
			setSize(new Dimension(1500,900));
		else
			setSize(dim);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
		    public void windowClosing(WindowEvent we)
		    { 
		        String choices[] = {"Yes","No"};
		        int PromptResult = JOptionPane.showOptionDialog(null,"Are you sure you want to exit?","DragonBall",JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE,null,choices,choices[1]);
		        if(PromptResult==JOptionPane.YES_OPTION)
		        {
		            System.exit(0);
		        }
		    }
		});
		//setDefaultCloseOperation(EXIT_ON_CLOSE);
		//setResizable(false);
		//setPreferredSize(getMaximumSize());
		//setDefaultCloseOperation();
		//setLayout(null); //for some reason!!! not working
//		setLayout(new SpringLayout());
//		pack();
//		setSize(getMaximumSize());
		setTitle("DragonBall");
		
		 Image icon = Toolkit.getDefaultToolkit().getImage("images.png");
		 
		setIconImage(icon);
		//loadGame(false);
		
	}
	
	
	
	
	
	public void collectedseven(Dragon dragon){
		getContentPane().removeAll();
		getContentPane().revalidate();
		getContentPane().repaint();
		jl= new sevenDragon(this,listener,dragon);
		add(jl);
		setVisible(true);
	}
	public void BattleEnded(Game game, boolean boss,boolean won,NonPlayableFighter foe,boolean levelup){
		getContentPane().removeAll();
		getContentPane().revalidate();
		getContentPane().repaint();
		if(won){
			jl= new BattleEndView(listener, this,game,boss,foe,levelup);
			add(jl);
		}
		else{
			jl= new LostView(this,listener);
			add(jl);
		}
		setVisible(true);
		
	}
	
	public void loadBattle(BattleEvent be, Battle b){
		getContentPane().removeAll();//or remove(JComponent)
		getContentPane().revalidate();
		getContentPane().repaint();
		
		
		BattleView bv=new BattleView((Fighter)(b.getMe()),(Fighter)(b.getFoe()),b,this,listener);
		jl=bv;
		add(jl);
		
		
		setVisible(true);
	}
	
	public void loadUpgrade(Fighter f){
		getContentPane().removeAll();//or remove(JComponent)
		getContentPane().revalidate();
		getContentPane().repaint();
		jl=new UpgradeFighter(this,f,listener);
		add(jl);
		setVisible(true);
	}
	public void loadGame(boolean savedOrNot){
		//setSize(1370,725);
		NewGame ng=new NewGame(this,savedOrNot);
		ng.getNewgame().addActionListener(listener);
		ng.getLoadgame().addActionListener(listener);
		jl=ng;
		setVisible(true);
		this.add(ng);
	}
	
	public void senzuBeanView(){
		getContentPane().removeAll();//or remove(JComponent)
		getContentPane().revalidate();
		getContentPane().repaint();
		jl=new SenzuBeanView(listener, this);
		add(jl);
		setVisible(true);
	}
	
	public void chooseFighter(){
		//System.out.println("hello3");
		getContentPane().removeAll();//or remove(JComponent)
		getContentPane().revalidate();
		getContentPane().repaint();
		chooseFighter cf=new chooseFighter(this);
		ArrayList<JButton> original= cf.original;
		for (int i = 0; i < original.size(); i++) {
			original.get(i).addActionListener(listener);
		}
		jl=cf;
		cf.play.addActionListener(listener);
		name= cf.txt.getText();
		setVisible(true);
		this.add(cf);
		
		
	}
	public void chooseFighter2(){
		//System.out.println("hello3");
		getContentPane().removeAll();//or remove(JComponent)
		getContentPane().revalidate();
		getContentPane().repaint();
		chooseFighter2 cf=new chooseFighter2(this);
		ArrayList<JButton> original= cf.original;
		for (int i = 0; i < original.size(); i++) {
			original.get(i).addActionListener(listener);
		}
		jl=cf;
		cf.play.addActionListener(listener);
		setVisible(true);
		this.add(cf);
		
		
	}
	
	public void dragonView(Dragon dragon){
		getContentPane().removeAll();//or remove(JComponent)
		getContentPane().revalidate();
		getContentPane().repaint();
		DragonView view=new DragonView(dragon,this);
		JButton [] buttons= view.buttons;
		//System.out.println("hello1");
		for (int i = 0; i < buttons.length; i++) {
			buttons[i].addActionListener(listener);
		}
		jl=view;
		setVisible(true);
		this.add(view);
	//	System.out.println("hello2");
	}
	
	public void loadWorld(Player player){
//		getContentPane().removeAll();//or remove(JComponent)
//		getContentPane().revalidate();
//		getContentPane().repaint();
		wm= new WorldMap(this,player,listener);
//		jl=wm;
//		add(wm);
//		setVisible(true);
		
		
	}
	public void viewWorld(){
		getContentPane().removeAll();//or remove(JComponent)
		getContentPane().revalidate();
		getContentPane().repaint();
		jl=wm;
		add(wm);
		revalidate();
		repaint();
		setVisible(true);
	}
	
	public void customizeFighter(Player player, char race){
		getContentPane().removeAll();//or remove(JComponent)
		getContentPane().revalidate();
		getContentPane().repaint();
		jl= new CustomizeFighter(player,race, this,listener);
		add(jl);
		setVisible(true);
		
	}
	
	public void DragonBall(){
		getContentPane().removeAll();//or remove(JComponent)
		getContentPane().revalidate();
		getContentPane().repaint();
		jl= new DragonBallFound(listener,this);
		add(jl);
		setVisible(true);
	}
	public static void main(String[] args) {
		//DragonBallView df=new DragonBallView();
	//	df.setSize(1370, 725);
	    //df.loadGame(false);
	//	df.loadGame(false);
		//df.chooseFighter();
		//JLabel jl=new NewGame(df,false);
		//JPanel jp=new JPanel();
		//jl.setBounds(0, 0, df.getHeight(),df.getWidth());
		//df.add(jl);
		//df.chooseFighter();
	//	System.out.println(df.name);
		//df.add(new NewGame(df));
	}
	
//	public void actionPerformed(ActionEvent e) {
//		JButton pressed=(JButton) e.getSource();
//		if(jl instanceof chooseFighter){
//		chooseFighter cf=(chooseFighter)jl;
//	
//		//if(e.getClass() instanceof chooseFighter)
//		if(cf.original.contains(pressed)){
//			cf.chosen=true;
//		int index=cf.original.indexOf(pressed);
//		pressed.setIcon(cf.pressed.get(index));
//		for (int i = 0; i < cf.original.size(); i++) {
//			if(i==index)
//				continue;
//			cf.original.get(i).setIcon(cf.origin.get(i));
//		}}
//		else if(pressed==cf.play){
//		if(cf.txt.getText()==null||(cf.txt.getText().equals(""))||!cf.chosen){
//	//	System.out.println(cf.getText());
//		JOptionPane.showMessageDialog(null, "Please enter your name and choose a fighter!","", JOptionPane.INFORMATION_MESSAGE);
//		 }
//		else{
//			 System.out.println("right you are harry");
//			}
//		}
//	}
//		else if(jl instanceof NewGame){
//			NewGame ng=(NewGame) jl;
//		if(pressed==ng.getNewgame()){	
//			chooseFighter();
//		}
//		else if(!ng.saved){
//			JOptionPane.showMessageDialog(null, "No Saved Games Yet!","", JOptionPane.INFORMATION_MESSAGE);
//		}
//		
//	}
//		else if(jl instanceof DragonView){
//			DragonView temp=(DragonView) jl;
//			JButton possible[]= temp.buttons;
//			DragonWish wish=null;
//			for (int i = 0; i < possible.length; i++) {
//				if(possible[i]==pressed){
//					switch(i){
//					case 0: wish=new DragonWish(temp.dragon,DragonWishType.ABILITY_POINTS,temp.dragon.getAbilityPoints());break;
//					case 1: wish=new DragonWish(temp.dragon,DragonWishType.SENZU_BEANS,temp.dragon.getSenzuBeans());break;
//					case 2: UltimateAttack randomUltimateAttack = temp.dragon.getUltimateAttacks().get(new Random().nextInt(temp.dragon.getUltimateAttacks().size()));
//					wish=new DragonWish(temp.dragon,DragonWishType.ULTIMATE_ATTACK,randomUltimateAttack); break;
//					case 3: SuperAttack randomSuperAttack = temp.dragon.getSuperAttacks().get(new Random().nextInt(temp.dragon.getSuperAttacks().size()));
//					wish=new DragonWish(temp.dragon,DragonWishType.SUPER_ATTACK,randomSuperAttack); break;
//					
//					}
//					if(wish==null)
//						continue;
//					else break;
//				}
//			}
//			
//
//		}
//	}
}
