package gfg.amazonprep.trees;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromParentArray extends BaseTree {
    public static void main(String[] args) {
        inOrderTraversal(createTree(new int[]{-1, 0, 0, 1, 1, 3, 5}, 7));
    }

    public static Node createTree(int arr[], int n) {
        Node root = null;
        Map<Integer, Node> map = new HashMap<>();
        for (int index = 0; index < n; index++) {
            Node newNode = new Node(index);
            if (map.containsKey(arr[index])) {
                Node parent = map.get(arr[index]);
                if (parent.left == null) {
                    parent.left = newNode;
                } else {
                    parent.right = newNode;
                }
                map.put(index, newNode);
            } else {
                if (arr[index] == -1) {
                    root = newNode;
                }
                map.put(index, newNode);
            }
        }
        for (int index = 0; index < n; index++) {
            Node current = map.get(index);
            Node parent = null;
            if (arr[index] == -1) {
                parent = root;
            } else {
                parent = map.get(arr[index]);
            }
            if (parent == current) {
                continue;
            }
            if (parent.left != null && parent.left == current) {
                continue;
            }
            if (parent.right != null && parent.right == current) {
                continue;
            }
            if (parent.left == null) {
                parent.left = current;
            } else if (parent.right == null) {
                parent.right = current;
            }
        }
        map.clear();
        return root;
    }
}
