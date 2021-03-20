/*
 * @class BookStore
 * @package org.mindidea.principle.demo05_ocp.demo1
 * @date 2021年3月19日 23:54
 * Copyright (c) 2021 MindIdea.org, All Rights Reserved.
 */
package org.mindidea.principle.demo05_ocp.demo1;

import java.text.NumberFormat;
import java.util.ArrayList;

/**
 * @author Tsingyun(青雲)
 * @version V1.0
 * @createTime 2021年3月19日 23:54
 * @blog https://mindidea.org
 */
public class BookStore {
    private final static ArrayList<IBook> bookList = new ArrayList<>();
    static {
        bookList.add(new OffFictionType("天龙八部", 23.8, 0));
        bookList.add(new OffFictionType("西游记", 43.7, 0));
        bookList.add(new OffFictionType("水浒传", 33.8, 0));
        bookList.add(new OffFictionType("三国演义", 53.0, 0));
    }

    public static void main(String[] args) {
        NumberFormat format = NumberFormat.getCurrencyInstance();
        format.setMaximumFractionDigits(2);
        for (IBook book: bookList) {
            System.out.println(book.getName() + "\t " + format.format((book.getPrice())));
        }
    }
}

interface IBook {
    String getName();   // 书名
    Double getPrice();  // 价格
    int getType();      // 分类
}

// 打折销售的图书
class OffFictionType extends FictionType {

    public OffFictionType(String name, Double price, Integer type) {
        super(name, price, type);
    }

    @Override
    public Double getPrice() {
        double selfPrice = super.getPrice();
        double offPrice = 0;

        // 大于40的 9 折
        if (selfPrice > 40) {
            offPrice = selfPrice * 90 / 100;
        }
        // 其余的 8 折
        else {
            offPrice = selfPrice * 80 /100;
        }

        return offPrice;
    }
}

// 小说类图书
class FictionType implements IBook {

    private String name;
    private Double price;
    private Integer type;

    public FictionType(String name, Double price, Integer type) {
        this.name = name;
        this.price = price;
        this.type = type;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Double getPrice() {
        return this.price;
    }

    @Override
    public int getType() {
        return this.type;
    }
}