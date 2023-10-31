package gfg.amazonprep.strings;

public class StringModification {
    public static void main(String[] args) {
        System.out.println(rearrangeString("aaabb"));
        System.out.println(rearrangeString("watztqbxwkimmiixcpjbuttwpoaptzyrattvjwuhietumdursd"));
    }

    public static String rearrangeString(String str) {
        char[] array = str.toCharArray();
        int j = array.length - 1;
        for (int i = 1; i < array.length; i++) {
            if (array[i] == array[i - 1]) {
                while (i < j && array[i] == array[j]) {
                    j--;
                }
                if (i < j) {
                    char temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        return new String(array);
    }

    private static int getOtherCharIndex(int[] charArray, char temp) {
        int result = -1;
        int index = (int) temp;
        for (int i = 0; i < charArray.length && index != i; i++) {
            if (charArray[i] > 1) {
                charArray[i]--;
                return i;
            }
        }
        return result;
    }
}
