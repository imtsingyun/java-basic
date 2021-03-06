/*
 * @class OrderPizza
 * @package org.mindidea.design.d2simplefactory.order
 * @date 2021年3月20日 21:29
 * Copyright (c) 2021 MindIdea.org, All Rights Reserved.
 */
package org.mindidea.design.d2simpleFactory.order;

import org.mindidea.design.d2simpleFactory.pizzastore.Pizza;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Tsingyun(青雲)
 * @version V1.0
 * @createTime 2021年3月20日 21:29
 * @blog https://mindidea.org
 */
public class OrderPizza {

    SimpleFactory simpleFactory;
    Pizza pizza = null;

    public OrderPizza(SimpleFactory factory) {
        setFactory(factory);
    }

    public void setFactory(SimpleFactory simpleFactory) {
        String pizzaType = "";
        this.simpleFactory = simpleFactory;
        do {
            pizzaType = getType();
            pizza = this.simpleFactory.createPizza(pizzaType);
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
