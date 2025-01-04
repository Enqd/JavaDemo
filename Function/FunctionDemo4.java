package Function;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;

public class FunctionDemo4 {
    public static void main(String[] args) {
        /*
            方法引用（类名引用成员方法）
            格式
                类名::成员方法
            需求
                集合里面一些字符串，要求变成大写后进行输出
         */

        ArrayList<String> list = new ArrayList<>();

        Collections.addAll(list, "aaa", "bbb", "ccc", "ddd");

        for(String s : list) {
            System.out.println(s.toUpperCase());
        }
    }
}
