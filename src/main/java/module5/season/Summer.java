package module5.season;

public class Summer extends Season {
    private String name = "summer";
    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public boolean isCold() {
        return !true;
    }
}
