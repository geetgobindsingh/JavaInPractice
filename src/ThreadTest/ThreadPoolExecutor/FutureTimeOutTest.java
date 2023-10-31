package ThreadTest.ThreadPoolExecutor;

import Utils.It;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by geetgobindsingh on 23/11/17.
 */
public class FutureTimeOutTest {


    public static void main(String[] args) {

        try {


            List<Future> futureList = new ArrayList<>();

            List<Task> taskList = getTaskList();

            int numThreads = taskList.size();
            ExecutorService executor = Executors.newFixedThreadPool(numThreads);


            CompletionService<Integer> compService = new ExecutorCompletionService<>(executor);

            for(Task task : taskList){
                futureList.add(compService.submit(task));
            }

            executor.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(3000);
                        int i =0 ;
                        for(Task task : taskList){
                            if (It.isFalse(futureList.get(i).isDone())) {
                                futureList.get(i).cancel(true);
                            }
                            i++;
                        }

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });


            try {
                for (Task task : taskList) {
                   // Future<Integer> future = ;
                    System.out.println(compService.take().get());
                }
            } catch (CancellationException ex) {
                System.out.println("Future Terminated");
            }


            System.out.println("END");

            executor.shutdown(); //always reclaim resources


        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }


    public static List<Task> getTaskList() {
        List<Task> list = new ArrayList<>();
        for (int i = 1; i <= 10; ++i) {
            list.add(new Task(i));
        }

        return list;
    }

    public static class Task implements Callable {

        public int value = 0;

        public Task(int value) {
            this.value = value;
        }

        @Override
        public Object call() throws Exception {

            try {
                Thread.sleep(1000 * (11 - value));
                //System.out.println(value);
            } catch (InterruptedException ex) {
                System.out.println("INTERUPTED");
                Thread.currentThread().interrupt();
                ex.printStackTrace();
            }

            return value;
        }
    }
}
