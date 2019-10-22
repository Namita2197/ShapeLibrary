import java.awt.*;
import java.util.HashMap;

public class EmbeddedImage implements Shape{

    private Point startPoint;
    private int height;
    private int width;
    private Picture picture;
    private String filename;
    private static HashMap<String, Picture> pictureHashMap = new HashMap<String, Picture>();

    public EmbeddedImage(String filename, double x, double y, int height, int width) throws Exception {
        this.startPoint = new Point(x, y);
        this.height = height;
        this.width = width;
        this.filename = filename;
        this.picture = pictureHashMap.get(filename);


        if (this.picture == null) {
            this.picture = new Picture(this.filename);
            pictureHashMap.put(filename, this.picture);
        }
    }

    public EmbeddedImage(String string) throws ShapeException {
        if (string.toLowerCase().contains("embeddedimage:"))
            string = string.split(":")[1];

        String[] strings = string.split(",");
        this.filename = strings[0];
        double x = Double.valueOf(strings[1]);
        double y = Double.valueOf(strings[2]);
        this.height = Integer.valueOf(strings[3]);
        this.width = Integer.valueOf(strings[4]);
        this.startPoint = new Point(x, y);
    }


    @Override
    public void move(double deltaX, double deltaY) throws ShapeException {
        this.startPoint.move(deltaX, deltaY);
    }

    @Override
    public double computeArea() throws ShapeException {
        return this.width*this.height;
    }

    public void scale(double scaleFactor) throws ShapeException {
        Validator.validatePositiveDouble(scaleFactor, "Invalid scale factor");
        height=(int)(getHeight()*scaleFactor);
        width=(int)(getWidth()*scaleFactor);
    }

    @Override
    public void render(Graphics2D graphics) throws ShapeException {
        this.picture.render(graphics, this.startPoint.getX(), this.startPoint.getY(), this.height, this.width);
    }
    @Override
    public String toString() {
        return "EmbeddedImage:" +
                this.filename + "," +
                this.startPoint.getX() + "," +
                this.startPoint.getY() + "," +
                this.height + "," +
                this.width;
    }


    public Point getStartPoint(){
        return this.startPoint;
    }
    public int getHeight(){ return this.height; }
    public int getWidth(){ return this.width; }



}
