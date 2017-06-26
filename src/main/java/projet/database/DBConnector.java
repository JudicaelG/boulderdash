package projet.database;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.io.FileReader;

public class DBConnector {

    static String url = "jdbc:mysql://localhost/boulderdash?useSSL=false&serverTimezone=UTC";
    static String login = "root";
    static String password ="";
    static java.sql.Connection cn =null;
    static java.sql.Statement st =null;
    static ResultSet rs= null;

    /**
     * Execute the query.
     *
     * @param level
     *            gets the content of the lvl and writes it to the file
     * @return nothing
     */
    public static void getLevel(int level) throws ClassNotFoundException, SQLException {
        try  {
            Class.forName("com.mysql.jdbc.Driver");

            cn = DriverManager.getConnection(url, login, password);

            st = cn.createStatement();

            String sqlLevelByID	= "{call selectLvl(" + level + ")}";

            rs = st.executeQuery(sqlLevelByID);

            int count =0;
            String retourChariot = System.getProperty("line.separator");

            while (rs.next()) {
                write(rs.getString("ID_Element") + " ");
                count++;
                if(count == 24)
                {
                    write(retourChariot);
                    count = 0;
                }
            }
        }
        finally {

        }
    }
    /**
     * Execute the query.
     *
     * @param level
     *            gets the width of the lvl and writes it to the file
     * @return nothing
     */
    public static void getWidth(int level) throws ClassNotFoundException, SQLException {
        try  {
            Class.forName("com.mysql.jdbc.Driver");

            cn = DriverManager.getConnection(url, login, password);

            st = cn.createStatement();

            String sqlLevelWidth	= "{call selectLvlWidth(" + level + ")}";

            rs = st.executeQuery(sqlLevelWidth);

            while (rs.next()) {
                write(rs.getString("Width_Map") + " ");
            }
        }
        finally {

        }
    }
    /**
     * Execute the query.
     *
     * @param level
     *            gets the height of the lvl and writes it to the file
     * @return nothing
     */
    public static void getHeight(int level) throws ClassNotFoundException, SQLException {
        try  {
            Class.forName("com.mysql.jdbc.Driver");

            cn = DriverManager.getConnection(url, login, password);

            st = cn.createStatement();

            String sqlLevelHeight	= "{call selectLvlHeight(" + level +")}";

            rs = st.executeQuery(sqlLevelHeight);

            String retourChariot = System.getProperty("line.separator");

            while (rs.next()) {
                write(rs.getString("Height_Map") + retourChariot + "576 576" + retourChariot);
            }
        }
        finally {

        }
    }
    /**
     * write in the file used to build lvls
     *
     * @param string that you want to write
     *            the query
     * @return nothing
     */
    public static void write (String string){

        File fichierTexte = new File ("world.txt");

        FileWriter ecrireFichier;

        FileReader lireFichier;


        String petitePhrase = string;

        try{

            lireFichier = new FileReader(fichierTexte);
            String ligne = "";
            int i = 0;

            while((i = lireFichier.read()) != -1){
                ligne += (char)i;
            }

            System.out.println(ligne);


            ecrireFichier = new FileWriter(fichierTexte);

            ecrireFichier.write(ligne + petitePhrase);

            ecrireFichier.close();


        }catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * Delete the content of the file.
     *
     * @param none
     *
     * @return nothing
     */
    public static void deleteContent() {
        try {

            PrintWriter printwriter =

                    new PrintWriter(new FileOutputStream("world.txt"));

            printwriter.println("");



            printwriter.close();

        }

        catch (Exception ex) {

            System.out.println("Error clear file world.txt");

        }
    }
}