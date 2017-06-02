import com.sun.xml.internal.bind.v2.runtime.unmarshaller.LocatorEx;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private final int MAX_STAFF = 3;

    private String name;
    private String city;
    private String league;

    private Director director;
    private List<Staff> staffPool;
    private List<Staff> staffs;
    private List<Player> playersPool;
    private List<Player> players;

    private Tactic tactic;

    private long capital;
    private int victory;
    private int nGame;

    public Team(String name, String city, String league) {
        this.name = name;
        this.city = city;
        this.league = league;

        this.director = null;
        this.staffPool = new ArrayList<Staff>();
        this.staffs = new ArrayList<Staff>();
        this.playersPool = new ArrayList<Player>();
        this.players = new ArrayList<Player>();

        this.capital = 0;
        this.victory = 0;
        this.nGame = 0;
    }

    public boolean isAllPlayerAvailable() {
        for(Player player : this.playersPool) {
            if(!player.getCondition().isAvailable()) return false;
        }

        return true;
    }

    public void setAllBenchAvailable() {
        for(Player player : this.playersPool) {
            player.getCondition().setAvailable(true);
        }
    }

    public boolean hasAllPosition() {
        // this.players 들의 선수들이 "Center", "Forward", "Guard"를 다 포함하고 있는가
        List<String> position = new ArrayList<>();
        position.add(new String("Center"));
        position.add(new String("Forward"));
        position.add(new String("Guard"));

        for(int i = 0; i < this.players.size(); i++){
            position.remove(this.players.get(i).getPosition());

            if(position.isEmpty()){
                return true;
            }
        }

        return false;
    }

    public boolean changePlayer(int in, int out) {
        // this.playerPool의 in 번째 선수를 this.players의 out번째 선수와 교체
        // 선수를 바꿨을때 hasAllPosition 이 성립하는가?

        if(in >= this.playersPool.size() || out >= this.players.size()) return false;

        PlayerSnapshot snapshot = this.createPlayerSnapShot();

        Player inPlayer = this.playersPool.get(in);
        Player outPlayer = this.players.get(out);

        this.players.remove(outPlayer);
        this.players.add(inPlayer);

        this.playersPool.add(outPlayer);
        this.playersPool.remove(inPlayer);

        if(!this.hasAllPosition()) {
            // rollback
            /*this.players.remove(inPlayer);
            this.players.add(outPlayer);

            this.playersPool.add(inPlayer);
            this.playersPool.remove(outPlayer);*/

            this.restoreFromSnapshot(snapshot);

            return false;
        }

        return true;
    }

    public boolean changeStaff(int in, int out) {
        if(in >= this.staffPool.size() || out >= this.staffs.size()) return false;

        Staff inStaff = this.staffPool.get(in);
        Staff outStaff = this.staffs.get(out);

        this.staffs.remove(outStaff);
        this.staffs.add(inStaff);

        this.staffPool.add(outStaff);
        this.staffPool.remove(inStaff);

        this.updateStaffEffect(outStaff, -1);
        this.updateStaffEffect(inStaff, 1);

        return true;
    }

    public void updateStaffEffect(Staff staff, int sign) {
        // 모든 선수에 대해서(this.players, this.playerPool) 해당 스태프의 능력치(effectOnPlayer)를
        // 더하기/빼기 staff.effectOnPlayer.affectHealthiness(Condition cond, int sign),
        // staff.effectOnPlayer.affectPsychological(Condition cond, int sign)

        for(Player player : this.players) {
            staff.getEffectOnPlayer().affectHealthiness(player.getCondition(), sign);
            staff.getEffectOnPlayer().affectPsychological(player.getCondition(), sign);
        }

        for(Player player : this.playersPool) {
            staff.getEffectOnPlayer().affectHealthiness(player.getCondition(), sign);
            staff.getEffectOnPlayer().affectPsychological(player.getCondition(), sign);
        }
    }

    public PlayerSnapshot createPlayerSnapShot() {
        PlayerSnapshot snapshot = new PlayerSnapshot();

        snapshot.copyPlayers(this.players, this.playersPool);

        return snapshot;
    }

    public void restoreFromSnapshot(PlayerSnapshot snapshot) {
        this.players = snapshot.getPlayers();
        this.playersPool = snapshot.getPlayersPool();
    }

    public void payout(long payment) {
        this.capital -= payment;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public void setCapital(long capital) {
        this.capital = capital;
    }

    public void setVictory(int victory) {
        this.victory = victory;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public String getLeague() {
        return league;
    }

    public Director getDirector() {
        return director;
    }

    public List<Staff> getStaffPool() {
        return staffPool;
    }

    public List<Player> getPlayersPool() {
        return playersPool;
    }

    public List<Staff> getStaffs() {
        return staffs;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public long getCapital() {
        return capital;
    }

    public int getnGame() {
        return nGame;
    }

    public void setnGame(int nGame) {
        this.nGame = nGame;
    }

    public int getVictory() {
        return victory;
    }

    public Tactic getTactic() { return tactic; }

    public void setTactic(Tactic tactic) {
        this.tactic = tactic;
    }
}