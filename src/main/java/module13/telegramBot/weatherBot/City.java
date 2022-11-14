package module13.telegramBot.weatherBot;

public class City {
    private String name;
    private Coordinates coordinates;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public City(String name, Coordinates coordinates) {
        this.name = name;
        this.coordinates = coordinates;
    }
}
