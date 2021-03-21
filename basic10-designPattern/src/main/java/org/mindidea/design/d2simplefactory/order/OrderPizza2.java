/*
 * @class OrderPizza
 * @package org.mindidea.design.d2simplefactory.order
 * @date 2021年3月20日 21:29
 * Copyright (c) 2021 MindIdea.org, All Rights Reserved.
 */
package org.mindidea.design.d2simplefactory.order;

import org.mindidea.design.d2simplefactory.pizzastore.Pizza;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Tsingyun(青雲)
 * @version V1.0
 * @createTime 2021年3月20日 21:29
 * @blog https://mindidea.org
 */
public class OrderPizza2 {

    Pizza pizza = null;

    public OrderPizza2() {
        String pizzaType = "";
        do {
            pizzaType = getType();
            pizza = SimpleFactory.createPizza2(pizzaType);

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
            BufferedReader strin = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("input pizza type:");
            return strin.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}
