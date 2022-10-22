package module5;

public class FirNumMultiplyOdd extends FirNum {
    @Override
    public int calc(int number) {
        int result = 1;
        for (int i = 1; i <= number; i += 2) {
            result *= i;
        }
        return result;
    }
}
