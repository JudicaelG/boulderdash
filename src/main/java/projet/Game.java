package projet;

import projet.display.*;
import projet.graphics.Assets;
import projet.graphics.Camera;
import projet.input.KeyManager;
import projet.states.GameState;
import projet.states.State;

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


// GETTERS AND SETTERS
    public int getWidth() { return width; }
    public int getHeight() { return height; }

    public KeyManager getKeyManager() {
        return keyManager;
    }
    public Camera getCamera() { return camera; }


// CONSTRUCTOR
    public Game(String title, int width, int height) {
        this.title = title;
        this.width = width;
        this.height = height;
        keyManager = new KeyManager();
    }


// METHODS
    private void init() {
        display = new Display(title, width, height);
        display.getFrame().addKeyListener(keyManager);
        Assets.init();

        handler = new Handler(this);
        camera = new Camera(handler, 0, 0);

        gameState = new GameState(handler);
        State.setState(gameState);
    }

    private void tick()  {
        keyManager.tick();

        if(State.getState() != null) {
            State.getState().tick(); }
    }

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

    public void run() {
        init();

        int fps = 60; // amount of time the 'tick' and 'render' methods are called per second
        double timePerTick = 1000000000 / fps; // maximum amount of time (in nanoseconds) the 'tick' and 'render' methods are executed
        double delta = 0; // amount of time until we have to call the 'tick' and 'render' methods again
        long now; // current time of the computer
        long lastTime = System.nanoTime(); // return the current time of the computer in nanoseconds
        long timer = 0; // time until 1 second
        int ticks = 0;

        while(running) {
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

    public synchronized void start() {
        if(running) {return;}
        running = true;
        thread = new Thread(this);
        thread.start();
    }

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
