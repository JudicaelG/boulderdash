package projet.entities;

import projet.entities.dynamic.Player;
import projet.game.Handler;

import java.awt.*;
import java.util.ArrayList;

public class EntityManager {
// ATTRIBUTES
    private Handler handler;

/**
 * The player entity
 */
    private Player player;

/**
 * The arraylist where are stocked every entities in the world
 */
    private ArrayList<Entity> entities;

// GETTERS AND SETTERS
    public Handler getHandler() { return handler; }
    public void setHandler(Handler handler) { this.handler = handler; }

    public Player getPlayer() { return player; }
    public void setPlayer(Player player) { this.player = player; }

    public ArrayList<Entity> getEntities() { return entities; }
    public void setEntities(ArrayList<Entity> entities) { this.entities = entities; }


// CONSTRUCTOR
    public EntityManager(Handler handler, Player player) {
        this.handler = handler;
        this.player = player;
        entities = new ArrayList<Entity>();
        addEntity(player);
    }


// METHODS
/**
 * Actualizes every entities and deletes theme if they are no longer active
 */
    public void tick() {
        for (int i = 0; i < entities.size(); i++) {
            Entity e = entities.get(i);
            e.tick();
            if(!e.isActive()) {
                //Entity oldE = e;
                float x = e.getX();
                float y = e.getY();
                entities.remove(e);
                //entities.set(i, new MudNone(handler, x, y));
                //entities.remove(oldE);
            }
        }
    }

/**
 * Renders every entities and then the player to display it over the other entities
 *
 * @param g The Graphics element
 */
    public void render(Graphics g) {
        for (Entity e : entities) {
            e.render(g);
        }
        player.render(g);
    }

/**
 * Adds an entity to the arraylist that contains every entities
 *
 * @param e The entity that has to be added
 */
    public void addEntity(Entity e) {
        entities.add(e);
    }
}
