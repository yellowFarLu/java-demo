package huangy.serli;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author huangy on 2019-05-02
 */

abstract class Shape implements Serializable {

    public static final int RED = 1, BLUE = 2, GREEN = 3;

    private int xPos, yPos, dimension;

    private static Random rand = new Random(47);

    private static int counter = 0;

    public abstract void setColor(int newColor);

    public abstract int getColor();

    public Shape(int xPos, int yPos, int dimension) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.dimension = dimension;
    }

    @Override
    public String toString() {
        return "Shape{" +
                "xPos=" + xPos +
                ", yPos=" + yPos +
                ", dimension=" + dimension +
                '}';
    }

    public static Shape randomFactory() {
        int xVal = rand.nextInt(100);
        int yVal = rand.nextInt(100);
        int dim = rand.nextInt(100);

        switch (counter++ %3) {
            default:
            case 0: return new Circle(xVal, yVal, dim);
            case 1: return new Squre(xVal, yVal, dim);
            case 2: return new Line(xVal, yVal, dim);
        }
    }
}

class Circle extends Shape {
    private static int color;

    public Circle(int xPos, int yPos, int dimension) {
        super(xPos, yPos, dimension);
        color = RED;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        Circle.color = color;
    }

    @Override
    public String toString() {
        return "Circle{color=" + color + "}" + super.toString();
    }
}


class Squre extends Shape {
    private static int color;

    public Squre(int xPos, int yPos, int dimension) {
        super(xPos, yPos, dimension);
        color = RED;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        Squre.color = color;
    }

    @Override
    public String toString() {
        return "Squre{color=" + color + "}" + super.toString();
    }
}

class Line extends Shape {

    private static int color;

    public static void serializeStaticState(ObjectOutputStream outputStream)
    throws IOException {
        outputStream.writeInt(color);
    }

    public static void deserializeStaticState(ObjectInputStream inputStream)
    throws IOException {
        color = inputStream.readInt();
    }

    public Line(int xPos, int yPos, int dimension) {
        super(xPos, yPos, dimension);
    }
    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        Line.color = color;
    }

    @Override
    public String toString() {
        return "Line{color=" + color + "}" + super.toString();
    }
}

public class StoreCADState {

    public static void main(String[] args) throws Exception {
        List<Class<? extends Shape>> shapeTypes = new ArrayList<>();
        shapeTypes.add(Circle.class);
        shapeTypes.add(Squre.class);
        shapeTypes.add(Line.class);

        List<Shape> shapes = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            shapes.add(Shape.randomFactory());
        }

        for (int i = 0; i < 10; i++) {
            shapes.get(i).setColor(Shape.GREEN);
        }

        ObjectOutputStream outputStream = new ObjectOutputStream(
                new FileOutputStream(
                        "/Users/huangyuan/Desktop/Study/code/java-demo/src/main/java/huangy/serli/test.txt")
        );

        outputStream.writeObject(shapeTypes);
        Line.serializeStaticState(outputStream);

        outputStream.writeObject(shapes);
    }

}
