package gfg.amazonprep.stack;

//TODO: @Interesting
public class ImplementStackUsingLinkedList {
    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        int i = 0;
        while (i < 3) {
            i++;
            System.out.println(myStack.pop());
        }
    }

    static class MyStack {

        // Note that top is by default null
        // in Java
        StackNode top;

        void push(int a) {
            StackNode temp = new StackNode(a);
            temp.next = top;
            top = temp;
        }

        int pop() {
            if (top == null) {
                return -1;
            } else {
                int val = top.data;
                top = top.next;
                return val;
            }
        }
    }

    static class StackNode {
        int data;
        StackNode next;

        StackNode(int a) {
            data = a;
            next = null;
        }
    }
}
