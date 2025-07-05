/**
 * Benefits:
 * SRP is respected: each component does one job
 *
 * Testability: each unit is independently testable
 *
 * Readability: OrderService is now an orchestrator — clear and focused
 *
 * Extensibility: easier to introduce new behaviors like payment processing or order discounts
 */
@Service
public class OrderService {

    @Autowired private OrderValidator validator;
    @Autowired private OrderMapper mapper;
    @Autowired private OrderRepository orderRepository;
    @Autowired private EmailService emailService;
    @Autowired private PricingService pricingService;

    public Order placeOrder(OrderRequest request) {
        validator.validate(request);

        Order order = mapper.mapToOrder(request);
        order.setTotal(pricingService.calculateTotal(order.getItems()));

        orderRepository.save(order);
        emailService.sendConfirmation(order.getCustomer().getEmail());

        return order;
    }
}
