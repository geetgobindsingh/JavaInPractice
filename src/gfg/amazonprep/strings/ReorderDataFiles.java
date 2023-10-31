package gfg.amazonprep.strings;

import java.util.Arrays;
import java.util.Comparator;

//TODO: @Interesting @Easy
public class ReorderDataFiles {
    public static void main(String[] args) {
        String[] files = new String[]{
                "file2 hi",
                "file3 hi"
        };

        for (String s : fileReorder(files)) {
            System.out.println(s + " ");
        }
    }

    public static String[] fileReorder(String[] files) { // 1 second
        int letterRegionEnd = files.length - 1;
        for (int i = files.length - 1; i >= 0; i--) {
            if (!isLetterLog(files[i])) {
                logSwap(files, i, letterRegionEnd);
                letterRegionEnd--;
            }
        }
        Arrays.sort(files, 0, letterRegionEnd + 1, new LogComparator());

        return files;
    }

    static void logSwap(String[] logs, int i1, int i2) {
        String temp = logs[i1];
        logs[i1] = logs[i2];
        logs[i2] = temp;
    }

    static boolean isLetterLog(String log) {
        for (int i = log.length() - 1; i >= 0; i--) {
            if (isLetter(log.charAt(i)))
                return true;
            if (isNum(log.charAt(i)))
                return false;
        }
        return false;//default
    }

    static boolean isLetter(char c) {
        if (c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z') {
            return true;
        }
        return false;
    }

    static boolean isNum(char c) {
        if (c >= '0' && c <= '9') {
            return true;
        }
        return false;
    }


    static class LogComparator implements Comparator<String> {
        @Override
        public int compare(String log1, String log2) {
            int log1CompIndex = log1.indexOf(" ") + 1;
            int log2CompIndex = log2.indexOf(" ") + 1;

            int compareVal = log1.substring(log1CompIndex).compareTo(log2.substring(log2CompIndex));
            if (compareVal == 0)
                return log1.compareTo(log2);
            else
                return compareVal;
        }
    }

    static class Log implements Comparable<Log> {
        String text;

        public Log(String text) {
            this.text = text;
        }

        @Override
        public int compareTo(Log otherLog) {
            int thisCompIndex = this.text.indexOf(" ") + 1;
            int otherCompIndex = otherLog.text.indexOf(" ") + 1;

            int compareVal = this.text.substring(thisCompIndex).compareTo(otherLog.text.substring(otherCompIndex));
            if (compareVal == 0)
                return this.text.compareTo(otherLog.text);
            else
                return compareVal;
        }

    }

    public static String[] fileReorder2(String[] files) { // 43 seconds
        int i = 0;
        int j = files.length - 1;

        while (j > 0) {
            while (j > 0 && files[j].substring(files[j].indexOf(" ") + 1).matches("^[ 0-9]*$")) {
                j--;
            }
            i = j;
            while (i >= 0 && files[i].substring(files[i].indexOf(" ") + 1).matches("^[ a-zA-Z]*$")) {
                i--;
            }
            if (i == -1) {
                break;
            }
            if (i < j) {
                swap(files, i, j);
                j--;
            }
        }

        quickSort(files, 0, j, true);
        for (i = 0; i <= j; i++) {
            String contender = files[i].substring(files[i].indexOf(" ") + 1);
            int k = i;
            for (; k < files.length; k++) {
                if (contender.equals(files[k].substring(files[k].indexOf(" ") + 1))) {
                    continue;
                } else {
                    break;
                }
            }
            k--;
            if (i < k) {
                quickSort(files, i, k, false);
            }
            i = k;
        }
        return files;
    }

    private static void quickSort(String[] files, int l, int r, boolean special) {
        if (l < r) {
            if (special) {
                int p = partition(files, l, r);
                quickSort(files, l, p - 1, special);
                quickSort(files, p + 1, r, special);
            } else {
                int p = partition2(files, l, r);
                quickSort(files, l, p - 1, special);
                quickSort(files, p + 1, r, special);
            }
        }
    }

    private static int partition(String[] files, int l, int r) {
        String original = files[l];
        String pivotItem = files[l].substring(files[l].indexOf(" ") + 1);
        int i = l;
        int j = r;
        while (i < j) {
            while (pivotItem.compareTo(files[i].substring(files[i].indexOf(" ") + 1)) >= 0 && i < r) {
                i++;
            }
            while (pivotItem.compareTo(files[j].substring(files[j].indexOf(" ") + 1)) < 0 && j > l) {
                j--;
            }
            if (i < j) {
                swap(files, i, j);
            }
        }
        files[l] = files[j];
        files[j] = original;
        return j;
    }

    private static int partition2(String[] files, int l, int r) {
        String original = files[l];
        String pivotItem = files[l];
        int i = l;
        int j = r;
        while (i < j) {
            while (pivotItem.compareTo(files[i]) >= 0 && i < r) {
                i++;
            }
            while (pivotItem.compareTo(files[j]) < 0 && j > l) {
                j--;
            }
            if (i < j) {
                swap(files, i, j);
            }
        }
        files[l] = files[j];
        files[j] = original;
        return j;
    }

    public static void swap(String[] files, int i, int j) {
        String temp = files[i];
        files[i] = files[j];
        files[j] = temp;
    }


}
