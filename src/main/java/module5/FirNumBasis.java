package module5;

public class FirNumBasis extends FirNum {
    @Override
    public int calc(int number) {
        int result = 0;
        for (int i = 1; i <= number; i++) {
            if (i % 2 == 0) {
                result += i;
            }
        }
        return result / 2;
    }
}
