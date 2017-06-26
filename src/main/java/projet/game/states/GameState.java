package projet.game.states;

import projet.game.World;
import projet.game.Handler;

import java.awt.*;

public class GameState extends State{
    // OBJECTS
    private World world;


    // CONSTRUCTOR

    /**
     * Creates the world of the game and initializes the camera
     *
     * @param handler The handler of the game
     */
    public GameState(Handler handler) {
        super(handler);
        world = new World(handler, "D:/_PROJET/BoulderDash/res/worlds/level5.txt");
        handler.setWorld(world);
        handler.getCamera().move(0, 0);
    }


    // METHODS
    @Override
    public void tick() {
        world.tick();
    }


/**
 * Displays the world
 *
 * @param g The Graphics element
 */
    @Override
    public void render(Graphics g) {
        world.render(g);
    }



}
