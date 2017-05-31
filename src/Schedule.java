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
        if(this.isGameOver()) return false; // 정해진 날 이상이 되면 종료

        this.sendMessage("Date : " + this.getStringDatefromToday(0));
        // 해당 날짜에 게임이 예정되어 있다면 게임 진행
        if(!this.gamePlan[this.dayCounter].equals("No")) this.doGame();

        // 이벤트 발생 (없을 수도 있음)
        this.eventOccur();

        // + 하루
        this.dayGoes();

        // 1일이면 월급 지급
        this.payday();

        return true;
    }

    public boolean isGameOver() {
        if(this.dayCounter >= this.gamePlan.length || this.teams[myTeam].getCapital() < 0) {
            this.sendMessage("Game over.");

            return true;
        } else {
            return false;
        }
    }

    public void doGame() {
        int[] excludes = new int[this.teams.length];
        excludes[this.myTeam] = 1;

        int chosen = RandomGenerator.getRangedRandomInt(0, this.teams.length - 1);
        Team awayTeam = this.teams[chosen == this.myTeam ? (chosen + 1) % this.teams.length : chosen];

        Game game = new Game(this.gamePlan[this.dayCounter], this.teams[this.myTeam], awayTeam);
        if(this.logger != null) game.setLogger(this.logger);

        this.sendMessage("Today, have a game with team " + awayTeam.getName() + " (" + this.gamePlan[this.dayCounter] + " Game)");

        game.proceedGame();
    }

    public void eventOccur() {
        int[] chosen = RandomGenerator.chooseMultipleChoice(this.events.length,
                (int)RandomGenerator.getRangedRandomInt(0, 3), new int[this.events.length]);

        this.sendMessage("===================Events===================");
        for(int i : chosen) {
            Event event = this.events[i];
            Team myTeam = this.teams[this.myTeam];

            if(this.logger != null) event.setLogger(this.logger);

            if(event.getEffectOnPlayer() == null) { //team event
                this.sendMessage("Event occured : " + event.getContent());
                event.affect(myTeam, null);
            } else {    // player event
                Player player = myTeam.getPlayers().get(RandomGenerator.getRangedRandomInt(0, myTeam.getPlayers().size() - 1));

                this.sendMessage("Event occured : " + player.getName() + event.getContent() +
                                " (" + player.getName() + " : Healthiness " + event.getEffectOnPlayer().getEffectOnHealthiness() + " / " +
                                "Psychological " + event.getEffectOnPlayer().getEffectOnPsychological() + ")");
                event.affect(myTeam, player);
            }
        }
        this.sendMessage("=============================================");
    }

    public void dayGoes() {
        Calendar c = Calendar.getInstance();
        c.setTime(this.currentDay);
        c.add(Calendar.DATE, 1);
        this.currentDay = c.getTime();

        this.dayCounter++;
    }

    public void payday() {
        Calendar c = Calendar.getInstance();
        c.setTime(this.currentDay);

        if(c.get(Calendar.DAY_OF_MONTH) == 1) {
            this.sendMessage("Today is payday. All of staffs and players are paid." + " Balance : " + String.valueOf(this.teams[myTeam].getCapital()));

            Team myTeam = this.teams[this.myTeam];

            myTeam.payout(myTeam.getDirector().getSalary());
            for(Unit unit : myTeam.getPlayers()) {
                myTeam.payout(unit.getSalary());
            }
            for(Unit unit : myTeam.getStaffs()) {
                myTeam.payout(unit.getSalary());
            }
        }
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
