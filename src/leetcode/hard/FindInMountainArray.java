package leetcode.hard;

public class FindInMountainArray {
    public interface MountainArray {
        public int get(int index);

        public int length();
    }

    public static void main(String[] args) {
        FindInMountainArray obj = new FindInMountainArray();
        int[] ar = new int[]{1, 2, 3, 4, 5, 3, 1};
        int[] finalAr2 = ar;
        System.out.println(obj.findInMountainArray(2, new MountainArray() {
            @Override
            public int get(int index) {
                return finalAr2[index];
            }

            @Override
            public int length() {
                return finalAr2.length;
            }
        }));
        ar = new int[]{0,1,2,4,2,1};
        int[] finalAr = ar;
        System.out.println(obj.findInMountainArray(3, new MountainArray() {
            @Override
            public int get(int index) {
                return finalAr[index];
            }

            @Override
            public int length() {
                return finalAr.length;
            }
        }));
        ar = new int[]{1,5,2};
        int[] finalAr1 = ar;
        System.out.println(obj.findInMountainArray(2, new MountainArray() {
            @Override
            public int get(int index) {
                return finalAr1[index];
            }

            @Override
            public int length() {
                return finalAr1.length;
            }
        }));
    }

    public int findInMountainArray(int target, MountainArray mountainArr) {
        //find center
        int left = 0;
        int right = mountainArr.length() - 1;
        int center = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            boolean lesser = mountainArr.get(mid) > mountainArr.get(mid - 1);
            boolean greater = mountainArr.get(mid) > mountainArr.get(mid + 1);
            if (lesser && greater) {
                center = mid;
                break;
            } else if (!lesser && greater) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        left = 0;
        right = center;
        while (left <= right) {
            int mid = (left + right) / 2;
            int val = mountainArr.get(mid);
            if (val == target) {
                return mid;
            } else if (val < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        left = center;
        right = mountainArr.length() - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int val = mountainArr.get(mid);
            if (val == target) {
                return mid;
            } else if (val > target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }
}
