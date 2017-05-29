/**
 * Created by Shin on 2017-05-26.
 */
public class Condition {
    private boolean available;
    private int healthiness;    // int : 1~10
    private int psychological;  // int : 1~10

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public int getHealthiness() {
        return healthiness;
    }

    public void setHealthiness(int healthiness) {
        this.healthiness = healthiness;
    }

    public int getPsychological() {
        return psychological;
    }

    public void setPsychological(int psychological) {
        this.psychological = psychological;
    }

}
