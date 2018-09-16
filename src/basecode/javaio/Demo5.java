package basecode.javaio;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

//利用字节缓冲流读写数据
public class Demo5 {

    public static void main(String[] args){
        String in = "src/basecode/javaio/fileTest/demoin.txt";
        String out = "src/basecode/javaio/fileTest/demo5out.txt";

        FileInputStream fis = null;
        FileOutputStream fos = null;
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try{
            fis = new FileInputStream(in);
            fos = new FileOutputStream(out);
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);
            byte[] b = new byte[1024];
            int len = bis.read(b);
            while(len != -1){
                bos.write(b,0,len);
                System.out.print(new String(b));
                len = bis.read(b);
            }
            bos.flush();
        }catch (Exception e) {
            e.printStackTrace();
        }finally{
            try{
                fis.close();
                fos.close();
                bis.close();
                bos.close();
            }catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
