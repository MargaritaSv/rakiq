package rakiq;

/**
 * Created by magy on 16.09.16.
 */
public class Picker extends People {
    private Tank tank;

    public Picker(Tank tank, String name, byte age, Rakiq.RakiqTypes rakiqTypes) {
        super(tank, name, age, rakiqTypes);
    }

    @Override
    public void run() {


        while (true) {

            while (tank.isMoreThanTen()) {
                try {
                    System.out.println("There's full tank! You'll get some kg rakiq.");
                    synchronized (tank) {
                        tank.wait();
                    }
                } catch (InterruptedException ex) {
                    System.out.println(ex.getMessage());

                }
            }

            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            tank.inTankPicker();
            notifyAll();
        }
    }
}
