package easy;

/**
 * Created by danny on 2016/10/16.
 */
public class ReverseInteger {

    public static void main(String args[]){

//        int x = -2147483648; //2147483648;
        int x = -143123125; //2147483648;
//        int y = 8463412512;
//        int x = -1296885;   -12/10  -12%10
        ReverseInteger reverseInteger =  new ReverseInteger();
        System.out.print(reverseInteger.reverse(x));
//        System.out.print(Math.abs(x));


    }

    public int reverse(int x) {
        int flag = x>0?1:-1;
        x = Math.abs(x);
        int y = 0;
        long count = 0;
        while (x > 0) {
            y = x % 10;
            count = count * 10 + y;
            x = x / 10;
            if(count>Integer.MAX_VALUE){
                return 0;
            }
        }

        return (int)count*flag;
    }
//public int reverse(int x) {
//    int sign=x<0?-1:1;
//    x=Math.abs(x);
//    long r=0;
//    for ( ; x>0; x=x/10) {
//        r= r*10+x%10;
//        if (r>Integer.MAX_VALUE)
//            return 0;
//    }
//    return (int)r*sign;
//}
}
