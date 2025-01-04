package Function;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class FunctionDemo5 {
    public static void main(String[] args) {
        /*
            方法引用(数组的构造方法)
            格式
                数组类型[]::new
            目的
                创建一个指定类型的数组
            需求
                集合中存储一些整数,收集到数组当中
            细节
                数组的类型要跟流中数组的类型保持一致
         */

        ArrayList<Integer> list = new ArrayList<>();
        Collections.addAll(list, 1,2,3,4,5,6);

        Integer[] newList = list.stream().toArray(Integer[]::new);
        System.out.println(Arrays.toString(newList));
    }
}
