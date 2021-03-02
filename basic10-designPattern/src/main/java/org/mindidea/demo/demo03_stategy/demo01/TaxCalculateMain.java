/*
 * @class TaxCalculateMain
 * @package org.mindidea.demo.demo03_stategy.demo01
 * @date 2020/12/6 16:35
 * Copyright (c) 2020 MindIdea.org, All Rights Reserved.
 */
package org.mindidea.demo.demo03_stategy.demo01;

/**
 * @author Tsingyun(青雲)
 * @version V1.0
 * @createTime 2020/12/6 16:35
 * @blog https://mindidea.org
 */
public class TaxCalculateMain {

    public static void main(String[] args) {
        TaxCalculator calculator = new TaxCalculator(10000d, 2000d) {
            @Override
            protected double calculateTax() {
                return getSalary() * 0.1 + getBonus() * 0.15;
            }
        };

        double tax = calculator.calculate();
        System.out.println(tax);


        //////////////////////////////////////////
        TaxCalculator calculator2 =
                new TaxCalculator(20000d, 2000d, (s, b) -> s * 0.1 + b * 0.15);

        double calculate = calculator2.calculate();
        System.out.println(calculate);
    }
}
