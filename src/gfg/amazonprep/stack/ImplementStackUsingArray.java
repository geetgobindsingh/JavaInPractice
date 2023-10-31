package gfg.amazonprep.stack;

//TODO: @Easy
public class ImplementStackUsingArray {
    int top;
    int arr[] = new int[1000];

    public ImplementStackUsingArray() {
        this.top = -1;
    }

    void push(int a) {
        // Your code here
        if (top < (arr.length - 1)) {
            top++;
            arr[top] = a;
        }
    }

    int pop() {
        if (top == -1) {
            return top;
        }
        return arr[top--];
    }
}
