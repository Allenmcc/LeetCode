package easy;

/**
 * Created by danny on 16/5/23.
 */

class LogorithmsTest{

    public static void main(String args[]){
        Logorithms logorithms = new Logorithms();
        boolean result =  logorithms.logorithms(16);
        System.out.println(result);
    }
}
public class Logorithms {
    public boolean logorithms(int num){

        double result = (Math.log(num)/Math.log(4));
        if (result % 1 == 0){

            return true;
        }else {
            return false;
        }
    }
}
