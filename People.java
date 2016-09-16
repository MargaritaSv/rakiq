package rakiq;

/**
 * Created by magy on 16.09.16.
 */
public class People {
    private String name;
    private byte age;

    public People(String name, byte age) {
        if (name == null || name.trim().length() == 0) {
            throw new IllegalArgumentException("The name is not correct.");
        }
        this.name = name;

        if (age <= 0 || age >= 100) {
            throw new IllegalArgumentException("The age is not correct.");
        }
        this.age = age;
    }
}
