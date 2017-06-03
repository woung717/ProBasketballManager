/**
 * Created by Shin on 2017-05-26.
 */
public class Condition {
    private boolean available;
    private int healthiness;    // int : 1~10
    private int psychological;  // int : 1~10

    public Condition() {
        this.available = true;
        this.healthiness = RandomGenerator.getRangedRandomInt(10, 15);
        this.psychological = RandomGenerator.getRangedRandomInt(10, 15);
    }

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
        if(healthiness >= 0) this.healthiness = healthiness;
    }

    public int getPsychological() {
        return psychological;
    }

    public void setPsychological(int psychological) {
        if(psychological >= 0) this.psychological = psychological;
    }

}
