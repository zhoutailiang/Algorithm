package exercise.arrayandstring;

import utils.Utils;

/**
 * Created by zhoutailiang on 2017/5/27.
 */
public class RotateWord {
    public static void main(String[] args) {
        String str1 = "waterbottle";
        String str2 = "erbottlewat";
        Utils.println(isRotateWord(str1, str2));
    }

    private static boolean isRotateWord(String str1, String str2) {
        if (str1 != null && str2 != null & str1.length() == str2.length() && str1.length() > 0) {
            String str1str1 = str1 + str1;
            return isSubstring(str1str1, str2);
        }
        return false;
    }

    private static boolean isSubstring(String str1, String str2) {
        return false;
    }

}
