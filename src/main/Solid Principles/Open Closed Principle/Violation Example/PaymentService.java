/**
 * Every time a new payment type is added, you must modify this class.
 */
public class PaymentService {
    public void processPayment(String paymentType) {
        if (paymentType.equals("CREDIT_CARD")) {
            // credit card logic
        } else if (paymentType.equals("UPI")) {
            // UPI logic
        } else if (paymentType.equals("PAYPAL")) {
            // PayPal logic
        }
    }
}
