package IO;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteStreamDemo2 {
    public static void main(String[] args) throws IOException {
        /*
            换行写:
                再次写出一个换行符就可以了
                windows: \r\n
                linux:   \n
                Mac:     \r
            细节:
                在windows操作系统当中，java对回车换行进行了优化。
                虽然完整的是\r\n，但是我们写其中一个\r或者\n，
                java也可以实现换行，因为java在底层会补全。

            续写
                如果想要续写,FileOutputStream第二个参数设置成true就行

         */

        //1.创建对象
        FileOutputStream f = new FileOutputStream("IO\\b.txt", true);

        //2.写入数据
        String str = "qilvxuanzuimei";
        byte[] bytes1 = str.getBytes();
        f.write(bytes1);

        String wrap = "\r\n";
        byte[] bytes2 = wrap.getBytes();
        f.write(bytes2);

        String str2 = "666";
        byte[] bytes3 = str2.getBytes();
        f.write(bytes3);
        //3.释放资源
        f.close();
    }
}
