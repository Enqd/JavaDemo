package day11;

import java.util.ArrayList;
import java.util.Collections;

public class test2 {
    public static void main(String[] args) {
        /*
        班级里有N个学生
        要求：
        70%的概率随机到男生
        30%的概率随机到女生

        男："范闲","范建","范统","杜子腾","宋合泛","侯笼藤","朱益群","朱穆朗玛峰"
        女："杜琦燕","袁明媛","李猜","田蜜蜜”
         */

        //1.定义概率集合,存放七个1三个0,1表示男0表示女
        ArrayList<Integer> list = new ArrayList<>();
        Collections.addAll(list, 1,1,1,1,1,1,1, 0,0,0);
        
        //2.定义男女集合
        ArrayList<String> man = new ArrayList<>();
        Collections.addAll(man, "范闲","范建","范统","杜子腾","宋合泛","侯笼藤","朱益群","朱穆朗玛峰");
        ArrayList<String> woman = new ArrayList<>();
        Collections.addAll(woman, "杜琦燕","袁明媛","李猜","田蜜蜜");

        //3.抽取数据
        Collections.shuffle(list);
        Collections.shuffle(man);
        Collections.shuffle(woman);
        if(list.getFirst() == 1) {
            System.out.println(man.getFirst());
        }else {
            System.out.println(woman.getFirst());
        }
        
    }
}
