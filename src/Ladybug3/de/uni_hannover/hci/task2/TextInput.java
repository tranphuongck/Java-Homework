package Ladybug3.de.uni_hannover.hci.task2;

import java.util.Scanner;

/**
 * This class handles input from the console.
 * 
 * @author Patric Plattner &lt;patric.plattner@hci.uni-hannover.de&gt;
 * @version 11.05.2021
 */
public class TextInput {
    private static Scanner sc_;

    /**
     * Initializes text input. Has to be called before any other method.
     */
    public static void init() {
        if (TextInput.sc_ == null) TextInput.sc_ = new Scanner(System.in);
    }

    public static String getLine() {
        if (TextInput.sc_.hasNextLine()) {
            return TextInput.sc_.nextLine();
        } else {
            System.err.println("No more line on stdin.");
            System.exit(1);
        }
        // cannot be reached but compiler will not compile if it is not there
        return "";
    }
}
