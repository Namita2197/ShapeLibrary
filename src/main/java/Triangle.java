import java.awt.*;

public class Triangle implements Shape{
    private Point corner1;
    private Point corner2;
    private Point corner3;

    public Triangle(double x1, double y1, double x2, double y2, double x3, double y3) throws ShapeException {
        corner1 = new Point(x1, y1);
        corner2 = new Point(x2, y2);
        corner3 = new Point(x3, y3);

        if (corner1 == null || corner2 == null || corner3 == null )
            throw new ShapeException("Invalid vertex or vertices");

        checkTriangleValidity(corner1, corner2, corner3);
    }

    public Triangle(Point corner1, Point corner2, Point corner3) throws ShapeException {
        this.corner1 = corner1;
        this.corner2 = corner2;
        this.corner3 = corner3;

        if (corner1 == null || corner2 == null || corner3 == null)
            throw new ShapeException("Invalid vertex or vertices");

        checkTriangleValidity(corner1, corner2, corner3);
    }

    public Triangle(String string) throws ShapeException {

        if (string.toLowerCase().contains("triangle:"))
            string = string.split(":")[1];

        String[] strings = string.split(",");
        this.corner1 = new Point(Double.valueOf(strings[0]), Double.valueOf(strings[1]));
        this.corner2= new Point(Double.valueOf(strings[2]), Double.valueOf(strings[3]));
        this.corner3= new Point(Double.valueOf(strings[4]), Double.valueOf(strings[5]));
    }

    public Point getCorner1() throws ShapeException { return corner1; }
    public Point getCorner2() throws ShapeException { return corner2; }
    public Point getCorner3() throws ShapeException { return corner3; }

    public void move(double deltaX, double deltaY) throws ShapeException {
        corner1.move(deltaX, deltaY);
        corner2.move(deltaX, deltaY);
        corner3.move(deltaX, deltaY);
    }

    public void scale(double scaleFactor) throws ShapeException {
        Validator.validatePositiveDouble(scaleFactor, "Invalid scale factor");
        double y1=corner1.getY();
        double x1=corner1.getX();
        double x2=corner2.getX();
        double y2=corner2.getY();
        double y3=corner3.getY();
        double x3=corner3.getX();
        y1=(y1*scaleFactor)-y1;
        x1=(x1*scaleFactor)-x1;
        x2=(x2*scaleFactor)-x2;
        y2=(y2*scaleFactor)-y2;
        x3=(x3*scaleFactor)-x3;
        y3=(y3*scaleFactor)-y3;

        corner1.move(x1,y1);
        corner2.move(x2,y2);
        corner3.move(x3,y3);
    }

    public double computeArea() throws ShapeException {
        double x1 = corner1.getX();
        double x2 = corner2.getX();
        double x3 = corner3.getX();
        double y1 = corner1.getY();
        double y2 = corner2.getY();
        double y3 = corner3.getY();
        double area = (x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2)) / 2.0;
        return area;

    }
    public void checkTriangleValidity(Point corner1,Point corner2,Point corner3) throws ShapeException {
        Line line1 = new Line(corner1, corner2);
        Line line2 = new Line(corner2, corner3);
        Line line3 = new Line(corner3, corner1);

        double lengthLine1 = line1.computeLength();
        double lengthLine2 = line2.computeLength();
        double lengthLine3 = line3.computeLength();

        assert lengthLine1+lengthLine2>lengthLine3;
    }

    public void render(Graphics2D graphics) throws ShapeException {

        int[] x = new int[4];
        int[] y = new int[4];

        x[0] = (int)getCorner1().getX();
        x[1] = (int)getCorner2().getX();
        x[2] = (int)getCorner3().getX();
        x[3]=x[0];

        y[0] = (int)getCorner1().getY();
        y[1] = (int)getCorner2().getY();
        y[2] = (int)getCorner3().getY();
        y[3]=y[0];

        graphics.drawPolyline(x, y, 4);
    }

    @Override
    public String toString() {
        String result=null;
        try {
            result="Triangle:" +
                    String.valueOf(this.getCorner1().getX()) + "," +
                    String.valueOf(this.getCorner1().getY()) + "," +
                    String.valueOf(this.getCorner2().getX()) + "," +
                    String.valueOf(this.getCorner2().getY()) + "," +
                    String.valueOf(this.getCorner3().getX()) + "," +
                    String.valueOf(this.getCorner3().getY());
        } catch (ShapeException e) {
            e.printStackTrace();
        }
        return result;
    }
}
