package rakiq;

/**
 * Created by magy on 16.09.16.
 */
public class Picker extends People {
    private Tank tank;

    public Picker(String name, byte age) {
        super(name, age);

    }

    @Override
    public void run() {

/*
        while (true) {
            while (!tank.isEmpty()) {
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
        */


    }
}
