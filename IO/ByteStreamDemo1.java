package IO;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteStreamDemo1 {
    public static void main(String[] args) throws IOException {
        /*
            演示：字节输出流FileOutputStream
            实现需求：写出一段文字到本地文件中。（暂时不写中文）
            实现步骤：
                创建对象
                写出数据
                释放资源
         */

        //1.创建对象
        FileOutputStream f = new FileOutputStream("IO\\a.txt");//指定文件的路径

        //2.写出数据
        f.write(97);

        //3.释放资源
        f.close();
    }
}
