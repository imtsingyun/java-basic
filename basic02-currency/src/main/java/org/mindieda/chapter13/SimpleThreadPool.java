/*
 * @class SimpleThreadPool
 * @package org.mindieda.chapter13
 * @date 2020/12/12 17:09
 * Copyright (c) 2020 MindIdea.org, All Rights Reserved.
 */
package org.mindieda.chapter13;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * @author Tsingyun(青雲)
 * @version V1.0
 * @createTime 2020/12/12 17:09
 * @blog https://mindidea.org
 */
public class SimpleThreadPool {

    private final int size;

    private final static int DEFAULT_SIZE = 10;

    private static volatile int seq = 0;

    private static final String THREAD_PREFIX = "SIMPLE_THREAD_POOL-";

    private final static ThreadGroup group = new ThreadGroup("POOL_GROUP");

    private final static LinkedList<Runnable> TASK_QUEUE = new LinkedList<>();

    private final static List<WorkerTask> THREAD_QUEUE = new ArrayList<>();

    public SimpleThreadPool() {
        this(DEFAULT_SIZE);
    }

    public SimpleThreadPool(int size) {
        this.size = size;
        init();
    }

    private void init() {
        for (int i = 0; i < size; i++) {
            createWorkerTask();
        }
    }

    public void submit(Runnable runnable) {
        synchronized (TASK_QUEUE) {
            TASK_QUEUE.addLast(runnable);
            TASK_QUEUE.notifyAll();
        }
    }

    private void createWorkerTask() {
        WorkerTask task = new WorkerTask(group, THREAD_PREFIX + (seq++));
        task.start();
        THREAD_QUEUE.add(task);
    }

    private enum TaskState {
        FREE, RUNNING, BLOCKED, DEAD
    }

    private static class WorkerTask extends Thread {

        private volatile TaskState taskState = TaskState.FREE;

        public TaskState getTaskState() {
            return this.taskState;
        }

        public WorkerTask(ThreadGroup group, String name) {
            super(group, name);
        }

        @Override
        public void run() {
            OUTER:
            while (this.taskState != TaskState.DEAD) {
                Runnable runnable;
                synchronized (TASK_QUEUE) {
                    while (TASK_QUEUE.isEmpty()) {
                        try {
                            taskState = TaskState.BLOCKED;
                            TASK_QUEUE.wait();
                        } catch (InterruptedException e) {
                            break OUTER;
                        }
                    }

                    runnable = TASK_QUEUE.removeFirst();
                    if (runnable != null) {
                        taskState = TaskState.RUNNING;
                        runnable.run();
                        taskState = TaskState.FREE;
                    }
                }
            }
        }

        public void close() {
            this.taskState = TaskState.DEAD;
        }
    }

    public static void main(String[] args) {
        SimpleThreadPool pool = new SimpleThreadPool();
        IntStream.rangeClosed(0, 40)
                .forEach(i -> pool.submit(() -> System.out.println("TEST")));
    }
}
