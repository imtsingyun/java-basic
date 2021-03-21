package org.mindidea.design.d4abstractFactory.order;

import org.mindidea.design.d4abstractFactory.pizza.LDCheesePizza;
import org.mindidea.design.d4abstractFactory.pizza.LDPepperPizza;
import org.mindidea.design.d4abstractFactory.pizza.Pizza;

/**
 * 抽象工厂的一个具体实现类
 */
public class LDFactory implements AbstractFactory {

    @Override
    public Pizza createPizza(String pizzaType) {
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
