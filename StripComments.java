public class StripComments {
    public static String stripComments(String text, String[] commentSymbols) {
        if(text.length() == 0){
            return text;
        }else {
            StringBuilder result = new StringBuilder(text);
            int temp;
            for (String commentSymbol : commentSymbols) {
                for (int j = 0; j < result.length(); j++) {
                    if (commentSymbol.equals(String.valueOf(result.charAt(j))) || result.charAt(j) == '\n') {
                        while (j > 0 && result.charAt(j - 1) == ' ') {
                            result.deleteCharAt(j - 1);
                            j--;
                        }
                        if (commentSymbol.equals(String.valueOf(result.charAt(j)))) {
                            while (j < result.length() && !String.valueOf(result.charAt(j)).equals("\n")) {
                                result.deleteCharAt(j);
                            }
                        }
                    }
                }
            }
            while (result.length() > 0 && result.charAt(result.length() - 1) == ' ') {
                result.deleteCharAt(result.length() - 1);
            }
            return result.toString();
        }
    }
}
