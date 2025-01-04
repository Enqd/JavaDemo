package Function;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FunctionDemo3 {
    public static void main(String[] args) {
        /*
            方法引用(引用构造方法)
            格式
                类名::new
            目的
                创建这个类的对象
            需求
                集合里面存储姓名和年龄,要求封装成Student对象并收集到List集合中

            方法引用的规则：
            1.需要有函数式接口
            2.被引用的方法必须已经存在
            3.被引用方法的形参和返回值,需要跟抽象方法的形参返回值保持一致
            4.被引用方法的功能需要满足当前的需求
         */

        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list,"张无忌,15","周芷若,14","赵敏,13","张强,20","张三丰,100","张翠山,40","张良,35","王二麻子,37");

        List<Student> new_List = list.stream()
                .map(Student::new)
                .collect(Collectors.toList());

        System.out.println(new_List);
    }
}

class Student {
    public String name;
    public int age;


    public Student() {
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Student(String str) {
        //构造方法引用的时候,只需要保证构造方法生成的对象跟抽象方法的返回值一致即可
        this.name = str.split(",")[0];
        this.age = Integer.parseInt(str.split(",")[1]);
    }

    /**
     * 获取
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     * @return age
     */
    public int getAge() {
        return age;
    }

    /**
     * 设置
     * @param age
     */
    public void setAge(int age) {
        this.age = age;
    }

    public String toString() {
        return "Student{name = " + name + ", age = " + age + "}";
    }
}