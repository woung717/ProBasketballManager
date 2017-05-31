import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    static Schedule schedule;
    static Database gameDB;

    static Director director;
    static Team[] teams;
    static MessageLogger logger;

    static int teamIndex;

    public static void main(String[] args) {
        logger = new MessageLogger();
        gameDB = Database.getInstance();

        director = directorSetting();
        teamIndex = chooseTeam();

        initialize();

        schedule = Schedule.getInstance(teams, teamIndex, gameDB.eventDB, gameDB.scheduleDB);
        schedule.setLogger(logger);

        do {
            (new Scanner(new BufferedReader(new InputStreamReader(System.in)))).nextLine();
        } while(schedule.proceedDay());

    }

    public static Director directorSetting() {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        System.out.print("Director's name : ");
        String name = scanner.nextLine();

        System.out.print("Director's age : ");
        int age = scanner.nextInt();

        System.out.print("Director's nationality (1. USA / 2. Europe / 3. Asia) : ");
        int nation = scanner.nextInt() % 3;

        return new Director(name, ((int)(Math.random() * 10) % 7) * 2000, age, gameDB.nationDB[nation]);
    }

    public static int chooseTeam() {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        for(int i = 0; i < gameDB.teamDB.length; i++) {
            System.out.print(String.valueOf(i + 1) + ". " + gameDB.teamDB[i][0] + " - " + gameDB.teamDB[i][1] + "(" + gameDB.teamDB[i][2] + ")\n");
        }

        System.out.print("Select team : ");

        return scanner.nextInt() - 1;
    }

    public static void initialize() {
        teams = new Team[gameDB.getTeamDB().length];

        for(int i = 0; i < teams.length; i++) {
            teams[i] = new Team(gameDB.teamDB[i][0], gameDB.teamDB[i][1], gameDB.teamDB[i][2]);

            if(i == teamIndex) teams[i].setDirector(director);

            int perTeamPlayer = gameDB.playersDB.length / teams.length;
            for(int j = 0; j < perTeamPlayer; j++) {
                gameDB.playersDB[i * perTeamPlayer + j].setLogger(logger);
                gameDB.playersDB[i * perTeamPlayer + j].setCondition(new Condition());
                if(j < 5) {
                    teams[i].getPlayers().add(gameDB.playersDB[i * perTeamPlayer + j]);
                } else {
                    teams[i].getPlayersPool().add(gameDB.playersDB[i * perTeamPlayer + j]);
                }
            }

            int perTeamStaff = gameDB.staffDB.length / teams.length;
            for(int j = 0; j < perTeamStaff; j++) {
                if(j < 3) {
                    teams[i].getStaffs().add(gameDB.staffDB[i * perTeamStaff + j]);
                } else {
                    teams[i].getStaffPool().add(gameDB.staffDB[i * perTeamStaff + j]);
                }
            }

            teams[i].setTactic(gameDB.tacticDB[RandomGenerator.getRangedRandomInt(0, gameDB.tacticDB.length - 1)]);
            teams[i].setCapital((Math.random() * 10) % 9 * 1000000);
        }
    }
}
