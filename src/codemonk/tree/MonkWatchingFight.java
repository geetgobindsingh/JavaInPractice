package codemonk.tree;
import ds.tree.BinarySearchTree;

public class MonkWatchingFight {

    /*
    Once Monk was watching a fight between an array and a tree, of being better.
    Tree got frustrated and converted that array into a Binary Search Tree by inserting the elements as nodes in BST,
    processing elements in the given order in the array.
    Now Monk wants to know the height of the created Binary Search Tree.
    Input
    4
    2 1 3 4
    Output
    3
     */
    public static void main(String[] args) throws java.io.IOException {
        java.io.BufferedReader br = new java.io.BufferedReader(new java.io.InputStreamReader(System.in));
        int numberOfNodes = Integer.parseInt(br.readLine());
        if (numberOfNodes >= 1 && numberOfNodes <= 1000) {
            String input = br.readLine();
            String[] array = input.split(" ");
            boolean flag = true;
            for (String element : array) {
                int elementLength = element.length();
                if (elementLength > 1000000) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                System.out.println(getHeightOfBSTree(numberOfNodes, array));
            }
        }
    }

    private static int getHeightOfBSTree(int numberOfNodes, String[] array) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        for (String element : array) {
            binarySearchTree.addNode(Integer.parseInt(element));
        }
        binarySearchTree.printTree();
        System.out.println("");
        return binarySearchTree.getHeight();
    }
}
