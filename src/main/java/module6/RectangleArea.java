package module6;

public class RectangleArea {
    private int [] coords = new int[4];

    public RectangleArea(int[] coords) {
        this.coords = coords;
    }

    public int getArea(){
        int sideA = 0;
        int sideB =0;

        sideA = coords [2] - coords [0];
        sideB = coords [3] - coords [1];

        return  Math.abs(sideA * sideB);
    }
}

class RectangleAreaTest {
    public static void main(String[] args) {
        int[] coords = {-12, 39, -7, -35};

        //Expect 100
        System.out.println(new RectangleArea(coords).getArea());
    }
}
