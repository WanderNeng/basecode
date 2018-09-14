package basecode.Concurrent;

//线程a数偶数，线程b数奇数
//通过这个例子，wait池等待锁，竞争锁，和拥有锁，是三个状态
public class SynchronizeDemo {

    static Object lock = new Object();//新建锁对象

    static int count = 0;

    public static void main(String[] args){
        Thread a = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    while (count < 100) {
                        if (count % 2 == 0) {
                            System.out.println("a" + count);
                            count++;
                            try {
                                lock.notify();//如果需要还在线程内，让出锁的步骤是先唤醒其他线程，再等待。
                                lock.wait();
                            }catch (Exception e){
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        });
        Thread b = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock){
                while(count < 100) {
                    if (count % 2 != 0) {
                        System.out.println("b" + count);
                        count++;
                        try {
                            lock.notify();
                            lock.wait();
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                    }

                }
                }
            }
        });
        a.start();
        b.start();

    }
}
