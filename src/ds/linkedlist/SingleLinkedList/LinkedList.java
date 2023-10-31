package ds.linkedlist.SingleLinkedList;

/**
 * Created by geetgobindsingh on 21/10/17.
 */
public class LinkedList {

    private Node head;

    public LinkedList() {
        this.head = null;
    }

    public void addNode(Node node) {
        if (head == null) {
            head = node;
        } else {
            Node currentNode = head;
            while (currentNode.getNext() != null) {
                currentNode = currentNode.getNext();
            }
            currentNode.setNext(node);
        }
    }

    public void addNodeForStack(Node node) {
        if (head == null) {
            head = node;
        } else {
            node.setNext(head);
            head = node;
        }
    }

    public Node getHead() {
        return this.head;
    }

    public void setHead(Node node) {
        this.head = node;
    }

    public void displayList() {
        String result = "";
        Node currentNode = head;
        while (currentNode != null && currentNode.getNext() != null) {
            result = result + currentNode.getData() + ",";
            currentNode = currentNode.getNext();
        }
        result = result + currentNode.getData();
        System.out.println(result);
    }
}
