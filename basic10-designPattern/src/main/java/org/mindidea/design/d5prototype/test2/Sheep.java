package org.mindidea.design.d5prototype.test2;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

@Data
@Slf4j
public class Sheep implements Serializable, Cloneable {
    private static final long serialVersionUID = 1L;
    private String name;
    private int age;
    private String color;

    // 浅拷贝
    public Sheep friend;

    public Sheep(String name, int age, String color) {
        super();
        this.name = name;
        this.age = age;
        this.color = color;
    }

//    @Override
//    public String toString() {
//        return "Sheep{" +
//                "name='" + name + '\'' +
//                ", age=" + age +
//                ", color='" + color + '\'' +
//                '}';
//    }

    // 克隆该实例
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
