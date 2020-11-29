/*
 * @class WriterWorker
 * @package org.mindidea.chapter7
 * @date 2020/11/29 16:01
 * Copyright (c) 2020 MindIdea.org, All Rights Reserved.
 */
package org.mindidea.chapter7;

import java.util.Random;

/**
 * @author Tsingyun(青雲)
 * @version V1.0
 * @createTime 2020/11/29 16:01
 * @blog https://mindidea.org
 */
public class WriterWorker extends Thread {

    private static final Random random = new Random(System.currentTimeMillis());

    private final SharedData data;
    private final String filler;
    private int index = 0;


    public WriterWorker(SharedData data, String filler) {
        this.data = data;
        this.filler = filler;
    }

    @Override
    public void run() {
        try {
            while (true) {
                char c = nextChar();
                data.write(c);
                System.out.println(Thread.currentThread().getName() + " write " + c);
                Thread.sleep(random.nextInt(1000));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private char nextChar() {
        char c = filler.charAt(index);
        index++;
        if (index >= filler.length()) {
            index = 0;
        }
        return c;
    }
}
