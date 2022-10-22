package module6;

public class TotalScore {
    public int sum(int[] scores) {
        int result = 0;
        for (int i = 0; i < scores.length; i++) {
            result += scores[i];
        }
        return result;
    }
}

class TotalScoreTest {
    public static void main(String[] args) {
        int[] score = {10, 20, 100};

        //130
        System.out.println(new TotalScore().sum(score));
    }
}
