
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
    public void move() throws Exception {
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

//        p1.move(moveX, moveY);
//        line.move(moveX, moveY);
//        circle.move(moveX, moveY);
//        triangle.move(moveX, moveY);
//        rectangle.move(moveX, moveY);

        Composite shiftedCompositeShape = new Composite();
        shiftedCompositeShape.appendShape(triangle);
        shiftedCompositeShape.appendShape(rectangle);
        shiftedCompositeShape.appendShape(line);
        shiftedCompositeShape.appendShape(circle);
        shiftedCompositeShape.appendShape(p1);

        assertEquals(shiftedCompositeShape.getShapeCount(), compositeShape.getShapeCount());
        assertEquals(shiftedCompositeShape.computeArea(), compositeShape.computeArea(),0.1);
    }

//    @Test
//    public void area() throws Exception {
//        Point p1 = new Point(0, 0);
//        Point p2 = new Point(40, 0);
//        Point p3 = new Point(40, 40);
//        Point p4 = new Point(0, 40);
//
//        Point p5 = new Point(40, 60);
//        Point p6 = new Point(0, 60);
//
//        Rectangle rectangle = new Rectangle(p1, p2, p5, p6);
//        Square square = new Square(p1, p2, p3, p4);
//        Triangle triangle = new Triangle(p1, p2, p3);
//        Line line = new Line(p1, p5);
//        Ellipse ellipse = new Ellipse(100, 100, 50, 40);
//        Circle circle = new Circle(200, 200, 40);
//
//        CompositeShape compositeShape = new CompositeShape();
//        compositeShape.addShape(triangle);
//        compositeShape.addShape(rectangle);
//        compositeShape.addShape(square);
//        compositeShape.addShape(line);
//        compositeShape.addShape(ellipse);
//        compositeShape.addShape(circle);
//        compositeShape.addShape(p1);
//
//        double compositeArea = compositeShape.area();
//        double individualItemArea = rectangle.area() + square.area() + triangle.area() + line.area() + ellipse.area() +
//                circle.area() + p1.area();
//        assertEquals(compositeArea, individualItemArea, 0.001);
//    }
//
//    @Test
//    public void render() throws Exception {
//        Point p1 = new Point(0, 0);
//        Point p2 = new Point(40, 0);
//        Point p3 = new Point(40, 40);
//        Point p4 = new Point(0, 40);
//
//        Point p5 = new Point(40, 60);
//        Point p6 = new Point(0, 60);
//
//        Rectangle rectangle = new Rectangle(p1, p2, p5, p6);
//        Square square = new Square(p1, p2, p3, p4);
//        Triangle triangle = new Triangle(p1, p2, p3);
//        Line line = new Line(p1, p5);
//        Ellipse ellipse = new Ellipse(100, 100, 50, 40);
//        Circle circle = new Circle(200, 200, 40);
//
//        String imageFilename = "image.jpg";
//        EmbedImage embedImage = new EmbedImage(imageFilename, 200, 200, 400, 400);
//
//        CompositeShape compositeShape = new CompositeShape();
//        compositeShape.addShape(embedImage);
//        compositeShape.addShape(triangle);
//        compositeShape.addShape(rectangle);
//        compositeShape.addShape(square);
//        compositeShape.addShape(line);
//        compositeShape.addShape(ellipse);
//        compositeShape.addShape(circle);
//        compositeShape.addShape(p1);
//
//        double area = compositeShape.area();
//        System.out.println("Computed area of the composite shape is :" + area);
//
//        // Construct the bufferedImage of one of the predefined image types
//        BufferedImage bufferedImage = new BufferedImage(800, 800, BufferedImage.TYPE_INT_RGB);
//
//        // create a graphics which can be used to draw into buffered image
//        Graphics2D graphics = bufferedImage.createGraphics();
//        graphics.setColor(Color.white);
//
//        compositeShape.render(graphics);
//
//        // Save as PNG
//        File file = new File("composite.jpg");
//        ImageIO.write(bufferedImage, "jpg", file);
//        graphics.dispose();
//    }
//
//
//    @Test
//    public void toStringTest() throws Exception{
//        // Composite of composite and embedded image
//        Point p1 = new Point(0, 0);
//        Point p2 = new Point(40, 0);
//        Point p3 = new Point(40, 40);
//        Point p4 = new Point(0, 40);
//
//        Point p5 = new Point(40, 60);
//        Point p6 = new Point(0, 60);
//
//        Rectangle rectangle = new Rectangle(p1, p2, p5, p6);
//        Square square = new Square(p1, p2, p3, p4);
//        Triangle triangle = new Triangle(p1, p2, p3);
//        Ellipse ellipse = new Ellipse(100, 100, 50, 40);
//
//        CompositeShape compositeShape = new CompositeShape();
//        CompositeShape compositeShapeInner = new CompositeShape();
//
//        compositeShape.addShape(triangle);
//        compositeShape.addShape(rectangle);
//
//        compositeShapeInner.addShape(square);
//        compositeShapeInner.addShape(ellipse);
//
//        compositeShape.addShape(compositeShapeInner);
////        CompositeShape newComposite = new CompositeShape(compositeShape.toString());
//        // that's because compositeShapeInner count as 1
//    }
}