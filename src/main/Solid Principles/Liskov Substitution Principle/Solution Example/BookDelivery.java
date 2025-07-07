/**
 * After the refactoring, we could use any subclass in place of its superclass without breaking the application.
 */
public class BookDelivery {
     String title;
     Integer userID;
}


public class OfflineDelivery extends BookDelivery {
     void getDeliveryLocations() {
     }
}

public class OnlineDelivery extends BookDelivery {

     void getSoftwareOptions() {
     }
}

public class PosterMapDelivery extends OfflineDelivery {

     @Override
     void getDeliveryLocations() {
     }

}

public class AudioBookDelivery extends OnlineDelivery {

     @Override
     void getSoftwareOptions() {
     }
}
