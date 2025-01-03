package day13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Stream;

public class StreamDemo2 {
    public static void main(String[] args) {
        /*
            单列集合        default Stream<E> stream()                      Collection中的默认方法
            双列集合        无                                               无法直接使用stream流
            数组          public static <T> Stream<T> stream(T[] array)   Arrays工具类中的静态方法
            一堆零散数据      public static<T>Stream<T>of(T...values)S        tream接口中的静态方法
         */

        //1.单列集合
        ArrayList<String> list = new ArrayList<>();

        Collections.addAll(list, "a", "b", "c", "d");

        list.stream().forEach(s -> System.out.println(s));

        int[] arr1 = {1, 2, 5, 3};
        String[] arr2 = {"a", "b", "c"};

        //注意：
        //Stream接口中静态方法of的细节
        //方法的形参是一个可变参数，可以传递一堆零散的数据，也可以传递数组
        //但是数组必须是引用数据类型的，如果传递基本数据类型，是会把整个数组当做一个元素，放到stream当中。
        Stream.of(arr1).forEach(s -> System.out.println(s));//[I@7291c18f
        //正确做法
        //调用Arrays工具类的静态方法
        Arrays.stream(arr1).forEach(s -> System.out.println(s));

        Stream.of(arr2).forEach(s -> System.out.println(s));//a b c

    }
}
