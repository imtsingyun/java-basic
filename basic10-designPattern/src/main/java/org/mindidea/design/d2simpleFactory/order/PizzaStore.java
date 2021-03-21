package org.mindidea.design.d2simpleFactory.order;

public class PizzaStore {

    public static void main(String[] args) {
        // 使用简单工厂
//        new OrderPizza(new SimpleFactory());
        new OrderPizza2();

        System.out.println("退出程序");
    }
}
