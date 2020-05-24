import java.util.ArrayList;
import java.util.List;

public class CountingDuplicates {
    public static int duplicateCount(String text) {
        List<Character> duplicates = new ArrayList<>();
        for(int i = 0; i < text.length(); i++){
            for(int j = i + 1; j < text.length(); j++){
                if(Character.toLowerCase(text.charAt(i)) == Character.toLowerCase(text.charAt(j))
                        && !duplicates.contains(Character.toLowerCase(text.charAt(i)))){
                    duplicates.add(Character.toLowerCase(text.charAt(i)));
                }
            }
        }
        return duplicates.size();
    }
}
