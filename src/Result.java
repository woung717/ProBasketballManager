/**
 * Created by Shin on 2017-05-26.
 */
public class Result {
    private int homeScore;
    private int awayScore;

    private long reward;

    public Result(long reward) {
        this.reward = reward;
    }

    public int getHomeScore() {
        return homeScore;
    }

    public void setHomeScore(int homeScore) {
        this.homeScore = homeScore;
    }

    public int getAwayScore() {
        return awayScore;
    }

    public void setAwayScore(int awayScore) {
        this.awayScore = awayScore;
    }

    public long getReward() {
        return reward;
    }
}
