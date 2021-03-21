package org.mindidea.design.d4abstractFactory.order;

import org.mindidea.design.d4abstractFactory.pizza.BJCheesePizza;
import org.mindidea.design.d4abstractFactory.pizza.BJPepperPizza;
import org.mindidea.design.d4abstractFactory.pizza.Pizza;

/**
 * 抽象工厂的一个具体实现类
 */
public class BJFactory implements AbstractFactory {
    @Override
    public Pizza createPizza(String pizzaType) {
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
