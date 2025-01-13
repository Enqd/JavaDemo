package IO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteStreamTest2 {
    public static void main(String[] args) throws IOException {
        /*
            练习:
                文件拷贝
                把D:\杂项\movie.mp4(6MB)路径下的文件拷贝到当前模块下

         */

        //记录时间
        long start = System.currentTimeMillis();

        //1.创建对象
        FileInputStream fis = new FileInputStream("D:\\杂项\\movie.mp4");

        FileOutputStream fos = new FileOutputStream("IO\\copy.mp4");

        //2.拷贝数据
        byte[] bytes = new byte[1024*1024*5];//以每次读取5MB的速度进行读取
        int len;//fis.read(bytes)返回读取到的长度,和fis.read()的返回值不同,fis.read()返回读取到的内容
        while((len = fis.read(bytes)) != -1) {//读取到末尾时,返回-1,以此来作为结束条件
            fos.write(bytes, 0, len);//当末尾内容不足5MB时,从0开始到len结束,读取bytes数组内的这些个长度的内容
        }

        //3.释放资源'
        //关闭顺序:先开的最后关闭
        fos.close();
        fis.close();

        long end = System.currentTimeMillis();

        System.out.println(end - start);
    }
}
