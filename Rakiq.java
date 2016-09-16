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

    private BlockingQueue<PeopleBoil> tanks = new ArrayBlockingQueue<PeopleBoil>(1);

    public void boil(PeopleBoil peopleBoil) {
        try {
            Thread.sleep(TIME_TO_BOIL);
            tanks.put(peopleBoil);
        } catch (InterruptedException ex) {
            return;
        }
    }

    public PeopleBoil readyWithBoil() {
        try {
            return tanks.take();
        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

}