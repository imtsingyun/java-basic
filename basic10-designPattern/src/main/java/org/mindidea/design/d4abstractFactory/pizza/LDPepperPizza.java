package org.mindidea.design.d4abstractFactory.pizza;

public class LDPepperPizza extends Pizza {
    @Override
    public void prepare() {
        setName("伦敦胡椒披萨");
        System.out.println("准备伦敦胡椒披萨的原材料");
    }
}
