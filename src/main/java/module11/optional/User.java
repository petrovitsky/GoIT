package module11.optional;

public class User {
    private String name;
    private int age;
    private Position position;

    private boolean isOnVacation;

    public User(String name, int age, Position position, boolean isOnVacation) {
        this.name = name;
        this.age = age;
        this.position = position;
        this.isOnVacation = isOnVacation;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Position getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", position" +
                "=" + position +
                "}";
    }
}
