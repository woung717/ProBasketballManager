import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Shin on 2017-05-26.
 */
public class Team {
    private final int NSTAFF = 3;

    private String name;
    private String city;
    private String league;

    private Director director;
    private List<Staff> staffPool;
    private List<Staff> staffs;
    private List<Player> playersPool;
    private List<Player> players;

    private Tactic tactic;

    private double capital;
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

        this.capital = 0.0;
        this.victory = 0;
        this.nGame = 0;
    }

    public boolean hasAllPosition() {
        // this.players 들의 선수들이 "Center", "Forward", "Guard"를 다 포함하고 있는가
        return true; // 반환값으로 변경
    }

    public boolean addStaff(int index) {
        // this.staffs의 크기가  NSTAFF보다 작을때(<) staffPool의 index번째 staff를 this.staffs에 추가
        // 모든 선수에 대해서(this.players, this.playerPool) 해당 스태프의 능력치(effectOnPlayer)를
        // 더하기 updateStaffEffect(Staff staff, int sign) // sign == 1
        // staffpool풀에서 삭제

        if(staffs.size()<NSTAFF){
            staffs.add(staffPool.get(index));
            updateStaffEffect(staffPool.get(index), 1); //staff이 아닌 staffPool에 있는.
            staffPool.remove(index);

            return true;// 추가했으면 return true 못하면 false
        }
        else
            return false;
    }

    public boolean removeStaff(int index) {
        // 현재 staff수가 0보다 클때 index번째의 스태프를 this.staffs 에서 제거하고
        // 모든 선수에 대해서(this.players, this.playerPool) 해당 스태프의 능력치(effectOnPlayer)를
        // 빼기 updateStaffEffect(Staff staff, int sign) // sign == -1
        // staffpool에 추가

        if(this.staffs.size()>=0){
            //this.staffs.remove(this.staffPool.get(index));
            updateStaffEffect(this.staffs.get(index), -1);
            this.staffPool.add(this.staffs.get(index));
            this.staffs.remove(index);

            return true;// 제거했으면 return true 못하면 false
        }
        else
            return false;
    }

    public void updateStaffEffect(Staff staff, int sign) {
        // 모든 선수에 대해서(this.players, this.playerPool) 해당 스태프의 능력치(effectOnPlayer)를
        // 더하기/빼기 staff.effectOnPlayer.affectHealthiness(Condition cond, int sign),
        // staff.effectOnPlayer.affectPsychological(Condition cond, int sign)


        //player에 대해
        if(sign == 1){
            for(int i=0; i< this.players.size(); i++){
                this.players.get(i).getCondition().setHealthiness(
                        this.players.get(i).getCondition().getHealthiness()+
                                staff.effectOnPlayer.getEffectOnHealthiness());

                this.players.get(i).getCondition().setPsychological(
                        this.players.get(i).getCondition().getPsychological()+
                                staff.effectOnPlayer.getEffectOnPsychological());
            }

            //playersPool에 대해
            for(int i=0; i< this.playersPool.size(); i++){
                //이미 다른 스태프의 능력치는 더해졌다는 가정하에
                this.playersPool.get(i).getCondition().setHealthiness(
                        this.playersPool.get(i).getCondition().getHealthiness()+
                                staff.effectOnPlayer.getEffectOnHealthiness());

                this.playersPool.get(i).getCondition().setPsychological(
                        this.playersPool.get(i).getCondition().getPsychological()+
                                staff.effectOnPlayer.getEffectOnPsychological());
            }
        }
        else if(sign== -1){
            for(int i=0; i< this.players.size(); i++){
                //이미 다른 스태프의 능력치는 더해졌다는 가정하에
                this.players.get(i).getCondition().setHealthiness(
                        this.players.get(i).getCondition().getHealthiness()-
                                staff.effectOnPlayer.getEffectOnHealthiness());

                this.players.get(i).getCondition().setPsychological(
                        this.players.get(i).getCondition().getPsychological()-
                                staff.effectOnPlayer.getEffectOnPsychological());
            }

            //playersPool에 대해
            for(int i=0; i< this.playersPool.size(); i++){
                //이미 다른 스태프의 능력치는 더해졌다는 가정하에
                this.playersPool.get(i).getCondition().setHealthiness(
                        this.playersPool.get(i).getCondition().getHealthiness()-
                                staff.effectOnPlayer.getEffectOnHealthiness());

                this.playersPool.get(i).getCondition().setPsychological(
                        this.playersPool.get(i).getCondition().getPsychological()-
                                staff.effectOnPlayer.getEffectOnPsychological());
            }
        }

        //hasAllPosition 추가해야하나?
    }

    public void changePlayer(int in, int out) {
        // 선수를 바꿨을때 hasAllPosition 이 성립하는가?
        // this.playerPool의 in 번째 선수를 this.players의 out번째 선수와 교체

        //선수 in
        this.players.add(playersPool.get(out));
        this.playersPool.remove(out);

        //선수 out
        this.playersPool.add(players.get(in));
        this.players.remove(in);


    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public void setCapital(double capital) {
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

    public List<Staff> getStaffs() {
        return staffs;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public double getCapital() {
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
