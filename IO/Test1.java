package IO;

import java.io.*;

public class Test1 {
    public static void main(String[] args) throws IOException {
        /*
            拷贝文件夹,考虑子文件夹
         */

        //1.创建对象
        //源文件夹
        File src = new File("IO");

        //目的文件夹
        File dest = new File("IO");

        //2.拷贝文件
        copyDir(src, dest);
    }

    private static void copyDir(File src, File dest) throws IOException {
        //如果dest文件夹不存在,则创建,如果存在,则不管
        dest.mkdirs();
        //1.进入数据源
        File[] files = src.listFiles();

        //2.遍历数组
        for(File file : files) {
            if(file.isFile()){
                //如果是文件,则直接读取
                FileInputStream fis = new FileInputStream(file);
                FileOutputStream fos = new FileOutputStream(new File(dest, file.getName()));//dest得到的只是文件夹,要从文件开始文件结束,需要再创建一个文件夹

                byte[] bytes = new byte[1024];
                int len;
                while((len = fis.read(bytes)) != -1){
                    fos.write(bytes, 0, len);
                }

                fos.close();
                fis.close();
            }else{
                //如果是文件夹,则递归
                copyDir(file, new File(dest, file.getName()));
            }
        }
    }
}
