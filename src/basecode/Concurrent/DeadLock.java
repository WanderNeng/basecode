package basecode.Concurrent;


//演示死锁
public class DeadLock {
    //创建两个锁对象
    class MyLock {
        private Object objA = new Object();
        private Object objB = new Object();
    }

    class DemoDeadLock extends Thread{
        private boolean flag;
        private MyLock myLock;

        public DemoDeadLock(Boolean flag, MyLock myLock) {
            this.flag = flag;
            this.myLock = myLock;
        }

        @Override
        public void run() {
            if (flag) {
                synchronized (myLock.objA) {
                    System.out.println("if A");
                    synchronized (myLock.objB) {
                        System.out.println("if B");
                    }
                }
            } else {
                synchronized (myLock.objB) {
                    System.out.println("else B");
                    synchronized (myLock.objA) {
                        System.out.println("else A");
                    }
                }
            }

        }
    }
    public static void main(String[] args) {
        DeadLock t5 = new DeadLock();
        MyLock myLock = t5.new MyLock();
        DemoDeadLock dl1 = t5.new DemoDeadLock(true,myLock);
        DemoDeadLock dl2 = t5.new DemoDeadLock(false,myLock);
        dl1.start();
        dl2.start();

    }


}
