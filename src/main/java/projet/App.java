package projet;

import projet.game.Game;

public class App
{
    public static void main( String[] args )
    {
        /*try {
            loadLevel(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }*/
        Game game = new Game("Boulder Dash", 768, 768);
        game.start();
    }
}
