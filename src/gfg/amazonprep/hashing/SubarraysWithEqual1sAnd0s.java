package gfg.amazonprep.hashing;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//TODO: @Difficult @Interesting
public class SubarraysWithEqual1sAnd0s {
    public static void main(String[] args) {
        int[] ar = new int[]{1, 0, 0, 1, 0, 1, 1};
//        int[] ar = new int[]{0, 0, 0, 1, 1, 1};
//        int[] ar = new int[]{1, 0, 0, 0, 0, 1, 1};
        System.out.println(countSubarrWithEqualZeroAndOne(ar, ar.length));
    }

    public static int countSubarrWithEqualZeroAndOne(int arr[], int N) { //O(n)
        // 'um' implemented as hash table to store
        // frequency of values obtained through
        // cumulative sum
        Map<Integer, Integer> um = new HashMap<>();
        int curr_sum = 0;

        // Traverse original array and compute cumulative
        // sum and increase count by 1 for this sum
        // in 'um'. Adds '-1' when arr[i] == 0
        for (int i = 0; i < N; i++) {
            curr_sum += (arr[i] == 0) ? -1 : arr[i];
            um.put(curr_sum, um.get(curr_sum) == null ? 1 : um.get(curr_sum) + 1);
        }

        int count = 0;

        // traverse the hash table 'um'
        for (Map.Entry<Integer, Integer> itr : um.entrySet()) {

            // If there are more than one prefix subarrays
            // with a particular sum
            if (itr.getValue() > 1)
                count += ((itr.getValue() * (itr.getValue() - 1)) / 2);
        }

        // add the subarrays starting from 1st element and
        // have equal number of 1's and 0's
        if (um.containsKey(0))
            count += um.get(0);

        // required count of subarrays
        return count;
    }

    public static int countSubarrWithEqualZeroAndOneDP(int arr[], int N) { //O(n^2) solution as DP
        int matrix[][] = new int[N][N];
        int count = 0;
        Set<Integer> s = new HashSet();
        for (int a : arr) {
            s.add(a);
        }
        if (s.size() == 1) {
            return 0;
        }
        for (int g = 0; g < N; g++) {
            for (int i = 0, j = g; j < N; i++, j++) {
                if (g == 0) {
                    matrix[i][j] = (arr[j] == 0) ? -1 : 1;
                } else if (g % 2 == 0) {
                    int dif = (g / 2);
                    matrix[i][j] = (matrix[i + dif][j] + matrix[i][j - dif - 1]);
                } else {
                    int dif = ((g + 1) / 2);
                    matrix[i][j] = (matrix[i + dif][j] + matrix[i][j - dif]);
                    if (matrix[i][j] == 0) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    /*
     for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.print("\n");
        }
     */
}
