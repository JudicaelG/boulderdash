package view;

import java.awt.image.BufferedImage;

public class Assets {
    // ATTRIBUTES
    private static final int SPRITE_SIZE = 16;

    public static BufferedImage wall, mud, mud_none, door, weird, wall_special, buzzbuzz, puffpuff, star;
    public static BufferedImage[] rock, diamond;
    public static BufferedImage[] butterfly, bat, squid, spider, wild_man;
    public static BufferedImage[] player_afk, player_left, player_up, player_right, player_down;

    public static void init() {
    // Decors and Monsters
        SpriteSheet sheet_DecorsMonsters = new SpriteSheet(ImageLoader.loadImage("/textures/sprites_DecorsMonsters.png"));
        wall =          sheet_DecorsMonsters.crop(0,0,SPRITE_SIZE,SPRITE_SIZE);
        mud =           sheet_DecorsMonsters.crop(SPRITE_SIZE,0,SPRITE_SIZE,SPRITE_SIZE);
        mud_none =      sheet_DecorsMonsters.crop(SPRITE_SIZE*2,0,SPRITE_SIZE,SPRITE_SIZE);
        door =          sheet_DecorsMonsters.crop(SPRITE_SIZE*6,0,SPRITE_SIZE,SPRITE_SIZE);
        weird =         sheet_DecorsMonsters.crop(SPRITE_SIZE*7,0,SPRITE_SIZE,SPRITE_SIZE);
        wall_special =  sheet_DecorsMonsters.crop(SPRITE_SIZE*8,0,SPRITE_SIZE,SPRITE_SIZE);
        buzzbuzz =      sheet_DecorsMonsters.crop(SPRITE_SIZE*9,0,SPRITE_SIZE,SPRITE_SIZE);
        puffpuff =      sheet_DecorsMonsters.crop(SPRITE_SIZE*10,0,SPRITE_SIZE,SPRITE_SIZE);
        star =          sheet_DecorsMonsters.crop(SPRITE_SIZE*11,0,SPRITE_SIZE,SPRITE_SIZE);

        // rock
        rock = new BufferedImage[4];
        rock[0] = sheet_DecorsMonsters.crop(SPRITE_SIZE*3, 0, SPRITE_SIZE, SPRITE_SIZE);
        rock[1] = sheet_DecorsMonsters.crop(SPRITE_SIZE*3, SPRITE_SIZE, SPRITE_SIZE, SPRITE_SIZE);
        rock[2] = sheet_DecorsMonsters.crop(SPRITE_SIZE*3, SPRITE_SIZE*2, SPRITE_SIZE, SPRITE_SIZE);
        rock[3] = sheet_DecorsMonsters.crop(SPRITE_SIZE*3, SPRITE_SIZE*3, SPRITE_SIZE, SPRITE_SIZE);

        // diamond
        diamond = new BufferedImage[4];
        diamond[0] = sheet_DecorsMonsters.crop(SPRITE_SIZE*4, 0, SPRITE_SIZE, SPRITE_SIZE);
        diamond[1] = sheet_DecorsMonsters.crop(SPRITE_SIZE*4, SPRITE_SIZE, SPRITE_SIZE, SPRITE_SIZE);
        diamond[2] = sheet_DecorsMonsters.crop(SPRITE_SIZE*4, SPRITE_SIZE*2, SPRITE_SIZE, SPRITE_SIZE);
        diamond[3] = sheet_DecorsMonsters.crop(SPRITE_SIZE*4, SPRITE_SIZE*3, SPRITE_SIZE, SPRITE_SIZE);


    // Player
        SpriteSheet sheet_Player = new SpriteSheet(ImageLoader.loadImage("/textures/sprites_Player.png"));

        player_afk = new BufferedImage[2];
        player_afk[0] = sheet_Player.crop(0, 0, SPRITE_SIZE, SPRITE_SIZE);
        player_afk[1] = sheet_Player.crop(SPRITE_SIZE, 0, SPRITE_SIZE, SPRITE_SIZE);

        player_left = new BufferedImage[3];
        player_left[0] = sheet_Player.crop(0, SPRITE_SIZE, SPRITE_SIZE, SPRITE_SIZE);
        player_left[1] = sheet_Player.crop(SPRITE_SIZE, SPRITE_SIZE, SPRITE_SIZE, SPRITE_SIZE);
        player_left[2] = sheet_Player.crop(SPRITE_SIZE*2, SPRITE_SIZE, SPRITE_SIZE, SPRITE_SIZE);

        player_up = new BufferedImage[4];
        player_up[0] = sheet_Player.crop(0, SPRITE_SIZE*2, SPRITE_SIZE, SPRITE_SIZE);
        player_up[1] = sheet_Player.crop(SPRITE_SIZE, SPRITE_SIZE*2, SPRITE_SIZE, SPRITE_SIZE);
        player_up[2] = sheet_Player.crop(SPRITE_SIZE*2, SPRITE_SIZE*2, SPRITE_SIZE, SPRITE_SIZE);
        player_up[3] = sheet_Player.crop(SPRITE_SIZE*3, SPRITE_SIZE*2, SPRITE_SIZE, SPRITE_SIZE);

        player_right = new BufferedImage[3];
        player_right[0] = sheet_Player.crop(0, SPRITE_SIZE*3, SPRITE_SIZE, SPRITE_SIZE);
        player_right[1] = sheet_Player.crop(SPRITE_SIZE, SPRITE_SIZE*3, SPRITE_SIZE, SPRITE_SIZE);
        player_right[2] = sheet_Player.crop(SPRITE_SIZE*2, SPRITE_SIZE*3, SPRITE_SIZE, SPRITE_SIZE);

        player_down = new BufferedImage[4];
        player_down[0] = sheet_Player.crop(0, SPRITE_SIZE*4, SPRITE_SIZE, SPRITE_SIZE);
        player_down[1] = sheet_Player.crop(SPRITE_SIZE, SPRITE_SIZE*4, SPRITE_SIZE, SPRITE_SIZE);
        player_down[2] = sheet_Player.crop(SPRITE_SIZE*2, SPRITE_SIZE*4, SPRITE_SIZE, SPRITE_SIZE);
        player_down[3] = sheet_Player.crop(SPRITE_SIZE*3, SPRITE_SIZE*4, SPRITE_SIZE, SPRITE_SIZE);
        
        
        
        SpriteSheet sheet_butterfly = new SpriteSheet(ImageLoader.loadImage("/textures/sprites_DecorsMonsters.png")); 
		butterfly = new BufferedImage[5];
		butterfly[0] = sheet_butterfly.crop(SPRITE_SIZE*10,             0, SPRITE_SIZE, SPRITE_SIZE);
		butterfly[1] = sheet_butterfly.crop(SPRITE_SIZE*10,   SPRITE_SIZE, SPRITE_SIZE, SPRITE_SIZE);
		butterfly[2] = sheet_butterfly.crop(SPRITE_SIZE*10, SPRITE_SIZE*2, SPRITE_SIZE, SPRITE_SIZE);
		butterfly[3] = sheet_butterfly.crop(SPRITE_SIZE*10, SPRITE_SIZE*3, SPRITE_SIZE, SPRITE_SIZE);
	
		SpriteSheet sheet_bat = new SpriteSheet(ImageLoader.loadImage("/textures/sprites_DecorsMonsters.png")); 
		bat = new BufferedImage[6];
		bat[0] = sheet_bat.crop(SPRITE_SIZE*10,             0, SPRITE_SIZE, SPRITE_SIZE);
		bat[1] = sheet_bat.crop(SPRITE_SIZE*10,   SPRITE_SIZE, SPRITE_SIZE, SPRITE_SIZE);
		bat[2] = sheet_bat.crop(SPRITE_SIZE*10, SPRITE_SIZE*2, SPRITE_SIZE, SPRITE_SIZE);
		bat[3] = sheet_bat.crop(SPRITE_SIZE*10, SPRITE_SIZE*3, SPRITE_SIZE, SPRITE_SIZE);
		
		SpriteSheet sheet_squid = new SpriteSheet(ImageLoader.loadImage("/textures/sprites_DecorsMonsters.png")); 
		squid = new BufferedImage[7];
		squid[0] = sheet_squid.crop(SPRITE_SIZE*10,SPRITE_SIZE*12, SPRITE_SIZE, SPRITE_SIZE);
		squid[1] = sheet_squid.crop(SPRITE_SIZE*10,SPRITE_SIZE*13, SPRITE_SIZE, SPRITE_SIZE);
		squid[2] = sheet_squid.crop(SPRITE_SIZE*10,SPRITE_SIZE*14, SPRITE_SIZE, SPRITE_SIZE);
		squid[3] = sheet_squid.crop(SPRITE_SIZE*10,SPRITE_SIZE*15, SPRITE_SIZE, SPRITE_SIZE);
		
		SpriteSheet sheet_spider = new SpriteSheet(ImageLoader.loadImage("/textures/sprites_DecorsMonsters.png")); 
		spider = new BufferedImage[8];
		spider[0] = sheet_spider.crop(SPRITE_SIZE*9,SPRITE_SIZE*20, SPRITE_SIZE, SPRITE_SIZE);
		spider[1] = sheet_spider.crop(SPRITE_SIZE*9,SPRITE_SIZE*21, SPRITE_SIZE, SPRITE_SIZE);
		spider[2] = sheet_spider.crop(SPRITE_SIZE*9,SPRITE_SIZE*22, SPRITE_SIZE, SPRITE_SIZE);
		spider[3] = sheet_spider.crop(SPRITE_SIZE*9,SPRITE_SIZE*23, SPRITE_SIZE, SPRITE_SIZE);
		
		SpriteSheet sheet_wild_man = new SpriteSheet(ImageLoader.loadImage("/textures/sprites_DecorsMonsters.png")); 
		wild_man = new BufferedImage[9];
		wild_man[0] = sheet_wild_man.crop(SPRITE_SIZE*10,SPRITE_SIZE*16, SPRITE_SIZE, SPRITE_SIZE);
		wild_man[1] = sheet_wild_man.crop(SPRITE_SIZE*10,SPRITE_SIZE*17, SPRITE_SIZE, SPRITE_SIZE);
		wild_man[2] = sheet_wild_man.crop(SPRITE_SIZE*10,SPRITE_SIZE*18, SPRITE_SIZE, SPRITE_SIZE);
		wild_man[3] = sheet_wild_man.crop(SPRITE_SIZE*10,SPRITE_SIZE*19, SPRITE_SIZE, SPRITE_SIZE);
    }
}
