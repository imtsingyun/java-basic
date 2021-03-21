package org.mindidea.design.d4abstractFactory.order;

public class PizzaStore {
    public static void main(String[] args) {
        new OrderPizza(new LDFactory());
    }
}
