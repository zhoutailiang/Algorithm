package exercise.arrayandstring;

import java.util.Arrays;

import utils.Utils;

/**
 * Created by zhoutailiang on 2017/5/11.
 */
public class RearrangeToAnotherString {
    public static void main(String[] args) {
        String originalStr = "abcadebfag";
        String anotherStr = "abcadebfag";
        Utils.println(originalStr + " can be rearranged to " + anotherStr + "?");
        Utils.println(canRearrangeToAnotherString1(originalStr, anotherStr));
        Utils.println(canRearrangeToAnotherString2(originalStr, anotherStr));
        Utils.println(canRearrangeToAnotherString3(originalStr, anotherStr));
    }

    /******************************方法1******************************/
    public static boolean canRearrangeToAnotherString1(String originalStr, String anotherStr) {
        if (originalStr == null && anotherStr == null) {
            return true;
        }

        if (originalStr == null || anotherStr == null) {
            return false;
        }

        if (originalStr.equals(anotherStr)) {
            return true;
        }

        int originalLen = originalStr.length();
        int anotherLen = anotherStr.length();

        if (originalLen != anotherLen) {
            return false;
        }

        char[] orignalChars = originalStr.toCharArray();
        char[] anotherChars = anotherStr.toCharArray();
        boolean[] isFound = new boolean[originalLen];
        for (int i = 0; i < orignalChars.length; i++) {
            char origianlChar = orignalChars[i];
            int j = 0;
            for (; j < anotherChars.length; j++) {
                char anotherChar = anotherChars[j];
                if (origianlChar == anotherChar && !isFound[j]) {
                    isFound[j] = true;
                    break;
                }
            }
            if (j == anotherChars.length) {
                return false;
            }
        }
        return true;
    }

    /******************************方法2******************************/
    public static boolean canRearrangeToAnotherString2(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        return sort(str1).equals(sort(str2));
    }

    public static String sort(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    /******************************方法3******************************/
    public static boolean canRearrangeToAnotherString3(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        int[] charCounts = new int[256];
        for (int i = 0; i < str1.length(); i++) {
            charCounts[str1.charAt(i)]++;
        }
        for (int i = 0; i < str2.length(); i++) {
            if (--charCounts[str2.charAt(i)] < 0) {
                return false;
            }
        }
        return true;
    }
}
