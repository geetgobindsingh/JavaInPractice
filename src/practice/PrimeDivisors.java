package practice;

import java.util.*;

public class PrimeDivisors {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        primeDivisors(sc.nextInt());
    }

    public static void primeDivisors(int number) {
        int div = 2;

        while (number > 1) {
            int rest = number % div;

            if (rest == 0) {
                System.out.println("" + div);

                while (number > 1) {
                    number /= div;
                    rest = number % div;

                    if (rest > 0) break;
                }
            }

            div++;
        }
    }

}
