package org.mindidea.design.d4abstractFactory.order;

import org.mindidea.design.d4abstractFactory.pizza.Pizza;

/**
 * 抽象工厂模式的抽象层（接口）
 */
public interface AbstractFactory {
    /**
     * 创建披萨的方法由 抽象工厂的实现类来具体实现
     * @param pizzaType 披萨类型
     * @return Pizza
     */
    Pizza createPizza(String pizzaType);
}
