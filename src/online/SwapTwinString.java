package online;

import java.util.ArrayList;

public class SwapTwinString {

    public static void main(String[] args) {

        String[] a = {"cbad", "dcba"};
        String[] b = {"abcd", "abcd"};

        String[] res = twins(a, b);

        for(int i = 0; i< res.length; ++i) {
            System.out.println(res[i]);
        }

    }

    /*
     * Complete the function below.
     */
    static String[] twins(String[] a, String[] b) {
        boolean terminate = false;
        String[] result = null;
        if (a.length == b.length) {
            int length = a.length;
            if (length <= 1000 && length >= 1) {
                result = new String[length];
                for (int index = 0; index < length; ++index) {
                    String aa = a[index].toLowerCase();
                    String bb = b[index].toLowerCase();
                    if (aa.length() >= 1 && aa.length() <= 100 && bb.length() >= 1 && bb.length() <= 100) {
                        result[index] = getResult(aa, bb, aa.length());
                    } else {
                        result[index] = "No";
                    }
                }
            } else {
                terminate = true;
            }
        } else {
            terminate = true;
        }

        if (terminate) {
            return new String[0];
        } else {
            if (result != null) {
                return result;
            } else {
                return new String[0];
            }
        }
    }

    static String getResult(String aa, String bb, int length) {
        int iterations = (length % 2 == 0) ? (length / 2) : (length / 2) + 1;

        String result = "No";

        if (aa.equalsIgnoreCase(bb)) {
            result = "Yes";
        }

        for (int index = 0; index < iterations; ++index) {
            if (getSwapedString(index, index+2, aa).equalsIgnoreCase(bb)) {
                result = "Yes";
                break;
            }
        }

        return result;
    }

    static String getSwapedString(int index1, int index2, String val) {
        String[] arr = val.split("");
        String a = arr[index1];
        String b = arr[index2];
        arr[index1] = b;
        arr[index2] = a;

        String finalVal = "";
        for (int i = 0; i< arr.length ; ++i) {
            finalVal = finalVal + arr[i];
        }

        return finalVal;
    }

}
