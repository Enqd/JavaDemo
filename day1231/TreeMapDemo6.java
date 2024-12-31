package day1231;

import java.util.Map;
import java.util.TreeMap;

public class TreeMapDemo6 {
    public static void main(String[] args) {
        /*
        需求：字符串“aababcabcdabcde”
        请统计字符串中每一个字符出现的次数，并按照以下格式输出
        输出结果：
        a(5)b(4)c(3)d(2)e(1)

        如果题目中没有要求对结果进行排序，默认使用HashMap
        如果题目中要求对结果进行排序，请使用TreeMap
         */


        //1.定义字符串
        String s = "aababcabcdabcde";

        //2.定义集合
        TreeMap<Character, Integer> map = new TreeMap<>();

        //3.统计个数
        for(int i = 0; i < s.length(); i++){
            if(map.containsKey(s.charAt(i))){
                //存在
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            }else{
                //不存在
                map.put(s.charAt(i), 1);
            }
        }

        //4.打印集合
        //System.out.println(map);
        for(Map.Entry<Character, Integer> entry : map.entrySet()){
            System.out.print(entry.getKey() + "(" + entry.getValue() + ")");
        }
    }
}
