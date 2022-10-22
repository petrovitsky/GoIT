package module8;

public abstract class Shape {
    private String name = getClass().getSimpleName();

    public String getName() {
        return this.name;
    }
}
