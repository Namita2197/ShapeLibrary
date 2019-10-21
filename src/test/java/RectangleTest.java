import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

import static org.junit.Assert.*;

public class RectangleTest {
    @Test
    public void constructorTest() throws ShapeException {
        Rectangle testingRectangle1=new Rectangle(0,5,5,5,0,0,5,0);
        assertEquals(0,testingRectangle1.getCorner1().getX(),0);
        assertEquals(5,testingRectangle1.getCorner1().getY(),0);
        assertEquals(5,testingRectangle1.getCorner2().getX(),0);
        assertEquals(5,testingRectangle1.getCorner2().getY(),0);
        assertEquals(0,testingRectangle1.getCorner3().getX(),0);
        assertEquals(0,testingRectangle1.getCorner3().getY(),0);
        assertEquals(5,testingRectangle1.getCorner4().getX(),0);
        assertEquals(0,testingRectangle1.getCorner4().getY(),0);

        Point corner1 =new Point(0,5);
        Point corner2 =new Point(5,5);
        Point corner3 =new Point(0,0);
        Point corner4 =new Point(5,0);

        Rectangle testingRectangle2=new Rectangle(corner1,corner2,corner3,corner4);
        assertEquals(0,testingRectangle2.getCorner1().getX(),0);
        assertEquals(5,testingRectangle2.getCorner1().getY(),0);
        assertEquals(5,testingRectangle2.getCorner2().getX(),0);
        assertEquals(5,testingRectangle2.getCorner2().getY(),0);
        assertEquals(0,testingRectangle2.getCorner3().getX(),0);
        assertEquals(0,testingRectangle2.getCorner3().getY(),0);
        assertEquals(5,testingRectangle2.getCorner4().getX(),0);
        assertEquals(0,testingRectangle2.getCorner4().getY(),0);
    }

    @Test(expected = ShapeException.class)
    public void checkInvalidConstructor() throws ShapeException {
        Point corner1 =new Point(10,15);
        Point corner2 =new Point(20,15);
        Point corner3 =new Point(10,10);
        Point corner4 =new Point(20,10);
        new Rectangle(null,corner2,corner3,corner4);
        new Rectangle(corner1,null,corner3,null);
    }

    @Test
    public void move() throws ShapeException {
        Point corner1 =new Point(10,10);
        Point corner2 =new Point(20,10);
        Point corner3 =new Point(10,0);
        Point corner4 =new Point(20,0);
        Rectangle testRectangle=new Rectangle(corner1,corner2,corner3,corner4);
        testRectangle.move(10,10);
        assertEquals(20,testRectangle.getCorner1().getX(),0);
        assertEquals(20,testRectangle.getCorner1().getY(),0);
        assertEquals(30,testRectangle.getCorner2().getX(),0);
        assertEquals(20,testRectangle.getCorner2().getY(),0);
        assertEquals(20,testRectangle.getCorner3().getX(),0);
        assertEquals(10,testRectangle.getCorner3().getY(),0);
        assertEquals(30,testRectangle.getCorner4().getX(),0);
        assertEquals(10,testRectangle.getCorner4().getY(),0);
    }

    @Test
    public void scale() throws ShapeException {
        Point corner1 =new Point(10,15);
        Point corner2 =new Point(20,15);
        Point corner3 =new Point(10,10);
        Point corner4 =new Point(20,10);
        Rectangle testScaling =new Rectangle(corner1,corner2,corner3,corner4);
        testScaling.scale(2);
        assertEquals(10,testScaling.getCorner1().getX(),0);
        assertEquals(30,testScaling.getCorner1().getY(),0);
        assertEquals(40,testScaling.getCorner2().getX(),0);
        assertEquals(30,testScaling.getCorner2().getY(),0);
        assertEquals(10,testScaling.getCorner3().getX(),0);
        assertEquals(10,testScaling.getCorner3().getY(),0);
        assertEquals(40,testScaling.getCorner4().getX(),0);
        assertEquals(10,testScaling.getCorner4().getY(),0);
    }

    @Test
    public void computeArea() throws ShapeException {
        Point corner1 =new Point(10,15);
        Point corner2 =new Point(20,15);
        Point corner3 =new Point(10,10);
        Point corner4 =new Point(20,10);
        Rectangle testArea= new Rectangle(corner1,corner2,corner3,corner4);
        double area=testArea.computeArea();
        assertEquals(50,area,0);
    }

    @Test
    public void renderTest() throws Exception {

        Point corner1 = new Point(10, 10);
        Point corner2 = new Point(50, 10);
        Point corner3= new Point(10, 0);
        Point corner4 = new Point(50, 0);
        Rectangle rectangle = new Rectangle(corner1,corner2,corner3,corner4);

        BufferedImage bufferedImage = new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics = bufferedImage.createGraphics();
        graphics.setColor(Color.white);
        graphics.fillRect(0,0,100,100);
        graphics.setColor(Color.BLACK);

        rectangle.renderRectangle(graphics);
        ImageIO.write(bufferedImage, "png", new File("output/Rectangle.png"));
    }
}