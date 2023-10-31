package gfg.amazonprep.stack;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

//TODO: @Interesting
public class StockSpanProblem {
    public static void main(String[] args) {
//        int ar[] = new int[]{100, 80, 60, 70, 60, 75, 85};
//        String[] sr = "100 80 60 70 60 75 85".split(" ");
        String[] sr = "74 665 742 512 254 469 748 445 663 758 38 60 724 142 330 779 317 636 591 243 289 507 241 143 65 249 247 606 691 330 371 151 607 702 394 349 430 624 85 755 357 641 167 177 332 709 145 440 627 124 738 739 119 483 530 542 34 716 640 59 305 331 378 707 474 787 222 746 525 673 671 230 378 374 298 513 787 491 362 237 756 768 456 375 32 53 151 351 142 125 367 231 708 592 408 138 258 288 554 784 546 110 210 159 222 189 23 147 307 231 414 369 101 592 363 56 611 760 425 538 749 84 396 42 403 351 692 437 575 621 597 22 149 800".split(" ");
        int ar[] = new int[sr.length];
        for (int index = 0; index < ar.length; index++) {
            ar[index] = Integer.parseInt(sr[index]);
        }
        int i[] = calculateSpan(ar, ar.length);
        for (int index = 0; index < ar.length; ++index) {
            System.out.println(ar[index] + " - " + i[index]);
        }
    }

    //TODO: do it using stack

    //1, 1, 1, 2, 1, 4, 6
    public static int[] calculateSpan11(int A[], int n) { // less than 13 sec

        int[] ans = new int[n];
        // Span value of first element is always 1
        ans[0] = 1;

        // Calculate span values for rest of the elements
        for (int i = 1; i < n; i++) {
            int counter = 1;
            while ((i - counter) >= 0 && A[i] >= A[i - counter]) {
                counter += ans[i - counter];
            }
            ans[i] = counter;
        }
        return ans;
    }

    public static int[] calculateSpan(int A[], int n) { //n using stack above 14.14sec
        int[] ans = new int[n];
        Arrays.fill(ans, 1);
        Stack<Integer> indexStack = new Stack<>();
        Stack<Integer> stack = new Stack<>();
        indexStack.push(0);
        stack.push(A[0]);
        for (int i = 1; i < n; i++) {
            while (!stack.isEmpty() && stack.peek() <= A[i]) {
                ans[i] = ans[i] + ans[indexStack.peek()];
                indexStack.pop();
                stack.pop();
            }
            indexStack.push(i);
            stack.push(A[i]);
        }
        return ans;
    }


    public static int[] calculateSpan1(int price[], int n) {// more then 14 sec in some test case
        int[] result = new int[n];
        Stack<Integer> stack = new Stack();
        for (int index = 0; index < n; ++index) {
            int spanCounter = 1;
            if (stack.isEmpty()) {
                result[index] = spanCounter;
                stack.push(index);
            } else {
                Queue<Integer> queue = new LinkedList<>();
                while (!stack.isEmpty() && price[stack.peek()] <= price[index]) {
                    spanCounter++;
                    queue.add(stack.pop());
                }
                while (!queue.isEmpty()) {
                    stack.push(queue.poll());
                }
                result[index] = spanCounter;
                stack.push(index);
            }
        }
        return result;
    }
}
