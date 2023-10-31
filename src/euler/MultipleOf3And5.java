package euler;

import java.util.Scanner;

public class MultipleOf3And5 {

    //If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.
    //
    //Find the sum of all the multiples of 3 or 5 below 1000.
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        if (!(t >= 1 && t <= Math.pow(10, 5))) {
            return;
        }
        boolean flag = false;
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            flag = ((n >= 1 && n <= Math.pow(10, 9)));
            if (flag) {
                System.out.println(getSum(n));
            } else {
                break;
            }

        }
    }

    public static int getSum(int n) {
        int sum = 0;
        sum = getSumOf3(n - 1) + getSumOf5(n - 1) - getSumOf15(n - 1);
        return sum;
    }

    public static int getSumOf3(int n) {
        int m = (int)Math.floor(n/3) + 1;
        return ((m*(3*(m-1)))/2);
    }


    public static int getSumOf5(int n) {
        int m = (int)Math.floor(n/5) + 1;
        return ((m*(5*(m-1)))/2);
    }


    public static int getSumOf15(int n) {
        int m = (int)Math.floor(n/15) + 1;
        return ((m*(15*(m-1)))/2);
    }
}
