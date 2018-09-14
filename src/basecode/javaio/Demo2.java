package basecode.javaio;


import java.io.FileReader;
import java.io.IOException;

//文件读取
public class Demo2 {

    public static void main(String[] args){
        String path = "src/basecode/javaio/fileTest/demo2.txt";
        FileReader fr = null;
        try{
            fr = new FileReader(path);
            char[] cb = new char[1024];
            int len = fr.read(cb);
            while(len != -1){
                String str = new String(cb,0,len);
                len = fr.read(cb);
                System.out.println(str);
            }

        }catch(IOException e){
            e.printStackTrace();
        }finally {
            if(fr != null){
                try{
                    fr.close();
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
        }
    }

}
