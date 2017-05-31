import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Shin on 2017-05-26.
 */
public class Schedule implements Loggable {
    private MessageLogger logger;

    private Date currentDay;
    private int dayCounter;
    private String[] gamePlan;
    private int myTeam;
    private Team[] teams;
    private Event[] events;

    // Singleton Object Initializer

    private static Schedule instance;

    private Schedule(Team[] teams, int myTeam, Event[] events,String[] gamePlan) {
        this.currentDay = new Date();
        this.dayCounter = 0;
        this.myTeam = myTeam;
        this.teams = teams;
        this.gamePlan = gamePlan;
        this.events = events;
    }

    public static Schedule getInstance(Team[] teams, int myTeam, Event[] events, String[] gamePlan) {
        if(instance == null) {
            instance = new Schedule(teams, myTeam, events, gamePlan);
        }

        return instance;
    }

    public boolean proceedDay() {
        if(this.dayCounter >= this.gamePlan.length) {
            this.sendMessage("Game over.");

            return false;
        }

        if(this.gamePlan[this.dayCounter].equals("No") == false) this.doGame();

        int[] chosen = ProbabilityGenerator.chooseMultipleChoice(this.events.length,
                        (int)(Math.random() * 4), 0.2, new int[this.events.length]);
        




        Calendar c = Calendar.getInstance();
        c.setTime(this.currentDay);
        c.add(Calendar.DATE, 1);
        this.currentDay = c.getTime();

        c.setTime(this.currentDay);
        if(c.get(Calendar.DAY_OF_MONTH) == 1) {
            this.sendMessage("Today is payday all of staff and players are paid.");

            // pay off for every players, staffs, director salary
        }

        this.dayCounter++;
    }

    public void doGame() {
        int[] excludes = new int[this.teams.length];
        excludes[this.myTeam] = 1;

        int chosen = ProbabilityGenerator.chooseMultipleChoice(this.teams.length, 1, 0.2, excludes)[0];
        Team awayTeam = this.teams[chosen];

        Game game = new Game(this.gamePlan[this.dayCounter], this.teams[this.myTeam], awayTeam);

        this.sendMessage("Today have a game with team " + awayTeam.getName() + " (" + this.gamePlan[this.dayCounter] + " Game)");

        game.proceedGame();
    }

    public String getStringDatefromToday(int offset) {
        Calendar c = Calendar.getInstance();
        c.setTime(this.currentDay);
        c.add(Calendar.DATE, offset);
        Date t = c.getTime();
        SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd ");

        return transFormat.format(t);
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
