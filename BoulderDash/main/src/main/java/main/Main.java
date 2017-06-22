package main;

import java.sql.SQLException;

import model.Game;
import view.ViewFacade;

/**
 * <h1>The Class Main.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public abstract class Main {

    /**
     * The main method.
     *
     * @param args
     *            the arguments
     */
    public static void main(final String[] args) { 
            Game game = new Game("Boulder Dash", 768, 768);
            game.start();
    }}
