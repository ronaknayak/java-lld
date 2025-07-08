/**
 * If a class is forced to implement methods it doesn’t need, that interface is doing too much.
 * Instead, split big interfaces into smaller ones — based on specific roles or use cases.
 *
 * Since the 5 methods are part of the RestaurantInterface, the implementation classes have to
 * implement all 5 of them.
 * Any change in any of the methods of the RestaurantInterface will propagate to all implementation
 * classes.
 * Maintenance of code then starts becoming really hard.
 */
public interface RestaurantInterface {
     public void acceptOnlineOrder();
     public void acceptTelephoneOrder();
     public void acceptWalkInCustomerOrder();
     public void payOnline();
     public void payInPerson();
}

public class OnlineCustomerImpl implements RestaurantInterface {
     public void acceptOnlineOrder() {
          //logic for placing online order
     }

     public void acceptTelephoneOrder() {
          //Not Applicable for Online Order
          throw new UnsupportedOperationException();
     }

     public void payOnline() {
          //logic for paying online
     }

     public void acceptWalkInCustomerOrder() {
          //Not Applicable for Online Order
          throw new UnsupportedOperationException();
     }

     public void payInPerson() {
          //Not Applicable for Online Order
          throw new UnsupportedOperationException();
     }
}
