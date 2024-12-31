package day1231;

import java.util.LinkedHashMap;

public class LinkedHashMapDemo3 {
    public static void main(String[] args){
        /*
        LinkedHashMap:
        由键决定：有序、不重复、无索引。
        有序：保证存储和取出的顺序一致
        原理：底层数据结构是依然哈希表，只是每个键值对元素又额外的多了一个双链表的机制记录存储的顺序。
         */

        //1.创建集合
        LinkedHashMap<String, String> map = new LinkedHashMap<>();

        //2.插入元素
        map.put("hubei", "wuhan");
        map.put("hunan", "changsha");
        map.put("beijing", "beijing");

        //3.遍历集合，跟HashMap一样
        System.out.println(map);
    }
}
