package exercise.arrayandstring;

import java.util.HashSet;
import java.util.Set;

import utils.Utils;

/**
 * Created by zhoutailiang on 2017/5/22.
 */
public class ClearZero {
    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3, 4},
                {1, 0, 3, 4},
                {1, 2, 3, 0},
                {1, 2, 3, 4},
                {1, 2, 0, 4},
                {1, 2, 3, 4}};
        Utils.printTwoDimensionArray(arr);
        clearZero(arr);
        Utils.println("--------");
        Utils.printTwoDimensionArray(arr);
    }

    private static void clearZero(int[][] arr) {
        int row = arr.length;
        int column = arr[0].length;
        Set<Integer> zeroRows = new HashSet<>();
        Set<Integer> columnRows = new HashSet<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (arr[i][j] == 0) {
                    zeroRows.add(i);
                    columnRows.add(j);
                }
            }
        }
        if (!zeroRows.isEmpty()) {

            for (int zeroRow : zeroRows) {
                for (int i = 0; i < column; i++) {
                    if (arr[zeroRow][i] != 0) {
                        arr[zeroRow][i] = 0;
                    }
                }
            }

            for (int columnRow : columnRows) {
                for (int i = 0; i < row; i++) {
                    if (arr[i][columnRow] != 0) {
                        arr[i][columnRow] = 0;
                    }
                }
            }
        }
    }
}
