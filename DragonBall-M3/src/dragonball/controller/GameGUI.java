package dragonball.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import dragonball.model.attack.Attack;
import dragonball.model.attack.SuperAttack;
import dragonball.model.attack.SuperSaiyan;
import dragonball.model.attack.UltimateAttack;
import dragonball.model.battle.Battle;
import dragonball.model.battle.BattleEvent;
import dragonball.model.battle.BattleEventType;
import dragonball.model.cell.Collectible;
import dragonball.model.character.fighter.Fighter;
import dragonball.model.character.fighter.NonPlayableFighter;
import dragonball.model.character.fighter.PlayableFighter;
import dragonball.model.dragon.Dragon;
import dragonball.model.dragon.DragonWish;
import dragonball.model.dragon.DragonWishType;
import dragonball.model.exceptions.InvalidFormatException;
import dragonball.model.exceptions.MissingFieldException;
import dragonball.model.exceptions.NotEnoughKiException;
import dragonball.model.exceptions.NotEnoughSenzuBeansException;
import dragonball.model.exceptions.UnknownAttackTypeException;
import dragonball.model.game.Game;
import dragonball.model.game.GameListener;
import dragonball.model.game.GameState;
import dragonball.model.player.Player;
import dragonball.model.world.World;
import dragonball.view.BattleEndView;
import dragonball.view.BattleView;
import dragonball.view.CustomizeFighter;
import dragonball.view.DragonBallFound;
import dragonball.view.DragonBallView;
import dragonball.view.DragonView;
import dragonball.view.LostView;
import dragonball.view.NewGame;
import dragonball.view.SenzuBeanView;
import dragonball.view.UpgradeFighter;
import dragonball.view.WorldMap;
import dragonball.view.chooseFighter;
import dragonball.view.chooseFighter2;
import dragonball.view.sevenDragon;

public class GameGUI implements ActionListener, GameListener,Serializable {
	transient DragonBallView view;
	Game game;
	int lastLevel;

	public GameGUI() throws MissingFieldException, UnknownAttackTypeException {
		game = new Game();
		game.setListener(this);
		view = new DragonBallView(this,false);
		view.loadGame(false);
		
		
//		Earthling e=new Earthling("Mariem");
//		ArrayList<SuperAttack> sa=new ArrayList<>();
//		ArrayList<UltimateAttack> ua=new ArrayList<>();
//		sa=game.getSuperAttacks();
//		ua=game.getUltimateAttacks();
	//game.getPlayer().createFighter('E',"mariem");
	//NonPlayableFighter f= game.getStrongFoes().get(0);//new NonPlayableFighter("name",2,1250,34,123,23,90,false,sa,ua);
//	
//		game.getPlayer().setName("helo");
//		game.getPlayer().setSenzuBeans(0);
	
//		e=(Earthling) game.getPlayer().getActiveFighter();
//		Battle b=new Battle(e,f);
//		BattleEvent be=new BattleEvent(b,BattleEventType.STARTED);
		//view.BattleEnded(game, false, false, f, false);
	
		
//	view.loadBattle(be, b);
		
		//view.add(new SenzuBeanView(this, view));
	//	view.add(new DragonBallFound(this, view));
		//	view.setVisible(true);
//		game.getPlayer().createFighter('F', "mariem");
//		PlayableFighter af= game.getPlayer().getActiveFighter();
//		af.setAbilityPoints(2);
//		World world= game.getWorld();
//		Cell [][] cell= world.getMap();
//		for(int i=0; i<9; i++){
//			cell [i][9]= new CollectibleCell(Collectible.DRAGON_BALL);
//			cell[i][9].setListener(world);
//		}
		//view.loadWorld(game.getPlayer());
		//view.viewWorld();
		// view.chooseFighter();
		//view.senzuBeanView();
		//view.DragonBall();
	}

