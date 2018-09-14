package basecode.Concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool {
    
    public static void main(String[] args){
        ExecutorService es = Executors.newFixedThreadPool(3);

    }
}
