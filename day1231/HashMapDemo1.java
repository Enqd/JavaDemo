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
class Student{

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
}
