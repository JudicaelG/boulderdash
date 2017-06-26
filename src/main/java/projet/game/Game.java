package projet.game;

import projet.game.states.GameOverState;
import projet.game.states.GameState;
import projet.game.states.State;
import projet.view.display.*;
import projet.view.Assets;
import projet.view.Camera;
import projet.input.KeyManager;
import projet.entities.Entity;
import projet.entities.dynamic.Player;

import java.awt.*;
import java.awt.image.BufferStrategy;


public class Game implements Runnable {
// ATTRIBUTES
    // base
    private Display display;
    private String title;
    private int width, height;

    private boolean running = false;
    private Thread thread;

    private BufferStrategy bs;
    private Graphics g;

    // States
    private State gameState;

    // Input
    private KeyManager keyManager;

    // Camera
    private Camera camera;

    // Handler
    private Handler handler;
    
    private static long startTime;
    public static long getStartTime(){return startTime;}


// GETTERS AND SETTERS
    public int getWidth() { return width; }
    public int getHeight() { return height; }

    public KeyManager getKeyManager() {
        return keyManager;
    }
    public Camera getCamera() { return camera; }


// CONSTRUCTOR
/**
 * Creates the game and activates keys
 *
 * @param title The title of the window
 *
 * @param width The width of the window
 *
 * @param height The height of the window
 */
    public Game(String title, int width, int height) {
        this.title = title;
        this.width = width;
        this.height = height;
        keyManager = new KeyManager();
    }


// METHODS
/**
 * Initialises the game :
 * Display / KeyManager / Handler / Camera / Game State
 */
    private void init() {
        display = new Display(title, width, height);
        display.getFrame().addKeyListener(keyManager);
        Assets.init();

        handler = new Handler(this);
        camera = new Camera(handler, 0, 0);

        gameState = new GameState(handler);
        State.setState(gameState);
    }

/**
 * Actualizes the game
 */
    private void tick()  {
        keyManager.tick();

        if(State.getState() != null) {
            State.getState().tick(); }
    }


/**
 * Renders the game
 */
    private void render() {
    // buffers
        bs = display.getCanvas().getBufferStrategy();
        if(bs == null) {
            display.getCanvas().createBufferStrategy(3); // makes the main more fluid
            return; }

    // graphics
        g = bs.getDrawGraphics(); // can draw anything
        // clear screen
        g.clearRect(0,0,width,height);

        // draw
        if(State.getState() != null) {
            State.getState().render(g); }

        bs.show(); // displays the buffer
        g.dispose(); // cleans the Frame
    }

/**
 * Runs and stops the game + sets the number of fps (equals to the amount of time the 'tick' and 'render' methods are called per second
 */
    public void run() {
        init();

        int fps = 60; // amount of time the 'tick' and 'render' methods are called per second
        double timePerTick = 1000000000 / fps; // maximum amount of time (in nanoseconds) the 'tick' and 'render' methods are executed
        double delta = 0; // amount of time until we have to call the 'tick' and 'render' methods again
        long now; // current time of the computer
        long lastTime = System.nanoTime(); // return the current time of the computer in nanoseconds
        long timer = 0; // time until 1 second
        int ticks = 0;
        startTime = System.currentTimeMillis()/1000;

        while(running) {
        	Entity.setRemainingTime(Entity.getMaxTime() - (int)(System.currentTimeMillis()/1000 - Game.getStartTime()));
        	//System.out.println(Entity.getRemainingTime());
        	if (Entity.getRemainingTime() < 0){State gameOverState = new GameOverState(handler);State.setState(gameOverState);}
            now = System.nanoTime();
            delta += (now - lastTime) / timePerTick;
            timer += now - lastTime;
            lastTime = now;

            if (delta >= 1) {
                tick();
                render();
                ticks++;
                delta--;
            }
        }
        stop();
    }

/**
 * Starts the game and creates a new Thread
 */
    public synchronized void start() {
        if(running) {return;}
        running = true;
        thread = new Thread(this);
        thread.start();
    }

/**
 * Stops the Thread and the game
 */
    public synchronized void stop() {
        if(!running) {return;}
        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
