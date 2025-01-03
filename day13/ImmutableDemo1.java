package day13;

import java.util.List;

public class ImmutableDemo1 {
    public static void main(String[] args) {
        /*
        创建不可变的list集合
        "张三", "李四", "王五", "赵六"
         */

        //集合一旦被创建就无法更改
        List<String> list = List.of("张三", "李四", "王五", "赵六");

        System.out.println(list.get(0));
    }
}
