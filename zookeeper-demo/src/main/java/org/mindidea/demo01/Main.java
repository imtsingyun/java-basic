/*
 * @class Main
 * @package org.mindidea.demo01
 * @date 2020/12/5 13:18
 * Copyright (c) 2020 MindIdea.org, All Rights Reserved.
 */
package org.mindidea.demo01;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;
import java.util.List;

/**
 * @author Tsingyun(青雲)
 * @version V1.0
 * @createTime 2020/12/5 13:18
 * @blog https://mindidea.org
 */
public class Main {
    public static void main(String[] args) throws IOException, KeeperException, InterruptedException {
        TestZookeeper test = new TestZookeeper();
        ZooKeeper zkClient = test.getZkClient();
        // 创建节点
//        createNode(zkClient);
        // 获取子节点
        getChildren(zkClient);
    }

    public static void createNode(ZooKeeper zkClient) throws KeeperException, InterruptedException {
        String path = zkClient.create("/mindidea", "java".getBytes(),
                ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        System.out.println(path);
    }

    public static void getChildren(ZooKeeper zkClient) throws KeeperException, InterruptedException {
        List<String> children = zkClient.getChildren("/sanguo", false);
        System.out.println(children);
        Thread.sleep(Long.MAX_VALUE);
    }
}
