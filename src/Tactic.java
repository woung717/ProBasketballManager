/**
 * Created by Shin on 2017-05-26.
 */
public class Tactic {
    private String name;

    private int offence;    // int : 1~5
    private int defence;    // int : 1~5

    public Tactic(String name, int offence, int defence) {
        this.name = name;
        this.offence = offence;
        this.defence = defence;
    }

    public String getName() {
        return name;
    }

    public double getOffence() {
        return offence;
    }

    public double getDefence() {
        return defence;
    }
}
