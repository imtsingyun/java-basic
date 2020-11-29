/*
 * @class ReadWriteLock
 * @package org.mindidea.chapter7
 * @date 2020/11/29 15:46
 * Copyright (c) 2020 MindIdea.org, All Rights Reserved.
 */
package org.mindidea.chapter7;

/**
 * N: 不需串行化
 * Y: 需要串行化
 * <p>
 * +-------------------------+
 * +        | read  | write
 * +-------------------------+
 * + read   |   N   |   Y
 * +-------------------------+
 * + write  |   Y   |   Y
 * +-------------------------+
 *
 * @author Tsingyun(青雲)
 * @version V1.0
 * @createTime 2020/11/29 15:46
 * @blog https://mindidea.org
 */
public class ReadWriteLock {

    private int readingReaders = 0;
    private int waitingReaders = 0;
    private int writingWriters = 0;
    private int waitingWriters = 0;
    private boolean preferWriter = true;

    public ReadWriteLock() {
        this(true);
    }

    public ReadWriteLock(boolean preferWriter) {
        this.preferWriter = preferWriter;
    }

    public synchronized void readLock() throws InterruptedException {
        this.waitingReaders++;
        try {
            while (writingWriters > 0 || (preferWriter && waitingWriters > 0)) {
                this.wait();
            }
            this.readingReaders++;
        } finally {
            this.waitingReaders--;
        }
    }

    public synchronized void readUnlock() {
        this.readingReaders--;
        this.notifyAll();
    }

    public synchronized void writeLock() throws InterruptedException {
        this.waitingWriters++;
        try {
            while (readingReaders > 0 || writingWriters > 0) {
                this.wait();
            }
            this.writingWriters++;
        } finally {
            this.waitingWriters--;
        }
    }

    public synchronized void writeUnlock() {
        this.writingWriters--;
        this.notifyAll();
    }
}
