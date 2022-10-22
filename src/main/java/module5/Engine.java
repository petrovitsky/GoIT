package module5;

public class Engine {
    private int power;
    private String FuelType = "A500";

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public String getFuelType() {
        return FuelType;
    }

    public void setFuelType(String fuelType) {
        FuelType = fuelType;
    }
}

class TestEngine {
    public static void main(String[] args) {
        System.out.println(new Engine().getFuelType());


        System.out.println(new XFuelEngine().getFuelType());

        AdvancedXFuelEngine engine = new AdvancedXFuelEngine();
        engine.setPower(1000);
        engine.setSerialNumber("SN504030");
        engine.printInfo(); //Serial number is SN504030, power is 1000
    }
}