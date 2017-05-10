package exercise.chapter01;

import utils.Utils;

/**
 * Created by zhoutailiang on 2017/5/10.
 */
public class UniqueChars {
    public static void main(String[] args) {
        Utils.println(isUniqueCharsForLowerCase("abcdefghijklmn"));
    }

    public static boolean isUniqueChars(String str) {
        boolean[] charBit = new boolean[256];
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (charBit[charAt]) {
                return false;
            } else {
                charBit[charAt] = true;
            }
        }
        return true;
    }

    public static boolean isUniqueCharsForLowerCase(String str) {
        int checker = 0;
        for (int i = 0; i < str.length(); i++) {
            int value = str.charAt(i) - 'a';
            if ((checker & (1 << value)) > 0) {
                return false;
            }
            checker |= 1 << value;
        }
        return true;
    }
}
