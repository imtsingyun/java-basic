package org.mindidea.design.d3factoryMethod.test1.order;


import org.mindidea.design.d3factoryMethod.test1.pizza.BJCheesePizza;
import org.mindidea.design.d3factoryMethod.test1.pizza.BJPepperPizza;
import org.mindidea.design.d3factoryMethod.test1.pizza.Pizza;

public class BJOrderPizza extends OrderPizza {

    @Override
    Pizza createPizza(String pizzaType) {
        Pizza pizza = null;
        switch (pizzaType) {
            case "cheese":
                pizza = new BJCheesePizza();
                break;
            case "pepper":
                pizza = new BJPepperPizza();
                break;
        }
        return pizza;
    }
}
