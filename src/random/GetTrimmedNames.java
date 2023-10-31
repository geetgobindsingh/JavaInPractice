package random;

import java.util.ArrayList;

public class GetTrimmedNames {
    public static void main(String[] args) {
        GetTrimmedNames obj = new GetTrimmedNames();
        ArrayList<String> list = new ArrayList<>();
        list.add("geet");
        list.add("amar");
        list.add("kapil");
        list.add("naman");
        System.out.println(obj.getPretty(11, list));
    }

    private String getPretty(int limit, ArrayList<String> list) {
        String result = "";
        for (String item : list) {
            String temp = result + "|" + item;
            if (temp.length() > limit) {
                return result;
            } else {
                result = temp;
            }
        }
        return result;
    }

    // a, aa, aaa
    // a\aa\aaa
    // 2
    // a
    // 4
    // a\aa
    // 6
    // a\aa
    // 8
    // a\aa\aaa
}
