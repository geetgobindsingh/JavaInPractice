package gfg.amazonprep.sorting;

import java.util.Random;

public class QuickSort {
    public static void main(String[] args) {
        //int[] input = new int[]{4, 3, 5, 1, 2};
        int[] input = new int[]{5, 1, 1, 2, 0, 0};
        //int[] input = new int[]{3,4,2,1};
        //int[] input = new int[]{5,2,3,1};
        int[] clone = input.clone();
        System.out.print("\nRight Most as Pivot\n");
        applyQuickSortRightMostPivot(clone, 0, input.length - 1);
        for (Integer n : clone) {
            System.out.print(n + " ");
        }
        System.out.print("\nLeftMost Most as Pivot\n");
        clone = input.clone();
        applyQuickSortLeftMostPivot(clone, 0, input.length - 1);
        for (Integer n : clone) {
            System.out.print(n + " ");
        }
        System.out.print("\nRandom as Pivot\n");
        clone = input.clone();
        applyQuickSortRandomPivot(clone, 0, input.length - 1);
        for (Integer n : clone) {
            System.out.print(n + " ");
        }
        System.out.print("\nMid point as Pivot\n");
        clone = input.clone();
        applyQuickSortMidPivot(clone, 0, input.length - 1);
        for (Integer n : clone) {
            System.out.print(n + " ");
        }

        System.out.print("\nQuick and Insertion combo, Left point as Pivot\n");
        clone = input.clone();
        applyQuickSortAndInsertionSort(clone, 0, input.length - 1);
        for (Integer n : clone) {
            System.out.print(n + " ");
        }
    }

    private static void applyQuickSortRightMostPivot(int[] input, int l, int r) {
        if (l < r) {
            int p = partitionWithRightMost(input, l, r);
            applyQuickSortRightMostPivot(input, l, p - 1);
            applyQuickSortRightMostPivot(input, p + 1, r);
        }
    }


    //4 3 5 1 2
    /*
    - find the sorted index for the pivot
    - final array left side elements are smaller or equal and right side element is higher or equal
     */
    private static int partitionWithRightMost(int[] input, int left, int right) {
        int pivotItem = input[right];                    // right most element is pivot
        int i = (left - 1);                              // i = -1 for left = 0
        for (int j = left; j <= right - 1; j++) {
            if (input[j] < pivotItem) {                  // if less then pivot, increase i and swap
                i++;
                swap(input, i, j);
            }
        }
        int pivotLocation = i + 1;
        swap(input, pivotLocation, right);               // final swap pivot item to its sorted position
        return pivotLocation;
    }

    private static void applyQuickSortLeftMostPivot(int[] input, int l, int r) {
        if (l < r) {
            int[] p = partitionWithLeftMost2(input, l, r);
            applyQuickSortLeftMostPivot(input, l, p[0]);
            applyQuickSortLeftMostPivot(input, p[1], r);
        }
    }

    //4 3 5 1 2
    private static int partitionWithLeftMost(int[] input, int left, int right) {
        int pivotItem = input[left];                    // left most element is pivot
        int i = (left + 1);                              // i = -1 for left = 0
        for (int j = left + 1; j <= right; j++) {
            if (input[j] < pivotItem) {                  // if less then pivot, swap and increase i
                swap(input, i, j);
                i++;
            }
        }
        int pivotLocation = i - 1;
        swap(input, left, pivotLocation);               // final swap pivot item to its sorted position
        return pivotLocation;
    }

    //4 3 5 1 2
    //two pointer algo, same as sorting 0s and 1s
    private static int[] partitionWithLeftMost2(int[] arr, int low, int high) {
        int pivot = arr[low];
        int i = low;
        int k = low;
        int j = high;
        while (k <= j) {
            if (arr[k] < pivot) {
                swap(arr, i, k);
                i++;
                k++;
            } else if (arr[k] > pivot) {
                swap(arr, k, j);
                j--;
            } else {
                k++;
            }
        }
        return new int[]{i - 1, j + 1};
    }


    private static void applyQuickSortRandomPivot(int[] input, int l, int r) {
        if (l < r) {
            int p = randomPartition(input, l, r);
            applyQuickSortLeftMostPivot(input, l, p);
            applyQuickSortLeftMostPivot(input, p + 1, r);
        }
    }

    public static int randomPartition(int[] arr, int low, int high) {
        Random random = new Random();
        int randomIndex = random.nextInt(high - low + 1) + low;
        swap(arr, 0, randomIndex); // Move the random pivot to the left most position
        return partitionWithLeftMost(arr, low, high);
    }


    private static void applyQuickSortMidPivot(int[] input, int l, int r) {
        if (l < r) {
            int p = partitionWithMidPivot(input, l, r);
            applyQuickSortLeftMostPivot(input, l, p);
            applyQuickSortLeftMostPivot(input, p + 1, r);
        }
    }

    private static int partitionWithMidPivot(int[] arr, int low, int high) {
        int pivot = arr[low + (high - low) / 2];
        int left = low - 1;
        int right = high + 1;
        while (true) {
            do {
                left++;
            } while (arr[left] < pivot);

            do {
                right--;
            } while (arr[right] > pivot);

            if (left >= right) {
                return right;
            }

            swap(arr, left, right);
        }
    }


    private static void applyQuickSortAndInsertionSort(int[] input, int l, int r) {
        if (l < r) {
            if ((r - l) < 47) {
                applyInsertionSort(input, l, r);
                return;
            }
            int p = randomPartition(input, l, r);
            applyQuickSortLeftMostPivot(input, l, p - 1);
            applyQuickSortLeftMostPivot(input, p + 1, r);
        }
    }

    private static void applyInsertionSort(int[] ar, int l, int r) {
        int length = r + 1;
        int x = ar[l];
        for (int k = l + 1; k < length; ++k) {
            if (x > ar[k]) {
                for (int j = (k - 1); j >= 0; --j) {
                    if (ar[j] > ar[j + 1]) {
                        swap(ar, j + 1, j);
                    }
                }
            }
            x = ar[k];
        }


//        for (int i = left + 1; i <= right; i++){
//            int tmp = nums[i];
//            int j = i;
//            while (j > left && nums[j - 1] > tmp) {
//                nums[j] = nums[j - 1];
//                j--;
//            }
//            nums[j] = tmp;
//        }
    }


    private static void swap(int[] ar, int indexA, int indexB) {
        int temp = ar[indexA];
        ar[indexA] = ar[indexB];
        ar[indexB] = temp;
    }
}
