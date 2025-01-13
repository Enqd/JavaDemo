package IO;

import java.io.FileInputStream;
import java.io.IOException;

public class ByteStreamDemo3 {
    public static void main(String[] args) throws IOException {
        /*
            字节输入流的细节:
                1.创建字节输入流的对象
                    细节1:如果文件不存在,直接报错

                2.写数据
                    细节1:一次读一个字节,读出来的是数据在ASCII上对应的数字
                    细节2:督导文件末尾了,read方法返回-1

                3.释放资源
         */

        //1.创建对象
        FileInputStream f = new FileInputStream("IO\\a.txt");
        
        //2.读取数据
//        int b1 = f.read();
//        System.out.println(b1);

        for (byte b : f.readAllBytes()) {
            System.out.println((char) b);
        }


        //3.释放资源
        f.close();

    }
}
