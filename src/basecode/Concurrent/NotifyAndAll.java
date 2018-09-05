package basecode.Concurrent;


/*
理解notify和notifyAll重点还是两个概念：一个是等待池，还有一个是争用池。
调用wait方法的线程都处在等待池中，需要被唤醒才能在争用池中。
争用池是可以去竞争锁的，但是等待池中线程，在锁是空余的也不能持有锁。
notify是唤醒一个等待池中的线程，notifyAll是唤醒所有等待池中的线程。
 */

import static java.lang.Thread.sleep;

public class NotifyAndAll {

    public static final Object object = new Object();

    public static void main(String[] args) throws Exception {
        NotifyAndAll naa = new NotifyAndAll();
        Thread[] threads = new Thread[10];
        for (int i = 0; i < threads.length; i++) {
            Obj obj = naa.new Obj(i);
            threads[i] = new Thread(obj);
        }
        for (Thread t : threads) {
            t.start();
        }
        sleep(5000);
        synchronized(object) {
//            object.notifyAll();//会将所有线程唤醒，并放在等待队列中，一个个接着使用锁
            object.notify();//只会唤醒一个线程，其它线程还是在wait池里面，即使这个线程执行完，让出锁
            //也需要等到被唤醒之后才能持有锁，继续执行
        }


    }


    class Obj implements Runnable {
        int i;

        public Obj(int i) {
            this.i = i;
        }

        @Override
        public void run() {

            synchronized (object) {
                try {
                    System.out.println("线程" + i + ": 等待中。。。");
                    object.wait();
                    System.out.println("线程" + i + "运行中。。。");
                    sleep(10000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
