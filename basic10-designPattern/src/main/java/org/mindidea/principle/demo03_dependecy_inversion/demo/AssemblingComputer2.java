/*
 * @class AssemblingComputer2
 * @package org.mindidea.principle.demo03_dependecy_inversion.demo
 * @date 2021年3月19日 21:24
 * Copyright (c) 2021 MindIdea.org, All Rights Reserved.
 */
package org.mindidea.principle.demo03_dependecy_inversion.demo;

import lombok.Data;

/**
 * @author Tsingyun(青雲)
 * @version V1.0
 * @createTime 2021年3月19日 21:24
 * @blog https://mindidea.org
 */
public class AssemblingComputer2 {
    public static void main(String[] args) {
        KingstonMemory2 memory = new KingstonMemory2();
        SamsungBoard2 board = new SamsungBoard2();

        memory.put(board);
    }
}

interface IMemory {
    void put(IBoard board);
    String getName();
}

interface IBoard {
    void access(IMemory memory);
}

// 金士顿内存
@Data
class KingstonMemory2 implements IMemory {
    private String name = "Kingston2 Memory";
    // 内存插入主板
    @Override
    public void put(IBoard board) {
        board.access(this);
    }

}

// 三星主板
@Data
class SamsungBoard2 implements IBoard {
    private String name = "Samsung2 Board";
    // 主板接入内存
    public void access(IMemory memory) {
        System.out.println(memory.getName() + " has been installed on " + name);
    }
}
