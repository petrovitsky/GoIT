package module6;

import java.util.Arrays;

public class TargetFinder {
    public int[] findTarget(int[] aiCoords, int[][] targets) {
        int distance = Integer.MAX_VALUE;
        int indexResult = 0;
        for (int i = 0; i < targets.length; i++) {
            if (distance > calcDist(aiCoords[0], aiCoords[1], targets[i][0], targets[i][1])) {
                distance = calcDist(aiCoords[0], aiCoords[1], targets[i][0], targets[i][1]);
                indexResult = i;
            }
        }
        return new int[]{targets[indexResult][0], targets[indexResult][1]};
    }
    private int calcDist(int x1, int y1, int x2, int y2) {

        return (int) Math.round(Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2)));
    }
}


class TargetFinderTest {
    public static void main(String[] args) {
        int[] aiCoords = {10, 10};
        int[][] targets = {
                {20, 20},
                {15, 14},
                {30, 5}
        };

        TargetFinder targetFinder = new TargetFinder();
        int[] nearestTarget = targetFinder.findTarget(aiCoords, targets);

        //Expect [15, 14]
        System.out.println(Arrays.toString(nearestTarget));
        System.out.println("======================");
        System.out.println("targets[0][0] = " + targets[0][0]);
        System.out.println("targets[0][1] = " + targets[0][1]);
        System.out.println("targets[1][0] = " + targets[1][0]);
        System.out.println("targets[1][1] = " + targets[1][1]);
        System.out.println("targets[2][0] = " + targets[2][0]);
        System.out.println("targets[2][1] = " + targets[2][1]);


    }
}