package Exception;

public class Student {
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
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     *
     * @return age
     */
    public int getAge() {
        return age;
    }

    /**
     * 设置
     *
     * @param age
     */
    public void setAge(int age) {
        if(age < 18 || age > 40) {
            //System.out.println("年龄超出限制");

            //抛出异常
            throw new RuntimeException();//运行时异常
        } else {
            this.age = age;
        }
    }

    //返回名字和年龄拼接后的结果
    public String getSplice() {
        return name + "-" + Integer.toString(age);
    }

    public String toString() {
        return "Student{name = " + name + ", age = " + age + "}";
    }
}
