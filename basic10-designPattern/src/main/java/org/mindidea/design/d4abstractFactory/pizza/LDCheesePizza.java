package org.mindidea.design.d4abstractFactory.pizza;

public class LDCheesePizza extends Pizza {
    @Override
    public void prepare() {
        setName("伦敦奶酪披萨");
        System.out.println("准备伦敦的奶酪披萨原材料");
    }
}
