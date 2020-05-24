public class DuplicateEncoder {
    static String encode(String word){
        word = word.toLowerCase();
        int counter = 0;
        StringBuilder result = new StringBuilder();

        for(int i = 0; i < word.length(); i++){
            for(int j = 0; j < word.length(); j++){
                if(word.charAt(i)==word.charAt(j)){
                    counter++;
                }
            }
            if(counter > 1){
                result.append(")");
            }else{
                result.append("(");
            }
            counter = 0;
        }
        return result.toString();
    }
}
