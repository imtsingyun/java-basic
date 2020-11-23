/*
 * @class Demo
 * @package org.mindidea.demo01
 * @date 2020/9/26 21:17
 * Copyright (c) 2020 MindIdea.org, All Rights Reserved.
 */
package org.mindidea.demo01;


import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 *
 * @author Tsingyun(青雲)
 * @version V1.0
 * @createTime 2020/9/26 21:10
 * https://mindidea.org
 *
 */
public class Demo01 {

    /**
     *
     * @author Tsingyun(青雲)
     * @createTime 2020/9/26 21:10
     */
    public static void main(String[] args) {
        MyThread thread = new MyThread();
        thread.start();

        RunnableTask task = new RunnableTask();
        new Thread(task).start();
        new Thread(task).start();

        // 创建异步任务
        FutureTask<String> futureTask = new FutureTask<String>(new CallerTask());
        // 启动线程
        new Thread(futureTask).start();
        try {
            String result = futureTask.get();
            System.out.println(result);
        } catch (ExecutionException ex) {
            ex.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("I am a child thread1");
        }
    }

    public static class RunnableTask implements Runnable {

        public void run() {
            System.out.println("I am a child Thread2");
        }
    }

    public static class CallerTask implements Callable<String> {

        public String call() throws Exception {
            return "hello";
        }
    }
}