import java.awt.*;

public class EmbeddedImage implements Shape{

    private Point startPoint;
    private int height;
    private int width;
    private UserImage userImage;
    private String filename;
    private static HashMap<String, UserImage> stringImageHashMap = new HashMap<String, UserImage>();

    public EmbeddedImage(String filename, double x, double y, int height, int width) throws Exception {
        this.startPoint = new Point(x, y);
        this.height = height;
        this.width = width;
        this.filename = filename;
        this.userImage = stringImageHashMap.get(filename);

        
        if (this.userImage == null) {
            this.userImage = new UserImage(this.filename);
            stringImageHashMap.put(filename, this.userImage);
            System.out.println("New object instantiated");
        }
    }


    @Override
    public void move(double deltaX, double deltaY) throws ShapeException {

    }

    @Override
    public double computeArea() throws ShapeException {
        return 0;
    }

    @Override
    public void render(Graphics2D graphics) throws ShapeException {

    }
}
