package day13;

import java.util.Set;

public class ImmutableDemo2 {
    public static void main(String[] args) {
        /*
        创建不可变的set集合
        "张三", "李四", "王五", "赵六"

        set里面的数据要保证唯一性
         */

        //集合一旦被创建就无法更改
        Set<String> set = Set.of("张三", "李四", "王五", "赵六");

        for(String s : set){
            System.out.println(s);
        }
    }
}
