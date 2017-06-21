package projet.view;

import java.awt.image.BufferedImage;

public class Assets {
    // ATTRIBUTES
    private static final int SPRITE_SIZE = 16;

    public static BufferedImage wall, mud, mud_none, diamond1, diamond2, door, weird, wall_special, buzzbuzz, puffpuff, star;
    public static BufferedImage[] rock, player_afk, player_left, player_up, player_right, player_down;

    public static void init() {
        // Decors and Monsters
        SpriteSheet sheet_DecorsMonsters = new SpriteSheet(ImageLoader.loadImage("/textures/sprites_DecorsMonsters.png"));
        wall =          sheet_DecorsMonsters.crop(0,0,SPRITE_SIZE,SPRITE_SIZE);
        mud =           sheet_DecorsMonsters.crop(SPRITE_SIZE,0,SPRITE_SIZE,SPRITE_SIZE);
        mud_none =      sheet_DecorsMonsters.crop(SPRITE_SIZE*2,0,SPRITE_SIZE,SPRITE_SIZE);
        diamond1 =      sheet_DecorsMonsters.crop(SPRITE_SIZE*4,0,SPRITE_SIZE,SPRITE_SIZE);
        diamond2 =      sheet_DecorsMonsters.crop(SPRITE_SIZE*5,0,SPRITE_SIZE,SPRITE_SIZE);
        door =          sheet_DecorsMonsters.crop(SPRITE_SIZE*6,0,SPRITE_SIZE,SPRITE_SIZE);
        weird =         sheet_DecorsMonsters.crop(SPRITE_SIZE*7,0,SPRITE_SIZE,SPRITE_SIZE);
        wall_special =  sheet_DecorsMonsters.crop(SPRITE_SIZE*8,0,SPRITE_SIZE,SPRITE_SIZE);
        buzzbuzz =      sheet_DecorsMonsters.crop(SPRITE_SIZE*9,0,SPRITE_SIZE,SPRITE_SIZE);
        puffpuff =      sheet_DecorsMonsters.crop(SPRITE_SIZE*10,0,SPRITE_SIZE,SPRITE_SIZE);
        star =          sheet_DecorsMonsters.crop(SPRITE_SIZE*11,0,SPRITE_SIZE,SPRITE_SIZE);

        rock = new BufferedImage[4];
        rock[0] = sheet_DecorsMonsters.crop(SPRITE_SIZE*3, 0, SPRITE_SIZE, SPRITE_SIZE);
        rock[1] = sheet_DecorsMonsters.crop(SPRITE_SIZE*3, SPRITE_SIZE, SPRITE_SIZE, SPRITE_SIZE);
        rock[2] = sheet_DecorsMonsters.crop(SPRITE_SIZE*3, SPRITE_SIZE*2, SPRITE_SIZE, SPRITE_SIZE);
        rock[3] = sheet_DecorsMonsters.crop(SPRITE_SIZE*3, SPRITE_SIZE*3, SPRITE_SIZE, SPRITE_SIZE);

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
    }
}
