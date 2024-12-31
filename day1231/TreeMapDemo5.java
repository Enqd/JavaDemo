package day1231;

import java.util.Comparator;
import java.util.Objects;
import java.util.TreeMap;

public class TreeMapDemo5 {
    public static void main(String[] args) {
        /*
        TreeMap集合：基本应用
        需求2：
        键：学生对象
        值：籍贯
        要求：按照学生年龄的升序排列，年龄一样按照姓名的字母排列，同姓名年龄视为同一个人。
         */

        //1.创建集合
        TreeMap<Student, String> map = new TreeMap<>();

        //2.创建Student对象
        Student s1 = new Student("zhangsan", 23);
        Student s2 = new Student("lisi", 18);
        Student s3 = new Student("wangwu", 18);

        //3.插入元素
        map.put(s1, "hubei");
        map.put(s2, "hunan");
        map.put(s3, "anhui");

        //4.打印集合
        System.out.println(map);
    }

}