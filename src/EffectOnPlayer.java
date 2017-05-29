/**
 * Created by Shin on 2017-05-26.
 */
public class EffectOnPlayer {
    private int effectOnHealthiness;
    private int effectOnPsychological;
    private boolean avail;

    public EffectOnPlayer(int effectOnHealthiness, int effectOnPsychological, boolean avail) {
        this.effectOnHealthiness = effectOnHealthiness;
        this.effectOnPsychological = effectOnPsychological;
        this.avail = avail;
    }

    public int getEffectOnHealthiness() {
        return this.effectOnHealthiness;
    }

    public int getEffectOnPsychological() {
        return this.effectOnPsychological;
    }

    public void affectHealthiness(Condition cond) {
        cond.setHealthiness(cond.getHealthiness() + this.effectOnHealthiness);
    }

    public void affectHealthiness(Condition cond, int sign) {
        cond.setHealthiness(cond.getHealthiness() + (sign * this.effectOnHealthiness));
    }

    public void affectPsychological(Condition cond) {
        cond.setPsychological(cond.getPsychological() + this.effectOnPsychological);
    }

    public void affectPsychological(Condition cond, int sign) {
        cond.setPsychological(cond.getPsychological() + (sign * this.effectOnPsychological));
    }

    public void affectPlayerAvailability(Condition cond) {
        cond.setAvailable(this.avail);
    }
}
