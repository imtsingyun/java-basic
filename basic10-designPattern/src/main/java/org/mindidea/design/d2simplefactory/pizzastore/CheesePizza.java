/*
 * @class CheesePizza
 * @package org.mindidea.design.d2simplefactory.pizzastore
 * @date 2021年3月20日 21:25
 * Copyright (c) 2021 MindIdea.org, All Rights Reserved.
 */
package org.mindidea.design.d2simplefactory.pizzastore;

/**
 * @author Tsingyun(青雲)
 * @version V1.0
 * @createTime 2021年3月20日 21:25
 * @blog https://mindidea.org
 */
public class CheesePizza extends Pizza {
    @Override
    public void prepare() {
        System.out.println("准备奶酪披萨原材料");
    }
}
