import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shin on 2017-06-02.
 */

// Memento Pattern

public class PlayerSnapshot {
    private List<Player> players;
    private List<Player> playersPool;

    PlayerSnapshot() {
        this.playersPool = new ArrayList<Player>();
        this.players = new ArrayList<Player>();
    }

    void copyPlayers(List<Player> players, List<Player> playersPool){
        for(Player player : players) {
            this.players.add(player);
        }

        for(Player player : playersPool) {
            this.playersPool.add(player);
        }
    }

    public List<Player> getPlayers() {
        return players;
    }

    public List<Player> getPlayersPool() {
        return playersPool;
    }
}
