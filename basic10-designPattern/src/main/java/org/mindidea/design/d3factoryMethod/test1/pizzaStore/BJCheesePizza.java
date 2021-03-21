package org.mindidea.design.d3factoryMethod.test1.pizzaStore;

public class BJCheesePizza extends Pizza {
    @Override
    public void prepare() {
        setName("北京奶酪披萨");
        System.out.println("准备北京的奶酪披萨原材料");
    }
}
