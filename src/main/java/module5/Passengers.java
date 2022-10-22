package module5;

abstract class Passenger {
    public abstract String getType();

    public abstract int getTicketPrice();
}

class RegularPassenger extends Passenger{
    private final String type = "Regular";
    private final int tiketPrice = 199;
    @Override
    public String getType() {
        return type;
    }


    @Override
    public int getTicketPrice() {
        return tiketPrice;
    }
}

class VIPPassenger extends Passenger {
    private final String type = "VIP";
    private final int tiketPrice = 399;

    @Override
    public String getType() {
        return type;
    }

    @Override
    public int getTicketPrice() {
        return tiketPrice;
    }
}

class Main {
    public static void main(String[] args) {
        Passenger regular = new RegularPassenger();
        System.out.println(regular.getType()); //Regular
        System.out.println(regular.getTicketPrice()); //199

        Passenger vip = new VIPPassenger();
        System.out.println(vip.getType());  //VIP
        System.out.println(vip.getTicketPrice()); //399
    }
}