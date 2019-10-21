import org.junit.Test;

import static org.junit.Assert.*;

public class RectangleTest {
    @Test
    public void constructor1Test() throws ShapeException {
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

    @Test
    public void getCorner1() {
    }

    @Test
    public void getCorner2() {
    }

    @Test
    public void getCorner3() {
    }

    @Test
    public void getCorner4() {
    }

    @Test
    public void move() {
    }

    @Test
    public void scale() {
    }

    @Test
    public void computeArea() {
    }

    @Test
    public void checkRectangleValidity() {
    }
}