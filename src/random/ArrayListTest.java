package random;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by geetgobindsingh on 14/11/17.
 */
public class ArrayListTest {
    public static void main(String[] args) {
        //ArrayList<String> list = new ArrayList<>(new ArrayList<>(new ArrayList<>(new ArrayList<>(new ArrayList<>(new ArrayList<>())))));

        ArrayList list = new ArrayList();
        ArrayList list2 = new ArrayList();

        list.equals(list2);

//        ArrayList<Integer> list = new ArrayList<Integer>();
//
//        list.add(null);
//        list.add(null);
//        list.add(1);
//
//        list.remove(1);
//
//        System.out.println(list.size());
//        System.out.println(list.get(0));

//        System.out.println(printArray(getInputArray(",1212121212")));
//        System.out.println(printArray(getInputArray("null,1212121212")));
//        System.out.println(printArray(getInputArray(",null")));
//        System.out.println(printArray(getInputArray("null")));
//        System.out.println(printArray(getInputArray("")));
//        System.out.println(printArray(getInputArray(",")));
//        System.out.println(printArray(getInputArray("1212121212")));

        List<String> loop = new ArrayList<>();
        loop.add("a");
        loop.add("b");
        loop.add("c");
        if (loop.contains("c")) {
            System.out.println("HAHAHA");
        }

        String[] arry = getInputArray("");
        for (int index = 0; index < arry.length; ++index) {
            System.out.println(arry[index]);
        }

//
//        int a = 0;
//        switch (a) {
//            case 0:
//            case 1: {
//                System.out.println("hiphip hurray");
//                break;
//            }
//            case 2:
//            case 3: {
//                System.out.println("hiphip hurray");
//                break;
//            }
//            case 4:
//            case 5: {
//                System.out.println("hiphip hurray");
//                break;
//            }
//        }
    }

    private static String printArray(String[] inputArray) {
        String result = "";
        int i = 0;
        for (String s : inputArray) {
            if (i == 0) {
                result = result + s + ",";
                i++;
            } else {
                result = result + s;
            }
        }
        return result;
    }
//
//    private static String[] getInputArray(String searchValues) {
//        String result[] = new String[2];
//        result[0] = "";
//        result[1] = "";
//        if (random.It.isEmpty(searchValues)) {
//            return result;
//        }
//        String[] temp = searchValues.split(",");
//        for (int index = 0; index < temp.length; ++index) {
//            if (random.It.isEmpty(temp[index]) || "null".equalsIgnoreCase(temp[index])) {
//                result[index] = "";
//            } else {
//                result[index] = temp[index];
//            }
//        }
//        return result;
//    }


    private static String[] getInputArray(String searchValues) {
        String[] temp = searchValues.split(",");
        String result[] = new String[temp.length];
        if (It.isEmpty(searchValues)) {
            return result;
        }
        for (int index = 0; index < temp.length; ++index) {
            if (It.isEmpty(temp[index]) || "null".equalsIgnoreCase(temp[index])) {
                result[index] = "";
            } else {
                result[index] = temp[index];
            }
        }
        return result;
    }


//        ArrayList<String> list = getList();
//
//        list.size();

//        if(list == null) {
//            System.out.print("list is null");
//        } else {
//            System.out.print(list);
//        }
//
//    public static ArrayList<String> getList() {
//        ArrayList<String> list = new ArrayList<>();
//        try {
//            list = new ArrayList<>(null);
//        } catch (Exception e) {
//           e.printStackTrace();
//        }
//        return list;
//    }

}
