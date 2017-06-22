package projet;

import projet.model.Game;

public class App
{
    public static void main( String[] args )
    {
        Game game = new Game("Boulder Dash", 768, 768);
        game.start();
    }
}
