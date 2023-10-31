package gfg.amazonprep.queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class GenerateBinaryNumbers {
    public static void main(String[] args) {
        for (String val : generate(5)) {
            System.out.print(val + " ");
        }
    }

    public static ArrayList<String> generate(long n) {
        ArrayList<String> result = new ArrayList<String>();
        Queue<String> queue = new LinkedList<>();
        queue.add("1");
        while (n-- > 0) {
            String pop = queue.poll();
            result.add(pop);
            queue.add(pop + "0");
            queue.add(pop + "1");
        }
        return result;
    }
}
