/**
 * There will be no need to do any dummy implementation. Even there is no need to throw an
 * UnsupportedOperationException as each interface has only methods that it will always use.
 *
 *
 */
public interface OrderInterface{
     public void placeOrder();
 }

 public interface PaymentInterface{
     public void payForOrder();
 }

public class OnlineCustomerImpl implements OrderInterface, PaymentInterface {

    @Override
    public void placeOrder() {
        // logic to place online order
    }

    @Override
    public void payForOrder() {
        // logic to do online payment
    }
}

public class WalkInCustomerImpl implements OrderInterface, PaymentInterface {

    @Override
    public void placeOrder() {
        // logic to place in-person order
    }

    @Override
    public void payForOrder() {
        // logic to do in-person payment
    }
}


public class TelephoneCustomerImpl implements OrderInterface, PaymentInterface {

    @Override
    public void placeOrder() {
        // logic to place telephonic order
    }

    @Override
    public void payForOrder() {
        // logic to do online payment
    }
}
