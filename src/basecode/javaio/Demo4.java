package basecode.javaio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

//字节流读写,复制文本
public class Demo4{

    public static void main(String[] args){
        String in = "src/basecode/javaio/fileTest/demoin.txt";
        String out = "src/basecode/javaio/fileTest/demo4out.txt";
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try{
            fis = new FileInputStream(in);
            //输出会新建文件，如果没有发现源文件的话，并且会覆盖文件中的内容
            fos = new FileOutputStream(out);
//            fos = new FileOutputStream(out.true);//加上true的话就是追加，不会覆盖
            byte[] b = new byte[1024];
            int len = fis.read(b);
            while(len != -1){
                fos.write(b,0,len);
                System.out.println(new String(b));
                len = fis.read(b);
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try{
                fis.close();
                fos.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }

    }
}
