package gfg.amazonprep.hashing;

import java.util.*;

public class FindAllFourSumNumbers {
    public static void main(String[] args) {
//        int[] arr = new int[]{0,0,2,1,1};
        int[] arr = new int[]{10, 2, 3, 4, 5, 7, 8};
        for (ArrayList<Integer> list : fourSum(arr, 23)) {
            for (Integer i : list) {
                System.out.print(i + " ");
            }
            System.out.println("");
        }
    }

    public static ArrayList<ArrayList<Integer>> fourSum(int[] arr, int k) { // O(n3)

        int n = arr.length;
        TreeSet<ArrayList<Integer>> result = new TreeSet<>(new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                int i = Integer.compare(o1.get(0), o2.get(0));
                if (i != 0) {
                    return i;
                }
                i = Integer.compare(o1.get(1), o2.get(1));
                if (i != 0) {
                    return i;
                }
                i = Integer.compare(o1.get(2), o2.get(2));
                if (i != 0) {
                    return i;
                }
                i = Integer.compare(o1.get(3), o2.get(3));
                if (i != 0) {
                    return i;
                }
                return 0;
            }
        });

        Arrays.sort(arr);

        int l = 0, r = 0;

        for (int i = 0; i < n - 3; i++) {
            for (int j = i + 1; j < n - 2; j++) {
                l = j + 1;
                r = n - 1;
                while (l < r) {
                    if (arr[i] + arr[j] + arr[l] + arr[r] == k) {
                        ArrayList<Integer> list = new ArrayList<>();
                        list.add(arr[i]);
                        list.add(arr[j]);
                        list.add(arr[l]);
                        list.add(arr[r]);
                        Collections.sort(list);
                        result.add(list);
                        l++;
                        r--;
                    } else if (arr[i] + arr[j] + arr[l] + arr[r] < k) {
                        l++;
                    } else {
                        r--;
                    }
                }
            }
        }

        return new ArrayList<>(result);
    }

    public static ArrayList<ArrayList<Integer>> fourSum1(int[] arr, int k) { // tle
        TreeSet<ArrayList<Integer>> result = new TreeSet<>(new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                int i = Integer.compare(o1.get(0), o2.get(0));
                if (i != 0) {
                    return i;
                }
                i = Integer.compare(o1.get(1), o2.get(1));
                if (i != 0) {
                    return i;
                }
                i = Integer.compare(o1.get(2), o2.get(2));
                if (i != 0) {
                    return i;
                }
                i = Integer.compare(o1.get(3), o2.get(3));
                if (i != 0) {
                    return i;
                }
                return 0;
            }
        });
        HashSet<Integer> set = new HashSet<>();
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }
        HashSet<String> unique = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                for (int q = j + 1; q < arr.length; q++) {
                    int sum = arr[i] + arr[j] + arr[q];
                    int def = k - sum;
                    if (set.contains(def)
                            && def != arr[i]
                            && def != arr[j]
                            && def != arr[q]) {
                        ArrayList<Integer> list = new ArrayList<>();
                        list.add(arr[i]);
                        list.add(arr[j]);
                        list.add(arr[q]);
                        list.add(def);
                        Collections.sort(list);
                        String key = "";
                        for (int a = 0; a < list.size(); a++) {
                            key = key + list.get(a);
                        }
                        if (!unique.contains(key)) {
                            result.add(list);
                            unique.add(key);
                        }
                    }
                }
            }
        }

        return new ArrayList<>(result);
    }
}
