package day11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class test1 {
    public static void main(String[] args) {
        /*
        班级里有N个学生，学生属性：姓名，年龄，性别。
        实现随机点名器
         */
        //1.定义集合
        ArrayList<String> list = new ArrayList<>();
        //2.添加元素
        Collections.addAll(list, "张三", "李四", "王五", "牛一", "孙倩", "刘可乐", "唐三");
        //3.定义随机
//        Random r = new Random();
//        for(String str : list){
//            int index = r.nextInt(list.size());//生成0到list.size()-1范围内的下标
//            System.out.println(list.get(index));
//        }

        Collections.shuffle(list);//打乱集合
        System.out.println(list.getFirst());

    }
}
