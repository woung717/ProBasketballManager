import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Shin on 2017-05-26.
 */
public class Schedule {
    private Date currentDay;

    // Singleton Object Initializer

    private static Schedule instance;

    private Schedule() {
        this.currentDay = new Date();
    };

    public static Schedule getInstance() {
        if(instance == null) {
            instance = new Schedule();
        }
        return instance;
    }

    public void proceedDay() {
        // Do game
        // Fire events

        Calendar c = Calendar.getInstance();
        c.setTime(this.currentDay);
        c.add(Calendar.DATE, 1);
        this.currentDay = c.getTime();

        c.setTime(this.currentDay);
        if(c.get(Calendar.DAY_OF_MONTH) == 1) {
            // pay off for every players, staffs, director salary
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
}
