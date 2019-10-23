public class ShapeFactory {

    public Composite create(String string) throws Exception {
            Composite compositeShape = new Composite();
             String string1 = string.toLowerCase();
            String[] shapeArray = string1.split(System.getProperty("line.separator"));

            for (int i = 1; i < shapeArray.length; i++) {

                String shapeName = shapeArray[i].split(":")[0];
                String shape = shapeArray[i].split(":")[1];
                if (shapeName.equals("rectangle")) {
                    System.out.println("Rectangle " + shape);
                    Rectangle rectangle = new Rectangle(shape);
                    compositeShape.appendShape(rectangle);
                }
                if (shapeName.equals("circle")) {
                    System.out.println("Circle " + shape);
                    Circle circle = new Circle(shape);
                    compositeShape.appendShape(circle);
                }
                if (shapeName.equals("triangle")) {
                    System.out.println("Triangle " + shape);
                    Triangle triangle = new Triangle(shape);
                    compositeShape.appendShape(triangle);
                }

                if (shapeName.equals("line")) {
                    System.out.println("Line" + shape);
                    Line line = new Line(shape);
                    compositeShape.appendShape(line);
                }

                if (shapeName.equals("embeddedimage")) {
                    System.out.println("embededimage" + shape);
                    EmbeddedImage embeddedImage= new EmbeddedImage(shape);
                    compositeShape.appendShape(embeddedImage);
                }

                if (shapeName.equals("composite")) {
                    int compositeElementCount = Integer.valueOf(shapeArray[i].split(":")[1]);
                    String innerComposite = "";
                    for (int j = 0; j <= compositeElementCount; j++) {
                        System.out.println("innerComposite : " + shapeArray[i + j]);
                        innerComposite = innerComposite.concat(shapeArray[i + j] + System.lineSeparator());
                    }
                    ShapeFactory factory = new ShapeFactory();
                    compositeShape.appendShape(factory.create(innerComposite));
                    i += compositeElementCount;
                }
            }
            return compositeShape;

    }

}
