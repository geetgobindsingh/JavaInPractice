package gfg.amazonprep.stack;

import java.util.Stack;
//TODO: @Easy
public class GetMinimumElementFromStackWithExtraStack {
    Stack<Integer> s = new Stack<>();
    Stack<Integer> min = new Stack<>();

    /*returns min element from stack*/
    int getMin() {
        // Your code here
        if (min == null) {
            return -1;
        }
        if (min.isEmpty()) {
            return -1;
        }
        return min.peek();
    }

    /*returns poped element from stack*/
    int pop() {
        if (s == null) {
            return -1;
        }
        // Your code here
        int x = s.pop();
        int mini = getMin();
        if (mini == x) {
            min.pop();
        }
        return x;
    }

    /*push element x into the stack*/
    void push(int x) {
        // Your code here
        if (s == null) {
            s = new Stack<>();
            min = new Stack<>();
        }
        int mini = getMin();
        s.push(x);
        if (mini == -1) {
            min.push(x);
        } else {
            if (x <= mini) {
                min.push(x);
            }
        }
    }
}
