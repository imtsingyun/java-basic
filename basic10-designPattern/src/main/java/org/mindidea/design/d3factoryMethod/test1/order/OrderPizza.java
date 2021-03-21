/*
 * @class OrderPizza
 * @package org.mindidea.design.d2simplefactory.order
 * @date 2021年3月20日 21:29
 * Copyright (c) 2021 MindIdea.org, All Rights Reserved.
 */
package org.mindidea.design.d3factoryMethod.test1.order;

import org.mindidea.design.d3factoryMethod.test1.pizzaStore.Pizza;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 使用工厂方法模式
 *
 * @author Tsingyun(青雲)
 * @version V1.0
 * @createTime 2021年3月20日 21:29
 * @blog https://mindidea.org
 */
public abstract class OrderPizza {

    // 构造器
    public OrderPizza() {
        String pizzaType;
        do {
            pizzaType = getType();
            Pizza pizza = createPizza(pizzaType);
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
     * 抽象方法，让工厂子类自己来实现细节
     *
     * @param pizzaType 披萨类型
     * @return 披萨
     */
    abstract Pizza createPizza(String pizzaType);

    /**
     * 根据用户的输入获取披萨的类型
     *
     * @return PizzaType
     */
    private String getType() {
        try {
            BufferedReader strin = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("input pizza type:");
            return strin.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}
