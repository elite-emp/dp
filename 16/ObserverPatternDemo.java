import java.util.ArrayList;
import java.util.List;

// Step 1: Define the Subject (NumberConverter)
class NumberConverter {
    private List<NumberObserver> observers = new ArrayList<>();
    private int decimalNumber;

    public void addObserver(NumberObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(NumberObserver observer) {
        observers.remove(observer);
    }

    public void setDecimalNumber(int decimalNumber) {
        this.decimalNumber = decimalNumber;
        notifyObservers();
    }

    public int getDecimalNumber() {
        return decimalNumber;
    }

    private void notifyObservers() {
        for (NumberObserver observer : observers) {
            observer.update(decimalNumber);
        }
    }
}

// Step 2: Define the Observer interface
interface NumberObserver {
    void update(int decimalNumber);
}

// Step 3: Implement Concrete Observers
class HexadecimalObserver implements NumberObserver {
    @Override
    public void update(int decimalNumber) {
        System.out.println("Hexadecimal: " + Integer.toHexString(decimalNumber).toUpperCase());
    }
}

class OctalObserver implements NumberObserver {
    @Override
    public void update(int decimalNumber) {
        System.out.println("Octal: " + Integer.toOctalString(decimalNumber));
    }
}

class BinaryObserver implements NumberObserver {
    @Override
    public void update(int decimalNumber) {
        System.out.println("Binary: " + Integer.toBinaryString(decimalNumber));
    }
}

// Step 4: Create a main class to demonstrate the Observer Pattern
public class ObserverPatternDemo {
    public static void main(String[] args) {
        NumberConverter numberConverter = new NumberConverter();

        HexadecimalObserver hexObserver = new HexadecimalObserver();
        OctalObserver octObserver = new OctalObserver();
        BinaryObserver binObserver = new BinaryObserver();

        numberConverter.addObserver(hexObserver);
        numberConverter.addObserver(octObserver);
        numberConverter.addObserver(binObserver);

        // Set initial decimal number
        System.out.println("Setting decimal number to 10:");
        numberConverter.setDecimalNumber(10);

        System.out.println();

        // Change the decimal number
        System.out.println("Changing decimal number to 255:");
        numberConverter.setDecimalNumber(255);

        System.out.println();

        // Change the decimal number again
        System.out.println("Changing decimal number to 100:");
        numberConverter.setDecimalNumber(100);
    }
}

