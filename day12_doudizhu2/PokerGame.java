package day12_doudizhu2;

import java.util.*;

public class PokerGame {
    //准备牌
    //牌盒：存储牌，如♠3
    //静态代码块只能访问静态，所以牌盒要设置为静态
    //此时牌盒内的存储序号与牌的集合，牌的大小与序号相关
    static HashMap<Integer, String> map = new HashMap<>();
    //存序号的集合，因为后续对牌的操作都是对序号的操作
    static ArrayList<Integer> list = new ArrayList<>();

    //静态代码块
    //特点：随着类的加载而加载，而且只执行1次
    static {
        //准备牌
        String[] color = {"♦", "♣", "♥", "♠"};
        String[] number = {"3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2"};

        int seriesNumber = 1;
        list.add(seriesNumber);

        for (String n : number) {
            for (String c : color) {
                map.put(seriesNumber++, c + n);
                list.add(seriesNumber);
            }
        }

        //添加大小王
        map.put(seriesNumber++, "小王");
        list.add(seriesNumber);
        map.put(seriesNumber++, "大王");
    }

    public PokerGame(){
        //洗牌
        Collections.shuffle(list);

        //发牌
        //准备4个集合，三个人的牌，一个底牌
        //TreeSet可以自动排序
        TreeSet<Integer> p1 = new TreeSet<>();
        TreeSet<Integer> p2 = new TreeSet<>();
        TreeSet<Integer> p3 = new TreeSet<>();
        TreeSet<Integer> dipai = new TreeSet<>();

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

        //看牌
        //玩家1
        lookPoker("zhangsan1", p1);

        //玩家2
        lookPoker("lisi",p2);

        //玩家3
        lookPoker("wangwu",p3);

        //底牌
        lookPoker("lord",dipai);
    }

    public void lookPoker(String name, TreeSet<Integer> list){
        System.out.print(name + ": ");

        for(Integer i : list){
            System.out.print(map.get(i) + " ");
        }

        System.out.println();
    }
}
