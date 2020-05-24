import java.util.ArrayList;
import java.util.List;

public class SumSquaredDivisors {
    public static String listSquared(long m, long n) {
        List<Long> divisors = new ArrayList<>();
        long sum = 0;
        long check;
        String result = "[";
        for(long i = m; i <= n; i++){
            for(long j = 1; j <= i; j++){
                if(i%j == 0){
                    divisors.add(j);
                }
            }
            for(long l : divisors){
                l = l*l;
                sum += l;
            }
            check = (long) Math.sqrt(sum);
            if(check*check == sum){
                result += "[" + i + ", " + sum + "], ";
            }
            divisors.clear();
            sum = 0;
        }
        if(result.length() >= 3) {
            result = result.substring(0, result.length() - 2);
        }
        result += "]";
        return result;
    }
}
