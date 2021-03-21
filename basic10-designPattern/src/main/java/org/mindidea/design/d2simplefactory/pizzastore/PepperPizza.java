package org.mindidea.design.d2simplefactory.pizzastore;

public class PepperPizza extends Pizza {

    public PepperPizza(String name) {
        this.name = name;
    }

    @Override
    public void prepare() {
        System.out.println("准备胡椒披萨原材料");
    }
}
