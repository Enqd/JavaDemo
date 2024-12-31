package day1231;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class HashMapDemo2 {
    public static void main(String[] args){
        /*
        某个班级80名学生，现在需要组成秋游活动，
        班长提供了四个景点依次是（A、B、C、D），
        每个学生只能选择一个景点，请统计出最终哪个景点想去的人数最多。
         */

        //1.先模拟同学投票
        String[] arr = {"A", "B", "C", "D"};
        //用list数组将投票结果存储起来
        ArrayList<String> list = new ArrayList<>();
        //用随机数产生结果
        Random r = new Random();
        for(int i = 0; i < 80; i++){
            int index = r.nextInt(arr.length);
            list.add(arr[index]);
        }

//        System.out.println(list);

        //2.创建Map对象，统计每个经典的个数
        //统计方法：先判断哈希表中是否有该经典，如果没有则加入到哈希表中
        //        如果哈希表中存在，则值加一
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < list.size(); i++){
            if(map.containsKey(list.get(i))){
                map.put(list.get(i), map.get(list.get(i)) + 1);
            }else {
                map.put(list.get(i), 1);
            }
        }

        //3.遍历哈希表，找到最大的键值对
        for(Map.Entry<String, Integer> entry : map.entrySet()){
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }
}
