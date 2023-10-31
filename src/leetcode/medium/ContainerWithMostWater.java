package leetcode.medium;

import java.util.Stack;

public class ContainerWithMostWater {
    public static void main(String[] args) {
        ContainerWithMostWater obj = new ContainerWithMostWater();
//        int[] input = {1,8,6,2,5,4,8,3,7};
//        System.out.println(obj.maxArea(input));
        int[] input2 = {1,2,1};
        System.out.println(obj.maxArea(input2));
    }

    public int maxArea(int[] height) {
        int i = 0, j = height.length - 1;
        int ans = 0;
        while (i < j) {
            int t = Math.min(height[i], height[j]) * (j - i);
            ans = Math.max(ans, t);
            if (height[i] < height[j]) {
                ++i;
            } else {
                --j;
            }
        }
        return ans;
    }
    public int maxArea2(int[] height) {
        int n = height.length;
        int[] lge = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; ++i) {
            while (st.size() > 0 && height[i] > height[st.peek()]) {
                st.pop();
            }
            if (st.isEmpty()) {
                lge[i] = i;
                st.push(i);
            } else {
                lge[i] = st.peek();
                if (height[i] != height[st.peek()]) {
                    st.push(i);
                }
            }
        }
        for (int i : height) {
            System.out.print(i + " ");
        }
        System.out.print("\n");
        for (int i : lge) {
            System.out.print(i + " ");
        }
        st.clear();
        int[] rge = new int[n];
        for (int i = n - 1; i >= 0; --i) {
            while (st.size() > 0 && height[i] > height[st.peek()]) {
                st.pop();
            }
            if (st.isEmpty()) {
                rge[i] = i;
                st.push(i);
            } else {
                rge[i] = st.peek();
                if (height[i] != height[st.peek()]) {
                    st.push(i);
                }
            }
            st.push(i);
        }
        System.out.print("\n");
        for (int i : rge) {
            System.out.print(i + " ");
        }
        System.out.print("\n");

        int max = 0;
        for (int i = 0; i < n; ++i) {
            int width = rge[i] - lge[i];
            int height2 = height[i];
            int area = width * height2;
            System.out.print(area + " ");
            max = Math.max(max, area);
        }

        return max;
    }
}
