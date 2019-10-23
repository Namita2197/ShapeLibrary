import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class InputOutputStream {

    public Composite readShape(String filename) throws Exception {

        File file = new File(filename);
        BufferedReader br = new BufferedReader(new FileReader(file));

        String line = br.readLine();
        String shape ="";

        while (line != null) {
            shape = shape.concat(line + System.lineSeparator());
            line= br.readLine();
        }
        ShapeFactory shapeFactory = new ShapeFactory();
        Composite compositeShape = shapeFactory.create(shape);
        return compositeShape;
    }

    public void writeShape(String filename, Composite shape) throws Exception {
        try (Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filename), "utf-8"))) {
            writer.write(shape.toString());
        }
    }

}
