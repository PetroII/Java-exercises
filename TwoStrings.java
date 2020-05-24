import java.util.HashMap;
import java.util.Map;

public class TwoStrings {
    public static String workOnStrings(String a, String b) {
        Map<Character,Integer> aChars = fillMap(a);
        Map<Character,Integer> bChars = fillMap(b);
        return caseChange(bChars,a) + caseChange(aChars,b);
    }
    private static Map<Character,Integer> fillMap(String input){
        String low = input.toLowerCase();
        Map<Character,Integer> chars = new HashMap<>();
        for(int i = 0; i < input.length(); i++){
            char c = low.charAt(i);
            if(!chars.containsKey(c)){
                chars.put(c,1);
            }else{
                int value = chars.get(c);
                chars.replace(c,value+1);
            }
        }
        return chars;
    }
    private static String caseChange(Map<Character,Integer> check, String change){
        StringBuilder sb = new StringBuilder();
        char c;
        for(int i = 0; i < change.length(); i++){
            c = change.charAt(i);
            if(check.containsKey(Character.toLowerCase(c))){
                int amount = check.get(Character.toLowerCase(c));
                for(int j = 0; j < amount; j++){
                    c = Character.toLowerCase(c) == c ? Character.toUpperCase(c) : Character.toLowerCase(c);
                }
            }
            sb.append(c);
        }
        return sb.toString();
    }
}