	public void actionPerformed(ActionEvent e) {
		GameState temporary = game.getState();
		JButton pressed = (JButton) e.getSource();
		JLabel jl = view.getJl();
		if (jl instanceof chooseFighter) {
			chooseFighter cf = (chooseFighter) jl;

			if (cf.getOriginal().contains(pressed)) {
				cf.setChosen(true);
				int index = cf.getOriginal().indexOf(pressed);
				cf.setChosenFighter(index);
				pressed.setIcon(cf.getPressed().get(index));
				for (int i = 0; i < cf.getOriginal().size(); i++) {
					if (i == index)
						continue;
					cf.getOriginal().get(i).setIcon(cf.getOrigin().get(i));
				}
			} else if (pressed == cf.getPlay()) {
				if (cf.getTxt().getText() == null
						|| (cf.getTxt().getText().equals("")) || !cf.isChosen()) {
					// System.out.println(cf.getText());
					JOptionPane.showMessageDialog(null,
							"Please enter your name and choose a fighter!", "",
							JOptionPane.INFORMATION_MESSAGE);
					
				} else {
					Player y = game.getPlayer();
					y.setName(cf.getTxt().getText());
					
				//	y.setSuperAttacks(game.getSuperAttacks());
					//y.setUltimateAttacks(game.getUltimateAttacks());
					int index = cf.getChosenFighter();
					char race='1';
					switch (index) {
					case 0:race='E';break;
					case 1:race='M';break;
					case 2:race='F';break;
					case 3:race='S';break;
					case 4:race='N';break;
					}
					view.customizeFighter(y, race);
				}
			}
		} else if (jl instanceof NewGame) {
			NewGame ng = (NewGame) jl;
			if (pressed == ng.getNewgame()) {
				view.chooseFighter();
			} else {
				File x= new File("gameSaved.txt");
				if(x.exists())
					
					try {
						//System.out.println("loaded");
						game.load("gameSaved.txt");
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				else
				if (!ng.isSaved()) {
					JOptionPane.showMessageDialog(null, "No Saved Games Yet!", "",JOptionPane.INFORMATION_MESSAGE);
				}
			}

		} else if (jl instanceof DragonView) {
			DragonView temp = (DragonView) jl;
			JButton possible[] = temp.getButtons();
			DragonWish wish = null;
			for (int i = 0; i < possible.length; i++) {
				if (possible[i] == pressed) {
					switch (i) {
					case 0:wish = new DragonWish(temp.getDragon(),DragonWishType.ABILITY_POINTS, temp.getDragon().getAbilityPoints());break;
					case 1:wish = new DragonWish(temp.getDragon(),DragonWishType.SENZU_BEANS, temp.getDragon().getSenzuBeans());break;
					case 2:UltimateAttack randomUltimateAttack = temp.getDragon().getUltimateAttacks().get(new Random().nextInt(temp.getDragon().getUltimateAttacks().size()));
							wish = new DragonWish(temp.getDragon(),DragonWishType.ULTIMATE_ATTACK,randomUltimateAttack);break;
					case 3: SuperAttack randomSuperAttack = temp.getDragon().getSuperAttacks().get(new Random().nextInt(temp.getDragon().getSuperAttacks().size()));
							wish = new DragonWish(temp.getDragon(),DragonWishType.SUPER_ATTACK, randomSuperAttack);break;
					}
					if (wish == null)
						continue;
					else
						break;
				}
			}
			game.getPlayer().chooseWish(wish);
			view.loadWorld(game.getPlayer());
			view.viewWorld();

		}
		else if(jl instanceof WorldMap){
			
			WorldMap wm= view.getWm();
			if(pressed==wm.getUpdate()){
				if(game.getPlayer().getActiveFighter().getAbilityPoints()>0)
					view.loadUpgrade(game.getPlayer().getActiveFighter());
				else{
					JOptionPane.showMessageDialog(null,game.getPlayer().getActiveFighter().getName()+" does not have enough ability point ", "",JOptionPane.INFORMATION_MESSAGE);
					return;
				}
					
			}
			else if(pressed==wm.getCustomize())
				view.chooseFighter2();
			else if(pressed==wm.getSave()){
				try {
					//System.out.println("saved");
					game.save("gameSaved.txt");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			else {
				
				ArrayList<JButton>fight= wm.getFighters();
				int len= fight.size();
				for(int i=0;i<len; i++){
					JButton x= fight.get(i);
					if(x==pressed){
						game.getPlayer().setActiveFighter(game.getPlayer().getFighters().get(i));
						//wm.addActiveFighter(true);
						view.loadWorld(game.getPlayer());
						view.viewWorld();
						return;
					}
				}
				
				JButton[][] buttons= wm.getButtons();
				World world= game.getWorld(); 
				for(int i=0; i<10; i++){
					boolean found=false;
					for(int j=0;j<10; j++){
						if(buttons[i][j]==pressed){
							int playrow= world.getPlayerRow();
							int playcol= world.getPlayerColumn();
							if(i==playrow-1 && j==playcol){
								world.moveUp();
								wm.addCharacter(playrow, playcol, i, j);
								return;
							}
							else
								if(i==playrow+1 && j==playcol){
									world.moveDown();
									wm.addCharacter(playrow, playcol, i, j);
									return;
								}
								else
									if(i==playrow && j==playcol+1){
										world.moveRight();
										wm.addCharacter(playrow, playcol, i, j);
										return;
									}
									else
										if(i==playrow && j==playcol-1){
											world.moveLeft();
											wm.addCharacter(playrow, playcol, i, j);
											return;
										}
										else{
											JOptionPane.showMessageDialog(null,"You can only move to an adjacent cell ", "",JOptionPane.INFORMATION_MESSAGE);
											return;
										}
							
						}
					}
				}
				
			}
				
		}
		else if(jl instanceof CustomizeFighter ){
			
			Player player= game.getPlayer();
			String s=((CustomizeFighter) jl).txt.getText();
			if(s==null || s.equals("")){
				JOptionPane.showMessageDialog(null,"Please enter a name for your fighter", "",JOptionPane.INFORMATION_MESSAGE);
				return;
			}
			else {
				ArrayList<JComboBox> choices= ((CustomizeFighter) jl).choices;
				for(JComboBox x: choices){
					Attack att= (Attack) x.getSelectedItem();
			//		System.out.println("open the gates");
					if(att instanceof SuperSaiyan &&((CustomizeFighter) jl).race!='S'){
						JOptionPane.showMessageDialog(null,"Cannot pick a SuperSaiyan attack for a non-Saiyan fighter", "",JOptionPane.INFORMATION_MESSAGE);
						return;}
						}
			}
			ArrayList<JComboBox> choices= ((CustomizeFighter) jl).choices;
			int ind=player.getFighters().size();
			
			if(((CustomizeFighter) jl).fighter==-1){
				player.createFighter(((CustomizeFighter) jl).race, s);
				
			}
			else
				ind=((CustomizeFighter) jl).fighter;
			
			ArrayList<SuperAttack> superAttack= new ArrayList<SuperAttack>();
			ArrayList<UltimateAttack> ultimateAttack= new ArrayList<UltimateAttack>();
			
			for(JComboBox x: choices){
				Attack att= (Attack) x.getSelectedItem();
				if(!att.getName().equals("No Attack")){
				if(att instanceof UltimateAttack){
					if(!ultimateAttack.contains(att))
						ultimateAttack.add((UltimateAttack) att);
				}
				else
					if(!superAttack.contains(att))
					  superAttack.add((SuperAttack) att);
				}
			}
			PlayableFighter x= player.getFighters().get(ind);
			x.setName(s);
			x.setSuperAttacks(superAttack);
			x.setUltimateAttacks(ultimateAttack);
			WorldMap wm= view.getWm();
			if(wm==null){
				view.loadWorld(player);
			}
			else if(((CustomizeFighter) jl).fighter==-1)
				wm.addFighter(x);
			view.loadWorld(game.getPlayer());
			view.viewWorld();
			
		}else if (jl instanceof chooseFighter2) {
			chooseFighter2 cf = (chooseFighter2) jl;

			if (cf.getOriginal().contains(pressed)) {
				cf.setChosen(true);
				int index = cf.getOriginal().indexOf(pressed);
				cf.setChosenFighter(index);
				pressed.setIcon(cf.getPressed().get(index));
				for (int i = 0; i < cf.getOriginal().size(); i++) {
					if (i == index)
						continue;
					cf.getOriginal().get(i).setIcon(cf.getOrigin().get(i));
				}
			} else if (pressed == cf.getPlay()) {
				if (!cf.isChosen()) {
					
					JOptionPane.showMessageDialog(null,"Choose a fighter!", "",JOptionPane.INFORMATION_MESSAGE);
					
				} else {
					Player y = game.getPlayer();
					
//					y.setSuperAttacks(game.getSuperAttacks());
//					y.setUltimateAttacks(game.getUltimateAttacks());
					int index = cf.getChosenFighter();
					char race='1';
					switch (index) {
					case 0:race='E';break;
					case 1:race='M';break;
					case 2:race='F';break;
					case 3:race='S';break;
					case 4:race='N';break;
					}
					view.customizeFighter(y, race);
				}
			}
		}
		else if(jl instanceof SenzuBeanView){
			view.loadWorld(game.getPlayer());
			view.viewWorld();
		}else if(jl instanceof DragonBallFound){
			view.loadWorld(game.getPlayer());
			view.viewWorld();
			
		}
		else if(jl instanceof UpgradeFighter){
			//healthBar, maxKi,physical,blast,stamina;
			PlayableFighter af= game.getPlayer().getActiveFighter();
			if(pressed==((UpgradeFighter) jl).getHealthBar())
				af.setMaxHealthPoints(af.getMaxHealthPoints()+50);
			else if(pressed==((UpgradeFighter) jl).getPhysical())
				af.setPhysicalDamage(af.getPhysicalDamage()+50);
			else if(pressed==((UpgradeFighter) jl).getBlast())
				af.setBlastDamage(af.getBlastDamage()+50);
			else if(pressed==((UpgradeFighter) jl).getMaxKi())
				af.setMaxKi(af.getMaxKi()+1);
			else
				af.setMaxStamina(af.getMaxStamina()+1);
			af.setAbilityPoints(af.getAbilityPoints()-1);
			view.loadWorld(game.getPlayer());
			view.viewWorld();
		}
		else
			if(jl instanceof BattleView){
				BattleView bv= (BattleView)jl;
				Battle b= bv.getBattle();
				//System.out.println("here we go again");
				if(pressed==bv.getUseBut()){
					
			//		System.out.println(game.getPlayer()==null);
					try {
						b.use(game.getPlayer(), Collectible.SENZU_BEAN);
					} catch (NotEnoughSenzuBeansException e1) {
						JOptionPane.showMessageDialog(null,e1.getMessage(), "Not Enough SenzuBeans",JOptionPane.INFORMATION_MESSAGE);
					}
				}
				else if(pressed==bv.getBlockBut()){
					b.setListener(game);
					b.block();
				}
				else
					if(pressed==bv.getAttackBut()){
					//	System.out.println("you wanna a piece of me");
						Attack x=bv.showAttacks();
						//System.out.println(x);
						try {
							b.setListener(game);
							b.attack(x);
						//	System.out.println("hello I aM BEING ATTACKED Game GUI TRY CATCh");
						} catch (NotEnoughKiException e1) {
							JOptionPane.showMessageDialog(null,e1.getMessage(), "",JOptionPane.INFORMATION_MESSAGE);
							//x=bv.showAttacks();
						}
						
					}
			}else if(jl instanceof sevenDragon){
				view.dragonView(((sevenDragon) jl).getDragon());
			}
			else if(jl instanceof BattleEndView || jl instanceof LostView){
				view.loadWorld(game.getPlayer());
				view.viewWorld();
			}
		
		if (temporary != game.getState()) {
			// NEED TO WORK ON IT
		}
	}

	public DragonBallView getView() {
		return view;
	}

	public void setView(DragonBallView view) {
		this.view = view;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	@Override
	public void onDragonCalled(Dragon dragon) {
		view.collectedseven(dragon);

	}

	@Override
	public void onCollectibleFound(Collectible collectible) {
		if(collectible==Collectible.SENZU_BEAN)
			view.senzuBeanView();
		else
			view.DragonBall();

	}
	

	@Override
	public void onBattleEvent(BattleEvent e) {
			
			if(e.getType()==BattleEventType.STARTED){
				Timer timer = new Timer();
				 
			    TimerTasker1 task = new TimerTasker1(e,view) {
			    	int secondsToWait = 4;
			        
			        public void run() {
			        	
			            secondsToWait--;
			        //    System.out.println("hello");
			        //    System.out.println(secondsToWait);
			      //      lblTimer.setText(secondsToWait + "");
			            if (secondsToWait == 0) {
			                timer.cancel();
			                timer.purge();
			                	view.loadBattle(e, (Battle)e.getSource());
			    			  
			                }
			        }
			    };
			    timer.scheduleAtFixedRate(task, 1000, 1000);

			    lastLevel= game.getPlayer().getActiveFighter().getLevel();
			}
			else if(e.getType()==BattleEventType.ENDED){
				boolean levelup=false;
				boolean boss =false;
				if(game.getPlayer().getActiveFighter().getLevel()>lastLevel)
					levelup=true;
				if(game.getWorld().getPlayerRow()==9 && game.getWorld().getPlayerColumn()==9)
					boss=true;
				view.BattleEnded(game, boss, e.getWinner()==((Battle)(e.getSource())).getMe(), (NonPlayableFighter)(((Battle)(e.getSource())).getFoe()), levelup);
			}
			else
				if(e.getType()==BattleEventType.NEW_TURN){
				//	System.out.println("hello new turn");
					
					//((BattleView)(view.getJl())).start(view);//used to be update
			//	((BattleView)(view.getJl())).changeTurn((Fighter)((Battle)(e.getSource())).getAttacker());
			
				Timer timer = new Timer();
			    TimerTasker task = new TimerTasker(((BattleView)(view.getJl())),(Fighter)((Battle)(e.getSource())).getAttacker()) {
			    	int secondsToWait = 4;
			        
			        public void run() {
			        	
			            secondsToWait--;
			        //    System.out.println(secondsToWait);
			      //      lblTimer.setText(secondsToWait + "");
			            if (secondsToWait == 0) {
			                timer.cancel();
			                timer.purge();
			                if(jl instanceof BattleView){
			                jl.inPeace();
			                ((BattleView)(view.getJl())).changeTurn((Fighter)((Battle)(e.getSource())).getAttacker());
			                }  
			                }
			        }
			    };
			    timer.scheduleAtFixedRate(task, 1000, 1000);

				
				
				
				//	start(view);
				}
				else
					if(e.getType()==BattleEventType.USE){
						BattleView bv=((BattleView)(view.getJl()));
						bv.getAction().setText(((Fighter)(bv.getBattle().getAttacker())).getName()+" just got restored his/her health");
						((BattleView)(view.getJl())).update();
					}
					else if(e.getType()==BattleEventType.ATTACK){
						BattleView bv=((BattleView)(view.getJl()));
						bv.getAction().setText(((Fighter)(bv.getBattle().getAttacker())).getName()+" just attacked with "+ e.getAttack().getName());
					
						((BattleView)(view.getJl())).update();
			//		System.out.println(game.getPlayer().getActiveFighter().getHealthPoints()+" "+game.getPlayer().getActiveFighter().getMaxHealthPoints());
					}
					else if(e.getType()==BattleEventType.BLOCK){
						BattleView bv=((BattleView)(view.getJl()));
						bv.getAction().setText(((Fighter)(bv.getBattle().getAttacker())).getName()+" just blocked");
						((BattleView)(view.getJl())).update();
						//System.out.println(game.getPlayer().getActiveFighter().getHealthPoints()+" "+game.getPlayer().getActiveFighter().getMaxHealthPoints());
						}
		}
	
	
	public void onloading(){
		view= new DragonBallView(this,true);
		view.loadWorld(game.getPlayer());
		view.viewWorld();
	}

	public static void main(String[] args) throws IOException,
			InvalidFormatException {
		GameGUI g = new GameGUI();
	}

	

}

class TimerTasker extends TimerTask{
	BattleView jl;
	Fighter f;
	public TimerTasker(BattleView jl, Fighter f){
		this.jl=jl;
		this.f=f;
	jl.inAction();
	}
	public void run() {
		// TODO Auto-generated method stub
		
	}
	
}

class TimerTasker1 extends TimerTask{
	BattleView jl;
	Fighter f;
	public TimerTasker1( BattleEvent e,DragonBallView db){
		db.transit();
	}
	public void run() {
		// TODO Auto-generated method stub
		
	}
	
}
