package rakiq;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by magy on 16.09.16.
 */
public class Tank {

    //for sum of all litters
    static AtomicInteger allLitter = new AtomicInteger(0);

    private List<Picker> pickers = new ArrayList<>();
    private List<PeopleBoil> peopleBoils = new ArrayList<>();
    //number<type,litter>
    private ConcurrentHashMap<Integer, Rakiq> inTank = new ConcurrentHashMap<>();

    public Tank(List<Picker> pickers) {
        this.pickers = pickers;
        this.pickers.forEach(picker -> new Thread(picker).start());

        createPeopleBoils();
        this.peopleBoils.forEach(peopleBoil -> new Thread(peopleBoil).start());

        //create tanks
        for (int i = 1; i <= 5; i++) {
            inTank.put(i, new Rakiq());
        }
    }

    private void createPeopleBoils() {
        PeopleBoil peopleBoil;
        for (int i = 0; i < 3; i++) {
            peopleBoil = new PeopleBoil("People_Boil_Rakiq " + i, (byte) (new Random().nextInt(20) + 40), Rakiq.RakiqTypes.values()[(int) (Math.random() * 3)]);
            peopleBoils.add(peopleBoil);
        }
    }

    //TODO: check every tank
    public boolean isNotMoreThanTen() {
        for (Map.Entry<Integer, Rakiq> t : inTank.entrySet()) {
            if (t.getValue().getKg() >= 10) {
                return false;
            }
        }
        return true;
    }

    public Rakiq takeFull() {
        Rakiq r = null;
        for (Map.Entry<Integer, Rakiq> t : inTank.entrySet()) {
            if (t.getValue().getKg() >= 10) {
                r = t.getValue();
                return r;
            }
        }
        return null;
    }
}