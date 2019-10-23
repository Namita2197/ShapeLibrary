import static org.junit.Assert.*;
import org.junit.Test;

public class ShapeFactoryTest {

        @Test
        public void testCreate() throws Exception {
            Point p1 =new Point(200,280);
            Point p2 =new Point(240,280);
            Point p3 =new Point(200,320);
            Point p4 =new Point(240,320);
            Point p5 =new Point(320,360);
            Point p6 =new Point(350,380);
            Point p7 =new Point(400,380);
            Point p8 =new Point(350,440);

            Circle circle = new Circle(p1, 50);
            Rectangle rectangle = new Rectangle(p1, p2, p3, p4);
            Triangle triangle = new Triangle(p6, p7, p8);
            Line line = new Line(p4, p5);

            Composite compositeShape = new Composite();
            compositeShape.appendShape(triangle);
            compositeShape.appendShape(circle);
            compositeShape.appendShape(line);
            compositeShape.appendShape(rectangle);

            String compositeShapeString = compositeShape.toString();
//            new Composite(compositeShapeString);
            ShapeFactory factory = new ShapeFactory();
            Composite stringToShape = factory.create(compositeShapeString);


            assertEquals(compositeShape.computeArea(), stringToShape.computeArea(), 0.5);
        }
}
