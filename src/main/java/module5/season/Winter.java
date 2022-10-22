package module5.season;

public class Winter extends Season{
    private String name = "winter";

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public boolean isCold() {
        return true;
    }
}
