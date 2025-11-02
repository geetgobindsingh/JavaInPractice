package leetcode.easy;

public class CheckIfTwoStringArraysAreEquivalent {
    public static void main(String[] args) {
        CheckIfTwoStringArraysAreEquivalent obj = new CheckIfTwoStringArraysAreEquivalent();
        System.out.println(obj.arrayStringsAreEqual(new String[]{"ab", "c"}, new String[]{"a", "bc"}));
        System.out.println(obj.arrayStringsAreEqual(new String[]{"ac", "b"}, new String[]{"ab", "c"}));
        System.out.println(obj.arrayStringsAreEqual(new String[]{"abc", "d", "defg"}, new String[]{"abcddefg"}));
    }

    int i = 0;
    int j = 0;

    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for (String s : word1) {
            sb1.append(s);
        }
        for (String s : word2) {
            sb2.append(s);
        }
        return sb1.toString().equals(sb2.toString());
    }
    public boolean arrayStringsAreEqual1(String[] word1, String[] word2) {
        while (true) {
            Character c = getNextChar1(word1);
            if (c != getNextChar2(word2)) {
                return false;
            }
            if (c == null) {
                break;
            }
        }
        return true;
    }

    private Character getNextChar1(String[] word) {
        if (i < word.length) {
            String s = word[i];
            if (s.length() == 0) {
                if ((i + 1) < word.length) {
                    i++;
                    s = word[i];
                }
            }
            if (s.length() == 0) {
                return null;
            }
            char c = s.charAt(0);
            word[i] = s.substring(1);
            return c;
        }

        return null;
    }

    private Character getNextChar2(String[] word) {
        if (j < word.length) {
            String s = word[j];
            if (s.length() == 0) {
                if ((j + 1) < word.length) {
                    j++;
                    s = word[j];
                }
            }
            if (s.length() == 0) {
                return null;
            }
            char c = s.charAt(0);
            word[j] = s.substring(1);
            return c;
        }

        return null;
    }
}
