package org.mindidea.design.d5prototype.test2;

import lombok.extern.slf4j.Slf4j;

/**
 * 使用克隆羊学习原型模式
 */
@Slf4j
public class Client {
    public static void main(String[] args) throws CloneNotSupportedException {
        Sheep sheep = new Sheep("Tom", 1, "white");
        Sheep sheep1 = (Sheep) sheep.clone();
//        sheep.setName("dddd");
        System.out.println(sheep == sheep1);
        System.out.println(sheep + "," + sheep.hashCode());
        System.out.println(sheep1 + "," + sheep1.hashCode());
        System.out.println(System.identityHashCode(sheep));
        System.out.println(System.identityHashCode(sheep1));
//        Sheep friend = new Sheep("jack", 2, "black");
//        sheep.friend = friend;
//
//        Sheep sheep1 = (Sheep) sheep.clone();
//        Sheep sheep2 = (Sheep) sheep.clone();
//        Sheep sheep3 = (Sheep) sheep.clone();
//
//        System.out.println(sheep == sheep1);
//        System.out.println(sheep);
//        log.info("sheep:{}, hashcode={}, friend-hashcode={}", sheep.toString(), sheep.hashCode(), sheep.friend.hashCode());
//        log.info("sheep1:{}, hashcode={}, friend-hashcode={}", sheep1.toString(), sheep1.hashCode(), sheep1.friend.hashCode());
//        log.info("sheep2:{}, hashcode={}, friend-hashcode={}", sheep2.toString(), sheep2.hashCode(), sheep2.friend.hashCode());
//        log.info("sheep3:{}, hashcode={}, friend-hashcode={}", sheep3.toString(), sheep3.hashCode(), sheep3.friend.hashCode());
    }
}
