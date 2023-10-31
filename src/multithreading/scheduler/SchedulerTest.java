package multithreading.scheduler;

import java.util.concurrent.TimeUnit;

public class SchedulerTest {

    public static int counter = 0;

    public static void main(String[] args) throws Exception {
        Scheduler scheduler = new Scheduler(1, 1000, TimeUnit.MILLISECONDS);
        scheduler.schedule(new Runnable() {
            @Override
            public void run() {
                if (scheduler.isTerminated()) {
                    return;
                }
                if (counter == 4) {
                    try {
                        throw new Exception("ERROR");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(counter++);
            }
        });
        scheduler.schedule(new Runnable() {
            @Override
            public void run() {
                if (scheduler.isTerminated()) {
                    return;
                }
                if (counter == 4) {
                    try {
                        throw new Exception("ERROR");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(100 + counter++);
            }
        });
        for (int i = 0; i < 5; i++) {
            Thread.sleep(1001);
        }
        scheduler.terminate();
    }
}
