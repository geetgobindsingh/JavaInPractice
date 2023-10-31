package leetcode.medium;

public class MiddleOfLL {

    /**
     * Given a non-empty, singly linked list with head node head, return a middle node of linked list.
     * <p>
     * If there are two middle nodes, return the second middle node.
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: [1,2,3,4,5]
     * Output: Node 3 from this list (Serialization: [3,4,5])
     * The returned node has value 3.  (The judge's serialization of this node is [3,4,5]).
     * Note that we returned a ListNode object ans, such that:
     * ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, and ans.next.next.next = NULL.
     * Example 2:
     * <p>
     * Input: [1,2,3,4,5,6]
     * Output: Node 4 from this list (Serialization: [4,5,6])
     * Since the list has two middle nodes with values 3 and 4, we return the second one.
     * <p>
     * The number of nodes in the given list will be between 1 and 100.
     */

    public static class Node {
        private final int data;
        private Node next;

        public Node(int value) {
            this.data = value;
            this.next = null;
        }

        public void setNextNode(Node node) {
            this.next = node;
        }

        public Node getNextNode() {
            return this.next;
        }

        public int getData() {
            return this.data;
        }

    }

    public static class SingleLinkedList {

        private Node head;

        public SingleLinkedList() {
            this.head = null;
        }

        public void addNode(Node node) {
            if (head == null) {
                head = node;
            } else {
                Node currentNode = head;
                while(currentNode.next != null) {
                    currentNode = currentNode.next;
                }
                currentNode.setNextNode(node);
            }
        }

        public Node getHead() {
            return this.head;
        }

        public void displayList() {
            String result = "";
            Node currentNode = head;
            while(currentNode != null && currentNode.next != null) {
                result = result + currentNode.getData() +",";
                currentNode = currentNode.next;
            }
            result = result + currentNode.getData();
            System.out.println(result);
        }
    }

    public static void main(String[] args) {
        int[] ar = new int[]{1,2,3,4,5,6,7,8};
        SingleLinkedList linkedList = new SingleLinkedList();
        if (ar.length > 0 && ar.length <= 100) {
            for (int a : ar) {
                linkedList.addNode(new Node(a));
            }
            linkedList.displayList();
            System.out.println(getMiddleOfLL(linkedList));
        }

    }

    private static int getMiddleOfLL(SingleLinkedList linkedList) {
        int result = -1;
        Node currentNode = linkedList.getHead();
        Node fastPointer, slowPointer = null;

        if (currentNode == null) {
            return result;
        }

        if (currentNode.next == null) {
            return currentNode.getData();
        }

        fastPointer = currentNode.getNextNode();
        slowPointer = currentNode;

        while (fastPointer.getNextNode() != null) {
            if (fastPointer.getNextNode().getNextNode() != null) {
                fastPointer = fastPointer.getNextNode().getNextNode();
                if (fastPointer.getNextNode() == null) {
                    slowPointer = slowPointer.getNextNode();
                }
            } else {
                fastPointer = fastPointer.getNextNode();
            }
            slowPointer = slowPointer.getNextNode();
        }

        return slowPointer.getData();
    }

}
