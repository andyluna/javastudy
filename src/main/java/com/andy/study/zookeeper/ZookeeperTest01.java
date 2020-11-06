package com.andy.study.zookeeper;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.ACL;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * @time: 2020/11/5 十一月 17:12
 * @author: xiangdan/xiangdan@dtxytech.com
 */
public class ZookeeperTest01 {
    private static final String connection = "localhost:2181";
    private static final CountDownLatch cdl = new CountDownLatch(1);
    public static void main(String[] args) throws Exception {
        //createNode();
        updateNode();
        getNode();
        deleteNode();
    }
    public static void createNode() throws KeeperException, InterruptedException {
        ZooKeeper zk = getZooKeeper();
        byte[] data = "xiangdan333".getBytes();
        String s = zk.create("/xiangdan/abc", data, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);

        System.out.println(s);
        closeZooKeeper(zk);
    }
    public static void getNode() throws KeeperException, InterruptedException {
        ZooKeeper zk = getZooKeeper();
        byte[] data = zk.getData("/xiangdan2", false, null);
        String s1 = new String(data);
        System.out.println("获取数据"+s1);
        closeZooKeeper(zk);
    }

    public static void updateNode() throws KeeperException, InterruptedException {
        ZooKeeper zk = getZooKeeper();
        Stat stat = zk.setData("/xiangdan/abc", "修改之后".getBytes(), -1);

        System.out.println("获取数据"+stat);
        closeZooKeeper(zk);
    }

    public static void deleteNode() throws KeeperException, InterruptedException {
        ZooKeeper zk = getZooKeeper();
        zk.delete("/xiangdan/abc", -1);

        closeZooKeeper(zk);
    }

    public static void closeZooKeeper(ZooKeeper zookeeper){
        if(zookeeper!=null){
            try {
                zookeeper.close();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }



    public static ZooKeeper getZooKeeper(){
        ZooKeeper zooKeeper = null;
        try {
            zooKeeper = new ZooKeeper(connection, 5000, new Watcher() {
                @Override
                public void process(WatchedEvent event) {
                    if(event.getState()== Event.KeeperState.SyncConnected){
                        cdl.countDown();
                    }
                }
            });
            cdl.await();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return zooKeeper;
    }

}
