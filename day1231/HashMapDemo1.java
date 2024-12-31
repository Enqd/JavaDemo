package day1231;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class HashMapDemo1 {
    public static void main(String[] args) {
        //存储学生对象并遍历
        //核心点：如果HashMap的键位置如果存储的是自定义对象，那么hashCode和equals方法需要重写
        Map<Student, String> map = new HashMap<>();

        Student s1 = new Student("zhangsan", 20);
        Student s2 = new Student("lisi", 22);
        Student s3 = new Student("wangwu", 30);
        Student s4 = new Student("wangwu", 30);

        map.put(s1, "hubei");
        map.put(s2, "hunan");
        map.put(s3, "anhui");
        map.put(s4, "neimenggu"); //集合覆盖，键重复的键值对返回原先的值String value = map.put(s4, "neimenggu")返回anhui

        //遍历集合
        //1
        for (Map.Entry<Student, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }

        System.out.println("------------------------------");

        //2
        Set<Student> keys = map.keySet();
        for(Student key : keys){
            String value = map.get(key);
            System.out.println(key + "=" + value);
        }

        System.out.println("------------------------------");

        //3
        map.forEach((key,value) -> System.out.println(key + "=" + value));
    }
}

//学生类
class Student implements Comparable<Student>{

    //属性
    public String name;
    public int age;

    //构造函数
    //隐式
    public Student() {
    };

    //显示
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    //get和set方法
    public String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    public String toString() {
        return "Student{name = " + name + ", age = " + age + "}";
    }

    @Override
    public int compareTo(Student o) {
        // 按照学生年龄的升序排列，年龄一样按照姓名的字母排列，同姓名年龄视为同一个人。

        // this：表示当前要添加的元素
        // o：表示已经在红黑树中存在的元素

        // 返回值：
        // 负数：表示当前要添加的元素是小的，存左边
        // 正数：表示当前要添加的元素是大的，存右边
        // 0：表示当前要添加的元素已经存在，舍弃

        if(this.getAge() == o.getAge()){
            return this.getName().compareTo(o.getName());//这里的compareTo是String内置的比较字符串的方法，重写的compareTo方法传入的是Student对象
        }else{
            return this.getAge() - o.getAge();
        }
    }
}
