package ThreadTest.ForkJoinPool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * Created by geetgobindsingh on 21/09/17.
 */
public class ForkAndJoinPool {

    public static void main(String args[]) {
        System.out.print("Add 16 by Divide and Conquer");

        ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();

        //ForkJoinPool forkJoinPool = new ForkJoinPool(2);

        DivideAndAddTask divideAndAddTask = new DivideAndAddTask(16);

        System.out.print(forkJoinPool.invoke(divideAndAddTask));

        //forkJoinPool.execute(divideAndAddTask);
        //System.out.print(divideAndAddTask.join());




    }

    private static class DivideAndAddTask extends RecursiveTask<Integer> implements ForkJoinPool.ManagedBlocker{

        private int mValue;

        DivideAndAddTask(int value) {
            this.mValue = value;
        }

        @Override
        protected Integer compute() {
            if (mValue > 1) {
                System.out.println("Splitting Work Load for " + mValue);

                List<DivideAndAddTask> splitSubTaskList = splitTask();

                for(DivideAndAddTask divideAndAddTask : splitSubTaskList) {
                    divideAndAddTask.fork();
                }

                int result = 0;

                for(DivideAndAddTask divideAndAddTask : splitSubTaskList) {
                    result += divideAndAddTask.join();
                }

                return result;

            } else {
                return mValue;
            }
        }

        private List<DivideAndAddTask> splitTask() {
            List<DivideAndAddTask> splitTaskList = new ArrayList<>();
            splitTaskList.add(new DivideAndAddTask(mValue/ 2));
            splitTaskList.add(new DivideAndAddTask(mValue/ 2));
            return splitTaskList;
        }

        @Override
        public boolean block() throws InterruptedException {
            return false;
        }

        @Override
        public boolean isReleasable() {
            return false;
        }
    }



}
