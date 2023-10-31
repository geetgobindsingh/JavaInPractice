package random;

import java.util.regex.Pattern;

/**
 * Created by geetgobindsingh on 28/07/17.
 */
public class CompareTimeStamp {

    public static void main(String[] args) {
      String lol = "hi bhai. bhai kes.a ho1";
      getSentenceFrom(lol);
      //System.out.print(getDictionarySavableWord(lol));
    }

    private static void getSentenceFrom(String word) {
        StringBuilder stringBuilder = new StringBuilder("");
        String[] array = word.split(Pattern.quote(".") + " ");
        for(int i= 0; i < array.length; ++i) {
            System.out.println(array[i]);
        }
        return ;
    }

    private static String getDictionarySavableWord(String word) {
        if(word != null && word.length() > 1 && Character.isUpperCase(word.codePointAt(0))) {
            String subStringWithoutFirstLetter = word.substring(1);
            if(subStringWithoutFirstLetter.equals(subStringWithoutFirstLetter.toLowerCase())) {
                return word.toLowerCase();
            } else {
                return word;
            }
        }
        return word;
    }
}
