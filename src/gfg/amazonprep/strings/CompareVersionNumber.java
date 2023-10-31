package gfg.amazonprep.strings;

import java.util.LinkedList;
import java.util.Queue;

public class CompareVersionNumber {
    public static void main(String[] args) {
        System.out.println(VersionCompare("0.1", "1.1"));
    }

    public static int VersionCompare(String v1, String v2) {
        Queue<Integer> A = new LinkedList<>();
        int lastIndex = 0;
        if (v1.contains(".")) {
            int endDotIndex = v1.lastIndexOf(".");
            for (int i = 0; i < v1.length(); i++) {
                if (v1.charAt(i) == '.') {
                    A.offer(Integer.parseInt(v1.substring(lastIndex, i)));
                    lastIndex = i + 1;
                }
                if (i == endDotIndex) {
                    A.offer(Integer.parseInt(v1.substring(endDotIndex + 1)));
                    break;
                }
            }
        } else {
            A.offer(Integer.parseInt(v1));
        }
        lastIndex = 0;
        Queue<Integer> B = new LinkedList<>();
        if (v2.contains(".")) {
            int endDotIndex = v2.lastIndexOf(".");
            for (int i = 0; i < v2.length(); i++) {
                if (v2.charAt(i) == '.') {
                    B.offer(Integer.parseInt(v2.substring(lastIndex, i)));
                    lastIndex = i + 1;
                }
                if (i == endDotIndex) {
                    B.offer(Integer.parseInt(v2.substring(endDotIndex + 1)));
                    break;
                }
            }
        } else {
            B.offer(Integer.parseInt(v2));
        }

        while (!B.isEmpty() || !A.isEmpty()) {
            if (B.isEmpty()) {
                while (!A.isEmpty()) {
                    if (A.poll() > 0) {
                        return 1;
                    }
                }
                return 0;
            } else if (A.isEmpty()) {
                while (!B.isEmpty()) {
                    if (B.poll() > 0) {
                        return -1;
                    }
                }
                return 0;
            } else {
                int a = A.poll();
                int b = B.poll();
                if (a > b) {
                    return 1;
                } else if (a < b) {
                    return -1;
                }
            }
        }

        return 0;
    }
}
