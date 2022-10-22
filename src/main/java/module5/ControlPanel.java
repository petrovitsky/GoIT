package module5;

public class ControlPanel {
    private Altimeter altimeter = new Altimeter();
    private AirGauge airGauge = new AirGauge();


    public void control(){
        System.out.println(altimeter);
        System.out.println(airGauge);
    }
}

class  Altimeter{
    private String data = "Measure height";
    @Override
    public String toString() {
        return data;
    }
}

class  AirGauge{
    private String data = "Measure air pressure";
    @Override
    public String toString() {
        return data;
    }



}


class ControlPanelTest{
    public static void main(String[] args) {
        new ControlPanel().control();
    }
}
