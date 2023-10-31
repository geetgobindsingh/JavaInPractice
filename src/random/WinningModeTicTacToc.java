package random;

public class WinningModeTicTacToc {
    public static void main(String[] args) {
        String[] str = new String[]{
                "X", "0", "0",
                "<>",
                "-", "0", "-",
                "<>",
                "-", "-", "-",};
        System.out.print(findWinningIndex(str));
    }

    private static int findWinningIndex(String[] str) {
        int[][] matrix = new int[3][3];
        int x = 0;
        int y = 0;
        for (int i = 0; i < str.length; i++) {
            if (str[i].equals("<>")) {
                x = (x + 1) % 3;
            } else if (str[i].equals("-")) {
                matrix[x][y] = 0;
                y = (y + 1) % 3;
            } else if (str[i].equals("X")) {
                matrix[x][y] = -1;
                y = (y + 1) % 3;
            } else {
                matrix[x][y] = 1;
                y = (y + 1) % 3;
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.print("\n");
        }

        for (int i = 0; i < 3; i++) {
            int sum = 0;
            for (int j = 0; j < 3; j++) {
                sum = sum + matrix[i][j];
            }
            if (Math.abs(sum) == 2) {
                if (matrix[i][0] == 0) {
                    return (3 * i) + (i % 3);
                }
                if (matrix[i][1] == 0) {
                    return (3 * i) + (i % 3) + 1;
                }
                if (matrix[i][2] == 0) {
                    return (3 * i) + (i % 3) + 2;
                }
            }
        }

        for (int i = 0; i < 3; i++) {
            int sum = 0;
            for (int j = 0; j < 3; j++) {
                sum = sum + matrix[j][i];
            }
            if (Math.abs(sum) == 2) {
                if (matrix[0][i] == 0) {
                    return i + (i % 3);
                }
                if (matrix[1][i] == 0) {
                    return (3 * 1) + i + (1 % 3);
                }
                if (matrix[2][i] == 0) {
                    return (3 * 2) + (2 % 3);
                }
            }
        }

        if ((Math.abs(matrix[0][0] + matrix[1][1] + matrix[2][2])) == 2) {
            if (matrix[0][0] == 0) {
                return 0;
            }
            if (matrix[1][1] == 0) {
                return 5;
            }
            if (matrix[2][2] == 0) {
                return 10;
            }
        }
        if ((Math.abs(matrix[0][2] + matrix[1][1] + matrix[2][0])) == 2) {
            if (matrix[0][2] == 0) {
                return 2;
            }
            if (matrix[1][1] == 0) {
                return 5;
            }
            if (matrix[2][0] == 0) {
                return 8;
            }
        }
        return -1;
    }
}
