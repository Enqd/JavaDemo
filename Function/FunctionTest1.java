package Function;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class FunctionTest1 {
    public static void main(String[] args) {
        /*
            需求:
                集合中存储一些字符串的数据，比如：张三，23。
                收集到Student类型的数组当中
         */

        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list, "张无忌,15", "周芷若,14", "赵敏,13", "张强,20", "张三丰,100", "张翠山,40", "张良,35");

//        List<String> newList = list.stream().collect(Collectors.toList());
//        System.out.println(newList);

//        List<Student> newList = list.stream().map(new Function<String, Student>() {
//            @Override
//            public Student apply(String s) {
//                return new Student(s.split(",")[0], Integer.parseInt(s.split(",")[1]));
//            }
//        }).collect(Collectors.toList());

        Student[] arr = list.stream().map(Student::new).toArray(Student[]::new);

        System.out.println(Arrays.toString(arr));

    }
}
