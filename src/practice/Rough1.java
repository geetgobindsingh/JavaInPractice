package practice;

import java.util.ArrayList;
import java.util.List;

public class Rough1 {

    // kth largest element in a tree

    // I : K = 2
    //          2
    //       2      1
    //     3   4   5   6
    // O: 5
    // floor / ceil - kth largest

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    static class Pair {
        int floor;
        int ceil;

        Pair(int floor, int ceil) {
            this.floor = floor;
            this.ceil = ceil;
        }
    }
    public static void main(String[] args) {
        int k = 2;
        TreeNode root = new TreeNode(2);
        TreeNode two =  new TreeNode(2);
        TreeNode three =  new TreeNode(3);
        TreeNode one =  new TreeNode(1);
        TreeNode four =  new TreeNode(4);
        TreeNode five =  new TreeNode(5);
        TreeNode six =  new TreeNode(6);
        root.left = two;
        root.right = one;
        two.left = three;
        two.right = four;
        one.left = five;
        one.right = six;
        Pair p = new Pair(Integer.MIN_VALUE,0);
        int factor = Integer.MAX_VALUE;
        for (int i = 0; i <= k; i++) {
            traverse(root, factor, p);
            System.out.println(p.floor);
            factor = p.floor;
            p.floor = Integer.MIN_VALUE;
        }
    }

    private static void traverse(TreeNode node, int factor, Pair p) {
        if (node == null) return;
        if (node.val < factor) {
            if (node.val > p.floor) {
                p.floor = node.val;
            }
        }
        traverse(node.left, factor, p);
        traverse(node.right, factor, p);

    }

    // matrix[][] characters
    // inp: "efg" | "aei" | "af"
    // a b c d
    // e f g h
    // i j k l
    //


    public static void main1(String[] args) {
        System.out.println(canForm(new char[][]{
                {'a', 'b', 'c', 'd'},
                {'e', 'e', 'g', 'e'},
                {'i', 'j', 'k', 'l'},
        }, "eeg"));
    }

    private static boolean canForm(char[][] chars, String inp) {
        int n = chars.length;
        int m = chars[0].length;
        List<int[]> locs = new ArrayList<>();
        char init = inp.charAt(0);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (chars[i][j] == init) {
                    locs.add(new int[]{i, j});
                }
            }
        }
        boolean[][] visited = new boolean[n][m];
        for (int[] loc : locs) {
            if (backtracking(loc[0], loc[1], 0, chars, inp, visited)) {
                return true;
            }
        }
        return false;
    }

    private static boolean backtracking(int x, int y, int charIndex, char[][] chars, String inp, boolean[][] visited) {
        if (x < 0 || x >= chars.length || y < 0 || y >= chars[0].length || visited[x][y] || charIndex >= inp.length()) {
            return false;
        }
        if (chars[x][y] == inp.charAt(charIndex)) {

            if (charIndex == inp.length() - 1) return true;

            visited[x][y] = true;
            boolean topLeft = backtracking(x - 1, y - 1, charIndex + 1, chars, inp, visited);
            boolean left = backtracking(x, y - 1, charIndex + 1, chars, inp, visited);
            boolean bottomLeft = backtracking(x + 1, y - 1, charIndex + 1, chars, inp, visited);
            boolean bottom = backtracking(x + 1, y, charIndex + 1, chars, inp, visited);
            boolean bottomRight = backtracking(x + 1, y + 1, charIndex + 1, chars, inp, visited);
            boolean right = backtracking(x, y + 1, charIndex + 1, chars, inp, visited);
            boolean topRight = backtracking(x - 1, y + 1, charIndex + 1, chars, inp, visited);
            boolean top = backtracking(x - 1, y, charIndex + 1, chars, inp, visited);
            if (topLeft || left || bottomLeft || bottom
                    || bottomRight || right || topRight || top) {
                return true;
            }
            visited[x][y] = false;
        }
        return false;
    }


}
