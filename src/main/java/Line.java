import java.awt.*;

/**
 *
 *  Line
 *
 *  This class represents line objects that can be moved.  Users of a line can also get its length and slope.
 *
 */
@SuppressWarnings("WeakerAccess")
public class Line implements Shape{
    private Point point1;
    private Point point2;

    /**
     * Constructor based on x-y Locations
     * @param x1                The x-location of first point -- must be a valid double.
     * @param y1                The y-location of first point -- must be a valid double.
     * @param x2                The x-location of second point -- must be a valid double.
     * @param y2                The y-location of second point -- must be a valid double.
     * @throws ShapeException   Exception throw if any parameter is invalid
     */
    public Line(double x1, double y1, double x2, double y2) throws ShapeException {
        point1 = new Point(x1, y1);
        point2 = new Point(x2, y2);
    }

    /**
     *
     * @param point1            The first point -- must not be null
     * @param point2            The second point -- must not b e null
     * @throws ShapeException   Exception throw if any parameter is invalid
     */
    public Line(Point point1, Point point2) throws ShapeException {
        if (point1==null || point2==null)
            throw new ShapeException("Invalid Point");

        this.point1 = point1.copy();
        this.point2 = point2.copy();
    }

    public Line(String string) throws ShapeException {

        if (string.toLowerCase().contains("line:"))
            string = string.split(":")[1];

        String[] strings = string.split(",");
        this.point1 = new Point(Double.valueOf(strings[0]), Double.valueOf(strings[1]));
        this.point2 = new Point(Double.valueOf(strings[2]), Double.valueOf(strings[3]));
    }


    /**
     * @return  The first point
     */
    public Point getPoint1() throws ShapeException { return point1.copy(); }

    /**
     * @return  The second point
     */
    public Point getPoint2() throws ShapeException { return point2.copy(); }

    /**
     * Move a line
     *
     * @param deltaX            The delta x-location by which the line should be moved -- must be a valid double
     * @param deltaY            The delta y-location by which the line should be moved -- must be a valid double
     * @throws ShapeException   Exception throw if any parameter is invalid
     */

    @Override
    public void move(double deltaX, double deltaY) throws ShapeException {
        point1.move(deltaX, deltaY);
        point2.move(deltaX, deltaY);
    }

    /**
     * @return  The length of the line
     */
    public double computeLength() {
        return Math.sqrt(Math.pow(point2.getX() - point1.getX(), 2) +
                Math.pow(point2.getY() - point1.getY(), 2));
    }

    @Override
    public void scale(double scaleFactor) throws ShapeException {
        Validator.validatePositiveDouble(scaleFactor, "Invalid scale factor");

        double y2=point2.getY();
        double x2=point2.getX();
        y2=(y2*scaleFactor)-y2;
        x2=(x2*scaleFactor)-x2;

        point1.move(0,0);
        point2.move(x2,y2);

    }

    @Override
    public double computeArea(){
        return 0;
    }

    @Override
    public void render(Graphics2D graphics) throws ShapeException {
        int x1=(int)point1.getX();
        int y1=(int)point1.getY();
        int x2=(int)point2.getX();
        int y2=(int)point2.getY();
        graphics.drawLine(x1,y1,x2,y2);
    }

    @Override
    public String toString() {
        String result=null;
        try {
             result= "Line:" +
                    String.valueOf(this.getPoint1().getX()) + "," +
                    String.valueOf(this.getPoint1().getY()) + "," +
                    String.valueOf(this.getPoint2().getX()) + "," +
                    String.valueOf(this.getPoint2().getY());
        } catch (ShapeException e) { }
        return result;
    }

    /**
     * @return  The slope of the line
     */
    public double computeSlope() {
        return (point2.getX() - point1.getX())/(point2.getY() - point1.getY());
    }
}
