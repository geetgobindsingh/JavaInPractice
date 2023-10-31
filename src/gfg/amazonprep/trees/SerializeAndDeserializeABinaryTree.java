package gfg.amazonprep.trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeserializeABinaryTree extends BaseTree {
    public static void main(String[] args) {
        Node root = new Node(10);
        Node a = new Node(20);
        Node b = new Node(30);
        Node c = new Node(40);
        Node d = new Node(50);
        root.left = a;
        a.left = b;
        b.left = c;
        c.left = d;

        ArrayList<Integer> arrayList = new ArrayList<>();
        preOrderTraversal(root);
        System.out.println("");
        serialize(root, arrayList);
        for (Integer i : arrayList) {
            System.out.print(i + " ");
        }
        System.out.println("");
        preOrderTraversal(deSerialize(arrayList));
    }

    public static void serialize(Node root, ArrayList<Integer> A) {
        if (root == null) {
            A.add(-1);
            return;
        }
        A.add(root.data);
        serialize(root.left, A);
        serialize(root.right, A);
    }

    static int index = 0;

    public static Node deSerialize(ArrayList<Integer> A) {
        if (index == A.size() || A.get(index) == -1) {
            index++;
            return null;
        }
        Node root = new Node(A.get(index));
        index++;
        root.left = deSerialize(A);
        root.right = deSerialize(A);
        return root;
    }


    public static void serialize1(Node root, ArrayList<Integer> A) {
        Queue<Node> queue = new LinkedList<>();
        Queue<Node> temp = new LinkedList<>();
        queue.add(root);
        int height = height(root);
        int level = 0;
        boolean flag = false;
        while (!queue.isEmpty()) {
            if (level == height) {
                break;
            }
            Node cur = queue.poll();
            if (cur != null) {
                flag = true;
                A.add(cur.data);
                temp.add(cur.left);
                temp.add(cur.right);
            } else {
                A.add(-1);
                temp.add(null);
                temp.add(null);
            }
            if (queue.isEmpty()) {
                level++;
                if (flag) {
                    while (!temp.isEmpty()) {
                        queue.add(temp.poll());
                    }
                } else {
                    break;
                }
                flag = false;
            }
        }
    }

    public static Node deSerialize1(ArrayList<Integer> A) {
        Node root = null;
        Node current = null;
        HashMap<Integer, Node> map = new HashMap<>();
        if (!A.isEmpty()) {
            for (int i = 0; i < A.size(); i++) {
                if (map.containsKey(i)) {
                    current = map.get(i);
                } else {
                    current = new Node(A.get(i));
                    map.put(i, current);
                }
                if (i == 0) {
                    root = current;
                }
                if (current == null) {
                    map.put(leftChild(i), null);
                    map.put(rightChild(i), null);
                    continue;
                }
                if (leftChild(i) < A.size()) {
                    if (A.get(leftChild(i)) != -1) {
                        current.left = new Node(A.get(leftChild(i)));
                    } else {
                        current.left = null;
                    }
                    map.put(leftChild(i), current.left);
                }
                if (rightChild(i) < A.size()) {
                    if (A.get(rightChild(i)) != -1) {
                        current.right = new Node(A.get(rightChild(i)));
                    } else {
                        current.right = null;
                    }
                    map.put(rightChild(i), current.right);
                }
            }
        }
        return root;
    }

    public static int leftChild(int i) {
        return (2 * i) + 1;
    }

    public static int rightChild(int i) {
        return (2 * i) + 2;
    }
}
