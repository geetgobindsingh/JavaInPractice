package daa.practice;

import java.util.*;

public class PathTest {

    private static int MAX_ROWS = 3;
    private static int MAX_COLUMNS = 3;

    private static Coordinate startingCoordinate = new Coordinate(0, 0);
    private static Coordinate targetCoordinate = new Coordinate(2, 2);

    private static String leftArrow = "\u2B05";
    private static String rightArrow = "\u27A1";
    private static String upArrow = "\u2B06";
    private static String bottomArrow = "\u2B07";
    private static String upLeftArrow = "\u2196";
    private static String upRightArrow = "\u2197";
    private static String bottomLeftArrow = "\u2199";
    private static String bottomRightArrow = "\u2198";
    private static String end = "\u21CE";

    public static void main(String[] args) {
        int board[][] = new int[MAX_ROWS][MAX_COLUMNS];
        String arrow[][] = new String[MAX_ROWS][MAX_COLUMNS];
        board[0][0] = 1;
        board[0][1] = 1;
        board[0][2] = 1;

        board[1][0] = 1;
        board[1][1] = 0;
        board[1][2] = 0;

        board[2][0] = 1;
        board[2][1] = 1;
        board[2][2] = 1;

        printBoard(board);

        TreeSet<Coordinate> coordinateSet = new TreeSet<Coordinate>(new Comparator<Coordinate>() {
            @Override
            public int compare(Coordinate o1, Coordinate o2) {
                return o1.equals(o2) ? 0 : 1;
            }
        });

        coordinateSet.add(startingCoordinate);

        List<Move> movesList = new ArrayList<>();

        getListOfCoordinates(board, arrow, startingCoordinate, targetCoordinate, coordinateSet, movesList, false);

        System.out.println("------------------");

        if (movesList != null) {
            printMoves(movesList);
            printArrows(arrow);
        } else {
            System.out.println("No Moves Possible");
        }
    }

    private static void printArrows(String[][] arrow) {
        for (int i = 0; i < arrow.length; ++i) {
            for (int j =0; j < arrow[i].length; ++j) {
                if (arrow[i][j] != null) {
                    System.out.print("-" + arrow[i][j] + "-");
                } else {
                    if (i == (targetCoordinate.x) && j == (targetCoordinate.y)) {
                        System.out.print("-" + end + "-");
                    } else {
                        System.out.print("-x-");
                    }
                }


            }
            System.out.println();
        }
    }

    private static boolean getListOfCoordinates(int[][] board, String[][] arrow, Coordinate start, Coordinate end,
                                             TreeSet<Coordinate> coordinates, List<Move> movesList, boolean terminate) {

        if (start.equals(end)) {
            return true;
        }

        Coordinate leftCoordinate = start.moveLeft(board, coordinates);
        if (leftCoordinate != null) {
            arrow[start.x][start.y] = leftArrow;
            coordinates.add(leftCoordinate);
            movesList.add(new Move(leftCoordinate.x - start.x, leftCoordinate.y - start.y));
            terminate = getListOfCoordinates(board, arrow, leftCoordinate, end, coordinates, movesList, terminate);
        }

        if (terminate) {
            return true;
        }

        Coordinate rightCoordinate = start.moveRight(board, coordinates);
        if (rightCoordinate != null) {
            arrow[start.x][start.y] = rightArrow;
            coordinates.add(rightCoordinate);
            movesList.add(new Move(rightCoordinate.x - start.x, rightCoordinate.y - start.y));
            terminate = getListOfCoordinates(board, arrow, rightCoordinate, end, coordinates, movesList, terminate);
        }

        if (terminate) {
            return true;
        }

        Coordinate upCoordinate = start.moveUp(board, coordinates);
        if (upCoordinate != null) {
            arrow[start.x][start.y] = upArrow;
            coordinates.add(upCoordinate);
            movesList.add(new Move(upCoordinate.x - start.x, upCoordinate.y - start.y));
            terminate = getListOfCoordinates(board, arrow, upCoordinate, end, coordinates, movesList, terminate);
        }

        if (terminate) {
            return true;
        }

        Coordinate downCoordinate = start.moveDown(board, coordinates);
        if (downCoordinate != null) {
            arrow[start.x][start.y] = bottomArrow;
            coordinates.add(downCoordinate);
            movesList.add(new Move(downCoordinate.x - start.x, downCoordinate.y - start.y));
            terminate = getListOfCoordinates(board, arrow, downCoordinate, end, coordinates, movesList, terminate);
        }

        if (terminate) {
            return true;
        }

        Coordinate diagonalBottomLeftCoordinate = start.moveDiagonalBottomLeft(board, coordinates);
        if (diagonalBottomLeftCoordinate != null) {
            arrow[start.x][start.y] = bottomLeftArrow;
            coordinates.add(diagonalBottomLeftCoordinate);
            movesList.add(new Move(diagonalBottomLeftCoordinate.x - start.x, diagonalBottomLeftCoordinate.y - start.y));
            terminate = getListOfCoordinates(board, arrow, diagonalBottomLeftCoordinate, end, coordinates, movesList, terminate);
        }

        if (terminate) {
            return true;
        }

        Coordinate diagonalBottomRightCoordinate = start.moveDiagonalBottomRight(board, coordinates);
        if (diagonalBottomRightCoordinate != null) {
            arrow[start.x][start.y] = bottomRightArrow;
            coordinates.add(diagonalBottomRightCoordinate);
            movesList.add(new Move(diagonalBottomRightCoordinate.x - start.x, diagonalBottomRightCoordinate.y - start.y));
            terminate = getListOfCoordinates(board, arrow, diagonalBottomRightCoordinate, end, coordinates, movesList, terminate);
        }

        if (terminate) {
            return true;
        }

        Coordinate diagonalTopLeftCoordinate = start.moveDiagonalTopLeft(board, coordinates);
        if (diagonalTopLeftCoordinate != null) {
            arrow[start.x][start.y] = upLeftArrow;
            coordinates.add(diagonalTopLeftCoordinate);
            movesList.add(new Move(diagonalTopLeftCoordinate.x - start.x, diagonalTopLeftCoordinate.y - start.y));
            terminate = getListOfCoordinates(board, arrow, diagonalTopLeftCoordinate, end, coordinates, movesList, terminate);
        }

        if (terminate) {
            return true;
        }

        Coordinate diagonalTopRightCoordinate = start.moveDiagonalTopRight(board, coordinates);
        if (diagonalTopRightCoordinate != null) {
            arrow[start.x][start.y] = upRightArrow;
            coordinates.add(diagonalTopRightCoordinate);
            movesList.add(new Move(diagonalTopRightCoordinate.x - start.x, diagonalTopRightCoordinate.y - start.y));
            terminate = getListOfCoordinates(board, arrow, diagonalTopRightCoordinate, end, coordinates, movesList, terminate);
        }
        return terminate;
    }


