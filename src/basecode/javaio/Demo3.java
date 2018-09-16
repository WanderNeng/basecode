package basecode.javaio;


import java.io.*;

//利用字符缓冲流，实现文本的传输
public class Demo3 {

    public static void main(String[] args){
        String in = "src/basecode/javaio/fileTest/demoin.txt";
        String out = "src/basecode/javaio/fileTest/demo3out.txt";
        FileReader fr = null;
        FileWriter fw = null;
        BufferedReader br = null;
        BufferedWriter bw = null;
        try{
            fr = new FileReader(in);
            fw = new FileWriter(out);
            //字符流转为缓冲流
            br = new BufferedReader(fr);
            bw = new BufferedWriter(fw);
            String line = br.readLine();//每次读一行，但是貌似不读换行符，需要手动加
            while(line != null){
                bw.write(line);
                bw.write("\n");
                line = br.readLine();
            }
            bw.flush();//flush很关键
        }catch(IOException e){
            e.printStackTrace();
        }finally{
            try{
                fr.close();
                fw.close();
                br.close();
                bw.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

}
