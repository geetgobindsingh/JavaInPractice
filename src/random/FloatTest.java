package random;

import Utils.It;

import java.util.ArrayList;
import java.util.List;

public class FloatTest {
    public static void main(String[] args) {
        //System.out.println(String.valueOf(getValue(3, 1)));

//
//        if ("a".equalsIgnoreCase(null)) {
//            System.out.println("true");
//        } else {
//            System.out.println("false");
//        }
//

        List<Long> longList = new ArrayList<>();
        longList.add(1l);
        longList.add(2l);
        longList.add(3l);
        longList.add(4l);

        List<String> stringList = new ArrayList<>();
        stringList.add("a");
        stringList.add("b");
        stringList.add("c");
        stringList.add("d");
        stringList.add("e");


        System.out.println(getCommaSeparatedFormattedStringFromList(longList));
        System.out.println(getCommaSeparatedFormattedStringFromList(stringList));
    }


    public static String getCommaSeparatedFormattedStringFromList(List<? extends Object> list) {
        String result = "";

        if (It.isFalse(list.isEmpty())) {
            for (int language_index = 0; language_index < list.size(); ++language_index) {
                String value = String.valueOf(list.get(language_index));
                if (It.isNotEmpty(value))
                    if (language_index == 0) {
                        result = value;
                    } else {
                        result = result + " , " + value;
                    }
            }
        }
        return result;
    }


    private static float getValue(int mMaxItems, int mItemCompleted) {
        return  (100.0f / (mMaxItems / mItemCompleted));
    }



}
