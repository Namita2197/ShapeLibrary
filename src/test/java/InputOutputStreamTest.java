import org.junit.Test;

import static org.junit.Assert.*;

public class InputOutputStreamTest {

    @Test
    public void readWriteShape() throws Exception {
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

        String pictureName = "picture.jpg";
        EmbeddedImage embeddedImage = new EmbeddedImage(pictureName, 10, 10, 200, 200);

        Composite compositeShape1 = new Composite();
        compositeShape1.appendShape(triangle);
        compositeShape1.appendShape(line);
        compositeShape1.appendShape(embeddedImage);

        Composite compositeShape2 = new Composite();
        compositeShape2.appendShape(rectangle);
        compositeShape2.appendShape(circle);

        compositeShape1.appendShape(compositeShape2);

        String filename = "test.txt";
        InputOutputStream file = new InputOutputStream();
        file.writeShape(filename, compositeShape1);

        Composite readCompositeShape = file.readShape(filename);
        System.out.println("\nRead Object from file: \n" + readCompositeShape.toString());
        System.out.println("\nExpected Object from file: \n" + compositeShape1.toString());
        assert readCompositeShape.toString().equals(compositeShape1.toString());
    }

}