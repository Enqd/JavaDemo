package Function;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

public class FunctionDemo2 {
    public static void main(String[] args) {
        /*
            方法引用（引用成员方法）
            格式
                其他类：其他类对象::方法名 ---> new 对象名::方法名
                本类：this::方法名
                父类：super::方法名
            需求：
                集合中有一些名字，按照要求过滤数据数据：
                "张无忌"，"周芷若"，"赵敏"，"张强"，"张三丰"
                要求：只要以张开头，而且名字是3个字的
         */

        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list, "张无忌","周芷若","赵敏","张强","张三丰");

//        list.stream()
//                .filter(s -> s.startsWith("张"))
//                .filter(s -> s.length() == 3)
//                .forEach(s -> System.out.println(s));

//        list.stream().filter(new Predicate<String>() {
//            @Override
//            public boolean test(String s) {
//                return s.startsWith("张") && s.length() == 3;
//            }
//        }).forEach(s -> System.out.println(s));

//        list.stream().filter(new StringOperation()::StringJudge);

          //静态方法中没有this
//        list.stream().filter(this::StringJudge);
        //正确写法是
        list.stream().filter(new FunctionDemo2()::StringJudge);


    }

    public boolean StringJudge(String s){
        return s.startsWith("张") && s.length() == 3;
    }
}