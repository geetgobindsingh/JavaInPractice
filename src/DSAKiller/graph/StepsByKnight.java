package DSAKiller.graph;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class StepsByKnight {

    public static void main(String[] args) {
        System.out.println(minStepToReachTarget(new int[]{4, 5},
                new int[]{1, 1},
                6));
        System.out.println(minStepToReachTarget(new int[]{5, 7},
                new int[]{15, 20},
                20));
    }

    static class Position {
        int x;
        int y;
        int distance;

        public Position(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }

    public static int minStepToReachTarget(int knightpos[], int targetpos[], int N) {
        boolean[][] visited = new boolean[N][N];
        int dx[] = {-2, -1, 1, 2, -2, -1, 1, 2};
        int dy[] = {-1, -2, -2, -1, 1, 2, 2, 1};
        Queue<Position> queue = new PriorityQueue<>(new Comparator<Position>() {
            @Override
            public int compare(Position o1, Position o2) {
                return Integer.compare(o1.distance, o2.distance);
            }
        });
        Position current = new Position(knightpos[0] - 1, knightpos[1] - 1, 0);
        queue.offer(new Position(current.x, current.y, current.distance));
        visited[current.x][current.y] = true;
        while (!queue.isEmpty()) {
            current = queue.poll();
            if ((targetpos[0] - 1) == current.x
                    && (targetpos[1] - 1) == current.y) {
                return current.distance;
            }
            for (int step = 0; step < 8; step++) {
                int x = current.x + dx[step];
                int y = current.y + dy[step];
                if (x < N && y < N
                        && x >= 0 && y >= 0
                        && !visited[x][y]) {
                    visited[x][y] = true;
                    queue.add(new Position(x, y, current.distance + 1));
                }
            }
        }
        return Integer.MAX_VALUE;
    }


    // KnightPos : knight position coordinates
    // targetPos : target position coordinated
    // N : square matrix size
    public static int minStepToReachTarget1(int knightpos[], int targetpos[], int N) {
        int[][] chessBoard = new int[N][N];
        return moveNextStep(chessBoard, targetpos, knightpos[0] - 1, knightpos[1] - 1, 1);
    }

    public static int moveNextStep(int[][] chessBoard, int[] targetpos, int x, int y, int moveCount) {
        if (x < 0 || y < 0
                || x >= chessBoard.length
                || y >= chessBoard.length
                || chessBoard[x][y] != 0) {
            return Integer.MAX_VALUE;
        } else if (x == (targetpos[0] - 1)
                && y == (targetpos[1] - 1)) {
            return moveCount;
        }
        int minSteps = moveCount;
        chessBoard[x][y] = 1;
        int moveSteps = moveNextStep(chessBoard, targetpos, x + 2, y - 1, moveCount + 1);

        if (minSteps < moveSteps) {
            minSteps = moveSteps;
        }
        chessBoard[x][y] = 1;
        moveSteps = moveNextStep(chessBoard, targetpos, x + 2, y + 1, moveCount + 1);

        if (minSteps < moveSteps) {
            minSteps = moveSteps;
        }
        chessBoard[x][y] = 1;
        moveSteps = moveNextStep(chessBoard, targetpos, x - 1, y + 2, moveCount + 1);

        if (minSteps < moveSteps) {
            minSteps = moveSteps;
        }
        chessBoard[x][y] = 1;
        moveSteps = moveNextStep(chessBoard, targetpos, x + 1, y + 2, moveCount + 1);

        if (minSteps < moveSteps) {
            minSteps = moveSteps;
        }
        chessBoard[x][y] = 1;
        moveSteps = moveNextStep(chessBoard, targetpos, x - 2, y + 1, moveCount + 1);

        if (minSteps < moveSteps) {
            minSteps = moveSteps;
        }
        chessBoard[x][y] = 1;
        moveSteps = moveNextStep(chessBoard, targetpos, x - 2, y - 1, moveCount + 1);

        if (minSteps < moveSteps) {
            minSteps = moveSteps;
        }
        chessBoard[x][y] = 1;
        moveSteps = moveNextStep(chessBoard, targetpos, x + 1, y - 2, moveCount + 1);

        if (minSteps < moveSteps) {
            minSteps = moveSteps;
        }
        chessBoard[x][y] = 1;
        moveSteps = moveNextStep(chessBoard, targetpos, x - 1, y - 2, moveCount + 1);
        chessBoard[x][y] = 0;
        if (minSteps < moveSteps) {
            minSteps = moveSteps;
        }
        return minSteps;
    }
}
