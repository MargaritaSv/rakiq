package rakiq;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by magy on 16.09.16.
 */
public class Rakiq {

    public static final int TIME_TO_BOIL = 200;
    private String typeRakiq;
    private AtomicInteger litter;

    public Rakiq() {
        this.typeRakiq = Rakiq.RakiqTypes.values()[(int) (Math.random() * 3)].toString();
        this.litter = new AtomicInteger(0);
    }

    public enum RakiqTypes {
        PLUM(1), APRICOT(2), FRAPPES(3);

        private int value;

        RakiqTypes(int value) {
            this.value = value;
        }
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