/*
 * @class SimpleCalculateStrategy
 * @package org.mindidea.demo03_stategy.demo01
 * @date 2020/12/6 16:44
 * Copyright (c) 2020 MindIdea.org, All Rights Reserved.
 */
package org.mindidea.demo03_stategy.demo01;

/**
 * @author Tsingyun(青雲)
 * @version V1.0
 * @createTime 2020/12/6 16:44
 * @blog https://mindidea.org
 */
public class SimpleCalculateStrategy implements CalculateStrategy {

    private final static double SALARY_RATE = 0.1;
    private final static double BONUS_RATE = 0.15;

    @Override
    public double calculate(double salary, double bonus) {
        return salary * SALARY_RATE + bonus * BONUS_RATE;
    }
}
