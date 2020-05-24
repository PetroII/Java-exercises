import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class PrimeDecomp {
    public static String factors(int n) {
        int divisor = 2;
        int counter = 0;
        String result = "";
        while(n >= divisor) {
            if(n == divisor){
                counter++;
                if(counter == 1){
                    result += "(" + divisor + ")";
                }else{
                    result += "(" + divisor + "**" + counter + ")";
                }
                break;
            }else if(n%divisor == 0){
                n /= divisor;
                counter++;
            }else if(counter == 0){
                divisor += divisor == 2 ? 1 : 2;
            }else if(counter == 1){
                result += "(" + divisor + ")";
                divisor += divisor == 2 ? 1 : 2;
                counter = 0;
            }else{
                result += "(" + divisor + "**" + counter + ")";
                divisor += divisor == 2 ? 1 : 2;
                counter = 0;
            }
        }
        return result;
    }
}
