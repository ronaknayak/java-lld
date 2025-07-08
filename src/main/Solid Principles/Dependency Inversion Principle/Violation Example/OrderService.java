/**
 * Instead of tightly coupling your code to concrete classes, depend on interfaces or abstract classes.
 */
public class OrderService {
    private EmailService emailService = new EmailService();

    public void placeOrder(Order order) {
        // process order
        emailService.send(order.getCustomerEmail());
    }
}
