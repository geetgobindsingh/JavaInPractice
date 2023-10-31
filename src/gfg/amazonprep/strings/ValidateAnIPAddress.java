package gfg.amazonprep.strings;

public class ValidateAnIPAddress {
    public static void main(String[] args) {

        System.out.println(isValidIP("222.111.111.111"));
        System.out.println(isValidIP("5555..555"));
        System.out.println(isValidIP("00000.00000."));
        System.out.println(isValidIP("0000.0000.0000.0000"));
    }

    public static boolean isValidIP(String s) {
        int start = 0;
        int end = 255;
        boolean inValid = true;
        int count = 3;
        while (s.length() > 0) {
            int index = s.indexOf('.');
            if (index == -1 && count > 0) {
                inValid = false;
                break;
            } else {
                try {
                    index = count == 0 ? s.length() : index;
                    String sample = s.substring(0, index);
                    int length = sample.length();
                    int sect = Integer.parseInt(sample);
                    if (String.valueOf(sect).length() != length) {
                        inValid = false;
                        break;
                    }
                    if (start > sect || sect > end) {
                        inValid = false;
                        break;
                    } else {
                        if (count == 0) {
                            break;
                        }
                        count--;
                    }
                } catch (Exception ex) {
                    inValid = false;
                    break;
                }
            }
            s = s.substring(index + 1);
        }
        return inValid && count == 0;
    }
}
