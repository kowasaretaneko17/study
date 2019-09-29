package linkedList;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 构建组：大道金服科技部
 * 作者:weiyimeng
 * 邮箱:weiyimeng@ddjf.com.cn
 * 日期:2019/9/19
 * 功能说明：LRUCache
 * 需求：
 */
public class LRUCache {
    private static LinkedHashMap<Integer,Integer> hashMap;
    public LRUCache(final int capacity) {
        //设置一个linkedHashMap，按照访问顺序进行排序
        hashMap = new LinkedHashMap<Integer, Integer>(capacity,0.75f,true){
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest){
                return size()>capacity;
            }
        };
    }
    public int get(int key) {
        return hashMap.getOrDefault(key,-1);
    }

    public void put(int key, int value) {
        hashMap.put(key,value);
    }
    public static void main(String[] args){
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1,1);
        lruCache.put(2,2);
        lruCache.get(1);
        lruCache.put(3,3);
        lruCache.put(4,4);
        lruCache.get(3);

        System.out.println(lruCache);
    }
}
