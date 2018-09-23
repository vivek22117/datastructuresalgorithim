package thread;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Vivek Kumar Mishra on 04/07/2018.
 */
public class Utils {

    private static final int MAX_DELAY_IN_MS = 1000;
    private static final int MIN_DELAY_IN_MS = 750;

    static public void randomDelay(){
        int delayMS = ThreadLocalRandom.current().nextInt(MAX_DELAY_IN_MS, MIN_DELAY_IN_MS);

        try{
            Thread.sleep(delayMS);
        } catch (InterruptedException ex){
            throw new RuntimeException(ex);
        }
    }

    public static double round(double value){
        return round(value, 2);
    }

    private static double round(double value,int places){
        if(places < 0) throw new IllegalArgumentException("Provide correct value");

        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(places, RoundingMode.HALF_DOWN);
        return bd.doubleValue();
    }
}
