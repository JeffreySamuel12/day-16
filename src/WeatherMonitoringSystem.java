
import java.util.ArrayList;
import java.util.List;

// Observer interface
interface Observer {
    void update(float temperature, float humidity);
}

// Subject interface
interface Subject {
    void registerObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers();
}

// Concrete Subject class
class WeatherData implements Subject {
    private List<Observer> observers;
    private float temperature;
    private float humidity;

    public WeatherData() {
        observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(temperature, humidity);
        }
    }

    public void setMeasurements(float temperature, float humidity) {
        this.temperature = temperature;
        this.humidity = humidity;
        notifyObservers();
    }
}

// Concrete Observer classes
class TemperatureDisplay implements Observer {
    private float temperature;

    @Override
    public void update(float temperature, float humidity) {
        this.temperature = temperature;
        display();
    }

    public void display() {
        System.out.println("Current Temperature: " + temperature + "°C");
    }
}

class HumidityDisplay implements Observer {
    private float humidity;

    @Override
    public void update(float temperature, float humidity) {
        this.humidity = humidity;
        display();
    }

    public void display() {
        System.out.println("Current Humidity: " + humidity + "%");
    }
}

// Main class
public class WeatherMonitoringSystem {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();

        TemperatureDisplay tempDisplay = new TemperatureDisplay();
        HumidityDisplay humidityDisplay = new HumidityDisplay();

        weatherData.registerObserver(tempDisplay);
        weatherData.registerObserver(humidityDisplay);

        // Simulate new weather measurements
        weatherData.setMeasurements(25.5f, 65.0f);
        weatherData.setMeasurements(27.0f, 70.0f);
    }
}
