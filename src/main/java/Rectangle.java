public class Rectangle {
    private Point corner1;
    private Point corner2;
    private Point corner3;
    private Point corner4;

    public Rectangle(double x1, double y1, double x2, double y2, double x3, double y3, double x4, double y4) throws ShapeException {
        corner1 = new Point(x1, y1);
        corner2 = new Point(x2, y2);
        corner3 = new Point(x3, y3);
        corner3 = new Point(x4, y4);
    }

    public Rectangle(Point corner1, Point corner2, Point corner3, Point corner4) throws ShapeException {
        this.corner1 = corner1;
        this.corner2 = corner2;
        this.corner3 = corner3;
        this.corner4 = corner4;
        if (corner1 == null || corner2 == null || corner3 == null || corner4 == null)
            throw new ShapeException("Invalid vertex or vertices");

        this.computeLengthBreadth(); // assert rectangle properties to make sure this is a valid rectangle

    }

    public Point getCorner1() throws ShapeException { return corner1.copy(); }
    public Point getCorner2() throws ShapeException { return corner2.copy(); }
    public Point getCorner3() throws ShapeException { return corner3.copy(); }
    public Point getCorner4() throws ShapeException { return corner4.copy(); }

    public void move(double deltaX, double deltaY) throws ShapeException {
        corner1.move(deltaX, deltaY);
        corner2.move(deltaX, deltaY);
        corner3.move(deltaX, deltaY);
        corner4.move(deltaX, deltaY);
    }

}
