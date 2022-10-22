package module6;

public class CircleIntersector {
    private int x1;
    private int y1;
    private int r1;
    private int x2;
    private int y2;
    private int r2;



    public CircleIntersector(int x1, int y1, int r1, int x2, int y2, int r2) {
        this.x1 = x1;
        this.y1 = y1;
        this.r1 = r1;
        this.x2 = x2;
        this.y2 = y2;
        this.r2 = r2;
    }

    private boolean isIntersects() {
        int distance = (int) Math.round(Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2)));
        boolean result =  distance <= r1 + r2;
        return result;
    }

    @Override
    public String toString() {
        return isIntersects() == true ? "intersects" : "not intersects";
    }
}

class CircleIntersectorTest {
    public static void main(String[] args) {
        //intersects
        System.out.println(new CircleIntersector(5, 5, 0, 8, 8, 0));

        //not intersects
        System.out.println(new CircleIntersector(0, 0, 1, 4, 0, 2));

        //not intersects
        System.out.println(new CircleIntersector(5, 5, 2, 8, 8, 2));

        System.out.println(new Distance(5, 5, 8, 8).getDistance());

    }
}