package rakiq;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by magy on 16.09.16.
 */
public class Demo {
    public static final int NUMBER_PICKERS = 7;

    public static void main(String[] args) {
        Tank tank = new Tank();

        //create 7 pickers

        Picker picker;
        ArrayList<Picker> pickers = new ArrayList<>();
        for (int i = 1; i <= NUMBER_PICKERS; i++) {
            pickers.add(new Picker(tank, "Pickers" + i, (byte) (new Random().nextInt(40) + 20), Rakiq.RakiqTypes.values()[(int) (Math.random() * 3)]));
        }
    }
}
