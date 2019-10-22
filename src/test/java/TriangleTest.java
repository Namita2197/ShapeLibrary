import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

import static org.junit.Assert.*;

public class TriangleTest {

    @Test
    public void constructorTest() throws ShapeException {
        Triangle triangle1=new Triangle(0,5,5,5,0,0);
        assertEquals(0,triangle1.getCorner1().getX(),0);
        assertEquals(5,triangle1.getCorner1().getY(),0);
        assertEquals(5,triangle1.getCorner2().getX(),0);
        assertEquals(5,triangle1.getCorner2().getY(),0);
        assertEquals(0,triangle1.getCorner3().getX(),0);
        assertEquals(0,triangle1.getCorner3().getY(),0);

        Point corner1 =new Point(0,5);
        Point corner2 =new Point(5,5);
        Point corner3 =new Point(0,0);


        Triangle triangle2=new Triangle(corner1,corner2,corner3);
        assertEquals(0,triangle2.getCorner1().getX(),0);
        assertEquals(5,triangle2.getCorner1().getY(),0);
        assertEquals(5,triangle2.getCorner2().getX(),0);
        assertEquals(5,triangle2.getCorner2().getY(),0);
        assertEquals(0,triangle2.getCorner3().getX(),0);
        assertEquals(0,triangle2.getCorner3().getY(),0);
    }

    @Test(expected = ShapeException.class)
    public void checkInvalidConstructor() throws ShapeException {
        Point corner1 =new Point(10,15);
        Point corner2 =new Point(20,15);
        Point corner3 =new Point(10,10);
        new Triangle(null,corner2,corner3);
        new Triangle(corner1,null,null);
    }

    @Test
    public void move() throws ShapeException {
        Point corner1 =new Point(10,10);
        Point corner2 =new Point(20,10);
        Point corner3 =new Point(10,0);
        Triangle testTriangle=new Triangle(corner1,corner2,corner3);
        testTriangle.move(10,10);
        assertEquals(20,testTriangle.getCorner1().getX(),0);
        assertEquals(20,testTriangle.getCorner1().getY(),0);
        assertEquals(30,testTriangle.getCorner2().getX(),0);
        assertEquals(20,testTriangle.getCorner2().getY(),0);
        assertEquals(20,testTriangle.getCorner3().getX(),0);
        assertEquals(10,testTriangle.getCorner3().getY(),0);
    }

    @Test
    public void scale() throws ShapeException {
        Point corner1 =new Point(10,15);
        Point corner2 =new Point(20,15);
        Point corner3 =new Point(10,10);

        Triangle testScaling =new Triangle(corner1,corner2,corner3);
        testScaling.scale(2);
        assertEquals(20,testScaling.getCorner1().getX(),0);
        assertEquals(30,testScaling.getCorner1().getY(),0);
        assertEquals(40,testScaling.getCorner2().getX(),0);
        assertEquals(30,testScaling.getCorner2().getY(),0);
        assertEquals(20,testScaling.getCorner3().getX(),0);
        assertEquals(20,testScaling.getCorner3().getY(),0);
    }

    @Test
    public void computeArea() throws ShapeException {
        Point corner1 =new Point(3,7);
        Point corner2 =new Point(1,1);
        Point corner3 =new Point(9,1);

        Triangle testArea= new Triangle(corner1,corner2,corner3);
        double area=testArea.computeArea();
        assertEquals(24,area,0.1);
    }

    @Test
    public void renderTest() throws Exception {

        Point corner1 = new Point(10, 10);
        Point corner2 = new Point(10, 0);
        Point corner3= new Point(50, 10);
        Triangle triangle = new Triangle(corner1,corner2,corner3);

        BufferedImage bufferedImage = new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics = bufferedImage.createGraphics();
        graphics.setColor(Color.white);
        graphics.fillRect(0,0,100,100);
        graphics.setColor(Color.BLACK);

        triangle.renderTriangle(graphics);
        ImageIO.write(bufferedImage, "png", new File("output/Triangle.png"));
    }
}