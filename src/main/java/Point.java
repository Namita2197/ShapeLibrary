import java.awt.*;

/**
 * Point
 *
 * This class represents point objects that can be moved and copied
 */
@SuppressWarnings("WeakerAccess")
public class Point implements Shape {
    private double x;
    private double y;

    /**
     * Constructor
     *
     * @param x                 The x-location of the point -- must be a valid double
     * @param y                 The y-location of the point -- must be a valid double
     * @throws ShapeException   Exception throw if any parameter is invalid
     */
    public Point(double x, double y) throws ShapeException {
        if (Double.isInfinite(x) || Double.isInfinite(y) ||
                Double.isNaN(x) || Double.isNaN(y))
            throw new ShapeException("Invalid Point");

        this.x = x;
        this.y = y;
    }

    public Point(String string) throws ShapeException {

        if (string.toLowerCase().contains("point:"))
            string = string.split(":")[1];

        String[] strings = string.split(",");
        this.x = Double.valueOf(strings[0]);
        this.y = Double.valueOf(strings[1]);
    }

    /**
     * @return  The x-location of the point
     */
    public double getX() { return x; }

    /**
     * @return  The y-location of the point
     */
    public double getY() { return y; }

    /**
     * Move the point in the x direction
     *
     * @param deltaX            The delta amount to move the point -- must be a valid double
     * @throws ShapeException   Exception thrown if the parameter is invalid
     */
    public void moveX(double deltaX) throws ShapeException {
        if (Double.isInfinite(deltaX) || Double.isNaN(deltaX))
            throw new ShapeException("Invalid delta value for move operation");

        x += deltaX;
    }

    /**
     * Move the point in the y direction
     *
     * @param deltaY            The delta amount to move the point -- must be a valid double
     * @throws ShapeException   Exception thrown if the parameter is invalid
     */
    public void moveY(double deltaY) throws ShapeException {
        if (Double.isInfinite(deltaY) || Double.isNaN(deltaY))
            throw new ShapeException("Invalid delta value for move operation");

        y += deltaY;
    }

    /**
     * Move the point
     *
     * @param deltaX            The delta amount to move the point in the x direction -- must be a valid double
     * @param deltaY            The delta amount to move the point in the y direction -- must be a valid double
     * @throws ShapeException   Exception throw if any parameter is invalid
     */

    @Override
    public void move(double deltaX, double deltaY) throws ShapeException {
        moveX(deltaX);
        moveY(deltaY);
    }

    @Override
    public double computeArea(){
        return 0;
    }

    @Override
    public void render(Graphics2D graphics) throws ShapeException {
        int x = (int)getX();
        int y = (int)getY();
        graphics.drawLine(x,y,x,y);
    }

    @Override
    public void scale(double scaleFactor) {
        System.out.println("can't scale point");
    }

    @Override
    public String toString() {
        return "Point:" +
                String.valueOf(this.getX()) + "," +
                String.valueOf(this.getY());
    }

    /**
     * Copy the point
     * @return                  A new point with same x and y locations
     * @throws ShapeException   Should never thrown because the current x and y are valid
     */
    public Point copy() throws ShapeException {
        return new Point(x, y);
    }
}
