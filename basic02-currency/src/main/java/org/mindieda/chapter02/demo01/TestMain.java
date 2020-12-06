/*
 * @class TestMain
 * @package org.mindieda.chapter02.demo01
 * @date 2020/12/6 16:06
 * Copyright (c) 2020 MindIdea.org, All Rights Reserved.
 */
package org.mindieda.chapter02.demo01;

/**
 * @author Tsingyun(青雲)
 * @version V1.0
 * @createTime 2020/12/6 16:06
 * @blog https://mindidea.org
 */
public class TestMain {
    public static void main(String[] args) {
        BankNumThread t1 = new BankNumThread("一号窗口");
        t1.start();
        BankNumThread t2 = new BankNumThread("二号窗口");
        t2.start();
    }
}
