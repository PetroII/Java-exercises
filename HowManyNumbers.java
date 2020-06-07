import java.util.ArrayList;
import java.util.List;

public class HowManyNumbers {
    public static List<Long> findAll(final int sumDigits, final int numDigits) {
        List<Long> result = new ArrayList<>();
        List<String> list = new ArrayList<>();
        StringBuilder num = new StringBuilder();
        finder(list, num, numDigits, 1, sumDigits);
        result.add((long)list.size());
        result.add(Long.parseLong(list.get(0)));
        result.add(Long.parseLong(list.get(list.size()-1)));
        return result;
    }
    private static void finder(List<String> list, StringBuilder num, int numDigits, int start, int sumDigits){
        if(sumDigits<0){
            return;
        }
        if(sumDigits==0 && num.length()==numDigits){
            list.add(num.toString());
            return;
        }
        for(int i=start; i<=9; i++){
            num.append(i);
            finder(list, num, numDigits, i, sumDigits - i);
            num.deleteCharAt(num.length() - 1);
        }
    }
}
