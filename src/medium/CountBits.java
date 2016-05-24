package medium;

/**
 * Created by danny on 16/5/24.
 */
class CountBitsTest{

    public static void main(String args[]){

        CountBits countBits = new CountBits();
        int[] res = countBits.countBits(7);
        for(int a:res) {
            System.out.println(a);
        }
    }
}

public class CountBits {
    public int[] countBits(int num) {
        int[] res = new int[num + 1];
        res[0] = 0;

        for (int i = 1; i <= num; i++) {
            // odd 奇数  101 同 10 ＋ 1
            if ((i & 1) == 1) {        //11 & 1 = 01 判断奇偶的好方法(主要看最后一位)
                res[i] = res[i>>1] + 1;
            }
            // even 偶数 100 通 10
            else {
                res[i] = res[i>>1];
            }
        }
        return res;
    }
}
