package basecode.designpatterns.producerandcustomer;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/*
    生产者
 */

public class Producer implements Runnable {

    private BlockingQueue<Product> bq;

    private volatile boolean isRunning = true;
    private static AtomicInteger count = new AtomicInteger();
    private static final int SLEEPTIME = 1000;

    public Producer(BlockingQueue<Product> bq) {
        this.bq = bq;
    }

    @Override
    public void run() {
        Product pro = null;
        Random r = new Random();
        System.out.println("start producting id:" + Thread.currentThread().getId());
        try {
            while (isRunning) {
                Thread.sleep(r.nextInt(SLEEPTIME));
                pro = new Product(count.incrementAndGet());
                System.out.println(pro + " 加入队列");
                if (!bq.offer(pro, 2, TimeUnit.SECONDS)) {//队列满了则返回false
                    System.err.println(" 加入队列失败");
                }
            }
            }catch(Exception e){
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }

    }

    public void stop(){
        isRunning = false;
    }
}