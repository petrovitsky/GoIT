package module11.optional;

public class User {
    private String name;
    private int age;
    private Position position;

    public User(String name, int age, Position position) {
        this.name = name;
        this.age = age;
        this.position = position;
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
