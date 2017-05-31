/**
 * Created by Shin on 2017-05-26.
 */
public class Game {
    private final int CHANCE = 40;

    private String type;
    private Team home;
    private Team away;
    private Result result;

    public Game(String type, Team home, Team way) {
        this.type = type;
        this.result = new Result(((int)(Math.random() * 10) % 7) * 1000000);
    }

    public Result proceedGame() {
        // 각각 40번씩 던지기
        return this.result;
    }

    public void giveReward(Team winner) {
        winner.setCapital(winner.getCapital() + this.result.getReward());
    }

    public void countGame() {
        this.home.setnGame(this.home.getnGame() + 1);
        this.away.setnGame(this.away.getnGame() + 1);
    }
}
