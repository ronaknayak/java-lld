package com.lld.design.pattern.behavioural;

/**
 * The Template Method Pattern defines the skeleton of an algorithm in a base class but lets
 * subclasses override specific steps without changing the overall structure.
 *
 * Advantages of Template Design Pattern:
 * Encourages Code ReUsability
 * Defines a Consistent Algorithm Structure
 * Supports Open-Closed Principle
 * Improves Code Maintainability
 */
public class TemplateMethodDesign {
    public static void main(String[] args) {
        PurchaseOrderTemplate online = new StorePurchaseOrder();
        online.isGift = true;
        online.processOrder();
        System.out.println("-----------------------------------");
        PurchaseOrderTemplate offline = new OnlinePurchaseOrder();
        offline.processOrder();
    }
}

abstract class PurchaseOrderTemplate {

    public boolean isGift;

    public abstract void doSelect();

    public abstract void doPayment();

    public final void doPack() {
        System.out.println("Gift wrap done.");
    }

    public abstract void doDelivery();

    public final void processOrder() {
        doSelect();
        doPayment();
        if (isGift) {
            doPack();
        }
        doDelivery();
    }
}

class StorePurchaseOrder extends PurchaseOrderTemplate {

    @Override
    public void doSelect() {
        System.out.println("Customer chooses the item from self.");
    }

    @Override
    public void doPayment() {
        System.out.println("Pays at the counter through cash/card");
    }

    @Override
    public void doDelivery() {
        System.out.println("Item delivered to in-delivery counter.");
    }
}

class OnlinePurchaseOrder extends PurchaseOrderTemplate {

    @Override
    public void doSelect() {
        System.out.println("Item added to online shopping cart,");
        System.out.println("Get gift wrap preference,");
        System.out.println("Get delivery address.");
    }

    @Override
    public void doPayment() {
        System.out.println("Online Payment through Net-banking/Cards.");
    }

    @Override
    public void doDelivery() {
        System.out.println("Ship the item through post to delivery address");
    }
}
