package exercise.chapter01;

import utils.Utils;

/**
 * Created by zhoutailiang on 2017/5/17.
 */
public class RotateImage {
    public static void main(String[] args) {
        int[][] image = {{1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}};
        Utils.printTwoDimensionArray(image);
        rotateImage(image);
        Utils.println("------------");
        Utils.printTwoDimensionArray(image);
    }

    public static void rotateImage(int[][] image) {
        int length = image.length;
        for (int layer = 0; layer < length / 2; layer++) {
            int first = layer;
            int last = length - 1 - layer;
            for (int i = first; i < last; i++) {
                int offset = i - first;
                int top = image[first][i];
                image[first][i] = image[last - offset][first];
                image[last - offset][first] = image[last][last - offset];
                image[last][last - offset] = image[i][last];
                image[i][last] = top;
            }
        }

    }
}
