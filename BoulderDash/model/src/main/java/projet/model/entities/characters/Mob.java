package projet.model.entities.characters;

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
	
	private static final int SPRITE_SIZE = 16;
	
	//CONSTRUCTOR
	public Mob(BoulderDashModel boulderDashModel, float x, float y, int width, int height) {
		super(boulderDashModel, x, y, width, height);
		// TODO Auto-generated constructor stub
		
		
			
	} // POSITION DES ICONES SUR L'ENSEMBLE DES SPRITES
		
	}