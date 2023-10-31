package ThreadTest.Synchronous;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by geetgobindsingh on 23/11/17.
 */
public class CyclicBarrierTest {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(2, new Runnable() {
            @Override
            public void run() {
                System.out.println("END");
            }
        }) ;


         new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("THREAD-1");
//                try {
////                    cyclicBarrier.await();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                } catch (BrokenBarrierException e) {
//                    e.printStackTrace();
//                }
            }
        }).start();

//         new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("THREAD-2");
//                try {
//                    cyclicBarrier.await();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                } catch (BrokenBarrierException e) {
//                    e.printStackTrace();
//                }
//            }
//        }).start();

        try {
            System.out.println("MAIN");
            cyclicBarrier.await();
            System.out.println("MAIN");
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }


        System.out.println("END_END");
    }
}
