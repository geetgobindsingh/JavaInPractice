package leetcode.hard;

import java.util.ArrayList;
import java.util.List;

public class CountWaysToBuildRoomsInAnAntColony {
    public static void main(String[] args) {
        CountWaysToBuildRoomsInAnAntColony obj = new CountWaysToBuildRoomsInAnAntColony();
        //System.out.println(obj.waysToBuildRooms(new int[]{-1, 0, 1}));
        System.out.println(obj.waysToBuildRooms(new int[]{-1, 0, 0, 1, 2}));
    }

    long count = 0;
    int mod = 1000_000_007;
    public int waysToBuildRooms(int[] prevRoom) {

        int n = prevRoom.length;
        List<Integer>[] children = new List[n];
        for (int i = 0; i < n; i++) {
            children[i] = new ArrayList<>();
        }
        for (int i = 1; i < n; i++) {
            children[prevRoom[i]].add(i);
        }
        int[] count = new int[n];
        dfs(0, children, count);
        int[] fact = new int[n + 1], ifact = new int[n + 1];
        fact[0] = 1;
        ifact[0] = 1;
        for (int i = 1; i <= n; i++) {
            fact[i] = modMul(fact[i - 1], i);
            ifact[i] = modMul(ifact[i - 1], modExp(i, mod - 2));
        }

        return helper(0, children, count, fact, ifact);
    }

    public int helper(int root, List<Integer>[] children, int[] count, int[] fact, int[] ifact) {
        int res = fact[count[root] - 1];
        List<Integer> list = children[root];
        for (Integer i : list) {
            int sub = helper(i, children, count, fact, ifact);
            res = modMul(res, sub);
            res = modMul(res, ifact[count[i]]);
        }
        return res;
    }


    public int dfs(int root, List<Integer>[] children, int[] count) {
        List<Integer> list = children[root];
        int res = 1;
        for (Integer i : list) {
            count[i] = dfs(i, children, count);
            res += count[i];
        }
        count[root] = res;
        return res;
    }

    public int modMul(int a, int b) {
        return (int) (((long) a * b) % mod);
    }

    public int modExp(int i, int j) {
        if (j == 0) return 1;
        int res = modExp(i, j / 2);
        if ((j & 1) == 1) return modMul(i, modMul(res, res));
        return modMul(res, res);
    }

    public int waysToBuildRooms1(int[] prevRoom) {
        int mod = 1000_000_009;
        int n = prevRoom.length;
        List<Integer>[] g = new List[n];
        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();
        }
        int[] inDegreess = new int[n];
        for (int start = 0; start < prevRoom.length; start++) {
            int end = prevRoom[start];
            if (end == -1) {
                continue;
            }
            g[end].add(start);
            inDegreess[start]++;
        }

        boolean[] visited = new boolean[n];
        dfs(g, inDegreess, visited, new ArrayList<>());
        return (int) (count % mod);
    }

    private void dfs(List<Integer>[] g, int[] inDegrees, boolean[] visited, ArrayList<Integer> stack) {

        boolean completed = false;

        for (int i = 0; i < inDegrees.length; i++) {

            if (!visited[i] && inDegrees[i] == 0) {

                visited[i] = true;
                stack.add(i);
                for (int adjacent : g[i]) {
                    inDegrees[adjacent]--;
                }
                dfs(g, inDegrees, visited, stack);

                visited[i] = false;
                stack.remove(stack.size() - 1);
                for (int adjacent : g[i]) {
                    inDegrees[adjacent]++;
                }

                completed = true;
            }
        }

        if (!completed) {
            stack.forEach(i -> System.out.print(i + " "));
            System.out.println();
            count = count + 1;
        }
    }


}
