/**
 * Problems:
 * 1. Multiple reasons to change:
 *
 * Email logic changes → modify this class
 * Logging format changes → modify this class
 * DB schema changes → modify this class
 *
 * 2. Hard to test in isolation
 *
 * 3. High coupling between unrelated parts of the system
 */
public class OrderProcessor {

    public void processOrder(Order order) {
        // 1. Validate order
        if (order.getItems().isEmpty()) {
            throw new RuntimeException("No items in order.");
        }

        // 2. Save to DB
        Database.save(order);

        // 3. Send confirmation email
        EmailSender.send(order.getCustomerEmail(), "Order placed!");

        // 4. Log order
        Logger.log("Order processed: " + order.getId());
    }
}
