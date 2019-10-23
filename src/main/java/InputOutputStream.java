import java.awt.image.BufferedImage;
import java.io.*;
public class InputOutputStream {

    public CompositeShape readShape(String filename) throws Exception {

        File file = new File(filename);
        BufferedReader br = new BufferedReader(new FileReader(file));

        String line;
        String shape ="";
        
        while ((line = br.readLine()) != null)
            shape = shape.concat(line+System.lineSeparator());

        // Parse the input
        ShapeFactory shapeObject = new ShapeFactory();
        CompositeShape compositeShape = shapeObject.create(shape);
        return compositeShape;
    }

    public void writeShape(String filename, CompositeShape shape) throws Exception {
        try (Writer writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(filename), "utf-8"))) {
            writer.write(shape.toString());
        }
    }

}
