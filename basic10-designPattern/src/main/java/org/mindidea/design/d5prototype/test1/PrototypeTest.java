package org.mindidea.design.d5prototype.test1;

public class PrototypeTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        Book book = new ConcreteBook("设计模式", "Abc", "软件", "23种设计模式详解");
        System.out.println("复印书籍：" + book.getName() + "，第 " + 1 + " 本");
        for (int i = 2; i <= 10; i ++) {
            Book book2 = (Book) book.clone();
            System.out.println("复印书籍：" + book2.getName() + "，第 " + i + " 本");
        }
    }
}
