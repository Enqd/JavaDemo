package day12_doudizhu1;

import java.util.ArrayList;
import java.util.Collections;

public class PokerGame {

    //牌盒：存储牌，如♠3
    //静态代码块只能访问静态，所以牌盒要设置为静态
    static ArrayList<String> list = new ArrayList<>();

    //静态代码块
    //特点：随着类的加载而加载，而且只执行1次
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
        list.add("大王");
        list.add("小王");
    }

    //空参构造
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

        //看牌
        //玩家1
        lookPoker("zhangsan", p1);

        //玩家2
        lookPoker("lisi",p2);

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
}
