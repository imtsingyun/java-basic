/*
 * @class TestZookeeper
 * @package org.mindidea.demo01
 * @date 2020/12/5 13:15
 * Copyright (c) 2020 MindIdea.org, All Rights Reserved.
 */
package org.mindidea.demo01;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;

/**
 * @author Tsingyun(青雲)
 * @version V1.0
 * @createTime 2020/12/5 13:15
 * @blog https://mindidea.org
 */
public class TestZookeeper {

    private final static String connection = "10.1.231.123:2181,10.1.231.46:2181,10.1.231.181:2181";

    private ZooKeeper zkClient;

    public TestZookeeper() throws IOException {
        zkClient = new ZooKeeper(connection, 2000, new Watcher() {
            public void process(WatchedEvent watchedEvent) {

            }
        });
    }

    public ZooKeeper getZkClient() {
        return zkClient;
    }
}
