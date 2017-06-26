package projet;

import projet.database.DBConnector;
import projet.game.Game;

import java.sql.SQLException;


public class App extends DBConnector
{
    public static void main( String[] args ) throws SQLException, ClassNotFoundException
    {
        int level = 1;
        deleteContent();
        getWidth(level);
        getHeight(level);
        getLevel(level);


        Game game = new Game("Boulder Dash", 768, 768);
        game.start();
    }
}