    private static void printMoves(List<Move> moves) {

        if (moves.isEmpty()) {
            System.out.println("Start and End are Same Coordinate");
            return;
        }

        System.out.println("Moves Possible are");
        for (Move move : moves) {
            System.out.println(move.x + " , " + move.y);
        }
    }

    private static void printBoard(int[][] board) {
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[i].length; ++j) {
                System.out.print("-" + board[i][j] + "-");
            }
            System.out.print("\n");
        }
    }

    static class Move {
        int x, y;
        public Move(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Coordinate {
        int x, y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Coordinate moveRight(int[][] board, TreeSet<Coordinate> coordinates) {
            int x = this.x;
            int y = this.y + 1;
            return isMovePossible(x, y, board, coordinates);
        }

        public Coordinate moveLeft(int[][] board, TreeSet<Coordinate> coordinates) {
            int x = this.x;
            int y = this.y - 1;
            return isMovePossible(x, y, board, coordinates);
        }

        public Coordinate moveUp(int[][] board, TreeSet<Coordinate> coordinates) {
            int x = this.x - 1;
            int y = this.y;
            return isMovePossible(x, y, board, coordinates);
        }

        public Coordinate moveDown(int[][] board, TreeSet<Coordinate> coordinates) {
            int x = this.x + 1;
            int y = this.y;
            return isMovePossible(x, y, board, coordinates);
        }

        public Coordinate moveDiagonalTopLeft(int[][] board, TreeSet<Coordinate> coordinates) {
            int x = this.x - 1;
            int y = this.y - 1;
            return isMovePossible(x, y, board, coordinates);
        }

        public Coordinate moveDiagonalTopRight(int[][] board, TreeSet<Coordinate> coordinates) {
            int x = this.x - 1;
            int y = this.y + 1;
            return isMovePossible(x, y, board, coordinates);
        }

        public Coordinate moveDiagonalBottomLeft(int[][] board, TreeSet<Coordinate> coordinates) {
            int x = this.x + 1;
            int y = this.y - 1;
            return isMovePossible(x, y, board, coordinates);
        }

        public Coordinate moveDiagonalBottomRight(int[][] board, TreeSet<Coordinate> coordinates) {
            int x = this.x + 1;
            int y = this.y + 1;
            return isMovePossible(x, y, board, coordinates);
        }

        private Coordinate isMovePossible(int x, int y, int[][] board, TreeSet<Coordinate> coordinates) {
            if (x >= 0 && x < MAX_ROWS && y >= 0 && y < MAX_COLUMNS && board[x][y] == 1) {
                Coordinate coordinate = new Coordinate(x, y);
                if (!coordinate.contains(coordinates)) {
                    return coordinate;
                }
            }
            return null;
        }

        public boolean contains(TreeSet<Coordinate> coordinates) {
            boolean contains = false;

            for (Coordinate coordinate : coordinates) {
                contains = coordinate.equals(this);
                if (contains) {
                    break;
                }
            }
            return contains;
        }

        boolean equals(Coordinate coordinate) {
            return this.x == coordinate.x && this.y == coordinate.y;
        }
    }
}
