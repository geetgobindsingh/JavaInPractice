package regex;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTester {
    public static void main(String[] args) {
        // email - regex email -> ?@? and . -> lese
        // phone - 9 to 13 length digit
        // name -
        // designation - always comes around name (up/down)
        // company name -
        // address -

        RegexTester obj = new RegexTester();

//        String card1 = "Prashant Tanwar\n" +
//                "Head-Delivery & Technical support\n" +
//                "+91-9318331813\n" +
//                "prashant@senpiper.com\n" +
//                "Senpiper Technologies India Pvt. Ltd.\n" +
//                "O 1st Floor, B15, Sector 32\n" +
//                "Gurugram, Haryana- 122001\n" +
//                "+91-80-37688200\n" +
//                "senpiper.com";

        String card1 = "BBRITANNIA\n" +
                "Anuj Jain\n" +
                "Lead Manager-Energy Eff & Control Systems\n" +
                "anujain@britindia.com\n" +
                "Britannia Industries Limited\n" +
                "R&D Centre, Plot No.23, Bidadi Industrial\n" +
                "Area, Balaveeranahalli Village, Bidadi,\n" +
                "Ramanagaram Dist., Karnataka - 562109\n" +
                "B +91-80-37688200\n" +
                "D +91-80-37688371\n" +
                "M +91 99406 64515\n" +
                "W www.britannia.co.n";

//        String card1 = "HERITAGE\n" +
//                "XPERIENTIAL\n" +
//                "LEARNING SCHOOL\n" +
//                "MUDIT MEHROTRA\n" +
//                "CHIEF OPERATING OFFICER\n" +
//                "91-98935 69370 I mudit.mehrotra@theheritageschool.in\n" +
//                "www.heritagexperiential.arg";

        String[] card1_arr = card1.split("\n");

        System.out.println();

        List<String> list = new ArrayList<>();
        List<String> emails = new ArrayList<>();
        List<String> mobiles = new ArrayList<>();
        List<String> websites = new ArrayList<>();
        List<String> addresses = new ArrayList<>();
        List<String> companyNames = new ArrayList<>();
        List<String> names = new ArrayList<>();

        Collections.addAll(list, card1_arr);

        List<Integer> emailIndexes = getEmailIndexes(list);
        emails = getStringFromIndex(emailIndexes, list);
        System.out.println("Email");
        printList(emails);

        list = new ArrayList<String>(getNewList(list, emailIndexes));

        System.out.println("-");

        List<Integer> mobileIndexes = getMobileIndexes(list);
        mobiles = getStringFromIndex(mobileIndexes, list);
        System.out.println("Mobile");
        printList(mobiles);

        list = new ArrayList<String>(getNewList(list, mobileIndexes));

        System.out.println("-");

        List<Integer> websiteIndexes = getWebsiteIndexes(list);
        websites = getStringFromIndex(websiteIndexes, list);
        System.out.println("Website");
        printList(websites);

        list = new ArrayList<String>(getNewList(list, websiteIndexes));

        System.out.println("-");

        List<Integer> addressIndexes = getAddressIndexes(list);
        addresses = getStringFromIndex(addressIndexes, list);
        System.out.println("Address");
        printList(addresses);

        list = new ArrayList<String>(getNewList(list, addressIndexes));

        System.out.println("-");

        List<Integer> companyNameIndexes = getCompanyNameIndexes(list);
        companyNames = getStringFromIndex(companyNameIndexes, list);
        System.out.println("Company");
        printList(companyNames);

        list = new ArrayList<String>(getNewList(list, companyNameIndexes));

        System.out.println("-");

        List<Integer> namesIndexes = getNameAndDesignationIndexes(list);
        names = getStringFromIndex(namesIndexes, list);
        if (names.size() > 1) {
            System.out.println("Name");
            System.out.println(names.get(0));
            System.out.println("-");
            System.out.println("Designation");
            System.out.println(names.get(1));
            System.out.println("-");
        } else {
            System.out.println("Name");
            printList(names);
            System.out.println("-");
        }

        list = new ArrayList<String>(getNewList(list, namesIndexes));
    }

    private static List<Integer> getNameAndDesignationIndexes(List<String> list) {
        List<Integer> result = new ArrayList<>();
        for (int index = 0; index < list.size(); ++index) {
            if (isName(list.get(index))) {
                result.add(index);
            }
        }
        return result;
    }

    private static List<Integer> getCompanyNameIndexes(List<String> list) {
        List<Integer> result = new ArrayList<>();
        for (int index = 0; index < list.size(); ++index) {
            if (isCompany(list.get(index))) {
                result.add(index);
            }
        }
        return result;
    }

    private static List<Integer> getWebsiteIndexes(List<String> list) {
        List<Integer> result = new ArrayList<>();
        for (int index = 0; index < list.size(); ++index) {
            if (isWebsite(list.get(index))) {
                result.add(index);
            }
        }
        return result;
    }

    private static List<Integer> getAddressIndexes(List<String> list) {
        List<Integer> result = new ArrayList<>();
        for (int index = 0; index < list.size(); ++index) {
            if (isAddress(list.get(index))) {
                result.add(index);
            }
        }
        return result;
    }

    private static List<Integer> getMobileIndexes(List<String> list) {
        List<Integer> result = new ArrayList<>();
        for (int index = 0; index < list.size(); ++index) {
            if (isMobile(list.get(index))) {
                result.add(index);
            }
        }
        return result;
    }

    private static List<String> getNewList(List<String> list, List<Integer> removeIndexList) {
        List<String> result = new ArrayList<>();
        for (int index = 0; index < list.size(); ++index) {
            if (!removeIndexList.contains(index)) {
                result.add(list.get(index));
            }
        }
        return result;
    }

    private static void printList(List<String> textList) {
        for (int index = 0; index < textList.size(); ++index) {
            System.out.println(textList.get(index));
        }
    }

    private static List<String> getStringFromIndex(List<Integer> indexes, List<String> list) {
        List<String> result = new ArrayList<>();
        for (int index = 0; index < indexes.size(); ++index) {
            result.add(list.get(indexes.get(index)));
        }
        return result;
    }

    private static List<Integer> getEmailIndexes(List<String> list) {
        List<Integer> result = new ArrayList<>();
        for (int index = 0; index < list.size(); ++index) {
            if (isEmail(list.get(index))) {
                result.add(index);
            }
        }
        return result;
    }

    public static boolean isEmail(String input) {
        Matcher m = Pattern.compile("[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+").matcher(input);
        while (m.find()) {
            return true;
        }
        String[] inputArray = input.split(" ");
        for (int index = 0; index < inputArray.length; ++index) {
            m = Pattern.compile("[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+").matcher(inputArray[index]);
            while (m.find()) {
                return true;
            }
        }
        return false;
    }

    public static boolean isMobile(String input) {
        Matcher m = Pattern.compile("(0/+91/91)?[\\-\\s]?(([5-9][0-9]{8,20})|([5-9][\\-\\s]?[0-9\\-\\s]{7,18}))").matcher(input);
        while (m.find()) {
            return true;
        }
        String[] inputArray = input.split(" ");
        for (int index = 0; index < inputArray.length; ++index) {
            m = Pattern.compile("(0/+91/91)?[\\-\\s]?(([5-9][0-9]{8,20})|([5-9][\\-\\s]?[0-9\\-\\s]{7,18}))").matcher(inputArray[index]);
            while (m.find()) {
                return true;
            }
        }
        return false;
    }

    public static boolean isWebsite(String input) {
        Matcher m = Pattern.compile("((http?|https|ftp|file)://)?((W|w){3}.)?[a-zA-Z0-9]+\\.[a-zA-Z]+").matcher(input);
        while (m.find()) {
            return true;
        }
        String[] inputArray = input.split(" ");
        for (int index = 0; index < inputArray.length; ++index) {
            m = Pattern.compile("((http?|https|ftp|file)://)?((W|w){3}.)?[a-zA-Z0-9]+\\.[a-zA-Z]+").matcher(inputArray[index]);
            while (m.find()) {
                return true;
            }
        }
        return false;
    }

    public static boolean isAddress(String input) {
        Matcher m = Pattern.compile("(([,]{1,})+|(\\d{5,})+)").matcher(input);
        while (m.find()) {
            return true;
        }
        String[] inputArray = input.split(" ");
        for (int index = 0; index < inputArray.length; ++index) {
            m = Pattern.compile("(([,]{1,})+|(\\d{5,})+)").matcher(inputArray[index]);
            while (m.find()) {
                return true;
            }
        }
        return false;
    }

    public static boolean isCompany(String input) {
        Matcher m = Pattern.compile("((Pvt.|PVT|Private|private)|(Ltd.|ltd|Limited|limited))").matcher(input);
        while (m.find()) {
            return true;
        }
        String[] inputArray = input.split(" ");
        for (int index = 0; index < inputArray.length; ++index) {
            m = Pattern.compile("((Pvt.|PVT|Private|private)|(Ltd.|ltd|Limited|limited))").matcher(inputArray[index]);
            while (m.find()) {
                return true;
            }
        }
        return false;
    }

    public static boolean isName(String input) {
        Matcher m = Pattern.compile("\\p{Upper}(\\p{Lower}+\\s?)").matcher(input);
        while (m.find()) {
            return true;
        }
        String[] inputArray = input.split(" ");
        for (int index = 0; index < inputArray.length; ++index) {
            m = Pattern.compile("\\p{Upper}(\\p{Lower}+\\s?)").matcher(inputArray[index]);
            while (m.find()) {
                return true;
            }
        }
        return false;
    }
}
