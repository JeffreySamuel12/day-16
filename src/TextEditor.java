interface Text {
    String getText();
}

// Concrete Component class
class PlainText implements Text {
    private String text;

    public PlainText(String text) {
        this.text = text;
    }

    @Override
    public String getText() {
        return text;
    }
}

// Abstract Decorator class
abstract class TextDecorator implements Text {
    protected Text decoratedText;

    public TextDecorator(Text decoratedText) {
        this.decoratedText = decoratedText;
    }

    @Override
    public String getText() {
        return decoratedText.getText();
    }
}

// Concrete Decorator classes
class BoldDecorator extends TextDecorator {
    public BoldDecorator(Text decoratedText) {
        super(decoratedText);
    }

    @Override
    public String getText() {
        return "<b>" + super.getText() + "</b>";
    }
}

class ItalicDecorator extends TextDecorator {
    public ItalicDecorator(Text decoratedText) {
        super(decoratedText);
    }

    @Override
    public String getText() {
        return "<i>" + super.getText() + "</i>";
    }
}

class UnderlineDecorator extends TextDecorator {
    public UnderlineDecorator(Text decoratedText) {
        super(decoratedText);
    }

    @Override
    public String getText() {
        return "<u>" + super.getText() + "</u>";
    }
}

// Main class
public class TextEditor {
    public static void main(String[] args) {
        Text text = new PlainText("Hello, World!");

        // Apply bold formatting
        text = new BoldDecorator(text);
        System.out.println(text.getText());

        // Apply italic formatting
        text = new ItalicDecorator(text);
        System.out.println(text.getText());

        // Apply underline formatting
        text = new UnderlineDecorator(text);
        System.out.println(text.getText());
    }
}

