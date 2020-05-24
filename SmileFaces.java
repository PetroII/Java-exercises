import java.util.*;

public class SmileFaces {
    public static int countSmileys(List<String> arr) {
        int result = 0;
        for(String s : arr){
            if(s.charAt(0)==':' || s.charAt(0)==';'){
                if(s.charAt(1)=='-' || s.charAt(1)=='~'){
                    if((s.charAt(2)==')' || s.charAt(2)=='D') && s.length() == 3){
                        result++;
                    }
                }else if((s.charAt(1)==')' || s.charAt(1)=='D') && s.length() == 2){
                    result++;
                }
            }
        }
        return result;
    }
}
