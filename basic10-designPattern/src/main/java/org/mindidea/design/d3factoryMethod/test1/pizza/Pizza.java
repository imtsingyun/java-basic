package org.mindidea.design.d3factoryMethod.test1.pizza;

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
