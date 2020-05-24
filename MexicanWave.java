public class MexicanWave {
    public static String[] wave(String str) {
        int counter = 0;
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) != ' '){
                counter++;
            }
        }

        String[] result = new String[counter];
        StringBuilder sb = new StringBuilder();
        counter = 0;

        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) != ' ') {
                for (int j = 0; j < str.length(); j++) {
                    if (i == j) {
                        sb.append(Character.toUpperCase(str.charAt(j)));
                    } else {
                        sb.append(str.charAt(j));
                    }
                }
                result[counter] = sb.toString();
                sb = new StringBuilder();
                counter++;
            }
        }
        return result;
    }
}
