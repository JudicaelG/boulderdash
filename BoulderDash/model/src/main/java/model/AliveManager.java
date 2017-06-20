package model;


import java.awt.*;
import java.util.ArrayList;

import model.entity.Alive;
import model.entity.Player;

public class AliveManager {
// ATTRIBUTES
    private BoulderDashModel boulderDashModel;
    private static Player player;
    private ArrayList<Alive> alive;


// GETTERS AND SETTERS
    public BoulderDashModel getHandler() { return boulderDashModel; }
    public void setBoulderDashModel(BoulderDashModel boulderDashModel) { this.boulderDashModel = boulderDashModel; }

    public static Player getPlayer() { return player; }
    public void setPlayer(Player player) { AliveManager.player = player; }

    public ArrayList<Alive> getalive() { return alive; }
    public void setalive(ArrayList<Alive> alive) { this.alive = alive; }


// CONSTRUCTOR
    public AliveManager(BoulderDashModel boulderDashModel, Player player) {
        this.boulderDashModel = boulderDashModel;
        AliveManager.player = player;
        alive = new ArrayList<Alive>();
    }


// METHODS
    public void tick() {
        for (int i = 0; i < alive.size(); i++) {
            Alive e = alive.get(i);
            e.tick();
        }
        player.tick();
    }

    public void render(Graphics g) {
        for (Alive e : alive) {
            e.render(g);
        }
        player.render(g);
    }

    public void addAlive(Alive e) {
        alive.add(e);
    }
}
