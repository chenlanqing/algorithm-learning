package com.algorithm.has;

import com.algorithm.hash.consistent.ConsistentHash;
import com.algorithm.hash.consistent.Node;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author QingFan
 * @version 1.0.0
 * @date 2023年02月21日 20:24
 */
public class HashTest {

    @Test
    public void test() {
        //initialize 4 service node
        MyNode node1 = new MyNode("IDC1", "127.0.0.1", 8080);
        MyNode node2 = new MyNode("IDC1", "127.0.0.1", 8081);
        MyNode node3 = new MyNode("IDC1", "127.0.0.1", 8082);
        MyNode node4 = new MyNode("IDC1", "127.0.0.1", 8084);

        //hash them to hash ring
        ConsistentHash<MyNode> ConsistentHash = new ConsistentHash<>(Arrays.asList(node1, node2, node3, node4), 10);//10 virtual node

        //we have 5 requester ip, we are trying them to route to one service node
        String requestIP1 = "192.168.0.1";
        String requestIP2 = "192.168.0.2";
        String requestIP3 = "192.168.0.3";
        String requestIP4 = "192.168.0.4";
        String requestIP5 = "192.168.0.5";

        goRoute(ConsistentHash, requestIP1, requestIP2, requestIP3, requestIP4, requestIP5);

        MyNode node5 = new MyNode("IDC2", "127.0.0.1", 8080);//put new service online
        System.out.println("-------------putting new node online " + node5.getKey() + "------------");
        ConsistentHash.addNode(node5, 10);

        goRoute(ConsistentHash, requestIP1, requestIP2, requestIP3, requestIP4, requestIP5);

        ConsistentHash.removeNode(node3);
        System.out.println("-------------remove node online " + node3.getKey() + "------------");
        goRoute(ConsistentHash, requestIP1, requestIP2, requestIP3, requestIP4, requestIP5);
    }

    private static class MyNode implements Node {
        private final String idc;
        private final String ip;
        private final int port;

        public MyNode(String idc, String ip, int port) {
            this.idc = idc;
            this.ip = ip;
            this.port = port;
        }

        @Override
        public String getKey() {
            return idc + "-" + ip + ":" + port;
        }

        @Override
        public String toString() {
            return getKey();
        }
    }

    private static void goRoute(ConsistentHash<MyNode> ConsistentHash, String... requestIps) {
        for (String requestIp : requestIps) {
            System.out.println(requestIp + " is route to " + ConsistentHash.routeNode(requestIp));
        }
    }
}
