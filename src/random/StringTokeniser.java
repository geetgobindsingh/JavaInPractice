package random;

import java.util.StringTokenizer;

public class StringTokeniser {
    public static void main(String[] args) {
        String hello = "a b c d e f g h i j k l m n o p q r s t u";
        StringTokenizer stringTokenizer = new StringTokenizer(hello, "");
        while (stringTokenizer.hasMoreTokens()) {
            System.out.println(stringTokenizer.nextToken());
        }
    }
}
