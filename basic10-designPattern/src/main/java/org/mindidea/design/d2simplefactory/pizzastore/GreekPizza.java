/*
 * @class GreekPizza
 * @package org.mindidea.design.d2simplefactory.pizzastore
 * @date 2021年3月20日 21:28
 * Copyright (c) 2021 MindIdea.org, All Rights Reserved.
 */
package org.mindidea.design.d2simplefactory.pizzastore;

/**
 * @author Tsingyun(青雲)
 * @version V1.0
 * @createTime 2021年3月20日 21:28
 * @blog https://mindidea.org
 */
public class GreekPizza extends Pizza {

    public GreekPizza(String name) {
        this.name = name;
    }

    @Override
    public void prepare() {
        System.out.println("准备希腊披萨原材料");
    }
}
