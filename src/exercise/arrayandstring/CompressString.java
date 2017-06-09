package exercise.arrayandstring;

import utils.Utils;

/**
 * Created by zhoutailiang on 2017/5/15.
 */
public class CompressString {

    public static void main(String[] args) {
        String input = "aabbccddeeffggg";
        Utils.println(compressString(input));
    }

    public static String compressString(String str) {
        char lastChar = str.charAt(0);
        int lastCharCount = 0;
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == lastChar) {
                lastCharCount++;
            } else {
                builder.append(lastChar);
                builder.append(lastCharCount);
                lastChar = c;
                lastCharCount = 1;
            }
        }
        builder.append(lastChar);
        builder.append(lastCharCount);

        String compressResult = builder.toString();

        return compressResult.length() >= str.length() ? str : compressResult;
    }
}
