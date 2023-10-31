package practice;

public class RunLengthDecoding {
    public static void main(String[] args) {
        System.out.println(getDecodedString(null));
        System.out.println(getDecodedString(""));
        System.out.println(getDecodedString("a"));
        System.out.println(getDecodedString("a1"));
        System.out.println(getDecodedString("a2"));
        System.out.println(getDecodedString("a33"));
        System.out.println(getDecodedString("a2b3"));
        System.out.println(getDecodedString("a2b12c4"));
        System.out.println(getDecodedString("a2b3c4d5"));
    }

    private static String getDecodedString(String s) {
        if (s == null || s.length() == 0 || s.length() == 1) return s;
        StringBuilder output = new StringBuilder();
        for (int index = 0; index < s.length(); index++) {
            if (Character.isDigit(s.charAt(index))) {
                int j = index;
                String countString = "";
                while (j < s.length() && Character.isDigit(s.charAt(j))) {
                    countString = countString + s.charAt(j++);
                }
                int count = Integer.parseInt(countString);
                if(count > 1) {
                    while (count-- > 1) {
                        output.append(s.charAt(index - 1));
                    }
                }
                index = j - 1;
            } else {
                output.append(s.charAt(index));
            }
        }
        return output.toString();
    }
}
