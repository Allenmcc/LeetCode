package medium;

import java.util.Scanner;

/**
 * Created by danny on 16/5/29.
 */

public class CharRe {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        int result = (k + 1) / 2;
        int lenMn = n * m;
        int arr[][] = new int[7][101];
        int a[] = new int[7];

        for (int i = 1; i <= k; i++) {
            String read = sc.next();
            for (int j = 0; j < read.length(); j++) {
                arr[i][j + 1] = (int) read.charAt(j) - '0';

            }
        }

//        for (int i = 1;i<=k;i++)
//            for(int j =1;j<=len; j++) {
//                System.out.println(arr[i][j]);
//            }

        for (int i = result; i <= lenMn; i++) {
            boolean f = true;
            for (int y = 1; y + i - 1 <= lenMn; y++) {
                for (int a_i = 0; a_i < 7; a_i++)
                    a[a_i] = 0;
                f = true;
                for (int j = y, r = 0; j <= y + i - 1; j++, r++) {
                    for (int q = 1; q <= k; q++) {
                        int tem = (int) Math.pow(2.0, r * 1.0);
                        a[q] += arr[q][j] * tem;
                    }
                }
                for (int z = 1; z < k; z++) {
                    for (int j = z + 1; j <= k; j++) {
                        if (a[z] == a[j])
                            f = false;
                    }
                }
                if (f) break;
            }
            if (f) {
                result = i;
                break;
            }

        }
        System.out.println(result);

    }

}
