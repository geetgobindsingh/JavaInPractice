package random;

public class Rough {
    public static void main(String[] args) {
//        System.out.println(getString("nlah blah", "nlah"));
        System.out.println(getString2());
    }

    public static String getString2() {
        String str = "https://www.google.com";
        if (str.contains("https://")) {
            return str.replaceAll("https://", "wss://");
        } else {
            return str.replaceAll("http://", "wss://");
        }
    }

    private static String getString(String inputText, String queryText) {
        String bubbleText = inputText;
        if (queryText.isEmpty()) {
            return bubbleText;
        }
        int index = bubbleText.indexOf(queryText);
        int startingIndex = index;
        int lastIndex = index + queryText.length();

        if (index < 0) {
            return bubbleText;
        }
        if (lastIndex > inputText.length()) {
            return bubbleText;
        }
        if (index >= 0 && (lastIndex == inputText.length() || (inputText.charAt(lastIndex) == ' '))) {
            String result = bubbleText.substring(0, startingIndex);
            result = result + "|" + bubbleText.substring(index, lastIndex) + "|";
            result = result + bubbleText.substring(lastIndex, bubbleText.length());
            return result;
        } else {
            return bubbleText;
        }
    }
}
