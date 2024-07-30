package Q4;

interface PaymentProcessor {
    void processPayment(double amount);
}


class PayPal {
    public void makePayment(double amount) {
        System.out.println("Processing payment of $" + amount + " through PayPal.");
    }
}


class Stripe {
    public void charge(double amount) {
        System.out.println("Charging $" + amount + " through Stripe.");
    }
}


class Square {
    public void processTransaction(double amount) {
        System.out.println("Processing transaction of $" + amount + " through Square.");
    }
}


class PayPalAdapter implements PaymentProcessor {
    private PayPal payPal;

    public PayPalAdapter(PayPal payPal) {
        this.payPal = payPal;
    }

    @Override
    public void processPayment(double amount) {
        payPal.makePayment(amount);
    }
}


class StripeAdapter implements PaymentProcessor {
    private Stripe stripe;

    public StripeAdapter(Stripe stripe) {
        this.stripe = stripe;
    }

    @Override
    public void processPayment(double amount) {
        stripe.charge(amount);
    }
}


class SquareAdapter implements PaymentProcessor {
    private Square square;

    public SquareAdapter(Square square) {
        this.square = square;
    }

    @Override
    public void processPayment(double amount) {
        square.processTransaction(amount);
    }
}

// Test class
public class AdapterPatternExample {
    public static void main(String[] args) {

        PaymentProcessor payPalProcessor = new PayPalAdapter(new PayPal());
        payPalProcessor.processPayment(100.00);

        PaymentProcessor stripeProcessor = new StripeAdapter(new Stripe());
        stripeProcessor.processPayment(200.00);

        PaymentProcessor squareProcessor = new SquareAdapter(new Square());
        squareProcessor.processPayment(300.00);
    }
}
