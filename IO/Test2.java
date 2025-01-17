package IO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test2 {
    public static void main(String[] args) throws IOException {
        /*
            文件加密
            为了保证文件的安全性，就需要对原始文件进行加密存储，再使用的时候再对其进行解密处理。
            加密原理:
                对原始文件中的每一个字节数据进行更改，然后将更改以后的数据存储到新的文件中。
            解密原理:
                读取加密之后的文件，按照加密的规则反向操作，变成原始文件。
         */

        //加密
        encryptedFile();

        //解密
        decryptFile();
    }

    private static void encryptedFile() throws IOException {
        //读取文件数据,然后在写入数据时对数据进行更改
        FileInputStream fis = new FileInputStream("IO");
        FileOutputStream fos = new FileOutputStream("IO");

        int len;
        while((len = fis.read()) != -1){
            fos.write(len ^ 1);//修改原来的ASCII值实现加密
        }

        fos.close();
        fis.close();
    }

    private static void decryptFile() throws IOException {
        //读取文件数据,然后在写入数据时对数据进行更改
        FileInputStream fis = new FileInputStream("IO");
        FileOutputStream fos = new FileOutputStream("IO");

        int len;
        while((len = fis.read()) != -1){
            fos.write(len ^ 1);//修改原来的ASCII值实现加密
        }

        fos.close();
        fis.close();
    }
}
