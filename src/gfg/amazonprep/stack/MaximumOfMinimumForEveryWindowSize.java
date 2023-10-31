package gfg.amazonprep.stack;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

//TODO: @Difficult @Important
public class MaximumOfMinimumForEveryWindowSize {

    public static void main(String[] args) {
        int ar[] = new int[]{10, 20, 30, 50, 10, 70, 30};
//        int ar[] = new int[]{35, 22, 74, 33, 88};
        for (Integer i : printMaxOfMin(ar, ar.length)) {
            System.out.print(i + " ");
        }
    }

    public static int[] printMaxOfMin(int[] arr, int n) {  // O(n) hacky approach
        // Used to find previous and next smaller
        Stack<Integer> s = new Stack<>();

        // Arrays to store previous and next smaller
        int left[] = new int[n + 1];
        int right[] = new int[n + 1];

        // Initialize elements of left[] and right[]
        for (int i = 0; i < n; i++) {
            left[i] = -1;
            right[i] = n;
        }

        // Fill elements of left[] using logic discussed on
        // https://www.geeksforgeeks.org/next-greater-element/
        for (int i = 0; i < n; i++) {
            while (!s.empty() && arr[s.peek()] >= arr[i]) {
                s.pop();
            }
            if (!s.empty()) {
                left[i] = s.peek();
            }
            s.push(i);
        }

        // Empty the stack as stack is
        // going to be used for right[]
        while (!s.empty()) {
            s.pop();
        }

        // Fill elements of right[] using same logic
        for (int i = n - 1; i >= 0; i--) {
            while (!s.empty() && arr[s.peek()] >= arr[i]) {
                s.pop();
            }
            if (!s.empty()) {
                right[i] = s.peek();
            }
            s.push(i);
        }

        // Create and initialize answer array
        int ans[] = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            ans[i] = 0;
        }

        // Fill answer array by comparing minimums of all
        // lengths computed using left[] and right[]
        for (int i = 0; i < n; i++) {
            // length of the interval
            int len = right[i] - left[i] - 1;

            // arr[i] is a possible answer for this length
            // 'len' interval, check if arr[i] is more than
            // max for 'len'
            ans[len] = Math.max(ans[len], arr[i]);
        }

        // Some entries in ans[] may not be filled yet. Fill
        // them by taking values from right side of ans[]
        for (int i = n - 1; i >= 0; i--) {
            ans[i] = Math.max(ans[i], ans[i + 1]);
        }

        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = ans[i+1];
        }


        return result;
    }

    public static int[] printMaxOfMin3(int[] arr, int N) {
        int[] result = new int[N];
        int w = 1;
        while (w <= N) {
            result[w - 1] = getMaxOfMin(arr, N, w);
            w++;
        }
        return result;
    }


    static int[] printMaxOfMin1(int[] arr, int N) { // O(n2Logn) TLE // Sliding Window
        int[] maxWindow = new int[N];
        int size = 1;
        Queue<Integer> queue = new PriorityQueue<>();
        while (size <= N) {
            int max = Integer.MIN_VALUE;
            int oldI = -1;
            for (int i = 0; i < N; i++) {
                if (queue.isEmpty()) {
                    oldI = i;
                    while (queue.size() < size) {
                        queue.add(arr[i++]);
                    }
                    i = i - 1;
                } else {
                    queue.remove(arr[oldI]);
                    queue.add(arr[i]);
                    oldI++;
                }
                max = Math.max(max, queue.peek());
            }
            maxWindow[size - 1] = max;
            size++;
            queue.clear();
        }
        return maxWindow;
    }


    static int[] printMaxOfMin2(int[] arr, int N) { // O(n3) TLE // Brute Force
        int[] maxWindow = new int[N];
        int size = 1;
        while (size <= N) {
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < (N - size + 1); i++) {
                int min = Integer.MAX_VALUE;
                for (int k = 0; k < size; k++) {
                    min = Math.min(min, arr[i + k]);
                }
                max = Math.max(max, min);
            }
            maxWindow[size - 1] = max;
            size++;
        }
        return maxWindow;
    }

    private static int getMaxOfMin(int[] arr, int n, int w) { // via Queue
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        Queue<Integer> queue = new PriorityQueue<>(w, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });

        for (int k = 0; k < w; k++) {
            queue.add(arr[k]);
        }

        min = queue.peek();

        queue.remove(arr[0]);

        if (max < min) {
            max = min;
        }

        for (int i = w; i < n; i++) {

            queue.add(arr[i]);

            min = queue.isEmpty() ? Integer.MAX_VALUE : queue.peek();

            if (max < min) {
                max = min;
            }

            queue.remove(arr[i - w + 1]);
        }
        return max;
    }

    private static int getMaxOfMin1(int[] arr, int n, int w) {
        int max = -1;
        for (int i = 0; i <= (n - w); i++) {

            int min = arr[i];
            for (int k = i; k < (i + w); k++) {
                if (min > arr[k]) {
                    min = arr[k];
                }
            }

            if (max < min) {
                max = min;
            }
        }
        return max;
    }
}
