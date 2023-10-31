package solveproblem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SherlockSquares {
    /*
    Topics
    Watson likes to challenge Sherlock's math ability.
    He will provide a starting and ending value describing a range of integers.
    Sherlock must determine the number of square integers within that range, inclusive of the endpoints.

    Note: A square integer is an integer which is the square of an integer, e.g. .

    For example, the range is  and , inclusive. There are three square integers in the range:  and .

    Function Description

    Complete the squares function in the editor below. random.It should return an integer representing the number of square integers in the inclusive range from  to .

    squares has the following parameter(s):

    a: an integer, the lower range boundary
    b: an integer, the uppere range boundary
    Input Format
    The first line contains , the number of test cases.
    Each of the next  lines contains two space-separated integers denoting  and , the starting and ending integers in the ranges.
    2
    3 9
    17 24
    output:
    2
    0
    1 <= T <= 100
    1 <= Ai <= 10^9
     */
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCasesCount = Integer.parseInt(br.readLine());
        if (!(testCasesCount >= 1 && testCasesCount <= 100)) {
            return;
        }
        while (testCasesCount > 0) {
            testCasesCount--;
            String range[] = br.readLine().split(" ");
            int start = Integer.parseInt(range[0]);
            if (!(start >= 1 && start <= Math.pow(10, 9))) {
                return;
            }
            int end = Integer.parseInt(range[1]);
            if (!(end >= 1 && end <= Math.pow(10, 9))) {
                return;
            }
            if (start > end) {
                return;
            }
            System.out.println(getPerfectSquareCount(start, end));
        }
    }

//    private static int getPerfectSquareCount(int start, int end) {
//        int count = 0;
//        for (; start<= end; ++start) {
//            double result = Math.sqrt(start);
//            if (((result - Math.floor(result)) == 0)) {
//                count++;
//            }
//        }
//        return count;
//    }

    private static int getPerfectSquareCount(int start, int end) {
        return (int)(Math.floor(Math.sqrt(end))-Math.ceil(Math.sqrt(start))+1);
    }
}
