package rakiq;

/**
 * Created by magy on 16.09.16.
 */
public abstract class People implements Runnable {
    private String name;
    private byte age;
    private Rakiq.RakiqTypes rakiqTypes;
    private Tank tank;

    public People( String name, byte age, Rakiq.RakiqTypes rakiqTypes) {
        //this.tank = tank;

        if (name == null || name.trim().length() == 0) {
            throw new IllegalArgumentException("The name is not correct.");
        }
        this.name = name;

        if (age <= 0 || age >= 100) {
            throw new IllegalArgumentException("The age is not correct.");
        }
        this.age = age;

        this.rakiqTypes = rakiqTypes;
    }

    public Rakiq.RakiqTypes getRakiqTypes() {
        return rakiqTypes;
    }


    @Override
    public String toString() {
        return "People{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", rakiqTypes=" + rakiqTypes +
                '}';
    }
}
