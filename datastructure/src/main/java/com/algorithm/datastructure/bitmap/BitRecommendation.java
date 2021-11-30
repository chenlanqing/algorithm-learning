package com.algorithm.datastructure.bitmap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.concurrent.ConcurrentHashMap;

public class BitRecommendation {

    private volatile ConcurrentHashMap<String, KBitMap> tags;

    private Comparator<IndexCount> cmp1 = new Comparator<IndexCount>() {
        public int compare(IndexCount e1, IndexCount e2) {
            return e1.getCount() - e2.getCount();
        }
    };

    private Comparator<IndexCount> cmp2 = new Comparator<IndexCount>() {
        public int compare(IndexCount e1, IndexCount e2) {
            return e2.getCount() - e1.getCount();
        }
    };

    public BitRecommendation() {
        this.tags = new ConcurrentHashMap<>();
    }

    public KBitMap getTag(String key) {
        return tags.get(key);
    }

    public void putTag(String key, KBitMap bitMap) {
        tags.put(key, bitMap);
    }

    public void removeTag(String key) {
        tags.remove(key);
    }

    /**
     * 获取多个bitmap and操作结果
     */
    public KBitMap getAndRecomend(List<String> keys) {
        KBitMap baseMap = null;
        for (String key : keys) {
            KBitMap bitMap = tags.get(key);
            if (bitMap == null) {
                continue;
            }
            if (baseMap == null) {
                baseMap = new KBitMap(Arrays.copyOf(bitMap.getBitArray(), bitMap.getBitArray().length));
                continue;
            }

            for (int i = 0; i < baseMap.getBitArray().length; i++) {
                baseMap.getBitArray()[i] = baseMap.getBitArray()[i] & bitMap.getBitArray()[i];
            }
        }

        return baseMap;
    }

    /**
     * 获取topSize个数的合并相似度最高的bitmap位置
     *
     * @param keys 计算合并相似度的tag
     * @param topSize 返回前几个数
     * @param scoreMap 可为null,传入某一tag的对应分值
     */
    public PriorityQueue<IndexCount> getSimilarRecomend(List<String> keys, int topSize, Map<String, Byte> scoreMap) {
        int maxLen = 0;
        Iterator<String> it = keys.iterator();
        while (it.hasNext()) {
            String key = it.next();
            KBitMap bitMap = tags.get(key);
            if (bitMap == null) {
                it.remove();
                continue;
            }
            int size = bitMap.size();
            if (size > maxLen) {
                maxLen = size;
            }
        }

        if (maxLen == 0) {
            return new PriorityQueue();
        }

        byte[] c = new byte[maxLen * 64];
        Arrays.fill(c, Byte.MIN_VALUE);
        PriorityQueue<IndexCount> q1 = new PriorityQueue(topSize, cmp1);

        for (String key : keys) {
            int s = 0;
            KBitMap bitMap = tags.get(key);
            long[] bitArray = bitMap.getBitArray();
            for (long bitLong : bitArray) {
                for (int i = 0; i < 64; i++) {

                    if (scoreMap != null && scoreMap.get(key) != null) {
                        c[s] += (byte) (((bitLong & (1l << i)) > 0 ? 1 : 0) * scoreMap.get(key));
                    } else {
                        c[s] += (byte) ((bitLong & (1l << i)) > 0 ? 1 : 0);
                    }

                    s++;
                }
            }
        }

        for (int i = 0; i < c.length; i++) {
            byte v = c[i];
            if (q1.size() == topSize) {
                if (v > q1.peek().getCount()) {
                    q1.poll();
                } else {
                    continue;
                }
            }
            q1.add(new IndexCount(i, v));
        }

        PriorityQueue<IndexCount> q2 = new PriorityQueue(topSize, cmp2);
        for (IndexCount ic : q1) {
            q2.add(ic);
        }
        return q2;
    }

    /**
     * 获取topSize个数的经and操作后再合并相似度最高的bitmap位置
     *
     * @param requiredKeys and操作的tag
     * @param keys 合并计算相似度的tag
     * @param topSize 返回前几个数
     * @param scoreMap 可为null,传入某一tag的对应分值,requiredKeys中的tag不会被计入分值
     */
    public PriorityQueue<IndexCount> getMixedRecomend(List<String> requiredKeys, List<String> keys, int topSize,
            Map<String, Byte> scoreMap) {
        KBitMap bitMap = getAndRecomend(requiredKeys);

        List<IndexCount> list = new ArrayList<>();
        int in = 0;
        for (long longbit : bitMap.getBitArray()) {
            for (int i = 0; i < 64; i++) {
                if ((longbit & (1l << i)) > 0) {

                    byte count = Byte.MIN_VALUE;
                    for (String key : keys) {
                        if (requiredKeys.contains(key)) {
                            continue;
                        }
                        if (scoreMap != null && scoreMap.get(key) != null) {
                            count += (byte) (tags.get(key).getBit(in) * scoreMap.get(key));
                        } else {
                            count += (byte) tags.get(key).getBit(in);
                        }
                    }
                    list.add(new IndexCount(in, count));
                }
                in++;
            }
        }

        PriorityQueue<IndexCount> q1 = new PriorityQueue(topSize, cmp1);
        PriorityQueue<IndexCount> q2 = new PriorityQueue(topSize, cmp2);
        for (IndexCount ic : list) {
            if (q1.size() == topSize) {
                if (ic.getCount() > q1.peek().getCount()) {
                    q1.poll();
                } else {
                    continue;
                }
            }
            q1.add(ic);
        }

        for (IndexCount ic : q1) {
            q2.add(ic);
        }

        return q2;
    }

    public class IndexCount {

        private int index;
        private byte count;

        public IndexCount(int i, byte c) {
            index = i;
            count = c;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public byte getCount() {
            return count;
        }

        public void setCount(byte count) {
            this.count = count;
        }
    }
}