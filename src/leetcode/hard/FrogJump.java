package leetcode.hard;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class FrogJump {
    private Boolean[][] f;
    private Map<Integer, Integer> pos = new HashMap<>();
    private int[] stones;
    private int n;

    public static void main(String[] args) {
        System.out.println(new FrogJump().canCross3(new int[]{0, 1, 3, 5, 6, 8, 12, 17}));
        System.out.println(new FrogJump().canCross(new int[]{0, 1, 3, 5, 6, 8, 12, 17}));
        System.out.println(new FrogJump().canCrossIterative(new int[]{0, 1, 3, 5, 6, 8, 12, 17}));
        System.out.println(new FrogJump().canCross(new int[]{0, 1, 2, 3, 4, 8, 9, 11}));
        System.out.println(new FrogJump().canCrossIterative(new int[]{0, 1, 2, 3, 4, 8, 9, 11}));
    }

    public boolean canCrossIterative(int[] stones) {
        n = stones.length;
        f = new Boolean[n][n];
        this.stones = stones;
        for (int i = 0; i < n; ++i) {
            pos.put(stones[i], i);
        }
        return iterativeDFS();
    }

    private boolean iterativeDFS() {
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{0, 0});

        while (!stack.isEmpty()) {
            int[] current = stack.pop();
            int i = current[0];
            int k = current[1];

            if (i == n - 1) {
                return true;
            }

            if (f[i][k] != null) {
                continue;
            }

            for (int j = k - 1; j <= k + 1; ++j) {
                if (j > 0) {
                    int h = stones[i] + j;
                    if (pos.containsKey(h)) {
                        stack.push(new int[]{pos.get(h), j});
                    }
                }
            }

            f[i][k] = false;
        }

        return false;
    }

    public boolean canCross(int[] stones) {
        n = stones.length;
        f = new Boolean[n][n];
        this.stones = stones;
        for (int i = 0; i < n; ++i) {
            pos.put(stones[i], i);
        }
        return dfs(0, 0);
    }


    private boolean dfs(int i, int k) {
        if (i == n - 1) {
            return true;
        }
        if (f[i][k] != null) {
            return f[i][k];
        }
        for (int j = k - 1; j <= k + 1; ++j) {
            if (j > 0) {
                int h = stones[i] + j;
                if (pos.containsKey(h) && dfs(pos.get(h), j)) {
                    return f[i][k] = true;
                }
            }
        }
        return f[i][k] = false;
    }

    public boolean canCross3(int[] stones) { //  TLE
        int n = stones.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(stones[i], i);
        }
        Stack<Pair> st = new Stack<>();
        st.push(new Pair(0, 0));
        while (st.size() > 0) {
            Pair curr = st.pop();
            if (curr.index == n - 1) {
                return true;
            }
            for (int j = curr.k - 1; j <= curr.k + 1; ++j) {
                if (j > 0) {
                    int next = stones[curr.index] + j;
                    if (map.containsKey(next) && map.get(next) > curr.index) {
                        st.push(new Pair(map.get(next), j));
                    }
                }
            }
        }
        return false;
    }

    static class Pair {
        int index;
        int k;

        public Pair(int index, int k) {
            this.index = index;
            this.k = k;
        }
    }
}
