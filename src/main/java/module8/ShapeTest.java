package module8;



public class ShapeTest {

    public static void main(String[] args) {
        Shape [] shapes = { new Circle(), new Octagon(), new Quad(), new Rhombus(), new Triangle()};
        ShapeInfo shapeInfo = new ShapePrinter();
        for (Shape s: shapes) {
            shapeInfo.print(s);
        }
    }
}
