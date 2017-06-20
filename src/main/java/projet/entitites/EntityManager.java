package projet.entitites;

import projet.Handler;
import projet.entitites.characters.Player;

import java.awt.*;
import java.util.ArrayList;

public class EntityManager {
// ATTRIBUTES
    private Handler handler;
    private Player player;
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
    public void tick() {
        for (int i = 0; i < entities.size(); i++) {
            Entity e = entities.get(i);
            e.tick();
        }
    }

    public void render(Graphics g) {
        for (Entity e : entities) {
            e.render(g);
        }
    }

    public void addEntity(Entity e) {
        entities.add(e);
    }
}
