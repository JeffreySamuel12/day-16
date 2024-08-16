// PaymentProcessingSystem.java

// Strategy interface
interface PaymentStrategy {
    void pay(double amount);
}

// Concrete Strategy Classes
class CreditCardPayment implements PaymentStrategy {
    private String cardNumber;

    public CreditCardPayment(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using Credit Card: " + cardNumber);
    }
}

class PayPalPayment implements PaymentStrategy {
    private String email;

    public PayPalPayment(String email) {
        this.email = email;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using PayPal: " + email);
    }
}

class BankTransferPayment implements PaymentStrategy {
    private String bankAccount;

    public BankTransferPayment(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using Bank Transfer: " + bankAccount);
    }
}

// Context class
class PaymentContext {
    private PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void processPayment(double amount) {
        paymentStrategy.pay(amount);
    }
}

// Main class
public class PaymentProcessingSystem {
    public static void main(String[] args) {
        PaymentContext context = new PaymentContext();

        // User selects Credit Card payment
        context.setPaymentStrategy(new CreditCardPayment("1234-5678-9012-3456"));
        context.processPayment(100.0);

        // User selects PayPal payment
        context.setPaymentStrategy(new PayPalPayment("user@example.com"));
        context.processPayment(200.0);

        // User selects Bank Transfer payment
        context.setPaymentStrategy(new BankTransferPayment("9876543210"));
        context.processPayment(300.0);
    }
}
