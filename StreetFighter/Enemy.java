import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Enemy implements GameConstants,EnemyStates {

	public BufferedImage EnemySprite;
	public BufferedImage defaultKen[];
	public int defaultKenIndex;
	public int defaultKenpass;
	public int w=120;
	public int h =200;
	public int health=100;
	public int floor = GAME_HEIGHT - 50;
	public int y =floor-h;
	public int x =700;
	public int force =-20;
	public int GRAVITY =1;
	public int xSPEED;
	public int SPEED=10;
	public boolean isPunched;
	public boolean isJump;
	public int PunchEffectIndex=0;
	public int PunchEffectTimePass=0;
//	public BufferedImage EnemySprite;
	public BufferedImage jump[];
	public BufferedImage punch[];
	public BufferedImage kick[];
	public BufferedImage punchEffect[];
	public int defaultTimePass;
	public int  jumpIndex =0;
	public int getState() {
		return State;
	}

	public void setState(int state) {
		State = state;
	}


	public int jumpTimePass =0;
	public int  punchIndex =0;
	public int punchTimePass =0;
	public int kickIndex=0;
	public int kickTimePass=0;
	public int State = DEFAULT;
	public boolean isKicked;
//	public int  GRAVITY =1;
//	public boolean  isJump =false;
	public Enemy() {
		loadSprite();
		defaultKen = DefaultKen();
		jump = jumpLoad();
		punch = punchLoad();
		punchEffect=loadPunchEffectOnPlayer();
		kick = kickLoad();
	    defaultKenIndex =0;
	    defaultKenpass=0;
	}
	
	
	public BufferedImage[] loadPunchEffectOnPlayer() {
		BufferedImage punchEffect[] = new BufferedImage[3];
		punchEffect[0] = EnemySprite.getSubimage(446, 317, 73, 80);
		punchEffect[1] = EnemySprite.getSubimage(748, 325, 43, 68);
		punchEffect[2] = EnemySprite.getSubimage(556, 334, 100, 46);
		return punchEffect;
	}

	
	public void DrawScore(Graphics g) {
		g.setFont(new Font("Arial",Font.BOLD,45));
		g.setColor(Color.MAGENTA);
		g.drawString(Integer.toString(health),x, y);
		
	}
	
	public void punchEffectOnPlayer(Graphics g) {
		if(PunchEffectIndex>loadPunchEffectOnPlayer().length-1) {
			PunchEffectIndex=0;
			State = DEFAULT;
			isPunched =false;
			isKicked = false;
		}
		else {
			g.drawImage(punchEffect[PunchEffectIndex],x,y , w, h,null);
		PunchEffectTimePass++;
			if(PunchEffectTimePass==8) {
				PunchEffectIndex++;
				PunchEffectTimePass=0;
			}
		}
	}
	public BufferedImage[] DefaultKen() {
		BufferedImage arr[] = new BufferedImage[11];
		arr[0] = EnemySprite.getSubimage(0, 105, 77, 92);
		arr[1] = EnemySprite.getSubimage(82, 107, 78, 89);
		arr[2] = EnemySprite.getSubimage(164, 106, 63, 88);
		arr[3] = EnemySprite.getSubimage(232, 106, 59, 90);
		arr[4] = EnemySprite.getSubimage(305, 104, 56, 94);
		arr[5] = EnemySprite.getSubimage(374, 107, 52, 91);
		arr[6] = EnemySprite.getSubimage(435, 108, 57, 91);
		arr[7] = EnemySprite.getSubimage(499, 105, 68, 92);
		arr[8] = EnemySprite.getSubimage(570, 105, 77, 91);
		arr[9] = EnemySprite.getSubimage(647, 107, 79, 89);
		arr[10] = EnemySprite.getSubimage(727, 110, 79, 90);
        return arr;
	}
	
	public void drawKen(Graphics g) {
		if(defaultKenIndex>DefaultKen().length-1) {
			defaultKenIndex =0;
		}
		else {
			
			g.drawImage(defaultKen[defaultKenIndex], x, y, w, h, null);
			defaultKenpass++;
			if(defaultKenpass==6) {
				defaultKenIndex++;
				defaultKenpass=0;
			}
			
		}
	}
	
	
	public void loadSprite() {
		try {
			EnemySprite = ImageIO.read(Enemy.class.getResource("ken1.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
}
	

public void jumpEffect(Graphics g) {
	if(jumpIndex>jumpLoad().length-1) {
		jumpIndex=0;
		State = DEFAULT;
	}
	else {
		g.drawImage(jump[jumpIndex],x,y , w, h,null);
	jumpTimePass++;
	
		if(jumpTimePass==3) {
			jumpIndex++;
			jumpTimePass=0;
		}
	}
}
public void punchEffect(Graphics g) {
	if(punchIndex>punchLoad().length-1) {
		punchIndex=0;
//		isPunched = false;
		State = DEFAULT;
	}
	else {
		g.drawImage(punch[punchIndex],x,y , w+20, h,null);
	punchTimePass++;
		if(punchTimePass==6) {
			punchIndex++;
			punchTimePass=0;
		}
	}
}

public void kickEffect(Graphics g) {
	if(kickIndex>kickLoad().length-1) {
		kickIndex=0;
//		isKicked =false;
		State = DEFAULT;
	}
	else {
		g.drawImage(kick[kickIndex],x,y , w+20, h,null);
	kickTimePass++;
		if(kickTimePass==4) {
			kickIndex++;
			kickTimePass=0;
		}
	}
}


public BufferedImage[] jumpLoad() {
	BufferedImage jump[] = new BufferedImage[11];
	jump[0] =EnemySprite.getSubimage(17, 512, 61, 108);
	jump[1] =EnemySprite.getSubimage(93, 510, 62, 110);
	jump[2] =EnemySprite.getSubimage(169, 528, 58, 90);
	jump[3] =EnemySprite.getSubimage(234, 531, 57, 81);
	jump[4] =EnemySprite.getSubimage(304, 533, 62, 72);
	jump[5] =EnemySprite.getSubimage(385, 538, 61, 70);
	jump[6] =EnemySprite.getSubimage(455, 538, 61, 73);
	jump[7] =EnemySprite.getSubimage(525, 539, 59, 84);
	jump[8] =EnemySprite.getSubimage(594, 532, 61, 96);
	jump[9] =EnemySprite.getSubimage(665, 528, 58, 102);
	jump[10] =EnemySprite.getSubimage(732, 527, 60, 105);
	return jump;
}
public void jump() {
	
	if(!isJump) {
		y += force;
		isJump = true;
	}
}
public void fall() {
	
	if(y<floor-h) {
		force += GRAVITY;
		y+=force;
	}
	else if(y>=floor-h) {
		isJump=false;
		y=floor-h;
		force =-20;

	}
}



public void moveLeft() {
	xSPEED = -SPEED;
	
}
public void moveRight() {
	xSPEED = SPEED;
}
public void move() {
	x+=xSPEED;
}

public void stop() {
	xSPEED=0;
}


public BufferedImage[] punchLoad() {
	BufferedImage punch[] = new BufferedImage[3];
	punch[0] = EnemySprite.getSubimage(532, 439, 49, 70);
	punch[1] = EnemySprite.getSubimage(603, 436, 48, 72);
	punch[2] = EnemySprite.getSubimage(679, 436, 44, 72);
	return punch;
}

public BufferedImage[] kickLoad() {
	BufferedImage kick[] = new BufferedImage[5];
	kick[0] = EnemySprite.getSubimage(359, 643, 38, 90);
	kick[1] = EnemySprite.getSubimage(420, 642, 38, 91);
	kick[2] = EnemySprite.getSubimage(468, 639, 61, 95);
	kick[3] = EnemySprite.getSubimage(538, 642, 38, 92);
	kick[4] = EnemySprite.getSubimage(359, 643, 38, 90);
	return kick;
}


public void DrawOnState(Graphics g) {
	DrawScore(g);
if(State==DEFAULT) 
{
drawKen(g);

}	
else if(State == JUMP) {
jumpEffect(g);
}
else if(State == PUNCH) {
punchEffect(g);
}
else if(State == KICK) {
 kickEffect(g); 
}
else if(State == PUNCHED) {
	punchEffectOnPlayer(g);
}
}
}

