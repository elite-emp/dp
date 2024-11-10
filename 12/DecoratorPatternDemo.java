// Step 1: Define the Car interface
interface Car {
    String assemble();
}

// Step 2: Implement Concrete Car Class
class BasicCar implements Car {
    @Override
    public String assemble() {
        return "Basic Car";
    }
}

// Step 3: Create an abstract CarDecorator class
abstract class CarDecorator implements Car {
    protected Car decoratedCar;

    public CarDecorator(Car decoratedCar) {
        this.decoratedCar = decoratedCar;
    }

    @Override
    public String assemble() {
        return decoratedCar.assemble();
    }
}

// Step 4: Implement Concrete Decorators
class SportsCarDecorator extends CarDecorator {
    public SportsCarDecorator(Car decoratedCar) {
        super(decoratedCar);
    }

    @Override
    public String assemble() {
        return super.assemble() + " + Sports Features (e.g., enhanced speed, sporty design)";
    }
}

class LuxuryCarDecorator extends CarDecorator {
    public LuxuryCarDecorator(Car decoratedCar) {
        super(decoratedCar);
    }

    @Override
    public String assemble() {
        return super.assemble() + " + Luxury Features (e.g., premium materials, advanced technology)";
    }
}

// Step 5: Create a main class to demonstrate the Decorator Pattern
public class DecoratorPatternDemo {
    public static void main(String[] args) {
        // Create a basic car
        Car basicCar = new BasicCar();
        System.out.println(basicCar.assemble());

        // Decorate the basic car to a sports car
        Car sportsCar = new SportsCarDecorator(new BasicCar());
        System.out.println(sportsCar.assemble());

        // Decorate the basic car to a luxury car
        Car luxuryCar = new LuxuryCarDecorator(new BasicCar());
        System.out.println(luxuryCar.assemble());

        // Combine both sports and luxury features
        Car sportsLuxuryCar = new LuxuryCarDecorator(new SportsCarDecorator(new BasicCar()));
        System.out.println(sportsLuxuryCar.assemble());
    }
}

