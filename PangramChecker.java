
public class PangramChecker {
    public boolean check(String sentence){
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        boolean result = true;
        for(int i = 0; i < sentence.length(); i++){
            for(int j = 0; j < alphabet.length; j++){
                if(Character.toLowerCase(sentence.charAt(i)) == alphabet[j]){
                    alphabet[j] = '0';
                    break;
                }
            }
        }
        for(char c : alphabet){
            if(c != '0'){
                result = false;
                break;
            }
        }
        return result;
    }
}
