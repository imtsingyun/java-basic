package org.mindidea.design.d5prototype.test1;

import lombok.Data;

/**
 * 图书类
 */
@Data
public abstract class Book implements Cloneable {
    private String name;
    private String author;
    private String type;
    private String content;

    public Book(String name, String author, String type, String content) {
        this.name = name;
        this.author = author;
        this.type = type;
        this.content = content;
        System.out.println("实例化书籍：" + this.name);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
