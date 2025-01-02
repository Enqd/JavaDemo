package day12_doudizhu3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class PokerGame {
    static ArrayList<String> list = new ArrayList<>();
    static HashMap<String, Integer> map = new HashMap<>();

    static {
        //准备牌
        String[] color = {"♠","♥","♣","♦"};
        String[] number = {"3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2"};

        //组合花色和数字
        for(String c : color){
            for(String n : number){
                list.add(c + n);
            }
        }

        //添加大小王
        list.add(" 大王");
        list.add(" 小王");

        // 指定牌的价值
        // 牌上的数字到Map集合中判断是否存在
        // 存在，获取价值
        // 不存在，本身的数字就
        map.put("J", 11);
        map.put("Q", 12);
        map.put("K", 13);
        map.put("A", 14);
        map.put("2", 15);
        map.put("小王", 50);
        map.put("大王", 100);
    }

    public PokerGame(){
        //洗牌
        Collections.shuffle(list);

        //发牌
        //准备4个集合，三个人的牌，一个底牌
        ArrayList<String> p1 = new ArrayList<>();
        ArrayList<String> p2 = new ArrayList<>();
        ArrayList<String> p3 = new ArrayList<>();
        ArrayList<String> dipai = new ArrayList<>();

        for(int i = 0; i < list.size(); i++){
            if(i <= 2){
                //发给底牌
                dipai.add(list.get(i));
                continue;
            }

            //给三个玩家轮流发牌
            if(i % 3 == 0){
                //发给玩家1
                p1.add(list.get(i));
            }else if(i % 3 == 1){
                //发给玩家2
                p2.add(list.get(i));
            }else{
                //发给玩家3
                p3.add(list.get(i));
            }
        }

        //发完牌后排序
        order(p1);
        order(p2);
        order(p3);
        order(dipai);

        lookPoker("zhangsan", p1);

        //玩家2
        lookPoker("lisi1",p2);

        //玩家3
        lookPoker("wangwu",p3);

        //底牌
        lookPoker("lord",dipai);
    }

    public void lookPoker(String name, ArrayList<String> list){
        System.out.print(name + ": ");

        for(String poker : list){
            System.out.print(poker + " ");
        }

        System.out.println();
    }

    //排序
    public void order(ArrayList<String> list){
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                //o1时待插入的数据，o2是已经排好序的数据
                //计算o1和o2的价值
                String color1 = o1.substring(0, 1);
                int val1 = getValue(o1);
                String color2 = o2.substring(0, 1);
                int val2 = getValue(o2);

                if(val1 == val2){
                    return color1.compareTo(color2);
                }else{
                    return val1 - val2;
                }
            }
        });
    }

    //获取价值
    public int getValue(String poker){
        //获取牌上的价值
        String number = poker.substring(1);

        if(map.containsKey(number)){
            //如果集合中存在，直接返回价值
            return map.get(number);
        }else{
            //如果不存在，类型转换
            return Integer.parseInt(number);
        }
    }
}
