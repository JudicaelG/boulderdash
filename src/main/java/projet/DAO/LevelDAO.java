package projet.DAO;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * <h1>The Class LevelDAO.</h1>
 * wich allows you to get the map and the level constraints from the database
 */

public class LevelDAO extends AbstractDAO {

    private static String sqlLevelByID	= "{selectLvl(?)}";

    private static String sqlLevelTime	= "{selectLvlTime(?)}";

    private static String sqlLevelDiamonds	= "{selectLvlDiamonds(?)}";

    private static String sqlLevelHeight	= "{selectLvlHeight(?)}";

    private static String sqlLevelWidth 	= "{selectLvlWidth(?)}";

    public static void ecrire(String nomFic, String texte)
    {
        String adressedufichier = System.getProperty("user.dir") + "/"+ nomFic;

        try
        {
            /**
             * BufferedWriter a besoin d un FileWriter,
             * les 2 vont ensemble, on donne comme argument le nom du fichier
             * true signifie qu on ajoute dans le fichier (append), on ne marque pas par dessus

             */
            FileWriter fw = new FileWriter(adressedufichier, true);

            // le BufferedWriter output auquel on donne comme argument le FileWriter fw cree juste au dessus
            BufferedWriter output = new BufferedWriter(fw);

            //on marque dans le fichier ou plutot dans le BufferedWriter qui sert comme un tampon(stream)
            output.write(texte);
            //on peut utiliser plusieurs fois methode write

            output.flush();
            //ensuite flush envoie dans le fichier, ne pas oublier cette methode pour le BufferedWriter

            output.close();
            //et on le ferme
            System.out.println("fichier créé");
        }
        catch(IOException ioe){
            System.out.print("Erreur : ");
            ioe.printStackTrace();
        }

    }

    /**
     * Gets the level by id.
     *
     * @param id
     *            the id
     * @return the example by id
     * @throws SQLException
     *             the SQL exception
     */
    public static void getLeveltime(final int id) throws SQLException {
        final CallableStatement callStatement = prepareCall(sqlLevelTime);
        callStatement.setInt(1, id);
        if (callStatement.execute()) {
            final ResultSet result = callStatement.getResultSet();
            while(result.next()){
                int i = 1;
                ecrire("D:/_PROJET/BoulderDash/res//worlds/texte.txt", result.getObject(i) + " ");
            }
            result.close();
        }
    }

    /**
     * Gets the level by id.
     *
     * @param id
     *            the id
     * @return the example by id
     * @throws SQLException
     *             the SQL exception
     */
    public static void getLevelDiamonds(final int id) throws SQLException {
        final CallableStatement callStatement = prepareCall(sqlLevelDiamonds);
        callStatement.setInt(1, id);
        if (callStatement.execute()) {
            final ResultSet result = callStatement.getResultSet();
            while(result.next()){
                int i = 1;
                ecrire("D:/_PROJET/BoulderDash/res//worlds/texte.txt", result.getObject(i) + " ");
            }
            result.close();
        }
    }

    /**
     * Gets the level by id.
     *
     * @param id
     *            the id
     * @return the example by id
     * @throws SQLException
     *             the SQL exception
     */
    public static void getLevelHeight(final int id) throws SQLException {
        final CallableStatement callStatement = prepareCall(sqlLevelHeight);
        callStatement.setInt(1, id);
        if (callStatement.execute()) {
            final ResultSet result = callStatement.getResultSet();
            while(result.next()){
                int i = 1;
                ecrire("D:/_PROJET/BoulderDash/res/worlds/texte.txt", result.getObject(i) + "\n144 144\n");
            }
            result.close();
        }
    }

    /**
     * Gets the level by id.
     *
     * @param id
     *            the id
     * @return the example by id
     * @throws SQLException
     *             the SQL exception
     */
    public static void getLevelWidth(final int id) throws SQLException {
        final CallableStatement callStatement = prepareCall(sqlLevelWidth);
        callStatement.setInt(1, id);
        if (callStatement.execute()) {
            final ResultSet result = callStatement.getResultSet();
            while(result.next()){
                int i = 1;
                ecrire("D:/_PROJET/BoulderDash/res/worlds/texte.txt", result.getObject(i) + " ");
            }
            result.close();
        }
    }

    /**
     * Gets the level by id.
     *
     * @param id
     *            the id
     * @return the example by id
     * @throws SQLException
     *             the SQL exception
     */
    public static void getLevelById(final int id) throws SQLException {
        final CallableStatement callStatement = prepareCall(sqlLevelByID);
        callStatement.setInt(1, id);
        if (callStatement.execute()) {
            final ResultSet result = callStatement.getResultSet();
            while(result.next()){
                for(int k=1; k < 39; k++){
                    int i = 1;
                    ecrire("D:/_PROJET/BoulderDash/res//worlds/texte.txt", result.getObject(i) + " ");
                    i++;
                }
            }
            result.close();
        }
    }

    public static void loadLevel(final int level) throws SQLException {
        getLevelWidth(level);
        getLevelHeight(level);
        getLevelById(level);

    }
}