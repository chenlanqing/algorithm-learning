package com.interview.lru;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author bluefish 2018/4/24
 * @version 1.0.0
 */
public class LRUAbstractMap extends java.util.AbstractMap {
    private final static Logger logger = LoggerFactory.getLogger(LRUAbstractMap.class);

    /**
     * 检查是否超期线程池
     */
    private ExecutorService checkTimePool;

    /**
     * Map的最大大小
     */
    private final static int max_size = 1024;

    private final static ArrayBlockingQueue<Node> QUEUE = new ArrayBlockingQueue<>(max_size);

    /**
     * 默认大小
     */
    private final static int DEFAULT_ARRAY_SIZE = 1024;

    private int arraySize;

    private Object[] arrays;

    private volatile boolean flag = true;

    private final static Long EXPIRE_TIME = 60 * 60 * 1000L;

    private volatile AtomicInteger size;

    public LRUAbstractMap() {
        arraySize = DEFAULT_ARRAY_SIZE;
        arrays = new Object[arraySize];
        executeCheckTime();
    }

    private void executeCheckTime() {
    }

    @Override
    public Set<Entry> entrySet() {
        return null;
    }

    @Override
    public int size() {
        return super.size();
    }

    @Override
    public Object get(Object key) {
        return super.get(key);
    }

    @Override
    public Object put(Object key, Object value) {
        return super.put(key, value);
    }

    @Override
    public Object remove(Object key) {
        return super.remove(key);
    }

    private class Node {
        private Node next;
        private Node pre;
        private Object key;
        private Object val;
        private Long updateTime;

        public Node(Node next, Node pre, Object key, Object val) {
            this.next = next;
            this.pre = pre;
            this.key = key;
            this.val = val;
            this.updateTime = System.currentTimeMillis();
        }

        public Long getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(Long updateTime) {
            this.updateTime = updateTime;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", value=" + val +
                    '}';
        }
    }

    /**
     * same to HashMap
     *
     * @param key
     * @return
     */
    public int hash(Object key) {
        int h;
        return key == null ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }
}
