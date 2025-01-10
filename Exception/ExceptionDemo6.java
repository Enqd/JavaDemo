package Exception;

public class ExceptionDemo6 {
    public static void main(String[] args) {
        /*
            手动抛出:
                throws：写在方法定义处，表示声明一个异常。告诉调用者，使用本方法可能会有哪些异常。运行时异常可以省略不写
                throw：写在方法内，结束方法。手动抛出异常对象，交给调用者。方法中下面的代码不再执行了。

            需求:
                定义一个方法求数组的最大值
         */

        int[] arr = null;
        int max = 0;
        try {
            max = getMax(arr);
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }

        System.out.println(max);

    }

    public static int getMax(int[] arr) /*throws NullPointerException, ArrayIndexOutOfBoundsException*/{
        if(arr == null){
            //手动创建一个异常,并把这个异常交给调用者去处理
            throw new NullPointerException();
        }

        if(arr.length == 0){
            //手动创建一个异常,并把这个异常交给调用者去处理
            throw new ArrayIndexOutOfBoundsException();
        }

        int max = arr[0];
        for(int i =0; i < arr.length; i++){
            if(arr[i] > max){
                max = arr[i];
            }
        }
        return max;
    }
}
