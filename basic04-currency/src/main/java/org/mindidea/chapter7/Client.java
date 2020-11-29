/*
 * @class Client
 * @package org.mindidea.chapter7
 * @date 2020/11/29 16:07
 * Copyright (c) 2020 MindIdea.org, All Rights Reserved.
 */
package org.mindidea.chapter7;

/**
 * @author Tsingyun(青雲)
 * @version V1.0
 * @createTime 2020/11/29 16:07
 * @blog https://mindidea.org
 */
public class Client {

    public static void main(String[] args) {
        final SharedData data = new SharedData(10);
        new ReaderWorker(data).start();
        new ReaderWorker(data).start();
        new ReaderWorker(data).start();
        new ReaderWorker(data).start();
        new ReaderWorker(data).start();
        new ReaderWorker(data).start();
        new WriterWorker(data, "qweriqepwroiquerasd").start();
        new WriterWorker(data, "zxcnzoxjksnmxncvjkw").start();
    }
}
