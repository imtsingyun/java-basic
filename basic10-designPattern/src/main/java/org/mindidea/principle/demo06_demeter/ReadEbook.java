/*
 * @class ReadEbook
 * @package org.mindidea.principle.demo06_demeter
 * @date 2021年3月20日 10:19
 * Copyright (c) 2021 MindIdea.org, All Rights Reserved.
 */
package org.mindidea.principle.demo06_demeter;

/**
 * 以阅读电子书为例，解释迪米特原则
 * <p>
 * 打开手机 ——> 找到软件 ——> 找到书阅读
 * 其中 手机和软件是直接关系，软件和书是直接关系
 * 而手机和书是没有直接关系的
 *
 * @author Tsingyun(青雲)
 * @version V1.0
 * @createTime 2021年3月20日 10:19
 * @blog https://mindidea.org
 */
public class ReadEbook {
    public static void main(String[] args) {
        Phone p = new Phone();
        p.openApp();
    }
}

class Phone {
    private ReadApp app = new ReadApp();

    public void openApp() {
        app.read();
    }
}

// 阅读软件类
class ReadApp {
    private EBook eBook = new EBook("设计模式");

    public void read() {
        System.out.println("Read a book, name is " + eBook.getTitle());
    }
}

// 电子书类
class EBook {
    private String title;

    public EBook(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}