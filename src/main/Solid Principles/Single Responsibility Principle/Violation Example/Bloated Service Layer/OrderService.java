/**
 * What is a Bloated Service Layer?
 * It refers to a service class that tries to do everything — it becomes a God class by:
 *
 * Coordinating business logic
 *
 * Performing validation
 *
 * Interacting directly with the database
 *
 * Managing side effects (emails, logs, payments, etc.)
 *
 * Doing transformations or DTO conversions
 *
 * Handling exceptions
 */

@Service
public class OrderService {

    @Autowired private OrderRepository orderRepository;
    @Autowired private EmailService emailService;

    public Order placeOrder(OrderRequest request) {
        // Validate
        if (request.getItems().isEmpty()) {
            throw new RuntimeException("Items required");
        }

        // Map request to entity
        Order order = new Order();
        order.setCustomer(request.getCustomer());
        order.setItems(request.getItems());
        order.setTotal(calculateTotal(request.getItems()));

        // Save
        orderRepository.save(order);

        // Send email
        emailService.sendConfirmation(order.getCustomer().getEmail());

        // Return result
        return order;
    }

    private double calculateTotal(List<Item> items) {
        // price * quantity calculation
    }
}
