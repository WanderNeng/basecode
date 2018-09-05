package basecode.designpatterns.producerandcustomer;

import java.text.MessageFormat;
import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable{

    private BlockingQueue<Product> bq;

    private static final int SLEEPTIME = 1000;

    public Consumer(BlockingQueue<Product> bq){
        this.bq = bq;
    }

    @Override
    public void run(){
        System.out.println("start Consumer id :"+Thread.currentThread().getId());
        Random r = new Random();
        try{
            while(true){
                Product pro = bq.take();
                if(pro != null)
                {
                    int re = pro.getData() * pro.getData();
                    System.out.println(MessageFormat.format("{0}*{1}={2}", pro.getData(),pro.getData(),re));
                    Thread.sleep(r.nextInt(SLEEPTIME));
                }
            }
        }catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }
}