import java.util.Observable;
import java.util.Observer;

// WeatherData class that extends Observable
class WeatherData extends Observable {
    private float temperature;
    private float humidity;
    private float pressure;

    // Method to indicate that measurements have changed
    public void measurementsChanged() {
        setChanged(); // Marks this Observable object as having been changed
        notifyObservers(); // Notifies all observers
    }

    // Method to set measurements
    public void setMeasurements(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged(); // Notify observers of the change
    }

    // Getters for temperature, humidity, and pressure
    public float getTemperature() {
        return temperature;
    }

    public float getHumidity() {
        return humidity;
    }

    public float getPressure() {
        return pressure;
    }
}

// Display class that implements Observer
class CurrentConditionsDisplay implements Observer {
    private float temperature;
    private float humidity;
    private Observable weatherData;

    public CurrentConditionsDisplay(Observable weatherData) {
        this.weatherData = weatherData;
        weatherData.addObserver(this); // Register as an observer
    }

    // Update method called when the Observable notifies observers
    @Override
    public void update(Observable obs, Object arg) {
        if (obs instanceof WeatherData) {
            WeatherData weatherData = (WeatherData) obs;
            this.temperature = weatherData.getTemperature();
            this.humidity = weatherData.getHumidity();
            display(); // Call the display method to show updated conditions
        }
    }

    // Method to display the current conditions
    public void display() {
        System.out.println("Current conditions: " + temperature + "°C and " + humidity + "% humidity");
    }
}

// Main class to run the weather station
public class WeatherStation {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();

        CurrentConditionsDisplay currentDisplay = new CurrentConditionsDisplay(weatherData);

        // Simulating new weather measurements
        weatherData.setMeasurements(25.0f, 65.0f, 1013.1f);
        weatherData.setMeasurements(27.0f, 70.0f, 1012.5f);
        weatherData.setMeasurements(20.0f, 80.0f, 1011.0f);
    }
}

