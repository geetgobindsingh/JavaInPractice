package random;

import java.util.ArrayList;
import java.util.Arrays;

public class PermutationTest {
    public static void main(String[] args) {
        String input = "abc";
        PermutationTest obj = new PermutationTest();

       // printTree(0, input.split(""));

        permute(input, 0, input.length() - 1);
        //obj.printListOfPermutations(obj.getListOfPermutations("", 0, input.split("")));
    }

    private static void permute(String str, int startIndex, int endIndex) {
        if (startIndex == endIndex)
            System.out.println(str);
        else {
            for (int i = startIndex; i <= endIndex; i++) {
                str = swap(str, startIndex, i);
                permute(str, startIndex + 1, endIndex);
                str = swap(str, startIndex, i);
            }
        }
    }

    private static void printTree(int index, String input[]) {
        int i = index;
        while (i < input.length) {
            System.out.print(input[i]);
            i++;
            printTree(i, input);
        }
        System.out.println("");
    }

    private void printListOfPermutations(ArrayList<String> listOfPermutations) {
        for (String permutation : listOfPermutations) {
            System.out.println(permutation);
        }
    }

    public static String swap(String a, int i, int j)
    {
        char temp;
        char[] charArray = a.toCharArray();
        temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }

    private void swap(String[] input, int index1, int index2) {
        String temp = input[index1];
        input[index1] = input[index2];
        input[index2] = temp;
    }


    private ArrayList<String> getListOfPermutations(String staticString, int startIndex, String[] dynamicArray) {
        ArrayList<String> result = new ArrayList<>();

        staticString = staticString + dynamicArray[startIndex];

        if (dynamicArray.length == 2) {
            result.add(staticString + Arrays.toString(dynamicArray));
            String temp = dynamicArray[0];
            dynamicArray[0] = dynamicArray[1];
            dynamicArray[1] = temp;
            result.add(staticString + Arrays.toString(dynamicArray));
        } else {
            for (int index = startIndex + 1; index < dynamicArray.length; ++index) {
                result.addAll(getListOfPermutations(staticString, index, Arrays.copyOfRange(dynamicArray, index, dynamicArray.length)));
            }
        }
        return result;
    }

//    private ArrayList<String> getListOfPermutations(int startIndex, String[] input) {
//        ArrayList<String> result = new ArrayList<>();
//        result.add(Arrays.toString(input));
//        for (int index = startIndex + 1; index < input.length; ++index) {
//            result.addAll(getListOfPermutations(index, input));
//            swap(input , startIndex , index);
//        }
//        return result;
//    }
}
