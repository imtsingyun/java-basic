package org.mindidea.design.d4abstractFactory.pizza;

public class BJCheesePizza extends Pizza {
    @Override
    public void prepare() {
        setName("北京奶酪披萨");
        System.out.println("准备北京的奶酪披萨原材料");
    }
}
