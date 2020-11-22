/*
 * @class ThreadJoin
 * @package org.mindidea.chapter5
 * @date 2020/11/22 17:19
 * Copyright (c) 2020 MindIdea.org, All Rights Reserved.
 */
package org.mindidea.chapter5;

/**
 * @author Tsingyun(青雲)
 * @version V1.0
 * @createTime 2020/11/22 17:19
 * @blog https://mindidea.org
 */
public class ThreadJoin3 {

    public static void main(String[] args) throws InterruptedException {
        long l = System.currentTimeMillis();
        Thread t1 = new Thread(new CaptureRunnable("M1", 10000L));
        Thread t2 = new Thread(new CaptureRunnable("M2", 30000L));
        Thread t3 = new Thread(new CaptureRunnable("M3", 20000L));

        t1.start();
        t2.start();
        t3.start();
        t1.join();
        t2.join();
        t3.join();

        long endTime = System.currentTimeMillis();
        System.out.printf("Save data begin timestamp is：%s, end timestamp is: %s\n", l, endTime);
    }
}


class CaptureRunnable implements Runnable {

    private String machineName;

    private long spendTime;

    public CaptureRunnable(String machineName, long spendTime) {
        this.machineName = machineName;
        this.spendTime = spendTime;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(spendTime);
            System.out.println(machineName + " complete data capture and successful.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getResult() {
        return machineName + " finish";
    }
}
