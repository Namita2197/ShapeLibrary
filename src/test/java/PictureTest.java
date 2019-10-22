import org.junit.Test;

import java.awt.*;
import java.awt.image.BufferedImage;

import static org.junit.Assert.*;

public class PictureTest {
    @Test
    public void render() throws Exception {

        Picture picture = new Picture("picture.jpg");
        BufferedImage bufferedImage = new BufferedImage(400, 400, BufferedImage.TYPE_INT_RGB);

        Graphics2D graphics = bufferedImage.createGraphics();
        graphics.setColor(Color.white);

        picture.render(graphics, 0, 0, 100, 200);
    }

}