package random;

/**
 * Created by geetgobindsingh on 22/08/17.
 */
public class ReadTest {

    public static void main(String args[]) {
        StringBuilder stringBuilder = new StringBuilder("aBcD");
        for(int i = 0; i < stringBuilder.length(); ++i) {
            stringBuilder.setCharAt(i, Character.isUpperCase(stringBuilder.charAt(i)) ? Character.toLowerCase(stringBuilder.charAt(i)) : Character.toUpperCase(stringBuilder.charAt(i)));
        }
    }
}
