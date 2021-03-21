package org.mindidea.design.d3factoryMethod.test1.pizza;

public class LDCheesePizza extends Pizza {
    @Override
    public void prepare() {
        setName("伦敦奶酪披萨");
        System.out.println("准备伦敦的奶酪披萨原材料");
    }
}
