/*
 * @class DependecyInversion
 * @package org.mindidea.principle.demo03_dependecy_inversion
 * @date 2021年3月18日 00:11
 * Copyright (c) 2021 MindIdea.org, All Rights Reserved.
 */
package org.mindidea.principle.demo03_dependecy_inversion;

/**
 * 依赖倒置原则
 *
 * @author Tsingyun(青雲)
 * @version V1.0
 * @createTime 2021年3月18日 00:11
 * @blog https://mindidea.org
 */
public class DependencyInversion1 {
    public static void main(String[] args) {

    }
}

class Email {
    public String getInfo() {
        return "邮件信息：hello,world!";
    }
}

class Wechat {
    public String getInfo() {
        return "短信内容：hello,world!";
    }
}

// person 接收消息
// 写死使用 Email 类，只能接收邮件，如果需要短信或微信，则需要新增短信类，Person类中也需要新增接收短信的方法
class Person {
    public void receive(Email email) {
        System.out.println(email.getInfo());
    }

    public void receive(Wechat wechat) {
        System.out.println(wechat.getInfo());
    }
}
