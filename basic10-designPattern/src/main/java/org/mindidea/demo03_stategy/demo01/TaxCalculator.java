/*
 * @class Calculator
 * @package org.mindidea.demo03_stategy.demo01
 * @date 2020/12/6 16:32
 * Copyright (c) 2020 MindIdea.org, All Rights Reserved.
 */
package org.mindidea.demo03_stategy.demo01;

/**
 * @author Tsingyun(青雲)
 * @version V1.0
 * @createTime 2020/12/6 16:32
 * @blog https://mindidea.org
 */
public class TaxCalculator {

    private final double salary;

    private final double bonus;

    private final CalculateStrategy calculateStrategy;

    public TaxCalculator(double salary, double bonus, CalculateStrategy calculateStrategy) {
        this.salary = salary;
        this.bonus = bonus;
        this.calculateStrategy = calculateStrategy;
    }

    public TaxCalculator(double salary, double bonus) {
        this.salary = salary;
        this.bonus = bonus;
        this.calculateStrategy = null;
    }

    protected double calculateTax() {
        return calculateStrategy.calculate(salary, bonus);
    }

    public double calculate() {
        return this.calculateTax();
    }

    public double getSalary() {
        return salary;
    }

    public double getBonus() {
        return bonus;
    }

}
