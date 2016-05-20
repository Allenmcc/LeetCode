package easy;

/**
 * Created by danny on 16/5/20.
 */

class ReverseTest {
    public static void main(String args[]) {

        ReverseString reverseString = new ReverseString();
//       String result =  reverseString.reverseString("nimei");
//        String result = reverseString.reverseString2("nimei");
        String result = reverseString.reverseString3("nimei");
        System.out.println(result);
    }

}

public class ReverseString {
    public String reverseString(String s) {

        return new StringBuffer(s).reverse().toString();

    }

    public String reverseString2(String s) {
        String temp = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            temp += c;
        }
        return temp;
    }

    public String reverseString3(String s){

        char[] array = s.toCharArray();
        String temp = "";
        for (int i = array.length-1;i>=0;i--){
            temp += array[i];
        }
        return temp;


    }


}
