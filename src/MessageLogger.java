import java.awt.*;

/**
 * Created by Shin on 2017-05-31.
 */

// Observer Pattern

// Observer Class
// *Single Observer Multiple Source

public class MessageLogger {
    private TextField tf;

    public MessageLogger(TextField textField) {
        this.tf = textField;
    }

    public void setMessage(String msg) {
        if(msg != null)
            this.tf.setText(msg);
    }

    public void addMessage(String msg) {
        if(msg != null)
            this.tf.setText(this.tf.getText() + "\n" + msg);
    }

    public void clearMessage() {
        this.tf.setText("");
    }
}
