package practice;

public class FriendsPairingProblem {
    public static void main(String[] args) {
        printAllFriendsPairs(3);
    }

    private static void printAllFriendsPairs(int n) {
        boolean[] visited = new boolean[n + 1];
        printAllFriendsPairs(1, n, visited, "");
    }

    private static void printAllFriendsPairs(int i, int n, boolean[] visited, String asf) {
        if (i > n) {
            System.out.println(asf);
            return;
        }
        if (visited[i]) {
            printAllFriendsPairs(i + 1, n, visited, asf);
        } else {
            visited[i] = true;
            printAllFriendsPairs(i + 1, n, visited, asf + "( " + i + "), ");
            for (int j = i + 1; j <= n; j++) {
                if (!visited[j]) {
                    visited[j] = true;
                    printAllFriendsPairs(i + 1, n, visited, asf + "( " + i + "," + j + "), ");
                    visited[j] = false;
                }
            }
            visited[i] = false;
        }
    }


}
