import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by Shin on 2017-06-01.
 */
public class Interations implements Loggable {
    private Team team;
    private MessageLogger logger;
    private Tactic[] tactics;

    public Interations(Team team, Tactic[] tactics) {
        this.team = team;
        this.tactics = tactics;
    }

    public int printMainMenu() {
        this.sendMessage("======================================");
        this.sendMessage("1. Show Team Information");
        this.sendMessage("2. Show Director Information");
        this.sendMessage("3. Player change");
        this.sendMessage("4. Staff change");
        this.sendMessage("5. Tatic change");
        this.sendMessage("======================================");
        this.sendMessage("Select Menu : ");
        return (new Scanner(new BufferedReader(new InputStreamReader(System.in)))).nextInt();
    }

    public int showTactics() {
        int i = 1;
        for(Tactic tactic : this.tactics) {
            this.sendMessage(i++ + ". " + tactic.getName() + "(" + tactic.getOffence() + ", " + tactic.getDefence() + ")");
        }
        this.sendMessage("Select Tactic : ");

        return (new Scanner(new BufferedReader(new InputStreamReader(System.in)))).nextInt() - 1;
    }

    public void showDirectorInformation() {
        this.sendMessage("+ Name : " + this.team.getDirector().getName());
        this.sendMessage("+ Age : " + this.team.getDirector().getAge());
        this.sendMessage("+ Nationality : " + this.team.getDirector().getNationality());
        this.sendMessage("+ Salary : " + this.team.getDirector().getSalary());
    }

    public void showPlayers() {
        for(Player player : this.team.getPlayers()) {
            this.sendMessage("* " + player.getName() + "/" + player.getNationality() + "/" + player.getHeight() + "/" + player.getSkill() + "/" + player.getPosition());
        }
        for(Player player : this.team.getPlayersPool()) {
            this.sendMessage(player.getName() + "/" + player.getNationality() + "/" + player.getHeight() + "/" + player.getSkill() + "/" + player.getPosition());
        }
    }

    public void showStaffs() {
        for(Staff staff : this.team.getStaffs()) {
            this.sendMessage("* " + staff.getName() + "/Healthiness Effect : " + staff.getEffectOnPlayer().getEffectOnHealthiness() + "/Psychological Effect : " + staff.getEffectOnPlayer().getEffectOnPsychological());
        }
        for(Staff staff : this.team.getStaffPool()) {
            this.sendMessage(staff.getName() + "/Healthiness Effect : " + staff.getEffectOnPlayer().getEffectOnHealthiness() + "/Psychological Effect : " + staff.getEffectOnPlayer().getEffectOnPsychological());
        }
    }

    public void showTeamInformation() {
        this.sendMessage("+ " + this.team.getName() + "-" + this.team.getCity() + "(" + this.team.getLeague() + ")");
        this.sendMessage("+ Director : " + this.team.getDirector().getName());
        this.sendMessage("+ Tatic : " + this.team.getTactic().getName());
        this.sendMessage("+ Game Count : " + this.team.getnGame() + " Victory Count : " + this.team.getVictory());
        this.sendMessage("+ Balance : $" + this.team.getCapital());
        this.sendMessage("+ Player Entry");
        this.sendMessage("=======================================");
        this.showPlayers();
        this.sendMessage("=======================================");
        this.sendMessage("+ Staff List");
        this.sendMessage("=======================================");
        this.showStaffs();
        this.sendMessage("=======================================");
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
