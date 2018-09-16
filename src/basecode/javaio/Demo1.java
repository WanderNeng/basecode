package basecode.javaio;

import java.io.FileWriter;
import java.io.IOException;

//文件的写入，字符流
public class Demo1 {

    public static void main(String[] args) {
        String path = "src/basecode/javaio/fileTest/demo1.txt";
        FileWriter fw = null;
        try {
            fw = new FileWriter(path, true);//如果追加数据就使用true
            fw.write("That is a demo about writing char.");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fw != null) {
                try {
                    fw.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
