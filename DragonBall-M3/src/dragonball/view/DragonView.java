package dragonball.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import dragonball.model.dragon.Dragon;
import dragonball.model.dragon.DragonWish;
import dragonball.model.dragon.DragonWishType;


public class DragonView extends JLabel{
	Dragon dragon;
	DragonBallView jf;
	int width;
	int height;
	JButton [] buttons;
	
	public DragonView(Dragon dragon, DragonBallView jf){
		this.dragon=dragon;
		this.jf= jf;
		width= jf.getWidth();
		height= jf.getHeight();
		ImageIcon back;
		buttons= new JButton[4];
		
		if(dragon.getName().equals("Shenron")){
			viewShenron();	
			back= new ImageIcon(Toolkit.getDefaultToolkit().getImage("shenronBackground.png").getScaledInstance(width,height, java.awt.Image.SCALE_SMOOTH));
		}
		else if(dragon.getName().equals("Porunga")){
			viewPorunga();
			back= new ImageIcon(Toolkit.getDefaultToolkit().getImage("porungaBack.png").getScaledInstance(width,height, java.awt.Image.SCALE_SMOOTH));
		}
		else
		{
			viewDragon();
			back= new ImageIcon(Toolkit.getDefaultToolkit().getImage("shenronBackground.png").getScaledInstance(width,height, java.awt.Image.SCALE_SMOOTH));
			
		}
		JLabel background= new JLabel(back);
		add(background);
		background.setBounds(0,0,width,height);
		
	}
	
	private void viewDragon() {
		
		Font font= new Font(Font.MONOSPACED, Font.CENTER_BASELINE, 90);
		
		DragonWish [] wish=dragon.getWishes();
		int len= wish.length;
		for(int i=0; i<len; i++){
		
			if(wish[i].getType()==DragonWishType.ABILITY_POINTS){
				JButton ab=new JButton(dragon.getAbilityPoints()+" Ability Points");
				ab.setFont(font);
				ab.setForeground(Color.WHITE);
				ab.setBounds(0,0,(int)(width*0.5),(int)(height*0.5));
				ab.setContentAreaFilled(false);
				add(ab);
				buttons[0]=ab;
			}
			else if(wish[i].getType()==DragonWishType.SENZU_BEANS){
			
				JButton sn=new JButton(dragon.getSenzuBeans()+" Senzu Beans");
				sn.setFont(font);
				sn.setForeground(Color.WHITE);
				sn.setBounds((int)(width*0.5),0,(int)(width*0.5),(int)(height*0.5));
				sn.setContentAreaFilled(false);
				add(sn);
				buttons[1]=sn;
			}
			
			else if(wish[i].getType()==DragonWishType.ULTIMATE_ATTACK){
				JButton ua=new JButton("Ultimate Attack");
				ua.setFont(font);
				ua.setForeground(Color.WHITE);
				ua.setBounds((int)(width*0.5),(int)(height*0.5),(int)(width*0.5),(int)(height*0.5));
				ua.setContentAreaFilled(false);
				add(ua);
				buttons[2]=ua;
			}else{
				JButton sa=new JButton("Super Attack");
				sa.setFont(font);
				sa.setForeground(Color.WHITE);
				sa.setBounds(0,(int)(height*0.5),(int)(width*0.5),(int)(height*0.5));
				sa.setContentAreaFilled(false);
				add(sa);
				buttons[3]=sa;
			}
		}
	}

