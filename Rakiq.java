package rakiq;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by magy on 16.09.16.
 */
public class Rakiq {

    public static final int TIME_TO_BOIL = 200;
    private String typeRakiq;
    private Integer kg;

    public Rakiq() {
        this.typeRakiq = Rakiq.RakiqTypes.values()[(int) (Math.random() * 3)].toString();
        resetKg();
    }

    public Integer getKg() {
        return kg;
    }

    public String getTypeRakiq() {
        return typeRakiq;
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
            resetKg();
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

    //add more fruits
    public void addFruits(int kg) {
        this.kg += kg;
    }

    private void resetKg() {
        this.kg = 0;
    }
}