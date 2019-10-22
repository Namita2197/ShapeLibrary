import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

import static org.junit.Assert.*;

public class EmbeddedImageTest {

    @Test
    public void constructorTest() throws Exception {
        String filename = "picture.jpg";
        EmbeddedImage embeddedImage1 = new EmbeddedImage(filename, 10, 10, 40, 40);
        EmbeddedImage embeddedImage2 = new EmbeddedImage(filename, 50, 50, 40, 40);

        String filename1 = "Tree.jpg";
        EmbeddedImage embeddedImage3 = new EmbeddedImage(filename1, 100, 100, 30, 30);
        EmbeddedImage embeddedImage4 = new EmbeddedImage(filename1, 130, 130, 50, 50);
        EmbeddedImage embeddedImage5 = new EmbeddedImage(filename1, 100, 100, 30, 30);

        assertNotEquals(embeddedImage1.toString(),embeddedImage2.toString());
        assertNotEquals(embeddedImage3.toString(),embeddedImage4.toString());
        assert embeddedImage3.toString().equals(embeddedImage5.toString());
    }

    @Test
    public void computeAreaTest() throws Exception {
        String filename = "picture.jpg";
        EmbeddedImage embeddedImage = new EmbeddedImage(filename, 10, 10, 80, 80);
        assertEquals(6400,embeddedImage.computeArea(),0);
    }

    @Test
    public void moveTest() throws Exception {
        String filename = "picture.jpg";
        EmbeddedImage embeddedImage1 = new EmbeddedImage(filename, 10, 10, 40, 60);
        embeddedImage1.move(10, 10);
        assertEquals(20,(embeddedImage1.getStartPoint().getX()),0);
        assertEquals(20,(embeddedImage1.getStartPoint().getY()),0);
    }

    @Test
    public void stringConstructorTest() throws Exception {
        String filename = "Tree.jpg";
        EmbeddedImage embeddedImage1 = new EmbeddedImage(filename, 10, 10, 50, 50);
        EmbeddedImage embeddedImage2 = new EmbeddedImage(embeddedImage1.toString());
        assert embeddedImage1.toString().equals(embeddedImage2.toString());
    }

    @Test
    public void startPointTest() throws Exception {
        String filename = "Tree.jpg";
        EmbeddedImage embeddedImage = new EmbeddedImage(filename, 10, 10, 50, 50);
        assertEquals(10,(embeddedImage.getStartPoint().getX()),0);
        assertEquals(10,(embeddedImage.getStartPoint().getY()),0);
    }

    @Test
    public void scale() throws Exception {
        String filename = "Tree.jpg";
        EmbeddedImage embeddedImage = new EmbeddedImage(filename, 10, 10, 50, 50);
        embeddedImage.scale(3);
        assertEquals(150,embeddedImage.getHeight());
        assertEquals(150,embeddedImage.getWidth());
    }

    @Test
    public void render() throws Exception {

        String filename = "Tree.jpg";
        EmbeddedImage embeddedImage = new EmbeddedImage(filename, 10, 10, 50, 50);

        BufferedImage bufferedImage = new BufferedImage(400, 400, BufferedImage.TYPE_INT_RGB);

        Graphics2D graphics = bufferedImage.createGraphics();
        graphics.setColor(Color.white);

        embeddedImage.render(graphics);
        ImageIO.write(bufferedImage, "png", new File("output/Emdedded.png"));
    }

}