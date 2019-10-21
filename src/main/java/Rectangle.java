public class Rectangle {
    private Point corner1;
    private Point corner2;
    private Point corner3;
    private Point corner4;

    public Rectangle(double x1, double y1, double x2, double y2, double x3, double y3, double x4, double y4) throws ShapeException {
        corner1 = new Point(x1, y1);
        corner2 = new Point(x2, y2);
        corner3 = new Point(x3, y3);
        corner4 = new Point(x4, y4);
        if (corner1 == null || corner2 == null || corner3 == null || corner4 == null)
            throw new ShapeException("Invalid vertex or vertices");

        checkRectangleValidity(corner1, corner2, corner3, corner4);
    }

    public Rectangle(Point corner1, Point corner2, Point corner3, Point corner4) throws ShapeException {
        this.corner1 = corner1;
        this.corner2 = corner2;
        this.corner3 = corner3;
        this.corner4 = corner4;
        if (corner1 == null || corner2 == null || corner3 == null || corner4 == null)
            throw new ShapeException("Invalid vertex or vertices");

        checkRectangleValidity(corner1, corner2, corner3, corner4);
    }

    public Point getCorner1() throws ShapeException { return corner1; }
    public Point getCorner2() throws ShapeException { return corner2; }
    public Point getCorner3() throws ShapeException { return corner3; }
    public Point getCorner4() throws ShapeException { return corner4; }

    public void move(double deltaX, double deltaY) throws ShapeException {
        corner1.move(deltaX, deltaY);
        corner2.move(deltaX, deltaY);
        corner3.move(deltaX, deltaY);
        corner4.move(deltaX, deltaY);
    }

    public void scale(double scaleFactor) throws ShapeException {
        Validator.validatePositiveDouble(scaleFactor, "Invalid scale factor");
        double y1=corner1.getY();
        double x2=corner2.getX();
        double y2=corner2.getY();
        double x4=corner4.getX();
        y1=(y1*scaleFactor)-y1;
        x2=(x2*scaleFactor)-x2;
        y2=(y2*scaleFactor)-y2;
        x4=(x4*scaleFactor)-x4;

        corner1.move(0,y1);
        corner2.move(x2,y2);
        corner4.move(x4,0);
    }

    public double computeArea() throws ShapeException {
        Line length=new Line(corner1, corner2);
        Line breadth = new Line(corner2, corner4);
        double lengthMeasure=length.computeLength();
        double breadthMeasure=breadth.computeLength();
        return lengthMeasure*breadthMeasure;
    }
    public void checkRectangleValidity(Point corner1,Point corner2,Point corner3, Point corner4) throws ShapeException {
        Line line1 = new Line(corner1, corner2);
        Line line2 = new Line(corner2, corner4);
        Line line3 = new Line(corner1, corner3);
        Line line4 = new Line(corner3, corner4);
        Line hypotenuse1 = new Line(corner1, corner4);

        double lengthLine1 = line1.computeLength();
        double lengthLine2 = line2.computeLength();
        double lengthLine3 = line3.computeLength();
        double lengthLine4 = line4.computeLength();
        double lengthHypotenuse = hypotenuse1.computeLength();

        assert Math.round(Math.sqrt(Math.pow(lengthLine1, 2) + Math.pow(lengthLine2, 2))) == Math.round(lengthHypotenuse);
        assert Math.round(Math.sqrt(Math.pow(lengthLine3, 2) + Math.pow(lengthLine4, 2))) == Math.round(lengthHypotenuse);
    }

}
