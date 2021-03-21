package org.mindidea.design.d5prototype.deepCopy;

public class Test {
    public static void main(String[] args) throws CloneNotSupportedException {

        DeepPerson deepPerson = new DeepPerson();
        deepPerson.name = "lisi";
        deepPerson.person = new Person("zhangsan", "man");
        System.out.println(deepPerson.hashCode());

        DeepPerson deepPerson1 = (DeepPerson) deepPerson.clone();
        System.out.println(deepPerson1.hashCode());

        System.out.println(deepPerson.person.hashCode());
        System.out.println(deepPerson1.person.hashCode());


        System.out.println("--------------------------2222-------------------------");
        DeepPerson o = (DeepPerson) deepPerson.deepClone();
        System.out.println(deepPerson.toString() + ", " + deepPerson.person.hashCode());
        System.out.println(o.toString() + ", " + o.person.hashCode());
    }
}
