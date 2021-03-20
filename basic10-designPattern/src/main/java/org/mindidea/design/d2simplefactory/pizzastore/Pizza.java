/*
 * @class Pizza
 * @package org.mindidea.design.d2simplefactory.pizzastore
 * @date 2021年3月20日 17:35
 * Copyright (c) 2021 MindIdea.org, All Rights Reserved.
 */
package org.mindidea.design.d2simplefactory.pizzastore;

/**
 * 简单工厂
 *
 * @author Tsingyun(青雲)
 * @version V1.0
 * @createTime 2021年3月20日 17:35
 * @blog https://mindidea.org
 */
// 抽象类
public abstract class Pizza {
    protected String name;

    // 准备原材料，不同的披萨方法不同
    public abstract void prepare();

    public void bake() {
        System.out.println(name + " is baking");
    }

    public void cut() {
        System.out.println(name + " is cutting");
    }

    public void box() {
        System.out.println(name + " is boxing");
    }

    public void setName(String name) {
        this.name = name;
    }
}
