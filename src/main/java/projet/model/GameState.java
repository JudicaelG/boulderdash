package projet.model;

import java.awt.*;

public class GameState extends State{
    // OBJECTS
    private World world;


    // CONSTRUCTOR
    public GameState(Handler handler) {
        super(handler);
        world = new World(handler, "res/worlds/niveau2.txt");
        handler.setWorld(world);
        handler.getCamera().move(0, 0);
    }


    // METHODS
    @Override
    public void tick() {
        world.tick();
        //handler.getCamera().move(1, 1);
    }

    @Override
    public void render(Graphics g) {
        world.render(g);
    }
}
