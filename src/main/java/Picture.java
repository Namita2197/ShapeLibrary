import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
public class Picture {

        private BufferedImage bufferedImage;
        private File file;

        public Picture(String filename) throws Exception {
            this.file = new File(filename);
            this.bufferedImage = ImageIO.read(file);
        }

        public void render(Graphics2D graphics, double x, double y, int height, int width){
            graphics.drawImage(this.bufferedImage, (int)x, (int)y, height, width, null, null);
        }
}
