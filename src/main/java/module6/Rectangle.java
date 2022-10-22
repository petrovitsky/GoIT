package module6;

public class Rectangle {
    private int area;
    private int a;
    private int b;

    public Rectangle(int a, int b) {
        this.area = a * b;
        this.a = a;
        this.b = b;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public int getArea() {
        return area;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Rectangle rectangle = (Rectangle) o;

        return area == rectangle.area;
    }

    @Override
    public int hashCode() {
        return area;
    }

    public boolean canPlaceInto(Rectangle anotherRect) {

        if (this.a + this.b == anotherRect.a + anotherRect.b)
            return true;

        return      this.a <= anotherRect.a
                &&  this.b <= anotherRect.b
                &&  this.area <= anotherRect.area;

    }
}
class RectangleTest {
    public static void main(String[] args) {


        System.out.println(new Rectangle(64,84).canPlaceInto(new Rectangle(16,336) ));
    }
}

