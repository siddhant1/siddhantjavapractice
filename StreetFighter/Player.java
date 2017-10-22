import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;


public class Player implements GameConstants,GameStates {

	
	public int w=80;
	public int h =100;
	public int floor = GAME_HEIGHT - 50;
	public int force;
	public int xSPEED;
	public int SPEED=10;
	public int  defaultIndex =0;
	public BufferedImage defaultImage[] ;
	public BufferedImage spriteSheet;
	public BufferedImage jump[];
	public BufferedImage punch[];
	public BufferedImage kick[];
	public BufferedImage punchEffect[];
	public boolean isVisible;
	public int defaultTimePass;
	public int  jumpIndex =0;
	public int jumpTimePass =0;
	public int  punchIndex =0;
	public int punchTimePass =0;
	public int kickIndex=0;
	public int kickTimePass=0;
	public int PunchEffectIndex=0;
	public int PunchEffectTimePass=0;
	public int PunchEffectIndex1=0;
	public int PunchEffectTimePass1=0;
	public int y ;
	int counter =0;
	public int State = DEFAULT;
	public int x =200;
	public int  GRAVITY =1;
	public boolean  isJump =false;
	public Player() {
		isVisible =true;
		y=floor-h;
		force =-20;
		loadSprite();
		defaultImage = defaultImages();
		jump = jumpLoad();
		punch = punchLoad();
		kick = kickLoad();
		punchEffect = loadPunchEffectOnPlayer();
		
	}
	
	public BufferedImage[] loadPunchEffectOnPlayer() {
		BufferedImage punchEffect[] = new BufferedImage[3];
		punchEffect[0] = spriteSheet.getSubimage(370, 788, 52, 66);
		punchEffect[1] = spriteSheet.getSubimage(440, 794, 79, 49);
		punchEffect[2] = spriteSheet.getSubimage(534, 811, 92, 32);
		return punchEffect;
	}

	public void punchEffectOnPlayer(Graphics g) {
		if(PunchEffectIndex>loadPunchEffectOnPlayer().length-1) {
			PunchEffectIndex=0;
			State = DEFAULT;
		}
		else {
			g.drawImage(punchEffect[PunchEffectIndex],x,y , w, h,null);
		PunchEffectTimePass++;
			if(PunchEffectTimePass==5) {
				PunchEffectIndex++;
				PunchEffectTimePass=0;
			}
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
			if(jumpTimePass==6) {
				jumpIndex++;
				jumpTimePass=0;
			}
		}
	}
	public void punchEffect(Graphics g) {
		if(punchIndex>punchLoad().length-1) {
			punchIndex=0;
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
		BufferedImage jump[] = new BufferedImage[5];
		jump[0] =spriteSheet.getSubimage(681, 0, 36, 90);
		jump[1] =spriteSheet.getSubimage(742, 13, 32, 75);
		jump[2] =spriteSheet.getSubimage(794, 23, 35, 70);
		jump[3] =spriteSheet.getSubimage(847, 10, 34, 81);
		jump[4] =spriteSheet.getSubimage(901, 0, 37, 90);
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
//			State = DEFAULT;

		}
	}

	
	
	public void moveLeft() {
		xSPEED = SPEED;
		
	}
	public void moveRight() {
		xSPEED = -SPEED;
	}
	public void move() {
		x+=xSPEED;
	}
	
	public void stop() {
		xSPEED=0;
	}
	public void playerDefaultState(Graphics g) {
		if(defaultIndex>defaultImage.length-1) {
			defaultIndex=0;
		}
		else {
		g.drawImage(defaultImage[defaultIndex],x,y , w, h, null);
		defaultTimePass++;
		if(defaultTimePass==6) {
			defaultIndex++;
			defaultTimePass=0;
			
		}
		
		}
	}
	
	public BufferedImage[] defaultImages() {
		
		BufferedImage arr[] = new BufferedImage[5];
		arr[0] = spriteSheet.getSubimage(5, 113, 32, 77);
		arr[1] = spriteSheet.getSubimage(72, 108, 39, 88);
		arr[2] = spriteSheet.getSubimage(132, 108, 43, 83);
		arr[3] = spriteSheet.getSubimage(202, 108, 35, 81);
		arr[4] = spriteSheet.getSubimage(265, 109, 36, 80);
		return arr;
	}
	public BufferedImage[] punchLoad() {
		BufferedImage punch[] = new BufferedImage[3];
		punch[0] = spriteSheet.getSubimage(4, 207, 38, 82);
		punch[1] = spriteSheet.getSubimage(61, 206, 58, 84);
		punch[2] = spriteSheet.getSubimage(4, 207, 38, 82);
		return punch;
	}
	
	public BufferedImage[] kickLoad() {
		BufferedImage kick[] = new BufferedImage[4];
		kick[0] = spriteSheet.getSubimage(5, 310, 39, 85);
		kick[1] = spriteSheet.getSubimage(68, 308, 41, 86);
		kick[2] = spriteSheet.getSubimage(133, 304, 68, 90);
		kick[3] = spriteSheet.getSubimage(225, 306, 42, 90);
		return kick;
	}
	
	public void loadSprite() {
		try {
			spriteSheet = ImageIO.read(Player.class.getResource("RyuGBA.gif"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

public void DrawOnState(Graphics g) {
if(State==DEFAULT) {
	playerDefaultState(g);
	
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
}


public int getState() {
	return State;
}

public void setState(int state) {
	State = state;
}
}