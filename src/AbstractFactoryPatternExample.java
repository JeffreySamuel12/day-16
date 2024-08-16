
// Abstract Product Interfaces
interface Button {
    void render();
}

interface TextField {
    void render();
}

// Concrete Product Classes for Light Theme
class LightButton implements Button {
    @Override
    public void render() {
        System.out.println("Rendering Light Button");
    }
}

class LightTextField implements TextField {
    @Override
    public void render() {
        System.out.println("Rendering Light TextField");
    }
}

// Concrete Product Classes for Dark Theme
class DarkButton implements Button {
    @Override
    public void render() {
        System.out.println("Rendering Dark Button");
    }
}

class DarkTextField implements TextField {
    @Override
    public void render() {
        System.out.println("Rendering Dark TextField");
    }
}

// Abstract Factory Interface
interface UIFactory {
    Button createButton();
    TextField createTextField();
}

// Concrete Factory Classes for Light Theme
class LightUIFactory implements UIFactory {
    @Override
    public Button createButton() {
        return new LightButton();
    }

    @Override
    public TextField createTextField() {
        return new LightTextField();
    }
}

// Concrete Factory Classes for Dark Theme
class DarkUIFactory implements UIFactory {
    @Override
    public Button createButton() {
        return new DarkButton();
    }

    @Override
    public TextField createTextField() {
        return new DarkTextField();
    }
}

// Main class
public class AbstractFactoryPatternExample {
    public static void main(String[] args) {
        // Create a Light Theme Factory
        UIFactory lightFactory = new LightUIFactory();
        Button lightButton = lightFactory.createButton();
        TextField lightTextField = lightFactory.createTextField();
        lightButton.render();
        lightTextField.render();

        // Create a Dark Theme Factory
        UIFactory darkFactory = new DarkUIFactory();
        Button darkButton = darkFactory.createButton();
        TextField darkTextField = darkFactory.createTextField();
        darkButton.render();
        darkTextField.render();
    }
}
