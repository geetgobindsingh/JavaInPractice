package gfg.amazonprep.stack;

import java.util.Stack;

//TODO: @Easy
//TODO: @Interesting
public class TheCelebrityProblem {
    public static void main(String[] args) {
        int[][] M = new int[][]{{0, 1, 1}, {1, 0, 1}, {0, 0, 0}};
        System.out.println(getId(M, M[0].length));
        M = new int[][]{{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
        System.out.println(getId(M, M[0].length));
    }

    public static int getId(int M[][], int n) { //n
        int a = 0;
        int b = n - 1;

        //Check if a knows b, then a can’t be celebrity. so increment a, i.e. a++
        //Else b cannot be celebrity, so decrement b, i.e. b–
        while (a < b) {
            if (M[a][b] == 1) {
                a++;
            } else {
                b--;
            }
        }

        boolean celebrity = true;
        for (int k = 0; k < n; ++k) {
            if (k != a && (M[k][a] == 0 || M[a][k] == 1)) {
                celebrity = false;
                break;
            }
        }
        if (celebrity) {
            return a;
        } else {
            return -1;
        }
    }

    public static int getId2(int M[][], int n) { //n  via stack
        Stack<Integer> stack = new Stack<>();
        for (int index = 0; index < n; index++) {
            stack.push(index);
        }
        //Check if A knows B, then A can’t be a celebrity and push B in stack.
        // Check if A doesn’t know B, then B can’t be a celebrity push A in stack
        while (stack.size() > 1) {
            int a = stack.pop();
            int b = stack.pop();
            if (M[a][b] == 1) {
                stack.push(b);
            } else {
                stack.push(a);
            }
        }
        int c = stack.pop();
        boolean celebrity = true;
        for (int k = 0; k < n; ++k) {
            if (k != c && (M[k][c] == 0 || M[c][k] == 1)) {
                celebrity = false;
                break;
            }
        }
        if (celebrity) {
            return c;
        } else {
            return -1;
        }
    }

    public static int getId1(int M[][], int n) { //n2 brute force
        for (int i = 0; i < n; ++i) {
            boolean suspect = true;
            for (int j = 0; j < n; ++j) {
                if (M[i][j] == 1) {
                    suspect = false;
                    break;
                }
            }
            if (suspect) {
                boolean celebrity = true;
                for (int k = 0; k < n; ++k) {
                    if (k != i && M[k][i] == 0) {
                        celebrity = false;
                        break;
                    }
                }
                if (celebrity) {
                    return i;
                } else {
                    return -1;
                }
            }
        }
        return -1;
    }
}
