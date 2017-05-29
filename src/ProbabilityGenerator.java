/**
 * Created by Shin on 2017-05-29.
 */
public class ProbabilityGenerator {
    public static Boolean TrueFalse(boolean bool, float prob) {
        if(prob > 0 && prob <= 1.0)
            return Math.random() < prob;
        else
            return null;
    }

    public static int[] chooseMultipleChoice(int n, int m, float prob, int[] exclude) {
        int[] ret = new int[n];

        for(int i = 0; i < n && m != 0; i++) {
            if(Math.random() < prob && exclude[i] != 1) {
                ret[i] = 1; m--;
            } else {
                ret[i] = 0;
            }
        }

        return ret;
    }
}
