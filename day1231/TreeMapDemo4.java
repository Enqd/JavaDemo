package day1231;

import java.util.Comparator;
import java.util.TreeMap;

public class TreeMapDemo4 {
    public static void main(String[] args) {
        /*
        TreeMap集合：由键决定特性：不重复、无索引、可排序
        可排序：对键进行排序。
        注意：默认按照键的从小到大进行排序，也可以自己规定键的排序规则
        */

        /*
        TreeMap集合：基本应用
        需求1：
        键：整数表示id
        值：字符串表示商品名称
        要求：按照id的升序排列、按照id的降序排列
         */

        TreeMap<Integer, String> map = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;//降序排列
            }
        });

        map.put(21, "shayulajiao");
        map.put(25, "xiezilailai");
        map.put(13, "qingtingduizhang");

        //
        System.out.println(map);
    }


}
