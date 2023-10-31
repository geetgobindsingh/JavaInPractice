package ThreadTest.ThreadPoolExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by geetgobindsingh on 09/11/17.
 */
public class SingleThreadPoolTest {
    ExecutorService singleThread = Executors.newSingleThreadExecutor();

    public static void main(String[] args) {
        SingleThreadPoolTest singleThreadPoolTest = new SingleThreadPoolTest();

        Future future = singleThreadPoolTest.singleThread.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("Ding Task");
            }
        });

//        for (int i = 0; i < 10; ++i) {
//            singleThreadPoolTest.doTask();
//        }
    }


    public void doTask() {
        singleThread.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("Ding Task");
            }
        });
    }

}
