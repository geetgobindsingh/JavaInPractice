package solveproblem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class TicketSeller {
    /*
    There are N ticket sellers each of whom has a certain amount of tickets.
    The price of a ticket is the number of tickets remaining with the ticket seller.
    They can sell a total of K tickets. Find the maximum amount they can earn by selling K tickets.

    Input:
    The first line of the input consists of a single integer T denoting the number of test cases.
    Each of the test case consists of two lines. First line of each test case consists of two integers N and K.
    The next line contains space separated N integers A[0], A[1], …, A[N-1] where A[i] denotes the number of ticket with ith ticket seller.

    Output:
    For each test case, print in a new line, the maximum amount they can earn by selling K tickets. Print your answer modulo 109 + 7​

    Constraints:
    1 <= T <= 10^3
    1 <= N <= 10^5
    1 <= Ai, K <= 10^6

    Example:
    Input:
    2
    5 3
    4 3 6 2 4
    6 2
    5 3 5 2 4 4
    Output:
    15
    10

    Explanation:
    Assume 0-based indexing
    Testcase 1:
    Firstly, 2nd ticket seller can sell his one ticket at price = 6.
    Then, he will have 5 tickets with price = 5. He can again sell one ticket with price = 5.
    Now, he will have 4 tickets with price = 4. At last, any of the 0th,
    2nd or 4th ticket seller can sell one ticket as all of them are priced at 4.
    Hence, the total amount after selling 3 tickets = 6 + 5 + 4 = 15.

    Testcase 2:
    Firstly, 0th or 2nd ticket seller can sell his one ticket at price = 5.
    Let us assume that 2nd ticket seller sells his ticket.
    Now, he would be left with 4 tickets each with price = 4.
    Now, 0th ticket seller will sell his one ticket at price = 5 and now he will have 4 tickets each with price = 4.
    Hence, the total amount after selling 2 tickets = 5 + 5 = 10.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCasesCount = Integer.parseInt(br.readLine());
        if (!(testCasesCount >= 1 && testCasesCount <= Math.pow(10, 3))) {
            return;
        }
        long start = System.currentTimeMillis();
        while (testCasesCount > 0) {
            testCasesCount--;
            String constraints[] = br.readLine().split(" ");
            int numberOfSellers = Integer.parseInt(constraints[0]);
            if (!(numberOfSellers >= 1 && numberOfSellers <= Math.pow(10, 5))) {
                return;
            }
            int maxTicketSellCount = Integer.parseInt(constraints[1]);
            if (!(maxTicketSellCount >= 1 && maxTicketSellCount <= Math.pow(10, 6))) {
                return;
            }

            String[] tickerSellers = br.readLine().split(" ");
            if (tickerSellers.length != numberOfSellers) {
                return;
            }
            PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
            boolean flag = false;
            for (int index = 0; index < tickerSellers.length; ++index) {
                int intValue = Integer.parseInt(tickerSellers[index]);
                if (intValue >= 1 && intValue <= Math.pow(10, 6)) {
                    priorityQueue.add(intValue);
                } else {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                System.out.println(getMaxAmountFrom(priorityQueue, maxTicketSellCount));
            }
        }
        System.out.println("Total Time: " + ((System.currentTimeMillis() - start)));
    }

    //Total Time: 1145
    private static int getMaxAmountFrom(PriorityQueue<Integer> sellers, int maxTicketSellCount) {
        int sum = 0;
        while(maxTicketSellCount > 0) {
            int max = sellers.poll();
            sum += max;
            sellers.add(max - 1);
            maxTicketSellCount--;
        }
        return sum;
    }

//    //Total Tine: 3151
//    private static int getMaxAmountFrom(int[] sellers, int numberOfSellers,  int maxTicketSellCount) {
//        int sum = 0;
//        while(maxTicketSellCount > 0) {
//            maxTicketSellCount--;
//            Arrays.sort(sellers);
//            int maxValue = sellers[numberOfSellers - 1];
//            sum += maxValue;
//            sellers[numberOfSellers - 1] = maxValue - 1;
//        }
//        return sum;
//    }


}
