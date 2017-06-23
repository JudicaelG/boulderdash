package projet.model;

import java.awt.*;

public abstract class State {
    // CHANGE STATE
    private static State currentState = null;

    public static void setState(State state) {
        currentState = state;
    }

    public static State getState() { return currentState; }

    // METHODS
    protected Game game;

    protected Handler handler;

    public State(Handler handler) {
        this.handler = handler;
    }
    public abstract void tick();
    public abstract void render(Graphics g);
}
