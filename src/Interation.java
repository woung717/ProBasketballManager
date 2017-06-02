import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by Shin on 2017-06-01.
 */

// Singleton Pattern
public class Interation implements Loggable {
    private static Interation instance;

    private Team team;
    private MessageLogger logger;
    private Database db;

    private Interation(Database db, Team team) {
        this.team = team;
        this.db = db;
    }

    public static Interation getInstance(Database db, Team team) {
        if(instance == null) {
            instance = new Interation(db, team);
        }

        return instance;
    }

    public Director directorSetting() {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        System.out.print("Director's name : ");
        String name = scanner.nextLine();

        System.out.print("Director's age : ");
        int age = scanner.nextInt();

        System.out.print("Director's nationality (1. USA / 2. Europe / 3. Asia) : ");
        int nation = scanner.nextInt() % 3;

        return new Director(name, Double.valueOf(((Math.random() * 10) % 7) * 2000).longValue(), age, this.db.nationDB[nation]);
    }

    public int chooseTeam() {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        for(int i = 0; i < db.teamDB.length; i++) {
            System.out.print(String.valueOf(i + 1) + ". " + db.teamDB[i][0] + " - " + db.teamDB[i][1] + "(" + db.teamDB[i][2] + ")\n");
        }

        System.out.print("Select team : ");

        return scanner.nextInt() - 1;
    }

    public int printMainMenu() {
        this.sendMessage("======================================");
        this.sendMessage("1. Show Team Information");
        this.sendMessage("2. Show Director Information");
        this.sendMessage("3. Player change");
        this.sendMessage("4. Staff change");
        this.sendMessage("5. Tatic change");
        this.sendMessage("6. Go Next Day");
        this.sendMessage("======================================");
        this.sendMessage("Select Menu : ");

        return (new Scanner(new BufferedReader(new InputStreamReader(System.in)))).nextInt();
    }

    public int[] showPlayerChange() {
        int[] indexs = new int[2];

        this.sendMessage("================Main Players================");
        for(int i = 0; i < this.team.getPlayers().size(); i++) {
            this.sendMessage((i + 1) + ". " + this.team.getPlayers().get(i).getName() + "/" + this.team.getPlayers().get(i).getNationality() + "/" +
                    this.team.getPlayers().get(i).getHeight() + "/" + this.team.getPlayers().get(i).getSkill() + "/" + this.team.getPlayers().get(i).getPosition() +
                    "/" + this.team.getPlayers().get(i).getSkill());
        }
        this.sendMessage("============================================");
        this.sendMessage("Select player to out : ");
        indexs[0] = (new Scanner(new BufferedReader(new InputStreamReader(System.in)))).nextInt() - 1;

        this.sendMessage("================Bench Players================");
        for(int i = 0; i < this.team.getPlayersPool().size(); i++) {
            this.sendMessage((i + 1) + ". " + this.team.getPlayersPool().get(i).getName() + "/" + this.team.getPlayersPool().get(i).getNationality() + "/" +
                    this.team.getPlayersPool().get(i).getHeight() + "/" + this.team.getPlayersPool().get(i).getSkill() + "/" + this.team.getPlayersPool().get(i).getPosition());
        }
        this.sendMessage("============================================");
        this.sendMessage("Select player to in : ");
        indexs[1] = (new Scanner(new BufferedReader(new InputStreamReader(System.in)))).nextInt() - 1;

        return indexs;
    }

    public int[] showStaffChange() {
        int[] indexs = new int[2];

        this.sendMessage("================Working Staff================");
        for(int i = 0; i < this.team.getStaffs().size(); i++) {
            this.sendMessage((i + 1) + ". " + this.team.getStaffs().get(i).getName() + "/" + this.team.getStaffs().get(i).getSalary() + "/" +
                                this.team.getStaffs().get(i).getEffectOnPlayer().getEffectOnHealthiness() + "/" +
                                this.team.getStaffs().get(i).getEffectOnPlayer().getEffectOnPsychological() );
        }
        this.sendMessage("============================================");
        this.sendMessage("Select Staff to out : ");
        indexs[0] = (new Scanner(new BufferedReader(new InputStreamReader(System.in)))).nextInt() - 1;

        this.sendMessage("================Staff Pool================");
        for(int i = 0; i < this.team.getStaffPool().size(); i++) {
            this.sendMessage((i + 1) + ". " + this.team.getStaffPool().get(i).getName() + "/" + this.team.getStaffPool().get(i).getSalary() + "/" +
                    this.team.getStaffPool().get(i).getEffectOnPlayer().getEffectOnHealthiness() + "/" +
                    this.team.getStaffPool().get(i).getEffectOnPlayer().getEffectOnPsychological() );
        }
        this.sendMessage("============================================");
        this.sendMessage("Select Staff to in : ");
        indexs[1] = (new Scanner(new BufferedReader(new InputStreamReader(System.in)))).nextInt() - 1;

        return indexs;
    }

    public int showTactics() {
        int i = 1;
        for(Tactic tactic : this.db.tacticDB) {
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
