package Exception;

public class ExceptionDemo5 {
    public static void main(String[] args) {
        /*
            public String getMessage(）  返回此throwable的详细消息字符串
            public String toString()    返回此可抛出的简短描述
            public void printStackTrace() 把异常的错误信息输出在控制台----细节：仅仅是打印信息，不会停止程序运行
         */

        int[] arr = {1,2,3,4};

        try {
            System.out.println(arr[10]);
        } catch (ArrayIndexOutOfBoundsException e) {
//            String str = e.getMessage();
//            System.out.println(str);

//            String str = e.toString();
//            System.out.println(str);

            e.printStackTrace();
        }

        System.out.println("看看我打印没有");
    }
}
