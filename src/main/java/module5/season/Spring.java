package module5.season;

public class Spring extends Season{
    private String name = "spring";
    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public boolean isCold() {
        return !true;
    }
}
