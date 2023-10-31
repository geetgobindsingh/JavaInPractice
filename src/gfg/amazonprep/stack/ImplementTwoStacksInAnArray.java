package gfg.amazonprep.stack;

//TODO: @Easy
public class ImplementTwoStacksInAnArray {
    public static void main(String[] args) {
        Stacks stacks = new Stacks();
    }

    static class Stacks {
        // sq is the object of class TwoStack

        /* The method push to push element into the stack 2 */
        void push1(int x, TwoStack sq) {
            if ((sq.top1 + 1) != sq.top2 && sq.top1 < sq.arr.length) {
                sq.top1++;
                sq.arr[sq.top1] = x;
            }
        }

        /* The method push to push element into the stack 2*/
        void push2(int x, TwoStack sq) {
            if ((sq.top2 - 1) != sq.top1 && sq.top2 > 0) {
                sq.top2--;
                sq.arr[sq.top2] = x;
            }
        }

        /* The method pop to pop element from the stack 1 */
        //Return the popped element
        int pop1(TwoStack sq) {
            if (sq.top1 >= 0) {
                return sq.arr[sq.top1--];
            } else {
                return -1;
            }
        }

        /* The method pop to pop element from the stack 2 */
        //Return the popper element
        int pop2(TwoStack sq) {
            if (sq.top2 < sq.arr.length) {
                return sq.arr[sq.top2++];
            } else {
                return -1;
            }
        }
    }

    static class TwoStack {

        int size;
        int top1, top2;
        int arr[] = new int[100];

        TwoStack() {
            size = 100;
            top1 = -1;
            top2 = size;
        }
    }
}
