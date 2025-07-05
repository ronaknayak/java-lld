/**
 * If a class has more than one reason to change, it means it has more than one responsibility, and it’s violating SRP.
 *
 * Benefits of Refactored Version:
 *
 * SRP Compliance	Each class has 1 reason to change
 *
 * Testability	Each component can be tested in isolation
 *
 * Extensibility	Easily switch to SMS instead of email without touching OrderProcessor
 *
 * Readability	OrderProcessor now reads like a story
 *
 * Reusability	OrderValidator can be reused in other contexts (e.g., UI validation, REST API)
 */

// Central Orchestrator (still SRP-compliant)
public class OrderProcessor {

    private final OrderValidator validator = new OrderValidator();
    private final OrderRepository repository = new OrderRepository();
    private final EmailService emailService = new EmailService();
    private final OrderLogger logger = new OrderLogger();

    public void process(Order order) {
        validator.validate(order);
        repository.save(order);
        emailService.sendConfirmation(order.getCustomerEmail());
        logger.logOrder(order);
    }
}


class OrderValidator {
    public void validate(Order order) {
        if (order.getItems().isEmpty()) {
            throw new RuntimeException("No items in order.");
        }
    }
}

class OrderRepository {
    public void save(Order order) {
        // Save to DB logic
    }
}

class EmailService {
    public void sendConfirmation(String email) {
        // Email sending logic
    }
}

class OrderLogger {
    public void logOrder(Order order) {
        // Logging logic
    }
}
