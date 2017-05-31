import javafx.util.Pair;

import java.util.concurrent.TimeUnit;

/**
 * Created by Shin on 2017-05-26.
 */
public class Game implements Loggable {
    MessageLogger logger;

    private boolean verbose;

    private String type;
    private Team home;
    private Team away;
    private Result result;

    public Game(String type, Team home, Team way) {
        this.verbose = true;
        this.type = type;
        this.result = new Result(((int)(Math.random() * 10) % 7) * 1000000);
    }

    public void proceedGame() {
        this.countGame();
        this.playPhase();
        this.endGame();
    }

    public void playPhase() {
        // 각각 40번씩 던지기
        try {
            for(int i = 0; i < 8; i++) {
                for(int j = 0; j < this.home.getPlayers().size() && j < this.away.getPlayers().size(); j++) {
                    result.setHomeScore(result.getHomeScore() + this.home.getPlayers().get(j).shoot(this.verbose));
                    Thread.sleep(10);
                    result.setAwayScore(result.getAwayScore() + this.away.getPlayers().get(j).shoot(this.verbose));
                    Thread.sleep(10);
                }
            }
        } catch(Exception e) { ; }
    }

    public void endGame() {
        Team winner = this.getWinner();

        this.sendMessage("The Game is end.");
        this.sendMessage("Score (Home - Away) : " +
                String.valueOf(this.result.getHomeScore()) + " - " + String.valueOf(this.result.getHomeScore()));
        this.sendMessage("Winner is " + winner.getName());

        if(winner != null) {
            this.giveReward(winner);
        }
    }

    public Team getWinner() {
        if(this.result.getHomeScore() == this.result.getHomeScore()) {
            return null;
        } else {
            return (this.result.getHomeScore() > this.result.getAwayScore()) ? this.home : this.away;
        }
    }

    public void giveReward(Team winner) {
        winner.setVictory(winner.getVictory() + 1);
        winner.setCapital(winner.getCapital() + this.result.getReward());
    }

    public void countGame() {
        this.home.setnGame(this.home.getnGame() + 1);
        this.away.setnGame(this.away.getnGame() + 1);
    }

    @Override
    public void setLogger(Object o) {
        if(o instanceof MessageLogger) {
            this.logger = (MessageLogger) o;
        }
    }

    @Override
    public void sendMessage(String msg) {
        this.logger.addMessage(msg);
    }
}
