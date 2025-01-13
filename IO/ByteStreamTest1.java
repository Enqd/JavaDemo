package IO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteStreamTest1 {
    public static void main(String[] args) throws IOException {
        /*
            练习:
                文件拷贝
                把xxx路径下的文件拷贝到当前模块下

            注意:
                选择一个比较小的文件,不要太大
                该方法一次读取一个字节,效率很低
         */

        //记录时间
        long start = System.currentTimeMillis();

        //1.创建对象
        FileInputStream fis = new FileInputStream("D:\\杂项\\movie.mp4");

        FileOutputStream fos = new FileOutputStream("IO\\copy.mp4");

        //2.拷贝数据
        int b;
        while((b = fis.read()) != -1) {
            fos.write(b);
        }

        //3.释放资源'
        //关闭顺序:先开的最后关闭
        fos.close();
        fis.close();

        long end = System.currentTimeMillis();

        System.out.println(end - start);
    }
}
