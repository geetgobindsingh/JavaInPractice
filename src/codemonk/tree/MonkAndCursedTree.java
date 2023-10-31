package codemonk.tree;

import ds.tree.BTNode;
import ds.tree.BinarySearchTree;

public class MonkAndCursedTree {
    /*
  Monk has an array A having N distinct integers and a Binary Search Tree which is initially empty.
  He inserts all the elements of the array from index 1 to N in the BST in the order given in the array.
  But wait! The tree so formed turns out to be cursed.
  Monk is having some weird experiences since he made that tree.

  So, now to stop all that, Monk has two options, to destroy the BST or to pray to God and ask for a solution.
  Now since Monk has to use this BST in a Code Monk Challenge, he cannot destroy it. So he prays to God.

  God answer his prayers and sends an angel named Micro. Now, Micro asks Monk to find something.
  He tells him two values, X and Y, present in the BST and ask him to find the maximum value that
  lie in the path between node having value X and node having value Y. (including X and Y ).

  Now since, Monk is very afraid of that tree he asks for your help.

  Input:
   First line consists of a single integer denoting N.
   Second line consists of N space separated integers denoting the array A.
   Third line consists of two space separated integers denoting X and Y.

  Output:
   Print the maximum value that lie in the path from node having value X and node having value Y in a new line.

   Input
   5
   4 7 8 6 3
   3 7
   Output
   7
    */
    public static void main(String[] args) throws java.io.IOException {
        java.io.BufferedReader br = new java.io.BufferedReader(new java.io.InputStreamReader(System.in));
        int numberOfNodes = Integer.parseInt(br.readLine());
        if (numberOfNodes >= 1 && numberOfNodes <= Math.pow(10, 5)) {
            String input = br.readLine();
            String[] array = input.split(" ");
            boolean flag = true;
            for (String element : array) {
                int elementLength = element.length();
                if (elementLength > Math.pow(10, 9)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                String inputXandY = br.readLine();
                String[] xAndy = inputXandY.split(" ");
                System.out.println(getMaxBetweenXAndY(numberOfNodes, array, Integer.parseInt(xAndy[0]), Integer.parseInt(xAndy[1])));
            }
        }
    }

    private static Integer getMaxBetweenXAndY(int numberOfNodes, String[] array, int x, int y) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        for (String element : array) {
            binarySearchTree.addNode(Integer.parseInt(element));
        }
        if (x > y) {
            int temp = x;
            x = y;
            y = temp;
        }

        BTNode root = getNewRoot(binarySearchTree.getRoot(), x, y);

        return findMaxBetweenRootAndValueNode(root, y, root.getData());

    }
    private static Integer findMaxBetweenRootAndValueNode(BTNode root, int y, int max) {
        if (root != null) {
            if (root.getData() == y) {
                return root.getData();
            } else if (root.getData() > y) {
                return root.getData();
            } else {
                return Math.max(findMaxBetweenRootAndValueNode(root.getRightNode(), y, max), max);
            }
        }
        return null;
    }

    private static BTNode getNewRoot(BTNode root, int x, int y) {
        if (root.getData() > x && root.getData() > y) {
            return getNewRoot(root.getLeftNode(), x, y);
        } else if (root.getData() < x && root.getData() < y) {
            return getNewRoot(root.getRightNode(), x, y);
        }
        return root;
    }
}
