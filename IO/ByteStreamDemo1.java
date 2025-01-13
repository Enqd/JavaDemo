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

            字节输出流的细节:
                1.创建字节输出流对象
                    细节1:参数时字符串表示的路径或者File对象都可以
                    细节2:如果文件不存在会创建一个新的文件,但是要保证父级路径时存在的
                    细节3:如果文件已经存在,则会清空文件
                2.写数据
                    细节:write方法的参数时整数,但是实际上写道本地文件的时整数在ASCII上对应的字符
                3.释放资源
                    每次使用完流之后都要释放资源
         */


        //1.创建对象
        FileOutputStream f = new FileOutputStream("IO\\a.txt");//指定文件的路径

        //2.写出数据
        f.write(97);

        //3.释放资源
        f.close();
    }
}
