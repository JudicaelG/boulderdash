package projet.game;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Utils {
/**
 * Loads and reads the txt map file
 *
 * @param path The path to the file
 *
 * @return The map to a string
 */
    public static String loadFileAsString(String path) {
        StringBuilder builder = new StringBuilder();

        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            String line;
            while ((line = br.readLine()) != null) { builder.append(line + "\n");}
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return builder.toString();
    }

/**
 * Transforms dynamic in the file by int
 *
 * @param number The character to transform
 *
 * @return The element of the map as a int
 */
    public static int parseInt(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return 0;
        }
    }

}
