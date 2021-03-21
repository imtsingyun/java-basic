package org.mindidea.design.d2simplefactory.order;


import org.mindidea.design.d2simplefactory.pizzastore.*;

// 简单工厂类
public class SimpleFactory {

    // 根据 pizzaType 返回一个 Pizza 对象
    public Pizza createPizza(String pizzaType) {
        return createPizza2(pizzaType);
    }

    public static Pizza createPizza2(String pizzaType) {
        System.out.println("使用简单工厂模式");
        Pizza pizza = null;
        switch (pizzaType) {
            case "greek":
                pizza = new GreekPizza("Greek Pizza");
                break;
            case "cheese":
                pizza = new CheesePizza("Cheese Pizza");
                break;
            case "pepper":
                pizza = new PepperPizza("Pepper Pizza");
                break;
            case "chinese":
                pizza = new ChinesePizza("Chinese Pizza");
                break;
        }
        return pizza;
    }
}
