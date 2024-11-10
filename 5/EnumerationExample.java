import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;

// Adapter class that adapts Enumeration to Iterator
class EnumerationIterator implements Iterator<String> {
    private Enumeration<String> enumeration;

    public EnumerationIterator(Enumeration<String> enumeration) {
        this.enumeration = enumeration;
    }

    @Override
    public boolean hasNext() {
        return enumeration.hasMoreElements();
    }

    @Override
    public String next() {
        return enumeration.nextElement();
    }
}

// Main class to demonstrate the Adapter Pattern
public class EnumerationExample {
    public static void main(String[] args) {
        // Create a Vector (which implements Enumeration)
        Vector<String> vector = new Vector<>();
        vector.add("One");
        vector.add("Two");
        vector.add("Three");

        // Create an Enumeration from the Vector
        Enumeration<String> enumeration = vector.elements();

        // Adapting Enumeration to Iterator
        Iterator<String> iterator = new EnumerationIterator(enumeration);

        // Using the adapted Iterator
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}

