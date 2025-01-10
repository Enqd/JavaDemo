package Exception;

import java.util.Scanner;

public class ExceptionTest {
    public static void main(String[] args) {
        /*
            需求：
                键盘录入自己心仪的女朋友姓名和年龄。
                姓名的长度在3－10之间，
                年龄的范围为18－40岁，
                超出这个范围是异常数据不能赋值，需要重新录入，一直录到正确为止。
            提示:
                需要考虑用户在键盘录入时的所有情况。
                比如：录入年龄时超出范围，录入年龄时录入了abc等情况
         */

        //创建键盘录入对象
        Scanner scanner = new Scanner(System.in);

        //创建女朋友对象
        GirlFriends gf = new GirlFriends();

        while (true) {
//            try {
////                //接受女朋友的姓名
////                System.out.println("请输入女朋友的姓名(长度在3－10之间):");
////                String name = scanner.nextLine();
////                gf.setName(name);
////
////                //接受女朋友的年龄
////                System.out.println("请输入女朋友的年龄(18－40岁):");
////                String ageStr = scanner.nextLine();
////                int age = Integer.parseInt(ageStr);
////                gf.setAge(age);
////
////                //如果所有的数据都正确,跳出死循环
////                break;
////            } catch (NumberFormatException e) {
////                System.out.println("年龄格式有误,请输入数字");
////            } catch (RuntimeException e) {
////                System.out.println("姓名 或者 年龄范围异常,请重新输入");
////            }

            try {
                //接受女朋友的姓名
                System.out.println("请输入女朋友的姓名(长度在3－10之间):");
                String name = scanner.nextLine();
                gf.setName(name);

                //接受女朋友的年龄
                System.out.println("请输入女朋友的年龄(18－40岁):");
                String ageStr = scanner.nextLine();
                int age = Integer.parseInt(ageStr);
                gf.setAge(age);

                //如果所有的数据都正确,跳出死循环
                break;
            } catch (NumberFormatException e) {
                e.printStackTrace();
            } catch (NameFormatException e) {
                e.printStackTrace();
            } catch (AgeOutOfBoundsException e) {
                e.printStackTrace();
            }
        }

        //打印
        System.out.println(gf);
    }
}

class GirlFriends {
    public String name;
    public int age;


    public GirlFriends() {
    }

    public GirlFriends(String name, int age) {
        this.name = name;
        this.age = age;
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
        if (name.length() < 3 || name.length() > 10) {
            throw new NameFormatException(name + "超出范围");
        } else {
            this.name = name;
        }
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
     * @param age
     */
    public void setAge(int age) {
        if(age < 18 || age > 40){
            throw new AgeOutOfBoundsException(age + "超出范围");
        }else {
            this.age = age;
        }
    }

    public String toString() {
        return "girlFriends{name = " + name + ", age = " + age + "}";
    }
}