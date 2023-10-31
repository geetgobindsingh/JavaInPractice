package custom;

import java.util.concurrent.*;

public class AsynTask<I, O> {
    private ExecutorService backgroundThread = new ThreadPoolExecutor(
            2, 2,
            0L, TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<Runnable>());

    private ExecutorService mainThread = new ThreadPoolExecutor(
            1, 1,
            0L, TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<Runnable>());

    public interface Listener<I, O> {
        void onPreExecute();

        O doInBackground(I input);

        void onPostExecute(O output);
    }

    public AsynTask(final I input, final Listener<I, O> listener) throws Exception {
        mainThread.execute(new Runnable() {
            @Override
            public void run() {
                listener.onPreExecute();
            }
        });
        O output = backgroundThread.submit(new Callable<O>() {
            @Override
            public O call() {
                return listener.doInBackground(input);
            }
        }).get();
        mainThread.execute(new Runnable() {
            @Override
            public void run() {
                listener.onPostExecute(output);
            }
        });
    }


    public static void main(String[] args) {
        try {
            new AsynTask<Integer, String>(1, new Listener<Integer, String>() {
                @Override
                public void onPreExecute() {
                    System.out.println("onPreExecute");
                }

                @Override
                public String doInBackground(Integer input) {
                    System.out.println("doInBackground " + input);
                    return String.valueOf(input);
                }

                @Override
                public void onPostExecute(String output) {
                    System.out.println("onPostExecute " + output);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        int i = 0;
        while(i < 1000) {
            i++;
        }
    }
}
