package module13.telegramBot.weatherBot;

public class Coordinates {
    private String lat;
    private String lon;

    public String getLat() {
        return lat;
    }

      public String getLon() {
        return lon;
    }

    @Override
    public String toString() {
        return "Coordinates{" +
                "lat='" + lat + '\'' +
                ", lon='" + lon + '\'' +
                '}';
    }

    public Coordinates(String lat, String lon) {
        this.lat = lat;
        this.lon = lon;
    }
}
