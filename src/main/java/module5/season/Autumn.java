package module5.season;

public class Autumn extends Season{
    private String name = "autumn";
    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public boolean isCold() {
        return true;
    }
}
