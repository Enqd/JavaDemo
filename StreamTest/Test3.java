package StreamTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test3 {
    public static void main(String[] args) {
        /*
            现在有两个ArrayList集合,
            第一个集合中：存储6名男演员的名字和年龄
            第二个集合中：存储6名女演员的名字和年龄
            姓名和年龄中间用逗号隔开
            比如：张三,23

            要求完成如下的操作：
            1,男演员只要名字为3个字的前两人
            2,女演员只要姓杨的,并且不要第一个
            3,把过滤后的男演员姓名和女演员姓名合并到一起
            4,将上一步的演员信息封装成Actor对象。
            5,将所有的演员对象都保存到List集合中。

            备注：演员类Actor,属性只有一个：name,age
         */

//        ArrayList<Actor> list1 = new ArrayList<>();
//        ArrayList<Actor> list2 = new ArrayList<>();

//        Actor m1 = new Actor("蔡坤坤", 24);
//        Actor m2 = new Actor("叶齁咸", 23);
//        Actor m3 = new Actor("刘不甜", 22);
//        Actor m4 = new Actor("吴签", 24);
//        Actor m5 = new Actor("谷佳", 30);
//        Actor m6 = new Actor("肖凉凉", 27);
//
//        Actor w1 = new Actor("赵小隐", 35);
//        Actor w2 = new Actor("杨隐", 36);
//        Actor w3 = new Actor("高元元", 43);
//        Actor w4 = new Actor("张天天", 31);
//        Actor w5 = new Actor("刘诗", 35);
//        Actor w6 = new Actor("杨小幂", 33);

//        Collections.addAll(list1, m1, m2, m3, m4, m5, m6);
//        Collections.addAll(list2, w1, w2, w3, w4, w5, w6);

        ArrayList<String> list1 = new ArrayList<>();
        Collections.addAll(list1, "蔡坤坤,24", "叶齁咸,23", "刘不甜,22", "吴签,24", "谷嘉,30", "肖梁梁,27");
        ArrayList<String> list2 = new ArrayList<>();
        Collections.addAll(list2, "赵小颖,35", "杨颖,36", "高元元,43", "张天天,31", "刘诗,35", "杨小幂,33");

        //男演员只要名字为3个字的前两人
        Stream<String> stream1 = list1.stream().filter(s -> s.split(",")[0].length() == 3).limit(2);

        //女演员只要姓杨的,并且不要第一个
        Stream<String> stream2 = list2.stream().filter(s -> s.startsWith("杨")).skip(1);

        //把过滤后的男演员姓名和女演员姓名合并到一起,使用 map 类型转换!!
//        Stream.concat(stream1, stream2).map(new Function<String, Actor>() {
//            //方法的返回类型诗Actor类型
//            public Actor apply(String s) {
//                //"蔡坤坤", 24
//                String name = s.split(",")[0];
//                int age = Integer.parseInt(s.split(",")[1]);
//
//                return new Actor(name, age);
//            }
//        });

        //将上式变成lambda表达式
        List<Actor> list = Stream.concat(stream1, stream2)
                .map(s -> new Actor(s.split(",")[0], Integer.parseInt(s.split(",")[1])))
                .collect(Collectors.toList());

        System.out.println(list);

    }
}

class Actor {

    public String name;
    public int age;


    public Actor() {
    }

    public Actor(String name, int age) {
        this.name = name;
        this.age = age;
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
        return "Actor{name = " + name + ", age = " + age + "}";
    }

    //集合中传入的元素是对象时,要重写hashCode和equals方法

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Actor actor = (Actor) o;
        return age == actor.age && Objects.equals(name, actor.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}