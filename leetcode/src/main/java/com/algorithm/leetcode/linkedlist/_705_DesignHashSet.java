package com.algorithm.leetcode.linkedlist;

import com.algorithm.leetcode.ListNode;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * fixme 待完成
 *
 * @author QingFan
 * @version 1.0.0
 * @date 2021年11月10日 21:05
 */
public class _705_DesignHashSet {

    /**
     * ["MyHashSet","contains","remove","add","add","contains","remove","contains","contains","add","add","add","add","remove","add","add","add","add","add","add","add","add","add","add","contains","add","contains","add","add","contains","add","add","remove","add","add","add","add","add","contains","add","add","add","remove","contains","add","contains","add","add","add","add","add","contains","remove","remove","add","remove","contains","add","remove","add","add","add","add","contains","contains","add","remove","remove","remove","remove","add","add","contains","add","add","remove","add","add","add","add","add","add","add","add","remove","add","remove","remove","add","remove","add","remove","add","add","add","remove","remove","remove","add","contains","add"]
     * [[],[72],[91],[48],[41],[96],[87],[48],[49],[84],[82],[24],[7],[56],[87],[81],[55],[19],[40],[68],[23],[80],[53],[76],[93],[95],[95],[67],[31],[80],[62],[73],[97],[33],[28],[62],[81],[57],[40],[11],[89],[28],[97],[86],[20],[5],[77],[52],[57],[88],[20],[48],[42],[86],[49],[62],[53],[43],[98],[32],[15],[42],[50],[19],[32],[67],[84],[60],[8],[85],[43],[59],[65],[40],[81],[55],[56],[54],[59],[78],[53],[0],[24],[7],[53],[33],[69],[86],[7],[1],[16],[58],[61],[34],[53],[84],[21],[58],[25],[45],[3]]
     */
    public static void main(String[] args) throws Exception {
//        String[] methods = {"contains","remove","add","add","contains","remove","contains","contains","add","add","add","add","remove","add","add","add","add","add","add","add","add","add","add","contains","add","contains","add","add","contains","add","add","remove","add","add","add","add","add","contains","add","add","add","remove","contains","add","contains","add","add","add","add","add","contains","remove","remove","add","remove","contains","add","remove","add","add","add","add","contains","contains","add","remove","remove","remove","remove","add","add","contains","add","add","remove","add","add","add","add","add","add","add","add","remove","add","remove","remove","add","remove","add","remove","add","add","add","remove","remove","remove","add","contains","add"};
//        int[][] arr = {{72},{91},{48},{41},{96},{87},{48},{49},{84},{82},{24},{7},{56},{87},{81},{55},{19},{40},{68},{23},{80},{53},{76},{93},{95},{95},{67},{31},{80},{62},{73},{97},{33},{28},{62},{81},{57},{40},{11},{89},{28},{97},{86},{20},{5},{77},{52},{57},{88},{20},{48},{42},{86},{49},{62},{53},{43},{98},{32},{15},{42},{50},{19},{32},{67},{84},{60},{8},{85},{43},{59},{65},{40},{81},{55},{56},{54},{59},{78},{53},{0},{24},{7},{53},{33},{69},{86},{7},{1},{16},{58},{61},{34},{53},{84},{21},{58},{25},{45},{3}};
//        Boolean[] result = {false,null,null,null,false,null,true,false,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,false,null,true,null,null,true,null,null,null,null,null,null,null,null,true,null,null,null,null,false,null,false,null,null,null,null,null,true,null,null,null,null,true,null,null,null,null,null,null,true,true,null,null,null,null,null,null,null,false,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,false,null};
//        Boolean[] except = {false,null,null,null,false,null,true,false,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,false,null,true,null,null,false,null,null,null,null,null,null,null,null,false,null,null,null,null,false,null,false,null,null,null,null,null,true,null,null,null,null,false,null,null,null,null,null,null,false,false,null,null,null,null,null,null,null,false,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,false,null};
//
//        MyHashSet set = new MyHashSet();
//        Class<? extends MyHashSet> clazz = set.getClass();
//
//        for (int i = 0; i < methods.length; i++) {
//            String m = methods[i];
//            Method method = clazz.getMethod(m, int.class);
//            Object r = method.invoke(set, arr[i][0]);
//            if (r != null) {
//                Boolean ex = (Boolean) r;
//                if (result[i] != null) {
//                    if (result[i].booleanValue() != ex.booleanValue()) {
//                        System.out.println(i + "," + m + ", " + arr[i][0] + "," + result[i] + "," + ex);
//                    }
//                }
//            }
//        }
        MyHashSet set = new MyHashSet();
        set.add(1);
        set.add(2);
        System.out.println(set.contains(1));
        System.out.println(set.contains(3));
        set.add(2);
        System.out.println(set.contains(2));
        set.remove(2);
        System.out.println(set.contains(2));

    }

    static class MyHashSet {

        private ListNode root;
        private ListNode tail;

        public MyHashSet() {
        }

        public void add(int key) {
            if (contains(key)) {
                return;
            }
            ListNode newNode = new ListNode(key);
            if (root == null) {
                root = newNode;
                return;
            }
            if (tail == null) {
                tail = newNode;
                root.next = tail;
                return;
            }
            tail.next = newNode;
        }

        public void remove(int key) {
            if (root == null) {
                return;
            }
            ListNode pre = root;
            ListNode cur = root.next;
            while (cur != null) {
                if (cur.val == key) {
                    pre.next = cur.next;
                    cur.next = null;
                    break;
                }
                pre = cur;
                cur = cur.next;

            }
        }

        public boolean contains(int key) {
            if (root == null) {
                return false;
            }
            ListNode cur = root;
            while (cur != null) {
                if (cur.val == key) {
                    return true;
                }
                cur = cur.next;
            }
            return false;
        }
    }
}
