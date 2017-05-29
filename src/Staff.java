/**
 * Created by Shin on 2017-05-26.
 */
public class Staff extends Unit{
    EffectOnPlayer effectOnPlayer;

    public Staff(String name, long salary, EffectOnPlayer effectOnPlayer) {
        super(name, salary);

        this.effectOnPlayer = effectOnPlayer;
    }

    public EffectOnPlayer getEffectOnPlayer() {
        return effectOnPlayer;
    }
}
