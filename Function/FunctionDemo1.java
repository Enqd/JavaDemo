package Function;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FunctionDemo1 {
    public static void main(String[] args) {
        /*
            方法引用(引用静态方法)
            格式
                类::方法名
            需求
                集合中有以下数字，要求把他们都变成int类型
                "1"，"2"，"3"，"4"，"5"
         */

        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list,"1","2","3","4","5");

//        List<Integer> newList = list.stream().map(new Function<String, Integer>() {
//            @Override
//            public Integer apply(String s) {
//                return Integer.parseInt(s);
//            }
//        }).collect(Collectors.toList());

        //1.方法需要已经存在
        //2.方法的形参和返回值需要跟抽象方法的形参和返回值保持一致
        //3.方法的功能需要把形参的字符串转换成整数

        list.stream().map(Integer::parseInt).forEach(s -> System.out.println(s));
    }
}
