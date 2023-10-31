package euler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FindGoogle {

    /*
    The word google can be spelled in many different ways.

    E.g. google, g00gle, g0oGle, g<>0gl3, googl3, GooGIe, g()()GI3 etc...

    Because
    g = G
    o = O = 0 = () = [] = <>
    l = L = I
    e = E = 3

    That's the problem here to solve.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

//        String string = bufferedReader.readLine();
        String string = "googlee".trim();

        System.out.println(isGoogle(string));

        bufferedReader.close();
    }


    private static String isGoogle(String input) {
        String key = "google";
        boolean isGoogle;
        boolean errorEncountered = false;
        String[] input_ar = input.split("");
        int google_char_index = 0;
        String google_character;

        if (input.length() < 6
                || input.length() > 10) {
            return "False";
        }

        for (int index_input = 0; index_input < input.length(); ++index_input) {
            if (index_input >= key.length()) {
                errorEncountered = true;
                break;
            }
            google_character = String.valueOf(key.charAt(google_char_index));
            switch (google_character) {
                case "g": {
                    if (google_character.equalsIgnoreCase(input_ar[index_input])) {
                        google_char_index++;
                        continue;
                    } else {
                        errorEncountered = true;
                    }
                    break;
                }
                case "o": {
                    if (google_character.equalsIgnoreCase(input_ar[index_input])) {
                        google_char_index++;
                        continue;
                    } else if ("0".equalsIgnoreCase(input_ar[index_input])) {
                        google_char_index++;
                        continue;
                    } else if ("(".equalsIgnoreCase(input_ar[index_input])
                            && (((index_input + 1) <input_ar.length) && (")".equalsIgnoreCase(input_ar[index_input + 1])))) {
                        google_char_index++;
                        index_input++;
                        continue;
                    } else if ("<".equalsIgnoreCase(input_ar[index_input])
                            && (((index_input + 1) <input_ar.length) && (">".equalsIgnoreCase(input_ar[index_input + 1])))) {
                        google_char_index++;
                        index_input++;
                        continue;
                    } else if ("[".equalsIgnoreCase(input_ar[index_input])
                            && (((index_input + 1) <input_ar.length) && ("]".equalsIgnoreCase(input_ar[index_input + 1])))) {
                        google_char_index++;
                        index_input++;
                        continue;
                    } else {
                        errorEncountered = true;
                    }
                    break;
                }
                case "l": {
                    if (google_character.equalsIgnoreCase(input_ar[index_input])) {
                        google_char_index++;
                        continue;
                    } else if ("i".equalsIgnoreCase(input_ar[index_input])) {
                        google_char_index++;
                        continue;
                    } else if ("1".equalsIgnoreCase(input_ar[index_input])) {
                        google_char_index++;
                        continue;
                    } else {
                        errorEncountered = true;
                    }
                    break;
                }
                case "e": {
                    if (google_character.equalsIgnoreCase(input_ar[index_input])) {
                        google_char_index++;
                        continue;
                    } else if ("3".equalsIgnoreCase(input_ar[index_input])) {
                        google_char_index++;
                        continue;
                    } else {
                        errorEncountered = true;
                    }
                    break;
                }
            }

            if (errorEncountered) {
                break;
            }
        }

        isGoogle = !errorEncountered;

        return String.valueOf(isGoogle ? "True" : "False");
    }
}
