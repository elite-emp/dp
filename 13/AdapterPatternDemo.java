// Step 1: Define the Volt class
class Volt {
    private int volts;

    public Volt(int volts) {
        this.volts = volts;
    }

    public int getVolts() {
        return volts;
    }
}

// Step 2: Define the Socket class that produces 120V
class Socket {
    public Volt getVolt() {
        return new Volt(120);
    }
}

// Step 3: Create an interface for the Adapter
interface VoltAdapter {
    Volt get3Volt();
    Volt get12Volt();
    Volt get120Volt();
}

// Step 4: Implement the Adapter using class adapter pattern
class VoltAdapterImpl extends Socket implements VoltAdapter {
    @Override
    public Volt get3Volt() {
        return convertVolt(getVolt(), 40);
    }

    @Override
    public Volt get12Volt() {
        return convertVolt(getVolt(), 10);
    }

    @Override
    public Volt get120Volt() {
        return getVolt(); // Directly returns 120V
    }

    private Volt convertVolt(Volt volt, int divider) {
        return new Volt(volt.getVolts() / divider);
    }
}

// Step 5: Create a main class to test the Adapter pattern
public class AdapterPatternDemo {
    public static void main(String[] args) {
        VoltAdapter voltAdapter = new VoltAdapterImpl();

        Volt v3 = voltAdapter.get3Volt();
        System.out.println("Voltage: " + v3.getVolts() + "V");

        Volt v12 = voltAdapter.get12Volt();
        System.out.println("Voltage: " + v12.getVolts() + "V");

        Volt v120 = voltAdapter.get120Volt();
        System.out.println("Voltage: " + v120.getVolts() + "V");
    }
}

