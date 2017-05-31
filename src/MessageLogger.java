import java.awt.*;
import java.io.IOException;

/**
 * Created by Shin on 2017-05-31.
 */

// Observer Pattern

// Observer Class
// *Single Observer Multiple Source

public class MessageLogger {
    public void addMessage(String msg) {
        System.out.println(msg);
    }

    public void clearMessage() {
        try {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                Runtime.getRuntime().exec("clear");
        } catch (IOException | InterruptedException e) { ; }
    }
}
