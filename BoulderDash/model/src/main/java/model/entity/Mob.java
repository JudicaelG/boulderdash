package model.entity;

import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;

import model.BoulderDashModel;
import model.ImageLoader;
import model.SpriteSheet;

public abstract class Mob extends Alive {
	
	
	

	private Image imgMob;
	private ImageIcon icoMob;
	private int valeurMin = 0;
	private int valeurMax = 4;
	public static BufferedImage[] butterfly, bat, squid, spider, wild_man;
	private static final int SPRITE_SIZE = 16;
	
	//CONSTRUCTOR
	public Mob(BoulderDashModel boulderDashModel, float x, float y, int width, int height) {
		super(boulderDashModel, x, y, width, height);
		// TODO Auto-generated constructor stub
		
		
			SpriteSheet sheet_butterfly = new SpriteSheet(ImageLoader.loadImage("/textures/sprites_butterfly.png")); 
			butterfly = new BufferedImage[1];
			butterfly[0] = sheet_butterfly.crop(SPRITE_SIZE*10,             0, SPRITE_SIZE, SPRITE_SIZE);
			butterfly[1] = sheet_butterfly.crop(SPRITE_SIZE*10,   SPRITE_SIZE, SPRITE_SIZE, SPRITE_SIZE);
			butterfly[2] = sheet_butterfly.crop(SPRITE_SIZE*10, SPRITE_SIZE*2, SPRITE_SIZE, SPRITE_SIZE);
			butterfly[3] = sheet_butterfly.crop(SPRITE_SIZE*10, SPRITE_SIZE*3, SPRITE_SIZE, SPRITE_SIZE);
		
			SpriteSheet sheet_bat = new SpriteSheet(ImageLoader.loadImage("/textures/sprites_bat.png")); 
			bat = new BufferedImage[2];
			bat[0] = sheet_bat.crop(SPRITE_SIZE*10,             0, SPRITE_SIZE, SPRITE_SIZE);
			bat[1] = sheet_bat.crop(SPRITE_SIZE*10,   SPRITE_SIZE, SPRITE_SIZE, SPRITE_SIZE);
			bat[2] = sheet_bat.crop(SPRITE_SIZE*10, SPRITE_SIZE*2, SPRITE_SIZE, SPRITE_SIZE);
			bat[3] = sheet_bat.crop(SPRITE_SIZE*10, SPRITE_SIZE*3, SPRITE_SIZE, SPRITE_SIZE);
			
			SpriteSheet sheet_squid = new SpriteSheet(ImageLoader.loadImage("/textures/sprites_squid.png")); 
			squid = new BufferedImage[3];
			squid[0] = sheet_squid.crop(SPRITE_SIZE*10,SPRITE_SIZE*12, SPRITE_SIZE, SPRITE_SIZE);
			squid[1] = sheet_squid.crop(SPRITE_SIZE*10,SPRITE_SIZE*13, SPRITE_SIZE, SPRITE_SIZE);
			squid[2] = sheet_squid.crop(SPRITE_SIZE*10,SPRITE_SIZE*14, SPRITE_SIZE, SPRITE_SIZE);
			squid[3] = sheet_squid.crop(SPRITE_SIZE*10,SPRITE_SIZE*15, SPRITE_SIZE, SPRITE_SIZE);
			
			SpriteSheet sheet_spider = new SpriteSheet(ImageLoader.loadImage("/textures/sprites_spider.png")); 
			spider = new BufferedImage[1];
			spider[0] = sheet_spider.crop(SPRITE_SIZE*9,SPRITE_SIZE*20, SPRITE_SIZE, SPRITE_SIZE);
			spider[1] = sheet_spider.crop(SPRITE_SIZE*9,SPRITE_SIZE*21, SPRITE_SIZE, SPRITE_SIZE);
			spider[2] = sheet_spider.crop(SPRITE_SIZE*9,SPRITE_SIZE*22, SPRITE_SIZE, SPRITE_SIZE);
			spider[3] = sheet_spider.crop(SPRITE_SIZE*9,SPRITE_SIZE*23, SPRITE_SIZE, SPRITE_SIZE);
			
			SpriteSheet sheet_wild_man = new SpriteSheet(ImageLoader.loadImage("/textures/sprites_wild_man.png")); 
			wild_man = new BufferedImage[1];
			wild_man[0] = sheet_wild_man.crop(SPRITE_SIZE*10,SPRITE_SIZE*16, SPRITE_SIZE, SPRITE_SIZE);
			wild_man[1] = sheet_wild_man.crop(SPRITE_SIZE*10,SPRITE_SIZE*17, SPRITE_SIZE, SPRITE_SIZE);
			wild_man[2] = sheet_wild_man.crop(SPRITE_SIZE*10,SPRITE_SIZE*18, SPRITE_SIZE, SPRITE_SIZE);
			wild_man[3] = sheet_wild_man.crop(SPRITE_SIZE*10,SPRITE_SIZE*19, SPRITE_SIZE, SPRITE_SIZE);
			
	} // POSITION DES ICONES SUR L'ENSEMBLE DES SPRITES
		
	}