	public void viewShenron(){
		
		ImageIcon ability= new ImageIcon(Toolkit.getDefaultToolkit().getImage("ability_points.png").getScaledInstance((int)(width*0.5), (int)(height*0.5), java.awt.Image.SCALE_SMOOTH));
		JButton ab=new JButton(ability);
		ab.setBounds(0,0,(int)(width*0.5),(int)(height*0.5));
		ab.setContentAreaFilled(false);
		add(ab);
		buttons[0]= ab;
		
		
		ImageIcon senzu= new ImageIcon(Toolkit.getDefaultToolkit().getImage("senzuShenron.png").getScaledInstance((int)(width*0.5), (int)(height*0.5), java.awt.Image.SCALE_SMOOTH));
		JButton sn=new JButton(senzu);
		sn.setBounds((int)(width*0.5),0,(int)(width*0.5),(int)(height*0.5));
		sn.setContentAreaFilled(false);
		add(sn);
		buttons[1]=sn;
		
		
		ImageIcon ultimate= new ImageIcon(Toolkit.getDefaultToolkit().getImage("ultimateAttack.png").getScaledInstance((int)(width*0.5), (int)(height*0.5), java.awt.Image.SCALE_SMOOTH));
		JButton ua=new JButton(ultimate);
		ua.setBounds((int)(width*0.5),(int)(height*0.5),(int)(width*0.5),(int)(height*0.5));
		ua.setContentAreaFilled(false);
		add(ua);
		buttons[2]=ua;
		
		ImageIcon superattack= new ImageIcon(Toolkit.getDefaultToolkit().getImage("superAttack.png").getScaledInstance((int)(width*0.5), (int)(height*0.5), java.awt.Image.SCALE_SMOOTH));
		JButton sa=new JButton(superattack);
		sa.setBounds(0,(int)(height*0.5),(int)(width*0.5),(int)(height*0.5));
		sa.setContentAreaFilled(false);
		add(sa);
		buttons[3]=sa;
	}
	
	public void viewPorunga(){
		
		ImageIcon ability= new ImageIcon(Toolkit.getDefaultToolkit().getImage("ability_pointsPor.png").getScaledInstance((int)(width*0.5), (int)(height*0.5), java.awt.Image.SCALE_SMOOTH));
		JButton ab=new JButton(ability);
		ab.setBounds(0,0,(int)(width*0.5),(int)(height*0.5));
		ab.setContentAreaFilled(false);
		add(ab);
		buttons[0]=ab;
		
		
		ImageIcon senzu= new ImageIcon(Toolkit.getDefaultToolkit().getImage("senzuPor.png").getScaledInstance((int)(width*0.5), (int)(height*0.5), java.awt.Image.SCALE_SMOOTH));
		JButton sn=new JButton(senzu);
		sn.setBounds((int)(width*0.5),0,(int)(width*0.5),(int)(height*0.5));
		sn.setContentAreaFilled(false);
		add(sn);
		buttons[1]=sn;
		
		ImageIcon ultimate= new ImageIcon(Toolkit.getDefaultToolkit().getImage("ultimateAttack.png").getScaledInstance((int)(width*0.5), (int)(height*0.5), java.awt.Image.SCALE_SMOOTH));
		JButton ua=new JButton(ultimate);
		ua.setBounds((int)(width*0.5),(int)(height*0.5),(int)(width*0.5),(int)(height*0.5));
		ua.setContentAreaFilled(false);
		add(ua);
		buttons[2]=ua;
		
		ImageIcon superattack= new ImageIcon(Toolkit.getDefaultToolkit().getImage("superAttack.png").getScaledInstance((int)(width*0.5), (int)(height*0.5), java.awt.Image.SCALE_SMOOTH));
		JButton sa=new JButton(superattack);
		sa.setBounds(0,(int)(height*0.5),(int)(width*0.5),(int)(height*0.5));
		sa.setContentAreaFilled(false);
		add(sa);
		buttons[3]=sa;
	}
	
	public Dragon getDragon() {
		return dragon;
	}

	public void setDragon(Dragon dragon) {
		this.dragon = dragon;
	}

	public DragonBallView getJf() {
		return jf;
	}

	public void setJf(DragonBallView jf) {
		this.jf = jf;
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

	public JButton[] getButtons() {
		return buttons;
	}

	public void setButtons(JButton[] buttons) {
		this.buttons = buttons;
	}

	public static void main(String[] args) {
		//DragonBallView jf=new DragonBallView();
		
		//jf.pack();
		//jf.setSize(jf.getMaximumSize());
		//Image icon = Toolkit.getDefaultToolkit().getImage("images.png");
		//jf.setIconImage(icon);
		//Dragon dragon= new Dragon("Porunga",null,null,0,0);
		//DragonView dv= new DragonView(dragon,jf);
		//jf.add(dv);
		//jf.setVisible(true);
	}
	

}
