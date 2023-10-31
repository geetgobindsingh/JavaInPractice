package random;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by geetgobindsingh on 26/09/17.
 */
public class IteratorTest {

    //public  static CopyOnWriteArrayList<String> arrayList = new CopyOnWriteArrayList<>();

    private static Queue<String> arrayList = new ConcurrentLinkedQueue<String>();

    private static Lock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {


        arrayList.add("a");
        arrayList.add("a");
        arrayList.add("a");
        arrayList.add("a");
        arrayList.add("b");
        arrayList.add("b");
        arrayList.add("b");
        arrayList.add("b");
        arrayList.add("b");
        arrayList.add("b");
        arrayList.add("b");
        arrayList.add("c");
        arrayList.add("c");
        arrayList.add("c");
        arrayList.add("c");
        arrayList.add("d");
        arrayList.add("d");
        arrayList.add("d");
        arrayList.add("d");
        arrayList.add("d");



        Thread threadOne = new Thread(new Runnable() {
            @Override
            public void run() {
                iterateList("One", "b");
            }
        });
        Thread threadTwo = new Thread(new Runnable() {
            @Override
            public void run() {
                iterateList("Two", "d");
            }
        });
        Thread threadThree = new Thread(new Runnable() {
            @Override
            public void run() {
                iterateList("Three", "a");
            }
        });
        threadOne.start();
        threadTwo.start();
        threadThree.start();


        for(String item : arrayList) {
            System.out.println(item);
        }

    }

    public  static void iterateList(String threadNumber, String item) {
        try {

                for (Iterator<String> iterator = arrayList.iterator(); iterator.hasNext(); ) {
                    String typedWord = iterator.next();
                    System.out.println("From " + typedWord + " thread number " + threadNumber);
                    if (typedWord.equalsIgnoreCase(item)) {

                        iterator.remove();


                        System.out.println("So " + item + " removed by thread number " + threadNumber);
                    }
                }

        } catch (Exception ex) {
            System.out.println("Error is "+ ex.getCause() + " thread number " + threadNumber);
        }
    }
}
