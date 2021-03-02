/*
 * @class CalculateStategy
 * @package org.mindidea.demo.demo03_stategy.demo02
 * @date 2020/12/6 16:40
 * Copyright (c) 2020 MindIdea.org, All Rights Reserved.
 */
package org.mindidea.demo.demo03_stategy.demo01;

/**
 * @author Tsingyun(青雲)
 * @version V1.0
 * @createTime 2020/12/6 16:40
 * @blog https://mindidea.org
 */
@FunctionalInterface
public interface CalculateStrategy {

    double calculate(double salary, double bonus);
}
