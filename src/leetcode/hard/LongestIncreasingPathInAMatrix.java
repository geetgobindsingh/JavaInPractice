package leetcode.hard;

import kotlin.reflect.jvm.internal.impl.types.Variance;
import leetcode.easy.ValidPalindrome;

import java.util.*;

public class LongestIncreasingPathInAMatrix {
    public static void main(String[] args) {
        LongestIncreasingPathInAMatrix longestIncreasingPathInAMatrix = new LongestIncreasingPathInAMatrix();
//        int[][] matrix = new int[][]{{9, 9, 4}, {6, 6, 8}, {2, 1, 1}};
//        int[][] matrix = new int[][]{{3,4,5}, {3,2,6}, {2, 2, 1}};
        int[][] matrix = new int[][]{{9, 2}, {2, 2}};
        System.out.println("MAx count " + String.valueOf(longestIncreasingPathInAMatrix.longestIncreasingPath(matrix)));
        // 1,2,6,9
    }

    class Vertex {
        public final int data;
        public Vertex left, right, top, bottom;

        public Vertex(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
            this.top = null;
            this.bottom = null;
        }

        public void setLeft(Vertex left) {
            this.left = left;
        }

        public void setBottom(Vertex bottom) {
            this.bottom = bottom;
        }

        public void setRight(Vertex right) {
            this.right = right;
        }

        public void setTop(Vertex top) {
            this.top = top;
        }

        @Override
        public String toString() {
            return String.valueOf(this.data);
        }
    }

    public int longestIncreasingPath(int[][] matrix) {
        int maxCount = 0;
        Vertex[][] matrixVertex = new Vertex[matrix.length][matrix.length];

        for (int index_i = 0; index_i < matrix.length; ++index_i) {
            System.out.println();
            for (int index_j = 0; index_j < matrix.length; ++index_j) {
                matrixVertex[index_i][index_j] = new Vertex(matrix[index_i][index_j]);
                System.out.print(matrixVertex[index_i][index_j]);
                System.out.print(" ");
            }
        }
        System.out.println();

        List<Vertex> vertexList = new ArrayList<>();

        for (int index_i = 0; index_i < matrix.length; ++index_i) {
            for (int index_j = 0; index_j < matrix.length; ++index_j) {
                int leftIndex = index_j - 1;
                if (leftIndex >= 0) {
                    matrixVertex[index_i][index_j].setLeft(matrixVertex[index_i][leftIndex]);
                }
                int topIndex = index_i - 1;
                if (topIndex >= 0) {
                    matrixVertex[index_i][index_j].setTop(matrixVertex[topIndex][index_j]);
                }
                int rightIndex = index_j + 1;
                if (rightIndex < matrix.length) {
                    matrixVertex[index_i][index_j].setRight(matrixVertex[index_i][rightIndex]);
                }
                int bottomIndex = index_i + 1;
                if (bottomIndex < matrix.length) {
                    matrixVertex[index_i][index_j].setBottom(matrixVertex[bottomIndex][index_j]);
                }

                vertexList.add(matrixVertex[index_i][index_j]);
            }
        }

        Collections.sort(vertexList, new Comparator<Vertex>() {
            @Override
            public int compare(Vertex o1, Vertex o2) {
                return Integer.compare(o2.data, o1.data);
            }
        });

        List<Vertex> tempList = new ArrayList<>();
        List<Vertex> finalList = new ArrayList<>();
        for (Vertex v : vertexList) {
            System.out.print(v.data);
            System.out.print(" ");
            System.out.print(v.left);
            System.out.print(" ");
            System.out.print(v.top);
            System.out.print(" ");
            System.out.print(v.right);
            System.out.print(" ");
            System.out.print(v.bottom);
            System.out.println();
            tempList.clear();
            int temp = getMaxCount(v, tempList, 0);
            if (temp > maxCount) {
                maxCount = temp;
                finalList.clear();
                finalList.addAll(tempList);
            }
        }

        System.out.println();
        for (Vertex v : finalList) {
            System.out.print(v.data);
            System.out.print(" ");
            System.out.print(v.left);
            System.out.print(" ");
            System.out.print(v.top);
            System.out.print(" ");
            System.out.print(v.right);
            System.out.print(" ");
            System.out.print(v.bottom);
            System.out.println();
        }
        System.out.println();

        return maxCount;
    }

    public int getMaxCount(Vertex start, List<Vertex> vertexList, int count) {

        int leftValue = 0, topValue = 0, rightValue = 0, bottomValue = 0;
        List<Vertex> leftList = new ArrayList<>();
        leftList.addAll(vertexList);
        List<Vertex> topList = new ArrayList<>();
        topList.addAll(vertexList);
        List<Vertex> rightList = new ArrayList<>();
        rightList.addAll(vertexList);
        List<Vertex> bottomList = new ArrayList<>();
        bottomList.addAll(vertexList);

        if (start.left != null && start.left.data < start.data) {
            int temp = getMaxCount(start.left, leftList, count) + 1;
            if (temp < count) {
                leftValue =  count;
            } else {
                leftList.add(start);
                leftValue =  temp;
            }
        }
        if (start.top != null && start.top.data < start.data) {
            int temp = getMaxCount(start.top, topList, count) + 1;
            if (temp < count) {
                topValue = count;
            } else {
                topList.add(start);
                topValue = temp;
            }
        }
        if (start.right != null && start.right.data < start.data) {
            int temp = getMaxCount(start.right, rightList, count) + 1;
            if (temp < count) {
                rightValue =  count;
            } else {
                rightList.add(start);
                rightValue =  temp;
            }
        }
        if (start.bottom != null && start.bottom.data < start.data) {
            int temp = getMaxCount(start.bottom, bottomList, count) + 1;
            if (temp < count) {
                bottomValue =  count;
            } else {
                bottomList.add(start);
                bottomValue =  temp;
            }
        }
        List<Variable> variableList = new ArrayList<>();
        Variable left = new Variable(0, leftValue);
        variableList.add(left);
        Variable top = new Variable(1, topValue);
        variableList.add(top);
        Variable right = new Variable(2, rightValue);
        variableList.add(right);
        Variable bottom = new Variable(3, bottomValue);
        variableList.add(bottom);

        Collections.sort(variableList, new Comparator<Variable>() {
            @Override
            public int compare(Variable o1, Variable o2) {
                return Integer.compare(o2.value, o1.value);
            }
        });

        int flagIndex = variableList.get(0).flagIndex;
        vertexList.add(start);
        switch (flagIndex) {
            case 0: {
                vertexList.addAll(leftList);
                return leftValue;
            }
            case 1: {
                vertexList.addAll(topList);
                return topValue;
            }
            case 2: {
                vertexList.addAll(rightList);
                return rightValue;
            }
            case 3: {
                vertexList.addAll(bottomList);
                return bottomValue;
            }
        }
        return 1;
    }

    class Variable {
        public int flagIndex = -1;
        public int value = 0;
        public Variable(int flagIndex, int value) {
            this.flagIndex = flagIndex;
            this.value = value;
        }
    }
}
