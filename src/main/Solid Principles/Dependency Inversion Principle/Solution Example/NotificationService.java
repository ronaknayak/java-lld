/**
 * Now:
 * You can easily inject SMSNotificationService, PushNotificationService, etc.
 * OrderService doesn’t care about details, only abstraction.
 *
 * The above code also follows the Liskov Substitution Principle, as the
 * NotificationService type can be substituted with both of its subtypes
 * (EmailNotificationService and SMSNotificationService) without breaking the program.
 */
public interface NotificationService {
    void send(String to);
}

@Component
public class EmailNotificationService implements NotificationService {
    public void send(String to) {
        System.out.println("Email sent to: " + to);
    }
}

@Component
public class SMSNotificationService implements NotificationService {
    public void send(String to) {
        System.out.println("SMS sent to: " + to);
    }
}

@Service
public class OrderService {

    private final NotificationService notificationService;

    @Autowired
    public OrderService(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    public void placeOrder(Order order) {
        // business logic
        notificationService.send(order.getCustomerEmail());
    }
}
