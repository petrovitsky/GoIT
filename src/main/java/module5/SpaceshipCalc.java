package module5;

public class SpaceshipCalc {
    final int calculateAirBalloons(int passengerCount) {
        return passengerCount * 10;
    }
    public static void main(String[] args) {
        SpaceshipCalc calc = new SpaceshipCalc();
        System.out.println(calc.calculateAirBalloons(35));
        System.out.println(calc.calculateBookCount(50));


    }

    int calculateBookCount(int passengerCount){
        return passengerCount * 2;
    }
}

