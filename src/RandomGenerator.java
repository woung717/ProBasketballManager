import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Shin on 2017-05-29.
 */
public class RandomGenerator {
    public static Boolean TrueFalse(double prob) {
        return Math.random() < prob;
    }

    public static int[] chooseMultipleChoice(int n, int m, int[] exclude) {
        int[] ret = new int[m];

        List<Integer> shuffler = new LinkedList<Integer>();

        for(int i = 0; i < n; i++) if(exclude[i] != 1) shuffler.add(i);
        Collections.shuffle(shuffler);
        for(int i = 0; i < m; i++) ret[i] = shuffler.get(i);

        return ret;
    }

    public static int getRangedRandomInt(int min, int max) {
        return (int)(Math.random() * (max + 1 - min)) + min;
    }
}
