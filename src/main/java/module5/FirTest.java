package module5;

class FirNumSum extends FirNum {
    @Override
    public int calc(int number) {
        int result = 0;
        while (number > 0) {
            result += number;
            number--;
        }
        return result;
    }
}

class FirNum {
    public int calc(int number) {
        return number;
    }
}

class FirTest {
    public int test(FirNum firNum, int number) {
        return firNum.calc(number);
    }

    public static void main(String[] args) {
        FirNum firNum = new FirNumSum();
        FirTest firTest = new FirTest();

        //Should be 6
        System.out.println(firTest.test(firNum, 3));
    }
}
