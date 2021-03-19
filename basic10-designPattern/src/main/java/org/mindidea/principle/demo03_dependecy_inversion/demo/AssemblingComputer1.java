/*
 * @class AssemblingComputer1
 * @package org.mindidea.principle.demo03_dependecy_inversion.demo
 * @date 2021年3月19日 21:07
 * Copyright (c) 2021 MindIdea.org, All Rights Reserved.
 */
package org.mindidea.principle.demo03_dependecy_inversion.demo;

import lombok.Data;

/**
 * 以组装电脑为例，解释 “依赖倒置” 原则
 *
 * @author Tsingyun(青雲)
 * @version V1.0
 * @createTime 2021年3月19日 21:07
 * @blog https://mindidea.org
 */
public class AssemblingComputer1 {
    public static void main(String[] args) {
        KingstonMemory memory = new KingstonMemory();
        SamsungBoard board = new SamsungBoard();

        memory.put(board);
    }
}

// 金士顿内存
@Data
class KingstonMemory {
    private String name = "Kingston Memory";
    // 内存插入主板
    public void put(SamsungBoard board) {
        board.access(this);
    }
}

// 三星主板
@Data
class SamsungBoard {
    private String name = "Samsung Board";
    // 主板接入内存
    public void access(KingstonMemory memory) {
        System.out.println(memory.getName() + " has been installed on " + name);
    }
}


