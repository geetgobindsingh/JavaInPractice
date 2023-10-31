package playground;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Sortinggg {
    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList();
        arrayList.add("D");
        arrayList.add("b");
        arrayList.add("0");
        arrayList.add("Aaa");
        arrayList.add("aa");
        arrayList.add("-1");
        arrayList.add("C");
        Collections.sort(arrayList, new Comparator<Object>() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((String)o1).toLowerCase().compareTo(((String)o2).toLowerCase());
            }
        });
        for (Object s : arrayList) {
            System.out.print(s);
        }
    }
}
