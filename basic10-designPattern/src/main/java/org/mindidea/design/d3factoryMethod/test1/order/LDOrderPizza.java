package org.mindidea.design.d3factoryMethod.test1.order;


import org.mindidea.design.d3factoryMethod.test1.pizzaStore.*;

public class LDOrderPizza extends OrderPizza {

    @Override
    Pizza createPizza(String pizzaType) {
        Pizza pizza = null;
        switch (pizzaType) {
            case "cheese":
                pizza = new LDCheesePizza();
                break;
            case "pepper":
                pizza = new LDPepperPizza();
                break;
        }
        return pizza;
    }
}
