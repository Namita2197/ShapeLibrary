import java.awt.*;

public interface Shape {
    public void move(double deltaX, double deltaY) throws ShapeException;
    public double computeArea() throws ShapeException;
    public void render(Graphics2D graphics)throws ShapeException;
    public String toString();
}
