package exercise.chapter01;

import java.util.Arrays;

import utils.Utils;

/**
 * Created by zhoutailiang on 2017/5/12.
 */
public class ReplaceBlank {
    public static void main(String[] args) {
        String input = "Mr  John Smith ";
        char[] chars = input.toCharArray();
        Utils.println(new String(replaceBlank(chars)));
    }

    public static char[] replaceBlank(char[] chars) {
        int blankCounts = 0;
        for (char c : chars) {
            if (c == ' ') {
                blankCounts++;
            }
        }
        char[] copyChars = Arrays.copyOf(chars, chars.length + blankCounts * 2);
        int lastIndex = copyChars.length - 1;
        for (int i = chars.length - 1; i >= 0; i--) {
            char c = chars[i];
            if (c == ' ') {
                copyChars[lastIndex--] = '0';
                copyChars[lastIndex--] = '2';
                copyChars[lastIndex--] = '%';
            } else {
                copyChars[lastIndex--] = c;
            }
        }
        return copyChars;
    }
}
