package rakiq;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by magy on 16.09.16.
 */
public class Rakiq {

    public static final int TIME_TO_BOIL = 200;

    public enum RakiqTypes {
        PLUM, APRICOT, FRAPPES;
    }

    private BlockingQueue<Rakidjiiq> tanks = new ArrayBlockingQueue<Rakidjiiq>(1);

    public void boil(Rakidjiiq rakidjiiq) {
        try {
            Thread.sleep(TIME_TO_BOIL);
            tanks.put(rakidjiiq);
        } catch (InterruptedException ex) {
            return;
        }
    }

    public Rakidjiiq readyWithBoil() {
        try {
            return tanks.take();
        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

}