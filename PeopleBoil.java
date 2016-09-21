package rakiq;

/**
 * Created by magy on 16.09.16.
 */
public class PeopleBoil extends People {
    private Tank tank;

    public PeopleBoil(String name, byte age, Rakiq.RakiqTypes rakiqTypes) {
        super(name, age, rakiqTypes);
    }

    @Override
    public void run() {

        while (true) {
            while (tank.isNotMoreThanTen()) {
                try {
                    System.out.println("There's no full tank!");
                    synchronized (tank) {
                        tank.wait();
                    }
                } catch (InterruptedException ex) {
                    System.out.println(ex.getMessage());

                }
            }
        }
/*
        //if we have full tank
        Rakiq rakiq = tank.takeFull();
        System.out.println("Boil");

        //boil 1 sec.
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //
        System.out.println("Rakiq is ready");
        synchronized (tank) {
            tank.notifyAll();
        }
        */
    }
}
