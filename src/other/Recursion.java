package other;

/**
 * Created by zhoutailiang on 2017/3/10.
 */
public class Recursion {
    private static long mCount = 0;

    public static void main(String[] args) {
        System.out.println(pow(2, 10));
    }

    private static long pow(long base, long exp) {
        try {
            mCount++;
            if (exp == 0) return 1;
            return base * pow(base, exp);
        } catch ( Error error) {
            error.printStackTrace();
            System.out.println("stack deep = "+mCount);
            return -1;
        }
    }
}
