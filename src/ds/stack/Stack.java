package ds.stack;

import ds.linkedlist.SingleLinkedList.LinkedList;
import ds.linkedlist.SingleLinkedList.Node;

public class Stack {

    private final LinkedList linkedList;
    private int length = 0;

    public Stack() {
        this.linkedList = new LinkedList();
    }

    public int size() {
        return length;
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public void push(int data) {
        linkedList.addNodeForStack(new Node(data));
        length++;
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is Empty");
        } else {
            length--;
            Node node = linkedList.getHead();
            linkedList.setHead(node.getNext());
            return node.getData();
        }
    }

    public int top() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is Empty");
        } else {
            return linkedList.getHead().getData();
        }
    }
}
