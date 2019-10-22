
import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

import static org.junit.Assert.assertEquals;

public class CompositeTest {
    @Test
    public void appendDeleteShapeTest() throws Exception {
        Point p1 =new Point(0,5);
        Point p2 =new Point(5,5);
        Point p3 =new Point(0,0);
        Point p4 =new Point(5,0);

        Rectangle rectangle = new Rectangle(p1, p2, p3, p4);

        Triangle triangle = new Triangle(p1, p2, p3);
        Line line = new Line(p1, p2);

        Circle circle = new Circle(p4, 40);

        Composite compositeShape = new Composite();
        assertEquals(0,compositeShape.getShapeCount());

        compositeShape.appendShape(rectangle);
        assertEquals(1,compositeShape.getShapeCount());

        compositeShape.appendShape(triangle);
        assertEquals(2,compositeShape.getShapeCount());

        compositeShape.appendShape(line);
        assertEquals(3,compositeShape.getShapeCount());

        compositeShape.appendShape(circle);
        assertEquals(4,compositeShape.getShapeCount());

        compositeShape.appendShape(p1);
        assertEquals(5,compositeShape.getShapeCount());

        compositeShape.deleteShape(p1);
        assertEquals(4,compositeShape.getShapeCount());

        compositeShape.deleteShape(circle);
        assertEquals(3,compositeShape.getShapeCount());

        compositeShape.deleteShape(line);
        assertEquals(2,compositeShape.getShapeCount());
    }

    @Test
    public void doubleCompositeTest() throws Exception{
        Point p1 =new Point(0,5);
        Point p2 =new Point(5,5);
        Point p3 =new Point(0,0);
        Point p4 =new Point(5,0);

        Rectangle rectangle = new Rectangle(p1, p2, p3, p4);
        Triangle triangle = new Triangle(p1, p2, p3);
        Circle circle=new Circle(p1,50);
        Line line=new Line(p1,p2);

        Composite compositeShape = new Composite();
        Composite compositeShape2 = new Composite();

        compositeShape.appendShape(rectangle);
        compositeShape.appendShape(triangle);

        compositeShape2.appendShape(circle);
        compositeShape2.appendShape(line);

        compositeShape.appendShape(compositeShape2);
        assertEquals(3,compositeShape.getShapeCount());
    }

    @Test
    public void moveTesting() throws Exception {
        Point p1 =new Point(0,5);
        Point p2 =new Point(5,5);
        Point p3 =new Point(0,0);
        Point p4 =new Point(5,0);

        Rectangle rectangle = new Rectangle(p1, p2, p3, p4);
        Circle circle = new Circle(p1,50);
        Triangle triangle = new Triangle(p1, p2, p3);
        Line line = new Line(p1, p2);

        Composite compositeShape = new Composite();

        compositeShape.appendShape(p1);
        compositeShape.appendShape(line);
        compositeShape.appendShape(circle);
        compositeShape.appendShape(triangle);
        compositeShape.appendShape(rectangle);

        int moveX = 10;
        int moveY = 10;

        compositeShape.move(moveX, moveY);

        Composite shiftedCompositeShape = new Composite();
        shiftedCompositeShape.appendShape(triangle);
        shiftedCompositeShape.appendShape(rectangle);
        shiftedCompositeShape.appendShape(line);
        shiftedCompositeShape.appendShape(circle);
        shiftedCompositeShape.appendShape(p1);

        assertEquals(shiftedCompositeShape.getShapeCount(), compositeShape.getShapeCount());
        assertEquals(shiftedCompositeShape.computeArea(), compositeShape.computeArea(),0.1);
    }

    @Test
    public void computeAreaTesting() throws Exception {
        Point p1 =new Point(0,5);
        Point p2 =new Point(5,5);
        Point p3 =new Point(0,0);
        Point p4 =new Point(5,0);

        Rectangle rectangle = new Rectangle(p1, p2,p3, p4);
        Triangle triangle = new Triangle(p1, p2, p3);
        Line line = new Line(p1, p2);
        Circle circle = new Circle(p2, 40);

        Composite compositeShape = new Composite();
        compositeShape.appendShape(triangle);
        compositeShape.appendShape(rectangle);
        compositeShape.appendShape(line);
        compositeShape.appendShape(circle);
        compositeShape.appendShape(p1);

        double compositeArea = compositeShape.computeArea();
        double individualShapeArea = rectangle.computeArea() + triangle.computeArea()+ line.computeArea()+ circle.computeArea() + p1.computeArea();
        assertEquals( individualShapeArea, compositeArea ,0.001);
    }

    @Test
    public void renderTesting() throws Exception {
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

        EmbeddedImage embeddedImage = new EmbeddedImage("picture.jpg", 200, 200, 40, 40);

        Composite compositeShape = new Composite();
        compositeShape.appendShape(embeddedImage);
        compositeShape.appendShape(triangle);
        compositeShape.appendShape(rectangle);
        compositeShape.appendShape(line);
        compositeShape.appendShape(circle);
        compositeShape.appendShape(p1);

        double area = compositeShape.computeArea();
        System.out.println(" Area of the composite shape is :" + area);

        BufferedImage bufferedImage = new BufferedImage(800, 800, BufferedImage.TYPE_INT_RGB);

        Graphics2D graphics = bufferedImage.createGraphics();
        graphics.setColor(Color.white);
        compositeShape.render(graphics);

        ImageIO.write(bufferedImage, "jpg",new File("output/composite.jpg"));
    }

}