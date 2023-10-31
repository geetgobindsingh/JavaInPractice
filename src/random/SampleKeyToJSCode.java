package random;

import Utils.It;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SampleKeyToJSCode {
    public static void main(String[] args) {
        System.out.println(getIterableMap("a"));
        System.out.println(getIterableMap("a#0"));
        System.out.println(getIterableMap("a#0.b"));
        System.out.println(getIterableMap("a#0.b#1"));
        System.out.println(getIterableMap("a#0.b#1.c"));
        System.out.println(getIterableMap("a.b#1.k"));
        System.out.println(getIterableMap("a.b#11.c"));
        System.out.println(getIterableMap("a.b#1.c#22.k"));
        System.out.println(getIterableMap("a.b#1.c#22.k#34.t"));
    }

    private static HashMap<String, Integer> getIterableMap(String input) {
        System.out.println(getJSCode(input));
        HashMap<String, Integer> result = new HashMap<>();

        if (It.isFalse(input.contains("#"))) {
            return result;
        }

        char iterableCharacter = 'i';

        for (int index = 0; index < input.length(); ++index) {
            if (input.charAt(index) == '#') {
                String subString = input.substring(index + 1);
                int position;
                if (subString.contains(".")) {
                    position = Integer.parseInt(subString.substring(0,  subString.indexOf(".")));
                } else {
                    position = Integer.parseInt(subString);
                }
                result.put("$" + String.valueOf(iterableCharacter), position);
                iterableCharacter = (char)((int)(iterableCharacter) + 1);
            }
        }
        return result;
    }

    private static void print(Object inp) {
        System.out.println(inp);
    }

    private static Object getValue() {
        return 2.9e2;
    }

    private static String getJSCode(String input) {
        String result = "";
        for (int index = 0; index < input.length(); ++index) {
            if (input.charAt(index) != '#') {
                result = result + input.charAt(index);
            } else {
                index++;
                result = result + "[" + ((input.contains(".")) ? Integer.parseInt(input.substring(index,  input.indexOf("."))) : Integer.parseInt(input)) + "]";
            }
        }
        return result;
    }


}
