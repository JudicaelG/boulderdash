package model;


import java.awt.*;
import java.util.ArrayList;

import javax.swing.text.html.parser.Entity;

import model.entity.Player;

public class AliveManager {
// ATTRIBUTES
    private BoulderDashModel boulderDashModel;
    private Player player;
    private ArrayList<Entity> entities;


// GETTERS AND SETTERS
    public BoulderDashModel getHandler() { return boulderDashModel; }
    public void setHandler(BoulderDashModel boulderDashModel) { this.boulderDashModel = boulderDashModel; }

    public Player getPlayer() { return player; }
    public void setPlayer(Player player) { this.player = player; }

    public ArrayList<Entity> getEntities() { return entities; }
    public void setEntities(ArrayList<Entity> entities) { this.entities = entities; }


// CONSTRUCTOR
    public AliveManager(BoulderDashModel boulderDashModel, Player player) {
        this.boulderDashModel = boulderDashModel;
        this.player = player;
        entities = new ArrayList<Entity>();
    }


// METHODS
    public void tick() {
        for (int i = 0; i < entities.size(); i++) {
            Entity e = entities.get(i);
            e.tick();
        }
        player.tick();
    }

    public void render(Graphics g) {
        for (Entity e : entities) {
            e.render(g);
        }
        player.render(g);
    }

    public void addEntity(Entity e) {
        entities.add(e);
    }
}
