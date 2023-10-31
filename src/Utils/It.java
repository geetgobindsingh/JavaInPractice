package Utils;


/**
 * Created by geetgobindsingh on 22/09/17.
 */

public class It {
    private It() {
        // Utility class with static methods
    }

    public static boolean isFalse(boolean condition) {
        if(condition) return false;
        else return true;
    }

    public static boolean isTrue(boolean condition) {
        if(condition) return true;
        else return false;
    }

    public static boolean isNull(Object object) {
        if(object == null) return true;
        else return false;
    }

    public static boolean isNotNull(Object object) {
        if(object != null) return true;
        else return false;
    }

    public static boolean isSame(String stringOne, String stringTwo) {
        if(isNull(stringOne) || isNull(stringTwo)) {
            return false;
        }
        if(stringOne.equalsIgnoreCase(stringTwo)) {
            return true;
        }
        return false;
    }

    public static boolean isNotSame(String stringOne, String stringTwo) {
        if(isNull(stringOne) || isNull(stringTwo)) {
            return true;
        }
        if(stringOne.equalsIgnoreCase(stringTwo)) {
            return false;
        }
        return true;
    }

    public static boolean isSame(int intOne, int intTwo) {
        if(intOne == intTwo) {
            return true;
        }
        return false;
    }

    public static boolean isSame(long intOne, long intTwo) {
        if(intOne == intTwo) {
            return true;
        }
        return false;
    }

    public static boolean isNotSame(int intOne, int intTwo) {
        if(intOne == intTwo) {
            return false;
        }
        return true;
    }

    public static boolean isNotSame(long intOne, long intTwo) {
        if(intOne == intTwo) {
            return false;
        }
        return true;
    }

    public static boolean isEmpty(String str) {
        if (str == null || str.isEmpty())
            return true;
        else
            return false;
    }

    public static boolean isNotEmpty(String str) {
        if (str == null || str.isEmpty())
            return false;
        else
            return true;
    }

    public static boolean isZero(int input) {
        if(input == 0) return true;
        else return false;
    }

    public static boolean isNotZero(int input) {
        if(input != 0) return true;
        else return false;
    }

    public static boolean isZero(Long input) {
        if(input == 0) return true;
        else return false;
    }

    public static boolean isNotZero(Long input) {
        if(input != 0) return true;
        else return false;
    }
}
