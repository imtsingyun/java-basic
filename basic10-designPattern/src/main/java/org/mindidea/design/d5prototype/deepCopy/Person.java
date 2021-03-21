package org.mindidea.design.d5prototype.deepCopy;

import java.io.Serializable;

public class Person implements Serializable, Cloneable {

    private static final long serialVersionUID = 1L;

    private String name;

    private String gender;

    public Person(String name, String gender) {
        this.name = name;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
