/**
 * You should be able to add new behavior to a class without changing its existing code.
 *
 *
 * Benefit	Why It Matters
 * 🔄 Easy to extend	Add new payment types without touching existing logic
 * 💥 Avoids regressions	No risk of breaking existing functionality
 * 🧪 Easy to test	Each class handles its own behavior
 * 🔗 Supports plug-in architecture	Promotes reusable, pluggable components
 */
public class PaymentService {
    public void processPayment(PaymentStrategy payment) {
        payment.pay(); // Open for extension, closed for modification
    }
}

interface PaymentStrategy {
    void pay();
}

class CreditCardPayment implements PaymentStrategy {
    public void pay() {
        System.out.println("Paying by credit card");
    }
}

class UpiPayment implements PaymentStrategy {
    public void pay() {
        System.out.println("Paying via UPI");
    }
}

class PaypalPayment implements PaymentStrategy {
    public void pay() {
        System.out.println("Paying with PayPal");
    }
}
