package leetcode.medium;

import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TaskScheduler {
    public static void main(String[] args) {
        TaskScheduler obj = new TaskScheduler();
        System.out.println(obj.leastInterval(new char[]{'A', 'A', 'B', 'B'}, 2));
        System.out.println(obj.leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 2));
        System.out.println(obj.leastInterval(new char[]{'A','A','A','B','B','B'}, 0));
        System.out.println(obj.leastInterval(new char[]{'A','A','A','A','A','A','B','C','D','E','F','G'}, 2));
    }

    static class Pair implements Comparable<Pair> {
        final char c;
        int count = 0;
        int time = 0;

        Pair(char c, int count) {
            this.c = c;
            this.count = count;
        }

        @Override
        public int compareTo(@NotNull Pair o) {
            return Integer.compare(this.count, o.count);
        }
    }

    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> freqMap = new HashMap<>();
        for (char task : tasks) {
            freqMap.put(task, freqMap.getOrDefault(task, 0) + 1);
        }
        PriorityQueue<Pair> pq1 = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Pair> pq2 = new PriorityQueue<>(Collections.reverseOrder());
        for (Map.Entry<Character, Integer> entry : freqMap.entrySet()) {
            pq1.offer(new Pair(entry.getKey(), entry.getValue()));
        }
        int time = 1;

        while (pq1.size() > 0) {
            Pair p = pq1.poll();
            if (p.time != 0 && (time - p.time <= n)) {
                time += (n - 1);
            }
            p.count = p.count - 1;
            p.time = time;
            if (p.count > 0) {
                pq2.offer(p);
            }

            if (pq1.size() == 0) {
                pq1.addAll(pq2);
                pq2.clear();
            }
            if (pq1.size() != 0) {
                time++;
            }
        }
        return time;
    }
}
