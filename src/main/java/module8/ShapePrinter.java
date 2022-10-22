package module8;

public class ShapePrinter implements ShapeInfo {
    @Override
    public void print(Shape shape) {
        System.out.println("Name of the shape is: " + shape.getName());
    }
}
