package leetcode.hard;

import java.util.*;
public class TrappingRainWater {
    public static void main(String[] args) {
        TrappingRainWater obj = new TrappingRainWater();
        System.out.println(obj.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
        System.out.println(obj.trap(new int[]{4,2,0,3,2,5}));
    }

    public int trap(int[] height) {
        int n = height.length;
        Stack<Integer> st = new Stack<>();
        int[] lge = new int[n];
        for (int i = 0; i < n; ++i) {
            while (st.size() > 0 && height[i] >= height[st.peek()]) {
                st.pop();
            }
            if (st.size() > 0) {
                lge[i] = st.peek();
            } else {
                lge[i] = i;
                st.push(i);
            }
        }
        st.clear();
        int[] rge = new int[n];
        for (int i = n - 1; i >= 0; --i) {
            while (st.size() > 0 && height[i] >= height[st.peek()]) {
                st.pop();
            }
            if (st.size() > 0) {
                rge[i] = st.peek();
            } else {
                rge[i] = i;
                st.push(i);
            }
        }

        int trapWater = 0;
        for (int i = 0; i < n; i++) {
            int h = height[i];
            if (rge[i] != i && lge[i] != i) {
                int minHeight = Math.min(height[rge[i]], height[lge[i]]);
                int diff = minHeight - h;
                trapWater = trapWater + diff;
            }
        }
        return trapWater;
    }
}
