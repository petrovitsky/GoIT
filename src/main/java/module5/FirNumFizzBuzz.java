package module5;

public class FirNumFizzBuzz extends FirNum {
    @Override
    public int calc(int number) {
        int result = 0;
        for (int i = 1; i <= number; i++) {
            if (i % 15 == 0) {
                continue;
            }
            if (i % 3 == 0 || i % 5 == 0) {
                System.out.print(" " + i);
                result += i;
            }
        }
        return result;
    }
}
