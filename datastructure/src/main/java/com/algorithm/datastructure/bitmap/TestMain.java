package com.algorithm.datastructure.bitmap;

import com.algorithm.datastructure.bitmap.BitRecommendation.IndexCount;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TestMain {

    public static void main(String[] args) {

        // 总体推荐
        BitRecommendation recommend = new BitRecommendation();

        // a标签 bitmap最好预估大小初始化,目前扩容为1.1
        KBitMap a = new KBitMap(3600);
        a.setBitOn(5);
        a.setBitOn(10);
        a.setBitOn(3564);
        a.setBitOn(756);

        // b标签
        KBitMap b = new KBitMap(3600);
        b.setBitOn(5);
        b.setBitOn(10);
        b.setBitOn(999);
        b.setBitOn(687);
        b.setBitOn(3564);
        b.setBitOn(8756);

        // c标签
        KBitMap c = new KBitMap(3600);
        c.setBitOn(5);
        c.setBitOn(3564);

        recommend.putTag("a", a);
        recommend.putTag("b", b);
        recommend.putTag("c", c);

        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");

        System.out.println("取必须项and操作得出的结果");
        KBitMap bit = recommend.getAndRecomend(list);
        int in = 0;
        for (long longbit : bit.getBitArray()) {
            for (int i = 0; i < 64; i++) {
                if ((longbit & (1l << i)) > 0) {
                    System.out.println(in);
                }
                in++;
            }
        }

        System.out.println("只取最相似前5");
        PriorityQueue<IndexCount> q1 = recommend.getSimilarRecomend(list, 5, null);
        while (!q1.isEmpty()) {
            BitRecommendation.IndexCount ic = q1.poll();
            System.out.println(ic.getIndex() + "   " + (ic.getCount() + 128));
        }

        System.out.println("取必须项and操作后,再经过相似计算得出的队列,返回的相似度不包含必须项的记录次数");
        List<String> listRequire = new ArrayList<>();
        listRequire.add("a");
        listRequire.add("b");

        PriorityQueue<BitRecommendation.IndexCount> q2 = recommend.getMixedRecomend(listRequire, list, 5, null);
        while (!q2.isEmpty()) {
            BitRecommendation.IndexCount ic = q2.poll();
            System.out.println(ic.getIndex() + "   " + (ic.getCount() + 128));
        }

        Map<String, Byte> map = new HashMap<>();
        map.put("b", (byte) 10);

        System.out.println("只取最相似前5,传入分值");
        PriorityQueue<BitRecommendation.IndexCount> q3 = recommend.getSimilarRecomend(list, 5, map);
        while (!q3.isEmpty()) {
            BitRecommendation.IndexCount ic = q3.poll();
            System.out.println(ic.getIndex() + "   " + (ic.getCount() + 128));
        }

        System.out.println("取必须项and操作后,再经过相似计算得出的队列,返回的相似度不包含必须项的记录次数,传入分值");

        PriorityQueue<BitRecommendation.IndexCount> q4 = recommend.getMixedRecomend(listRequire, list, 5, map);
        while (!q4.isEmpty()) {
            BitRecommendation.IndexCount ic = q4.poll();
            System.out.println(ic.getIndex() + "   " + (ic.getCount() + 128));
        }
    }
}