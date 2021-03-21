package org.mindidea.design.d4abstractFactory.order;

import org.mindidea.design.d4abstractFactory.pizza.Pizza;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OrderPizza {

    AbstractFactory abstractFactory;

    public OrderPizza(AbstractFactory abstractFactory) {
        this.abstractFactory = abstractFactory;
        Pizza pizza;
        String pizzaType;
        do {
            pizzaType = getType();
            pizza = this.abstractFactory.createPizza(pizzaType);
            if (pizza != null) {
                pizza.prepare();
                pizza.bake();
                pizza.cut();
                pizza.box();
            } else {
                System.out.println("订购披萨失败");
                break;
            }
        } while (true);
    }

    /**
     * 根据用户的输入获取披萨的类型
     *
     * @return PizzaType
     */
    private String getType() {
        try {
            BufferedReader strIn = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("input pizza type:");
            return strIn.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}
