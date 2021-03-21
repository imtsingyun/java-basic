package org.mindidea.design.d3factoryMethod.test1.pizza;

public class BJPepperPizza extends Pizza {
    @Override
    public void prepare() {
        setName("北京胡椒披萨");
        System.out.println("准备北京胡椒披萨的原材料");
    }
}
