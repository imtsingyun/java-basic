/*
 * @class OrderPizza
 * @package org.mindidea.design.d2simplefactory.order
 * @date 2021年3月20日 21:29
 * Copyright (c) 2021 MindIdea.org, All Rights Reserved.
 */
package org.mindidea.design.d2simplefactory.order;

import org.mindidea.design.d2simplefactory.pizzastore.CheesePizza;
import org.mindidea.design.d2simplefactory.pizzastore.GreekPizza;
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
public class OrderPizza {

    public OrderPizza() {
        Pizza pizza = null;
        String orderType;
        do {
            orderType = getType();
            if ("greek".equals(orderType)) {
                pizza = new GreekPizza();
            } else if ("cheese".equals(orderType)) {
                pizza = new CheesePizza();
            }
        } while (true);
    }

    private String getType() {
        try {
            BufferedReader strin = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("input pizza type:");
            String str = strin.readLine();
            return str;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}
