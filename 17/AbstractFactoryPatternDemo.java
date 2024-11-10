// Step 1: Define the Shape interface
interface Shape {
    void draw();
}

// Step 2: Implement concrete shapes
class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a Circle");
    }
}

class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a Square");
    }
}

// Step 3: Define the ShapeFactory interface
interface ShapeFactory {
    Shape createShape(String shapeType);
}

// Step 4: Implement concrete factories
class SimpleShapeFactory implements ShapeFactory {
    @Override
    public Shape createShape(String shapeType) {
        if (shapeType.equalsIgnoreCase("CIRCLE")) {
            return new Circle();
        } else if (shapeType.equalsIgnoreCase("SQUARE")) {
            return new Square();
        }
        return null;
    }
}

// Step 5: Create another factory (if needed) for different types
class AdvancedShapeFactory implements ShapeFactory {
    @Override
    public Shape createShape(String shapeType) {
        // Additional shapes could be added here
        return null; // Returning null for simplicity
    }
}

// Step 6: Create a main class to demonstrate the Abstract Factory Pattern
public class AbstractFactoryPatternDemo {
    public static void main(String[] args) {
        ShapeFactory shapeFactory = new SimpleShapeFactory();

        // Create a Circle
        Shape circle = shapeFactory.createShape("CIRCLE");
        circle.draw();

        // Create a Square
        Shape square = shapeFactory.createShape("SQUARE");
        square.draw();
    }
}

