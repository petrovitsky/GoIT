package module13.telegramBot.weatherBot;

public class CityDto {
    private int id;
    private String name;
    private String country;
    private String admin1;
    private String lat;
    private String lon;

    private int pop;

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public String getLat() {
        return lat;
    }

    public String getLon() {
        return lon;
    }

    @Override
    public String toString() {
        return "CityDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", admin1='" + admin1 + '\'' +
                ", lat='" + lat + '\'' +
                ", lon='" + lon + '\'' +
                '}';
    }
}
