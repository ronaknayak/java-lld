/**
 * If class B is a subclass of class A, you should be able to use B wherever A is expected — without breaking behavior.
 * A child class shouldn't violate the expectations set by the parent class.
 *
 *
 * Why is it required to follow Liskov Substitution Principle?
 *
 * 1. This avoids overuse/misuse of inheritance. It helps us conform to the “is-a” relationship.
 * We can also say that subclasses must fulfil a contract defined by the base class.
 * See Book Delivery example.
 *
 * 2. Guarantees Behavioral Correctness
 * When a child class violates the parent’s behavior contract, the code still compiles — but behaves incorrectly at runtime.
 *
 * 3. Supports Open/Closed Principle
 * You can only safely extend behavior (OCP) if your new class doesn’t break substitution (LSP).
 * If B breaks expectations of A, then: You can’t replace A with B and You’re forced to modify existing logic → OCP fails
 *
 * 4. Enables Safe Polymorphism in Frameworks
 * See Spring Boot Example.
 *
 *
 * What are the common signs of a violation of LSP?
 *
 * Common signs of a violation include derived classes overriding methods in ways that are inconsistent with the base class,
 * throwing unexpected exceptions, or requiring additional conditions not specified in the base class etc.
 */
public class BookDelivery {
     String titles;
     Integer userID;
     void getDeliveryLocations() {
     }
}

public class PosterMapDelivery extends BookDelivery {

    @Override
    void getDeliveryLocations() {
        //Works here
    }
}

public class AudioBookDelivery extends BookDelivery {
    @Override
    void getDeliveryLocations() {
        /* Does not work here because it can't be implemented since
         * Audio book doesn't have a physical location. */
    }
}