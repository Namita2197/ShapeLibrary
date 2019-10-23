import java.awt.*;
import java.util.ArrayList;

public class Composite implements Shape {

    private ArrayList<Shape> composite;

    public Composite() throws Exception {
        composite = new ArrayList<Shape>();
    }

    public void appendShape(Shape shape) throws Exception {
        composite.add(shape);
    }

    public void deleteShape(Shape shape) throws Exception {
        composite.remove(shape);
    }

    public int getShapeCount() throws Exception{
        return this.composite.size();
    }

    @Override
    public void move(double deltaX, double deltaY) throws ShapeException {
        for (Shape shape : composite) {
            shape.move(deltaX, deltaY);
        }
    }

    @Override
    public double computeArea() throws ShapeException {
        double totalArea = 0;
        for (Shape shape : composite) {
            totalArea += shape.computeArea();
        }
        return totalArea;
    }

    @Override
    public void render(Graphics2D graphics) throws ShapeException {
        for (Shape shape : composite) {
            shape.render(graphics);
        }
    }

    @Override
    public void scale(double scaleFactor) throws ShapeException {
        for (Shape shape : composite) {
            shape.scale(scaleFactor);
        }
    }

    @Override
    public String toString() {
        String result = "Composite:" + String.valueOf(this.composite.size()) + System.lineSeparator();
        for (Shape shape : composite) {
            result = result.concat(shape.toString() + System.lineSeparator());
        }
        return result;
    }
}
