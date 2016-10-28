package medium;

import java.util.Scanner;

/**
 * Created by danny on 16/5/29.
 */
public class Xor {
    public static void main(String[] args) {
        int number = 0, max = 0;
        Scanner in = new Scanner(System.in);
        number = in.nextInt();
        int[] array = new int[number];
        for (int i = 0; i < number; i++) {
            array[i] = in.nextInt();
        }

        for (int i = 0; i < number - 1; i++) {
            for (int j = i + 1; j <= number - 1; j++) {
                int min_num = Math.min(i + 1, number - j);
                for (int k = 0; k < min_num; k++) {
                    max = Math.max(max, array[k] ^ array[j + k]);
                }
            }
        }

        System.out.println(max);

    }
}
