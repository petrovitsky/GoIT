package module5;

public class FirNumFactorial extends FirNum {
    @Override
    public int calc(int number) {
        if (number == 0) {
            return 1;
        }
        return number * calc(number - 1);
    }
}
