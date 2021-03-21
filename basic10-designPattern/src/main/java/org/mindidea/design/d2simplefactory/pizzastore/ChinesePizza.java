package org.mindidea.design.d2simplefactory.pizzastore;

public class ChinesePizza extends Pizza {

    public ChinesePizza(String name) {
        this.name = name;
    }

    @Override
    public void prepare() {
        System.out.println("准备中式披萨原材料");
    }
}
