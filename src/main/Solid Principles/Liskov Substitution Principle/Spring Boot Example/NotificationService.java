public interface NotificationService {
    void sendNotification(String recipient, String message);
}

@Component
public class EmailNotificationService implements NotificationService {
    public void sendNotification(String recipient, String message) {
        System.out.println("Email sent to " + recipient + ": " + message);
    }
}

@Component
public class SmsNotificationService implements NotificationService {
    public void sendNotification(String recipient, String message) {
        System.out.println("SMS sent to " + recipient + ": " + message);
    }
}

@Service
public class AlertService {

    private final NotificationService notificationService;

    @Autowired
    public AlertService(@Qualifier("emailNotificationService") NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    public void sendAlert(String recipient, String message) {
        notificationService.sendNotification(recipient, message);
    }
}
